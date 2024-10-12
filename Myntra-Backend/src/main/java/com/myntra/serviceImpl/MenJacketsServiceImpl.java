package com.myntra.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myntra.model.MenJackets;
import com.myntra.repository.MenJacketsRepository;
import com.myntra.service.MenJacketsService;

@Service 
public class MenJacketsServiceImpl implements MenJacketsService {

	@Autowired
	private MenJacketsRepository menJacketsRepo;

	
	@Override
	public List<MenJackets> GetJacketsData() {
		// TODO Auto-generated method stub
		return menJacketsRepo.findAll();
	}

}
