package com.myntra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myntra.model.MenSweatShirts;
import com.myntra.model.MenTShirt;
import com.myntra.repository.MenSweatShirtsRepository;


public interface MenSweatShirtsService {
	
	public List<MenSweatShirts> GetSweatShirtsData();
	
//	@Autowired
//	private MenSweatShirtsRepository menSweatShirstRepo;
//
//	public List<MenSweatShirts> GetSweatShirtsData(){
//		return menSweatShirstRepo.findAll();
//	}
}
