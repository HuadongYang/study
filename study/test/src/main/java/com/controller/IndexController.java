package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Util.UserUtil;
import com.pojo.vo.User;
import com.service.IndexService;

@Controller
public class IndexController {

	@Autowired
	IndexService indexService;
	
	@RequestMapping(value="/sudentName/{id}")
	@ResponseBody
	public String getName(@PathVariable Integer id){
		return indexService.getNameById(id);
	}
	
	@RequestMapping(value="/getLoginUser")
	@ResponseBody
	public Object getName(){
		return UserUtil.getLoginUer();
	}
	
}
