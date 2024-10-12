package com.myntra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myntra.model.MenTShirt;

import com.myntra.repository.MenTShirtRepository;


public interface MenTShirtService {
	
	public List<MenTShirt> GetTshirtData();

//	@Autowired
//	private MenTShirtRepository myntraMenTshirtRepository;
//	
//	public List<MenTShirt> GetTshirtData(){
//		return myntraMenTshirtRepository.findAll();
//	}
}
