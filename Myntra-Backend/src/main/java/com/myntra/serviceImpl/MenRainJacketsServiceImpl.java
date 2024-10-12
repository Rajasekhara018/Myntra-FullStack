package com.myntra.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myntra.model.MenRainJackets;
import com.myntra.repository.MenRainJacketsRepository;
import com.myntra.service.MenRainJacketsService;

@Service
public class MenRainJacketsServiceImpl implements MenRainJacketsService {

	
	@Autowired
	private MenRainJacketsRepository menRainJacketsRepo;
	
	@Override
	public List<MenRainJackets> GetRainJacketsData() {
		// TODO Auto-generated method stub
		return menRainJacketsRepo.findAll();
	}

}
