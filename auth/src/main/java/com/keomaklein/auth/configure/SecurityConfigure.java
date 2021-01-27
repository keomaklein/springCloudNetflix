package com.keomaklein.auth.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.keomaklein.auth.jwt.JwtConfigure;
import com.keomaklein.auth.jwt.JwtTokenProvider;

@Configuration
public class SecurityConfigure extends WebSecurityConfigurerAdapter{
	
	private final JwtTokenProvider jwtTokenProvider;

	@Autowired
	public SecurityConfigure(JwtTokenProvider jwtTokenProvider) {
		this.jwtTokenProvider = jwtTokenProvider;
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptpasswordEncoder = new BCryptPasswordEncoder();
		return bCryptpasswordEncoder;
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManager() throws Exception{		
		return super.authenticationManagerBean();		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.httpBasic().disable()
			.csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
				.authorizeRequests()
				.antMatchers("/login").permitAll()
				.anyRequest().authenticated()
			.and()
				.apply(new JwtConfigure(jwtTokenProvider));
	}
}
