package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class IndexController {

	
	@RequestMapping(value="/sudentName/{id}")
	@ResponseBody
	public String getName(@PathVariable Integer id){
		return "noConfiguration welcome";
	}
	
}
