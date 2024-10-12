package com.myntra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myntra.model.MenJackets;
import com.myntra.model.MenRainJackets;
import com.myntra.repository.MenJacketsRepository;

public interface MenJacketsService {
	
	public List<MenJackets> GetJacketsData();
	
//	@Autowired
//	private MenJacketsRepository menJacketsRepo;
//
//	public List<MenJackets> GetJacketsData(){
//		return menJacketsRepo.findAll();
//	}
}
