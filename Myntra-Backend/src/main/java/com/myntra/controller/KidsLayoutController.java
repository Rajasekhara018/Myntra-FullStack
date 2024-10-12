package com.myntra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myntra.model.KidsLayout;
import com.myntra.service.KidsLayoutService;

@RestController
@RequestMapping("api/myntra/kids")
@CrossOrigin(origins = "http://localhost:4201")
public class KidsLayoutController {

	@Autowired
	private KidsLayoutService kidsLayoutService;
	
	@GetMapping
	public List<KidsLayout> GetAll(){
		return kidsLayoutService.GetAllKidsLayoutData();
	}
}
