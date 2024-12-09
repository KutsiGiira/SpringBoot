package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class Secure {
    @Bean
    public InMemoryUserDetailsManager details(){
        UserDetails haytam = User.builder().username("haytam").password("{noop}123").roles("manager").build();
        UserDetails black = User.builder().username("Black").password("{noop}123").roles("black").build();
        return new InMemoryUserDetailsManager(haytam, black);
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
                configurer.requestMatchers(HttpMethod.GET, "api/employees/").hasRole("manager")
                        .requestMatchers(HttpMethod.GET, "api/employees/**").hasRole("manager")
                        .requestMatchers(HttpMethod.DELETE,"/api/employees/**").hasRole("black")
                        .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("manager")
                        .requestMatchers(HttpMethod.POST, "/api/employees/**").hasRole("manager")

        );
        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }
}
