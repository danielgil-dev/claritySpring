package com.clarity.spring.service;

import java.util.regex.Pattern;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.clarity.spring.model.Usuario;
import com.clarity.spring.repository.UserRepository;

@Service
public class UserService {
	
	private  UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	private static String regexDni = "^[0-9]{8}[A-Z]$";
	 private static  String letrasDni = "TRWAGMYFPDXBNJZSQVHLCKE";

	
	public UserService(UserRepository userRepository,PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder= passwordEncoder;
	}
	
	public void registerUser(String nombre, String apellido, String direccion, String email, String password, String telefono, String dni) throws Exception {
		
		if(userRepository.existsByemail(email)) {
			throw new Exception("El correo ya esta en uso");
		}
		if(!esDniValido(dni)) {
			throw new Exception("Formato de dni incorrecto");
		}
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		usuario.setDireccion(direccion);
		usuario.setEmail(email);
		usuario.setDni(dni);
		usuario.setContrasenya(passwordEncoder.encode(password));
		usuario.setTelefono(telefono);
		userRepository.save(usuario);
		
	}
	
	public Usuario getUserByEmail(String email) {
		Usuario usuario = userRepository.findByEmail(email);
		return usuario;
	}
	
	 private boolean esDniValido(String dni) {
	        if (!Pattern.matches(regexDni, dni)) {
	            return false;
	        }

	        String numeros = dni.substring(0, 8);
	        char letra = dni.charAt(8);

	        int indice = Integer.parseInt(numeros) % 23;
	        return letrasDni.charAt(indice) == letra;
	    }
}
