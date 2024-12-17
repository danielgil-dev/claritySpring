package com.clarity.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.clarity.spring.model.Usuario;
import com.clarity.spring.repository.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository; 
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = userRepository.findByEmailContainsIgnoreCase(username)
				.orElseThrow(()-> new UsernameNotFoundException("Usuario no encontrado"));
		
		UserBuilder builder = null;
		
		if (usuario != null) {
            builder = org.springframework.security.core.userdetails.User.withUsername(username); // Asigna el email
            builder.password(usuario.getContrasenya()); // Contraseña encriptada
            builder.authorities(new SimpleGrantedAuthority("ROLE_" + usuario.getRole())); // Rol del usuario
            builder.disabled(false); // Si el usuario está habilitado
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        return builder.build();
    }

}
