package com.myntra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myntra.model.MenTShirt;
import com.myntra.service.MenTShirtService;

@RestController
@RequestMapping("api/myntra/men/men-tshirts")
@CrossOrigin(origins = "http://localhost:4201")
public class MenTShirtController {
	@Autowired
	private MenTShirtService menTShirstService;
	
	@GetMapping
	public List<MenTShirt> GetData(){
		return menTShirstService.GetTshirtData();
	}
}
