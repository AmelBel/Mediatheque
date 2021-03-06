package org.project;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(http);
		http
		 .csrf().disable()
		 .authorizeRequests() // ACLs
		 .antMatchers(HttpMethod.GET,"/documents/**").permitAll()
		 .antMatchers("/emprunt/**").authenticated()
		 .anyRequest().authenticated()
		 .and()
		 .formLogin()// Page de login
		 .permitAll()
		 .and()
		 .logout()
		 .logoutUrl("/logout")
		.logoutSuccessUrl("/mediatheque/users")
		 .invalidateHttpSession(true);
		 
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(web);
		web.ignoring()
		.antMatchers("/**/*.js","/**/*.css","/**/*.png","/**/*.ico");//ignorer les javascrpt t les css et les images

	}

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		// TODO Auto-generated method stub
//		//super.configure(auth);
//		// Ici on utilise un realm mémoire, AuthenticationManagerBuilder permet
//		// également de facilement de se connecter à un annuaire LDAP ou une bd
//		
//		 auth.inMemoryAuthentication().withUser("user").password("{noop}"+ "password")
//		 .roles("USER")
//		 .and().withUser("admin").password("{noop}"+ "password")
//		 .roles("USER", "ADMIN");
//	}
	
	
	
}
