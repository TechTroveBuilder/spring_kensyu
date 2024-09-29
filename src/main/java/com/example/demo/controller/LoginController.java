package com.example.demo.controller;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.constant.MessaageConst;
import com.example.demo.form.LoginForm;
import com.example.demo.service.LoginService;
import com.example.demo.util.AppUtil;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class LoginController {

	private final LoginService service;
	
	private final MessageSource messageSource;
	
	@GetMapping("/login")
	public String view(Model model,LoginForm form) {
		
		return "login";
	}
	
	@PostMapping("/login")
	public String login(Model model,@Validated LoginForm form,BindingResult bdResult) {
		if(bdResult.hasErrors()) {
			return "login";
		}
		
		var userInfo = service.searchUserById(form.getLoginId());
		var isCorrectUserAuth = userInfo.isPresent() 
				&& form.getPassword().equals(userInfo.get().getPassword());
		
		if(isCorrectUserAuth) {
			return "redirect:/menu";
		}else {
			var errorMsg = AppUtil.getMessage(messageSource, MessaageConst.LOGIN_WRONG_INPUT);
			model.addAttribute("errorMsg",errorMsg);
			return "login";
		}
			
	}

}
