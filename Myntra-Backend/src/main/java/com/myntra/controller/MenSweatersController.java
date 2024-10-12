package com.myntra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myntra.model.MenSweaters;
import com.myntra.service.MenSweatersService;



@RestController
@RequestMapping("api/myntra/men/sweaters")
@CrossOrigin(origins = "http://localhost:4201")
public class MenSweatersController {

	@Autowired
	private MenSweatersService  menSweatersService;

	@GetMapping
	public List<MenSweaters> GetData(){
		return menSweatersService.GetSweatersData();
	}
}
