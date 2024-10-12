package com.myntra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myntra.model.MenCasualShirts;
import com.myntra.service.MenCasualShirtsService;


@RestController
@RequestMapping("api/myntra/men/casual-shirts")
@CrossOrigin(origins = "http://localhost:4201")
public class MenCasualShirtsController {

	@Autowired
	private MenCasualShirtsService  menCasualShirtsService;

	@GetMapping
	public List<MenCasualShirts> GetData(){
		return menCasualShirtsService.GetCasualShirtsData();
	}
}
