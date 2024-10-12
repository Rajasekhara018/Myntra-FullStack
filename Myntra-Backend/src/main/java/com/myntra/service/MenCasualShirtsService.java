package com.myntra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myntra.model.MenCasualShirts;
import com.myntra.model.MenFormalShirts;
import com.myntra.repository.MenCasualShirtsRepository;

public interface MenCasualShirtsService {
	
	public List<MenCasualShirts> GetCasualShirtsData();

//	@Autowired
//	private MenCasualShirtsRepository menCasualShirstReo;
//	
//	public List<MenCasualShirts> GetCasualShirtsData(){
//		return menCasualShirstReo.findAll();
//	}
}
