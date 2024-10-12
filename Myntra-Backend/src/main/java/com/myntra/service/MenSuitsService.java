package com.myntra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myntra.model.MenSuits;
import com.myntra.model.MenSweaters;
import com.myntra.repository.MenSuitsRepository;


public interface MenSuitsService {
	
	public List<MenSuits> GetSuitsData();
	
//	@Autowired
//	private MenSuitsRepository menSuitsRepo;
//
//	public List<MenSuits> GetSuitsData(){
//		return menSuitsRepo.findAll();
//	}
}
