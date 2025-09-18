package com.leopoldo.ebook.ebook.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.leopoldo.ebook.ebook.security.filters.jwtAuthenticationFilter;

@Configuration
public class SpringSecutiryConfig {


    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationManager authenticationManager() throws Exception {
        return  authenticationConfiguration.getAuthenticationManager();
    }


    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        jwtAuthenticationFilter filter = new jwtAuthenticationFilter(authenticationManager());
        filter.setFilterProcessesUrl("/api/v1/login");
        
        return http.authorizeHttpRequests((auth) -> auth
                .requestMatchers(HttpMethod.GET,"/api/v1/users").permitAll() 
                .anyRequest().authenticated()
                )
                .addFilter(filter)
                .csrf(csrf -> csrf.disable())
                .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }   
}
