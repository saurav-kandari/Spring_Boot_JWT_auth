package com.securitydemo.jwtAuth.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.securitydemo.jwtAuth.dao.UserRepo;
import com.securitydemo.jwtAuth.model.User;

public class EmployeeDetailService implements UserDetailsService {
	
	@Autowired
	private UserRepo usrRepo ;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User usr = usrRepo.findByEmail(username) ;
		if (usr == null) {
			throw new UsernameNotFoundException("user name not found");
		} else {
			return new CustomUser(usr);
		}
	}
	
	
	

}
