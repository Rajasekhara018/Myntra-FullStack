package com.myntra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myntra.model.MenBlazer;
import com.myntra.service.MenBlazerService;


@RestController
@RequestMapping("api/myntra/men/blazers-coats-shirts")
@CrossOrigin(origins = "http://localhost:4201")
public class MenBlazerController {

	@Autowired
	private MenBlazerService menBalzerService;

	@GetMapping
	public List<MenBlazer> GetData(){
		return menBalzerService.GetBlazersData();
	}
}
