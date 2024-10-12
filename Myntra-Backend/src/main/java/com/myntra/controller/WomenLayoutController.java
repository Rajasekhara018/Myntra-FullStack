package com.myntra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.myntra.model.MenLayout;
import com.myntra.model.WomenLayout;
import com.myntra.service.WomenLayoutService;


@RestController
@RequestMapping("api/myntra/women")
@CrossOrigin(origins = "http://localhost:4201")
public class WomenLayoutController {

	@Autowired
	private WomenLayoutService womenLayoutService;
	
	@GetMapping
	public List<WomenLayout> GetAll(){
		return womenLayoutService.GetAllWomenLayoutData();
	}
}
