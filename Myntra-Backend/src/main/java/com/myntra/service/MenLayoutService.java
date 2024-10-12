package com.myntra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myntra.model.MenLayout;
import com.myntra.repository.MenLayoutRepositpory;


public interface MenLayoutService {
	
	public List<MenLayout> GetAllMenLayoutData();
	
//	@Autowired
//	private MenLayoutRepositpory menLayoutRepository;
//	
//	public List<MenLayout> GetAllMenLayoutData(){
//		return menLayoutRepository.findAll();
//	}
}
