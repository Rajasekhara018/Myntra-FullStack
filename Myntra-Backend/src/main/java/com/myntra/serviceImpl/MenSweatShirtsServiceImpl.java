package com.myntra.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myntra.model.MenSweatShirts;
import com.myntra.repository.MenSweatShirtsRepository;
import com.myntra.service.MenSweatShirtsService;

@Service
public class MenSweatShirtsServiceImpl implements MenSweatShirtsService {

	@Autowired
	private MenSweatShirtsRepository menSweatShirstRepo;


	@Override
	public List<MenSweatShirts> GetSweatShirtsData() {
		// TODO Auto-generated method stub
		return menSweatShirstRepo.findAll();
	}

}
