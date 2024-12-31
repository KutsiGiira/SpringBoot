package com.example.Securityv2.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class Config {
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        UserDetails user = User.builder()
                .username("user")
                .password("{noop}user")
                .roles("user")
                .build();

        UserDetails black = User.builder()
                .username("black")
                .password("{noop}black")
                .roles("user","admin, manager")
                .build();

        UserDetails kustigira = User.builder()
                .username("kutsigira")
                .password("{noop}kutsigira")
                .roles("user","manager")
                .build();

        return new InMemoryUserDetailsManager(user,black, kustigira);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers("/").hasRole("user")
                        .requestMatchers("/manager/**").hasRole("manager")
                        .requestMatchers("/admin/**").hasRole("admin")
                        .anyRequest().authenticated()
        )

                .formLogin(form ->
                        form.loginPage("/myLogin").loginProcessingUrl("/logged").permitAll()
                        )
                .logout(logout ->
                        logout.permitAll()
                );
        return http.build();
    }
}
