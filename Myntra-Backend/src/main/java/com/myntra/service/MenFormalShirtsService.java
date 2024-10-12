package com.myntra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myntra.model.MenFormalShirts;
import com.myntra.model.MenJackets;
import com.myntra.repository.MenFormalShirstRepository;


public interface MenFormalShirtsService {
	
	public List<MenFormalShirts> GetFormalShirtsData();
	
//	@Autowired
//	private MenFormalShirstRepository menFormalShirtsRepo;
//
//	public List<MenFormalShirts> GetFormalShirtsData(){
//		return menFormalShirtsRepo.findAll();
//	}
}
