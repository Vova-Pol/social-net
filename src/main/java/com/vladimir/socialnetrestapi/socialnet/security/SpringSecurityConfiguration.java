package com.vladimir.socialnetrestapi.socialnet.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // 1.All requests should be authenticated
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );

        // 2.If a request is not authenticated, show login pop-up (web page by default)
        http.httpBasic(Customizer.withDefaults());

        // 3.CSRF -> POST and PUT requests
        http.csrf().disable();

        return http.build();
    }
}
