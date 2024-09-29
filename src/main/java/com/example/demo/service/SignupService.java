package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.UserInfo;
import com.example.demo.form.SignupForm;
import com.example.demo.repository.UserInfoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SignupService {
	private final UserInfoRepository repository;
	
	public UserInfo resistUserInfo(SignupForm form){
		var userInfo = new UserInfo();
		userInfo.setLoginId(form.getLoginId());
		userInfo.setPassword(form.getPassword());
		
		return repository.save(userInfo);
	}
}
