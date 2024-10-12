package com.myntra.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myntra.model.MenLayout;
import com.myntra.repository.MenLayoutRepositpory;
import com.myntra.service.MenLayoutService;

@Service
public class MenLayoutServiceImpl implements MenLayoutService {

	@Autowired
	private MenLayoutRepositpory menLayoutRepository;
	
	
	@Override
	public List<MenLayout> GetAllMenLayoutData() {
		// TODO Auto-generated method stub
		return menLayoutRepository.findAll();
	}

}
