package com.myntra.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myntra.model.WomenLayout;
import com.myntra.repository.WomenLayoutRepository;
import com.myntra.service.WomenLayoutService;

@Service
public class WomenLayoutServiceImpl implements WomenLayoutService {
	
	@Autowired
	private WomenLayoutRepository womenLayoutRepository;
	

	@Override
	public List<WomenLayout> GetAllWomenLayoutData() {
		// TODO Auto-generated method stub
		return womenLayoutRepository.findAll();
	}

}
