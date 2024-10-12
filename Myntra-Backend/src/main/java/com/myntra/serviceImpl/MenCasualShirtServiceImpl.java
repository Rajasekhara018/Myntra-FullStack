package com.myntra.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myntra.model.MenCasualShirts;
import com.myntra.repository.MenCasualShirtsRepository;
import com.myntra.service.MenCasualShirtsService;

@Service
public class MenCasualShirtServiceImpl implements MenCasualShirtsService {

	@Autowired
	private MenCasualShirtsRepository menCasualShirstReo;
	
	
	@Override
	public List<MenCasualShirts> GetCasualShirtsData() {
		// TODO Auto-generated method stub
		return menCasualShirstReo.findAll();
	}

}
