package com.example.SpringAuth.Config;


import com.example.SpringAuth.Service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;

@org.springframework.context.annotation.Configuration
@EnableWebSecurity
public class Configuration {
    @Autowired
    private UserDetailsService userDetailsService;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return
                httpSecurity
                        //csrf b7al wa7d sarot ma7dk dakhl l dik dar katb9a 3ndk walakin m3a katkhrj aykhsk sarot jdid
                        .csrf(customizer -> customizer.disable())

                        //hadi katb9a t3ti acces l kola blasa f site la knti mlogi wla la
                        //hadi anyRequest ya3ni ayi url jaaha ila drti .permitAll()
                        // blast authenticated kat3ti l klch wila drti requestmatchers("/blasa li khaso ilogi fiha")
                        //zid 9lb w 9ra 3liha ktr
                        .authorizeHttpRequests((request -> request
                                .requestMatchers("/addusers").permitAll()
                                .anyRequest().authenticated()))
                        .httpBasic(Customizer.withDefaults()).sessionManagement(session -> session
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                        .build();
    }
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }
}
