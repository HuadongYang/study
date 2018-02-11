package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.annotation.ControllerLogAnnotation;
import com.service.IndexService;

@Controller
public class IndexController {

	@Autowired
	IndexService indexService;
	
	@RequestMapping(value="/studentName/{id}")
	@ResponseBody
	@ControllerLogAnnotation
	public String getName(@PathVariable Integer id){
		//System.out.println(session.getId());
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		System.out.println(request.getSession().getId());
		return indexService.getNameById(id);
	}
	
	
}
