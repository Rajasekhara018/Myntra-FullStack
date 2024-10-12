package com.myntra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myntra.model.MenRainJackets;
import com.myntra.model.MenSuits;
import com.myntra.repository.MenRainJacketsRepository;

public interface MenRainJacketsService {
	
	
	public List<MenRainJackets> GetRainJacketsData();
//	@Autowired
//	private MenRainJacketsRepository menRainJacketsRepo;
//
//	public List<MenRainJackets> GetRainJacketsData(){
//		return menRainJacketsRepo.findAll();
//	}
}
