package com.clarity.spring.util;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.clarity.spring.repository.UserRepository;

public class PasswordGenerator {
	
	public UserRepository userRepository; 
	public Optional usuarios = userRepository.findByEmailContainsIgnoreCase("daniel@gmail.com");
	
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        // Contraseña en texto plano
        String rawPassword = "password123";

        // Generar la contraseña encriptada
        String encodedPassword = encoder.encode(rawPassword);

        System.out.println("Contraseña encriptada: " + encodedPassword);
    	System.out.println();
    	
    }
}

