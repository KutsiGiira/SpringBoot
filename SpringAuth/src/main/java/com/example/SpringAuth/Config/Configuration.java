package com.example.SpringAuth.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@org.springframework.context.annotation.Configuration
//@EnableWebSecurity
public class Configuration {
//    @Bean
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
                                .requestMatchers("/main").permitAll()
                                .anyRequest().authenticated()))
                        .build();
    }
}
