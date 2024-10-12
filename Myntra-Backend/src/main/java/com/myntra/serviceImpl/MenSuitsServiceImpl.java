package com.myntra.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myntra.model.MenSuits;
import com.myntra.repository.MenSuitsRepository;
import com.myntra.service.MenSuitsService;

@Service
public class MenSuitsServiceImpl implements MenSuitsService {
	
	@Autowired
	private MenSuitsRepository menSuitsRepo;


	@Override
	public List<MenSuits> GetSuitsData() {
		// TODO Auto-generated method stub
		return menSuitsRepo.findAll();
	}

}
