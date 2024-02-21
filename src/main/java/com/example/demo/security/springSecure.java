package com.example.demo.security;

//import javax.security.sasl.AuthorizeCallback;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableMethodSecurity
@EnableWebSecurity
@Configuration
public class springSecure {
    
	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder encoder)
	{
		UserDetails admin = User.withUsername("Akshay")
				.password(encoder.encode("Akshay123"))
				.roles("ADMIN")
				.build();
		
		UserDetails user = User.withUsername("User")
				.password(encoder.encode("User123"))
				.roles("USER")
				.build();
		return new InMemoryUserDetailsManager(admin,user);
	}
//	
	@Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
{

	
	 return http.csrf().disable()
             
			 .authorizeHttpRequests().requestMatchers("/User/allstring/allobject").authenticated()
             .and()
             .authorizeHttpRequests().requestMatchers("/User/all").hasRole("ADMIN")
             .and()
             .authorizeHttpRequests().requestMatchers("/User/allstring/**").authenticated()
             .and().formLogin()
             .and().build();
	}

	  @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	
	
}
