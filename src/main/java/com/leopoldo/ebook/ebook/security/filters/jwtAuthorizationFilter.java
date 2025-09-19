package com.leopoldo.ebook.ebook.security.filters;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import static com.leopoldo.ebook.ebook.security.TokenJwtConfig.*;

public class jwtAuthorizationFilter extends BasicAuthenticationFilter {

    
    public jwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
        
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {  
        String header = request.getHeader(HEADER);
        if (header == null || !header.startsWith(PREFIX_TOKEN)) {
            filterChain.doFilter(request, response);
            return;
        }
        String token = header.replace(PREFIX_TOKEN, "");
        try {
            Claims claims = Jwts.parser()
                    .verifyWith(clave_secreta)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
            String username = claims.getSubject();
            @SuppressWarnings("unchecked")



            List<String> authorities = (List<String>) claims.get("authorities");
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                    username,
                    null,
                    authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList())
            );
            SecurityContextHolder.getContext().setAuthentication(auth);
        } catch (Exception e) {
            SecurityContextHolder.clearContext();
        }
        filterChain.doFilter(request, response);
    }
}
