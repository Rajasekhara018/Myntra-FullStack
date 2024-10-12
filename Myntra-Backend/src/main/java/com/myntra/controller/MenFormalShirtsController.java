package com.myntra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myntra.model.MenFormalShirts;
import com.myntra.service.MenFormalShirtsService;


@RestController
@RequestMapping("api/myntra/men/formal-shirts")
@CrossOrigin(origins = "http://localhost:4201")
public class MenFormalShirtsController {

	@Autowired
	private MenFormalShirtsService  menFormalShirtsService;

	@GetMapping
	public List<MenFormalShirts> GetData(){
		return menFormalShirtsService.GetFormalShirtsData();
	}
}
