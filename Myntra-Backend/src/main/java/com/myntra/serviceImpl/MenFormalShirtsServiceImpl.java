package com.myntra.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myntra.model.MenFormalShirts;
import com.myntra.repository.MenFormalShirstRepository;
import com.myntra.service.MenFormalShirtsService;

@Service
public class MenFormalShirtsServiceImpl implements MenFormalShirtsService {
	
	@Autowired
	private MenFormalShirstRepository menFormalShirtsRepo;


	@Override
	public List<MenFormalShirts> GetFormalShirtsData() {
		// TODO Auto-generated method stub
		return menFormalShirtsRepo.findAll();
	}

}
