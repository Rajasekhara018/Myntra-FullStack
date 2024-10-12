package com.myntra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myntra.model.MenJackets;
import com.myntra.service.MenJacketsService;


@RestController
@RequestMapping("api/myntra/men/jackets")
@CrossOrigin(origins = "http://localhost:4201")
public class MenJacketsController {
	
	@Autowired
	private MenJacketsService  myenJacketsService;

	@GetMapping
	public List<MenJackets> GetData(){
		return myenJacketsService.GetJacketsData();
	}

}
