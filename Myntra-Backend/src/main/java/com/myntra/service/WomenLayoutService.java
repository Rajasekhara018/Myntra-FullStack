package com.myntra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.myntra.model.WomenLayout;
import com.myntra.repository.WomenLayoutRepository;


public interface WomenLayoutService {
	
	
	public List<WomenLayout> GetAllWomenLayoutData();
	
//	@Autowired
//	private WomenLayoutRepository womenLayoutRepository;
//	
//	public List<WomenLayout> GetAllWomenLayoutData(){
//		return womenLayoutRepository.findAll();
//	}

}
