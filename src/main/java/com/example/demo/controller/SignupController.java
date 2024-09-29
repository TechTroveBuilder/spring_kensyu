package com.example.demo.controller;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.constant.MessaageConst;
import com.example.demo.form.LoginForm;
import com.example.demo.form.SignupForm;
import com.example.demo.service.LoginService;
import com.example.demo.service.SignupService;
import com.example.demo.util.AppUtil;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class SignupController {

	private final SignupService service;
	
//	private final MessageSource messageSource;
	
	@GetMapping("/signup")
	public String view(Model model,SignupForm form) {
		
		return "signup";
	}
	
	@PostMapping("/signup")
	public void login(Model model,SignupForm form) {	
		service.resistUserInfo(form);
	}

}
