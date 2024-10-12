package com.myntra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myntra.model.MenBlazer;
import com.myntra.model.MenCasualShirts;
import com.myntra.repository.MenBlazerRepository;


public interface MenBlazerService {
	
	public List<MenBlazer> GetBlazersData();
	
//	@Autowired
//	private MenBlazerRepository menBlazerRepo;
//
//	public List<MenBlazer> GetBlazersData(){
//		return menBlazerRepo.findAll();
//	}
}
