/*package com.shweta.springwebservices.sportyshoes.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;



@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	PasswordEncoder passworEndoder;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/","index","/css/*","/js/*").permitAll()		
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
	}
	
	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
		
		UserDetails user1 = User.builder().username("user1")
				.password(passworEndoder.encode("password"))
				.authorities(ApplicationUserRole.USER.getGrandtedAuthorities())
//				.roles(ApplicationUserRole.USER.name())
				.build();
		
		UserDetails user2 = User.builder().username("user2")
				.password(passworEndoder.encode("password@123"))
				.authorities(ApplicationUserRole.USER.getGrandtedAuthorities())
//				.roles(ApplicationUserRole.VENDOR.name())
				.build();
		
		UserDetails admin1 = User.builder().username("admin1")
				.password(passworEndoder.encode("password@121"))
				.authorities(ApplicationUserRole.ADMIN.getGrandtedAuthorities())
//				.roles(ApplicationUserRole.ADMIN.name())
				.build();
		
		return new InMemoryUserDetailsManager(
				user1, user2 , admin1
				);
		
	}
}
*/