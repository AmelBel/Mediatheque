package org.project.service;

import java.util.HashSet;
import java.util.Set;

import org.project.handlerException.UserNotFoundException;
import org.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserAuthentificationService implements UserDetailsService {

	@Autowired
	UserRepository userRepository; 
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		org.project.model.User user =  userRepository.findByLogin(username).orElseThrow(() -> new UsernameNotFoundException("No sush username")); 
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		return new User(user.getLogin(), "{noop}" + user.getPassword(), grantedAuthorities);
	}

}
