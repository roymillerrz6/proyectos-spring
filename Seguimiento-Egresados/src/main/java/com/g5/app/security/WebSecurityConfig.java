package com.g5.app.security;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class WebSecurityConfig {
	
	
	private final UserDetailsService userDetailsService;
	private final JWTAuthorizationFilter jwtAuthorizationFilter;
	
	
	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception {
		
		JWTAuthenticationFilter jwtAuthenticationFilter = new JWTAuthenticationFilter();
		jwtAuthenticationFilter.setAuthenticationManager(authManager);
		jwtAuthenticationFilter.setFilterProcessesUrl("/login");
	
		return http
				  //.cors(cors -> cors.disable())
				.csrf().disable()
				.cors().configurationSource(corsConfiguration()).and()
				 //.cors().disable()
				 .authorizeRequests()
				 .anyRequest()
				 .authenticated()
				 .and()
				 .sessionManagement()
				 .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				 .and()
				 .addFilter(jwtAuthenticationFilter)
				 .addFilterBefore(jwtAuthorizationFilter,UsernamePasswordAuthenticationFilter.class)
				 .build();
	}

	/*@Bean
	protected UserDetailsService userDetailsService () {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withUsername("admin")
				.password(passwordEncoder().encode("admin"))
				.roles()
				.build());
		return manager;
	}
	*/
	
	@Bean
	protected CorsConfigurationSource corsConfiguration () {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		
		corsConfiguration.applyPermitDefaultValues();
		corsConfiguration.setAllowCredentials(false);
		corsConfiguration.setAllowedOrigins(Arrays.asList("*"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET","POST","PATCH", "PUT", "DELETE", "OPTIONS", "HEAD"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("*"));
        corsConfiguration.setExposedHeaders(Arrays.asList("Authorization"));
        
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.addExposedHeader("*");
        
        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
	}
	
	@Bean
	protected AuthenticationManager authManager (HttpSecurity http) throws Exception {

		
		return http.getSharedObject(AuthenticationManagerBuilder.class)
				.userDetailsService(userDetailsService)
				.passwordEncoder(passwordEncoder())
				.and()
				.build();
	}
	
	@Bean
	protected PasswordEncoder passwordEncoder () {
		return new BCryptPasswordEncoder();
	}
	
	
}
