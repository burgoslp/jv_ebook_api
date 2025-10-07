package com.leopoldo.ebook.ebook.security.filters;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leopoldo.ebook.ebook.models.User;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import static com.leopoldo.ebook.ebook.security.TokenJwtConfig.*;

public class jwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;


    public jwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response){
       
        String username = null;
        String password = null;

        try {
            User user = new ObjectMapper().readValue(request.getInputStream(), User.class);
            username = user.getUsername();
            password = user.getPassword();
        } catch (StreamReadException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
       
        
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        System.out.println("entrando a attemptAuthentication con user: " + username + " y pass: " + password);
        return authenticationManager.authenticate(authenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
                
                org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) authResult.getPrincipal();
                String username = user.getUsername();

                String token = Jwts.builder()
                        .subject(username)
                        .expiration(new Date(System.currentTimeMillis() +  2 * 60 * 60 * 1000)) // 2 HORA
                        .issuedAt(new Date())
                        .claim("authorities", user.getAuthorities().stream().map( Object::toString ).toList())
                        .claim("username", username)
                        .signWith(clave_secreta)
                        .compact();
                response.addHeader(HEADER,PREFIX_TOKEN + token);

                Map<String, Object> body = Map.of(
                    "token", token,
                    "username", username,
                    "roles",user.getAuthorities().stream().map(Object::toString).toList(),
                    "message", "Usuario autenticado correctamente"
                );
                response.getWriter().write(new ObjectMapper().writeValueAsString(body));
                response.setContentType("application/json");
                response.setStatus(200);
    }

}
