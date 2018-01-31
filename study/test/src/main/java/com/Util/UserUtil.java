package com.Util;

import org.springframework.security.core.context.SecurityContextHolder;

import com.pojo.vo.User;

public class UserUtil {

	public static Object getLoginUer(){
		if(SecurityContextHolder.getContext() == null || SecurityContextHolder.getContext().getAuthentication() == null){
			return null;
		}else{
			Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			return user  ; 
		}
	} 
}
