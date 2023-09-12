package com.camp.myapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Data 		// * @see Getter, @see Setter, @see RequiredArgsConstructor, @see ToString, @see EqualsAndHashCode, @see lombok.Value
			// 매개변수 없는 생성자 안만들어짐

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Person {
	private String name;
	private String gender;
	private String[] hobby;
	
	// default 생성자 만드는게 좋음
	// 뻔하고 반복되는 코드(생성자, getter, setter ...) 자동 생성해주는 것 = lombok
}
