package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class IndexController {

	
	@RequestMapping(value="/wel")
	@ResponseBody
	public String getName(){
		return "noConfiguration welcome";
	}
	
	
	@RequestMapping(value="/login")
	public String login(){
		return "/login";
	}
}
