package com.myntra.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myntra.model.KidsLayout;
import com.myntra.repository.KidsLayoutRepository;
import com.myntra.service.KidsLayoutService;

@Service
public class KidsLayoutServiceImpl implements KidsLayoutService {

	@Autowired
	private KidsLayoutRepository kidsLayoutRepository;
	
	@Override
	public List<KidsLayout> GetAllKidsLayoutData() {
		// TODO Auto-generated method stub
		return kidsLayoutRepository.findAll();
	}

}
