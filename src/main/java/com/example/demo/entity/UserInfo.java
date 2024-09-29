package com.example.demo.entity;

import lombok.Data;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user_info")
@Data
public class UserInfo {
	
	@Id
	@Column(name = "login_id")
	private String loginId;
	
	private String password;
}
