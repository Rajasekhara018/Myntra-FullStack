package com.myntra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myntra.model.MenSuits;
import com.myntra.service.MenSuitsService;



@RestController
@RequestMapping("api/myntra/men/suits")
@CrossOrigin(origins = "http://localhost:4201")
public class MenSuitsController {

	@Autowired
	private MenSuitsService  menSuitsService;

	@GetMapping
	public List<MenSuits> GetData(){
		return menSuitsService.GetSuitsData();
	}
}
