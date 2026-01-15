package com.in28minutes.learn_spring_security.basic;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration             Isabling as now working on jwt
@EnableMethodSecurity(jsr250Enabled = true)
public class BasicAuthSecurityConfiguration {

//	------------------------Filter chain customization-----------------------------------
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> {
										auth
										//  .requestMatchers("/users").hasRole("USER")  //Authorization
											.anyRequest().authenticated();
		});

		http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

		http.httpBasic(Customizer.withDefaults());

		http.csrf(csrf -> csrf.disable());

		http.headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin()));
		
		return http.build();
	}

//	-------------------------Dealing with CORS Error-------------------------------------
	
	// For CORS- dealing globally
	// May not work -then use local one
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods("*").allowedOrigins("http://localhost:5137");
			}
		};
	}
	// For locallly - @CrossOrigin(origins = "http://localhost:5137")

	
	
//	---------------------------Storing multiple user data---------------------------------------
	
	
//Option 1 - Hardcoded + storing in 'In memory database'
//	@Bean
//	public UserDetailsService userDetailsService() {
//
//		var user = User.withUsername("in28minutes").password("{noop}dummy").roles("USER").build();
//
//		var admin = User.withUsername("admin").password("{noop}dummy").roles("ADMIN").build();
//
//		return new InMemoryUserDetailsManager(user, admin);
//	}
	
	
//Option 2 - Hardcoded + storing in a database
	@Bean
	public DataSource dataSource() {
		return  new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
				.build();
	}
	@Bean
	public UserDetailsService userDetailsService(DataSource dataSource) {

		var user = User.withUsername("in28minutes")
//				.password("{noop}dummy")
				.password("dummy").passwordEncoder(str -> passwordEncoder().encode(str))
				.roles("USER")
				.build();

		var admin = User.withUsername("admin")
//				.password("{noop}dummy")
				.password("dummy").passwordEncoder(str -> passwordEncoder().encode(str))
				.roles("ADMIN")
				.build();

		var jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
		jdbcUserDetailsManager.createUser(user);
		jdbcUserDetailsManager.createUser(admin);
		
		return 	jdbcUserDetailsManager;

	}
	
//	 ------------------------------------hashing - Securing Passwords---------------------

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}
	

}
