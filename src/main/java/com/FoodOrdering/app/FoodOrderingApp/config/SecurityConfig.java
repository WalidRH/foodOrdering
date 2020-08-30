package com.FoodOrdering.app.FoodOrderingApp.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.FoodOrdering.app.FoodOrderingApp.service.impl.CustomeUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	CustomeUserDetailsService userDetails;

	@Autowired
	private JwtConfigure configurer;


	// Defining datasource for the user
	@Override
	protected void configure(AuthenticationManagerBuilder auth) {

		try {
			auth.userDetailsService(userDetails).passwordEncoder(passwordEncoder());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	// configure authorize requests
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.httpBasic().disable().csrf().disable().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and().authorizeRequests()
				.antMatchers("/api/auth/login").permitAll()
				.antMatchers("/api/auth/signup").permitAll()
				.antMatchers("/api/order/OrderedMenus/popular").permitAll()
				.antMatchers("/api/menu/add").hasAuthority("ROLE_ADMIN")
				.antMatchers("/api/menu/edit").hasAuthority("ROLE_ADMIN")
				.antMatchers("/api/order/OrderedMenus").hasAuthority("ROLE_ADMIN")
				.antMatchers("/api/menu/**").hasAuthority("ROLE_USER")
				.antMatchers("/api/order/**").authenticated()
				.anyRequest().authenticated()
				.and().csrf().disable().exceptionHandling().authenticationEntryPoint(unauthorizedEntryPoint()).and()
				.apply(configurer);
		http.cors();

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public AuthenticationEntryPoint unauthorizedEntryPoint() {
		return (request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
				"Unauthorized");
	}

}
