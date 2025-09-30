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
import com.leopoldo.ebook.ebook.security.filters.jwtAuthorizationFilter;

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

        jwtAuthorizationFilter authorizationFilter = new jwtAuthorizationFilter(authenticationManager());
        
        return http.authorizeHttpRequests((auth) -> auth
                //rutas libres
                .requestMatchers(HttpMethod.POST,"/api/v1/users").permitAll()
                .requestMatchers(HttpMethod.GET,"/api/v1/users").permitAll()
                .requestMatchers(HttpMethod.GET,"/api/v1/categories").permitAll()
                .requestMatchers(HttpMethod.GET,"/api/v1/categories/count").permitAll()
                .requestMatchers(HttpMethod.GET,"/api/v1/authors").permitAll()
                .requestMatchers(HttpMethod.GET,"/api/v1/authors/{id}").permitAll()
                .requestMatchers(HttpMethod.GET,"/api/v1/authors/count").permitAll()
                .requestMatchers(HttpMethod.GET,"/api/v1/books").permitAll()
                .requestMatchers(HttpMethod.GET,"/api/v1/books/{bookId}/usersWhoLiked").permitAll()
                .requestMatchers(HttpMethod.GET,"/api/v1/books/{bookId}/likes").permitAll()
                .requestMatchers(HttpMethod.GET,"/api/v1/books/{id}").permitAll()
                .requestMatchers(HttpMethod.GET,"/api/v1/books/count").permitAll()
                .requestMatchers(HttpMethod.GET,"/api/v1/books/countByCategory").permitAll()

                //rutas solo para administradores
                .requestMatchers(HttpMethod.DELETE, "/api/v1/users/{id}").hasRole("ADMIN") 
                .requestMatchers(HttpMethod.POST, "/api/v1/categories").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE,"/api/v1/categories/{id}").hasRole("ADMIN")
                .requestMatchers(HttpMethod.POST,"/api/v1/authors").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE,"/api/v1/authors/{id}").hasRole("ADMIN")
                .requestMatchers(HttpMethod.POST,"/api/v1/authors/{authorId}/books/{bookId}").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE,"/api/v1/authors/{authorId}/books/{bookId}").hasRole("ADMIN")
                .requestMatchers(HttpMethod.POST,"/api/v1/books").hasRole("ADMIN")
                .requestMatchers(HttpMethod.POST,"/api/v1/books/{bookId}/categories/{idCategory}").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE,"/api/v1/books/{bookId}/categories/{idCategory}").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET,"/api/v1/excel").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET,"/api/v1/loans").hasRole("ADMIN")
                .requestMatchers(HttpMethod.POST,"/api/v1/loans/aprove/{id}").hasRole("ADMIN")
                .requestMatchers(HttpMethod.POST,"/api/v1/loans/returned/{id}").hasRole("ADMIN")
                .requestMatchers(HttpMethod.POST,"api/v1/loans/rejected/{id}").hasRole("ADMIN")

                
                .anyRequest().authenticated()
                )
                .addFilter(filter)
                .addFilter(authorizationFilter)
                .csrf(csrf -> csrf.disable())
                .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }   
}
