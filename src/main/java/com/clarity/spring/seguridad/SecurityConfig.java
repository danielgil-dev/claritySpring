package com.clarity.spring.seguridad;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	 @Bean
	    InMemoryUserDetailsManager inmemoryUserDetailsManager() {
	        UserDetails admin = User.withDefaultPasswordEncoder()
	                                .username("admin")
	                                .password("admin")
	                                .roles("ADMIN")
	                                .build();

	        return new InMemoryUserDetailsManager(admin);
	    }
	 
	 @Bean
	    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	            .authorizeHttpRequests(auth -> auth
	                .requestMatchers("/webjars/**", "/css/**", "/h2-console/**").permitAll()
	                .anyRequest().authenticated()
	            )
	            .formLogin(form -> form
	                .loginPage("/auth/login")
	                .permitAll()
	                .defaultSuccessUrl("/")
	            )
	            .logout(logout -> logout
	                .permitAll()
	            )
	            .csrf(csrf -> csrf.disable()) 
	            .headers(headers -> headers.frameOptions().disable()); 

	        return http.build();
	    }
	 

}
