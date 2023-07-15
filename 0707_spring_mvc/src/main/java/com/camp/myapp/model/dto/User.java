package com.camp.myapp.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class User {
	private String userId;
	private String password;
	private String name;
	private String email;
	
	
}
