package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class KenbaController {

	@RequestMapping("/index")
	public String index(Model model) {
		return "index";
	}

}
