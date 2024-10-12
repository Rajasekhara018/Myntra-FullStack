package com.myntra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myntra.model.KidsLayout;
import com.myntra.repository.KidsLayoutRepository;


public interface KidsLayoutService {
	
	public List<KidsLayout> GetAllKidsLayoutData();

	
//	@Autowired
//	private KidsLayoutRepository kidsLayoutRepository;
//	
//	public List<KidsLayout> GetAllKidsLayoutData(){
//		return kidsLayoutRepository.findAll();
//	}
}
