package com.myntra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myntra.model.MenSweatShirts;
import com.myntra.service.MenSweatShirtsService;



@RestController
@RequestMapping("api/myntra/men/sweat-shirt")
@CrossOrigin(origins = "http://localhost:4201")
public class MenSweatShirtsController {

	@Autowired
	private MenSweatShirtsService  menSweatShirtsService;

	@GetMapping
	public List<MenSweatShirts> GetData(){
		return menSweatShirtsService.GetSweatShirtsData();
	}
}
