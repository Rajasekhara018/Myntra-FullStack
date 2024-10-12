package com.myntra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myntra.model.MenLayout;
import com.myntra.service.MenLayoutService;



@RestController
@RequestMapping("api/myntra/men")
@CrossOrigin(origins = "http://localhost:4201")
public class MenLayoutController {

	@Autowired
	private MenLayoutService menLayoutService;
	
	@GetMapping
	public List<MenLayout> GetAll(){
		return menLayoutService.GetAllMenLayoutData();
	}
}
