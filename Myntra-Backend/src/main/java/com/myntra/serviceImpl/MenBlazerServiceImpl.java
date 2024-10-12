package com.myntra.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myntra.model.MenBlazer;
import com.myntra.repository.MenBlazerRepository;
import com.myntra.service.MenBlazerService;

@Service
public class MenBlazerServiceImpl implements MenBlazerService {
	
	@Autowired
	private MenBlazerRepository menBlazerRepo;

	@Override
	public List<MenBlazer> GetBlazersData() {
		// TODO Auto-generated method stub
		return menBlazerRepo.findAll();
	}

}
