package com.taerin.chatGpt.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontController {
	
	@RequestMapping(value="/test")
	public String test(Model model) {
		model.addAttribute("test", "테스트 성공");
		return "test";
	}

}
