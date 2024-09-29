package com.example.demo.form;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LoginForm {
	
	@Length(max = 20)
	@NotEmpty
	private String loginId;
	@NotEmpty
	private String password;

}