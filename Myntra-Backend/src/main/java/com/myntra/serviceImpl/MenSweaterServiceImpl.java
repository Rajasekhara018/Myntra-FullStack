package com.myntra.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myntra.model.MenSweaters;
import com.myntra.repository.MenSweatersRepository;
import com.myntra.service.MenSweatersService;

@Service
public class MenSweaterServiceImpl implements MenSweatersService {
	@Autowired
	private MenSweatersRepository menSweatersRepo;


	@Override
	public List<MenSweaters> GetSweatersData() {
		// TODO Auto-generated method stub
		return menSweatersRepo.findAll();
	}

}
