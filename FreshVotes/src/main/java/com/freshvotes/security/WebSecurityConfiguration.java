package com.freshvotes.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


//this tells Spring that it is a Java version of an XML config file
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{

	// authentication = who are you (by username) and prove it (by password)
	// authorization = what type of user are you and what do you have access to
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// authentication = who are you (by username) and prove it (by password)
		
		// this method is to tell Spring security where the username and password is stored
		auth.inMemoryAuthentication()
			.withUser("trevor@craftycodr.com")
			.password("asdfasdf")
			.roles("USER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// authorization = what type of user are you and what do you have access to
		
		
		
		// "/" means allow anyone permission
		// "/index" means only the index file has permission
		http.csrf().disable()
					.authorizeRequests()
						.antMatchers("/").permitAll()
						.anyRequest().hasRole("USER").and()
					.formLogin()
						.loginPage("/login")
						.permitAll()
						.and()
					.logout()
						.logoutUrl("/logout")
						.permitAll();
	}
	
	
}