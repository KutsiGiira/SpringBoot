package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class Secure {
    @Bean
    public InMemoryUserDetailsManager details(){
        UserDetails haytam = User.builder().username("haytam").password("{noop}123").build();
        UserDetails black = User.builder().username("Black").password("{noop}123").build();
        return new InMemoryUserDetailsManager(haytam, black);
    }
}
