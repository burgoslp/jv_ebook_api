package com.leopoldo.ebook.ebook.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.leopoldo.ebook.ebook.models.User;
import com.leopoldo.ebook.ebook.repositories.IUserRepository;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserRepository ur;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> usuario= ur.findByUsernameWithRoles(username);
        User user = usuario.orElseThrow(() -> new UsernameNotFoundException("El usuario no fue encontrado con ese nombre: " + username));
        
        List<GrantedAuthority> authorities = user.getRoles()
                                                    .stream()
                                                    .map(roles ->(GrantedAuthority) new SimpleGrantedAuthority(roles.getName()))
                                                    .toList();

        System.out.println("Buscando usuario: " + username);
        System.out.println("Roles encontrados: " + user.getRoles());
        System.out.println("Password recuperado: " + user.getPassword());
        System.out.println("Authorities: " + authorities);
        return new org.springframework.security.core.userdetails.User(
            usuario.get().getUsername(),
            usuario.get().getPassword(),
            authorities
        );
    }

}
