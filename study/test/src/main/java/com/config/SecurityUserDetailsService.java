package com.config;

import java.util.ArrayList;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
@Component
public class SecurityUserDetailsService implements UserDetailsService {

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		ArrayList<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();  
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));  
        if(username.compareTo("lipore")==0){  
            return new User(username,"123456",authorities);  
        }else if(username.compareTo("admin")==0){  
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));  
            return new User(username,"123456",authorities);  
        }  
        return null;  
	}

}
