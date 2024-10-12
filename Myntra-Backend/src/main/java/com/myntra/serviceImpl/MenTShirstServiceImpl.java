package com.myntra.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myntra.model.MenTShirt;
import com.myntra.repository.MenTShirtRepository;
import com.myntra.service.MenTShirtService;

@Service
public class MenTShirstServiceImpl implements MenTShirtService  {
	
	@Autowired
	private MenTShirtRepository myntraMenTshirtRepository;
	

	@Override
	public List<MenTShirt> GetTshirtData() {
		// TODO Auto-generated method stub
		return myntraMenTshirtRepository.findAll();
	}

}
