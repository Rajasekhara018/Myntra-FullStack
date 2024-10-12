package com.myntra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myntra.model.MenSweatShirts;
import com.myntra.model.MenSweaters;
import com.myntra.repository.MenSweatersRepository;


public interface MenSweatersService {
	
	public List<MenSweaters> GetSweatersData();
	
//	@Autowired
//	private MenSweatersRepository menSweatersRepo;
//
//	public List<MenSweaters> GetSweatersData(){
//		return menSweatersRepo.findAll();
//	}
}
