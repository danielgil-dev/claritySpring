package com.clarity.spring.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.clarity.spring.model.Usuario;
import com.clarity.spring.repository.UserRepository;

@Service
public class UserService {
	
	private  UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	
	public UserService(UserRepository userRepository,PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder= passwordEncoder;
	}
	
	public void registerUser(String nombre, String apellido, String direccion, String email, String password, String telefono) throws Exception {
		
		if(userRepository.existsByemail(email)) {
			throw new Exception("El correo ya esta en uso");
		}
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		usuario.setDireccion(direccion);
				usuario.setEmail(email);
				usuario.setContrasenya(passwordEncoder.encode(password));
				usuario.setTelefono(telefono);
				userRepository.save(usuario);
		
	}
}
