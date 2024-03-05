package com.securitydemo.jwtAuth.config;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.securitydemo.jwtAuth.model.User;

public class CustomUser implements UserDetails {
	
	 @Bean
	 public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	  }
	
	private User usr ;
	
	public CustomUser(User usr) {
		super();
		this.usr = usr;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null ;
	}

	@Override
	public String getPassword() {
		return passwordEncoder().encode(usr.getPassword()) ;
	}

	@Override
	public String getUsername() {
		return usr.getEmail() ;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
