package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.IndexManager;

@Service
public class IndexService {

	@Autowired
	IndexManager indexManager;
	
	public String getNameById(Integer id){
		return indexManager.queryNameById(id);
	}
}
