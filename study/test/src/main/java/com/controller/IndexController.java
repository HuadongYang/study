package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
		return indexService.getNameById(id);
	}
	
	
}
