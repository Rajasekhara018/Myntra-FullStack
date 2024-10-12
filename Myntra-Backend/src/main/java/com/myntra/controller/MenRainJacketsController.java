package com.myntra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myntra.model.MenRainJackets;
import com.myntra.service.MenRainJacketsService;



@RestController
@RequestMapping("api/myntra/men/rain-jackets")
@CrossOrigin(origins = "http://localhost:4201")
public class MenRainJacketsController {

	@Autowired
	private MenRainJacketsService  menRainJacketsService;

	@GetMapping
	public List<MenRainJackets> GetData(){
		return menRainJacketsService.GetRainJacketsData();
	}
}
