package com.clarity.spring.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	protected BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}


	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(getPasswordEncoder());
		return provider;
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> auth.requestMatchers("/webjars/**", "/css/**", "/h2-console/**", "/index/**", "/auth/login", "/auth/register", "/products/**", "/categories/**", "/images/**")
				.permitAll()
				.anyRequest().authenticated())
				.formLogin(form -> form.loginPage("/auth/login").loginProcessingUrl("/auth/login").permitAll().defaultSuccessUrl("/index", true))
				.logout(logout -> logout.permitAll()).csrf(csrf -> csrf.disable())
				.headers(headers -> headers.frameOptions().disable());

		return http.build();
	}

}
