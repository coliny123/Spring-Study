package com.camp.myapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.camp.myapp.model.dto.User;
import com.camp.myapp.model.service.UserService;

@CrossOrigin("*")		// (동일 출처 원칙 보안)때문에 막아둠 비동기 통신? 프론트에서는 우리 백엔드server에 요청 우리 백엔드가 타 백엔드에게 요청 가져와서 토스 / 지금은 편의때문에 풀어둠
@RequestMapping("/api/users")	// 선행 공통 경로 
// @RestController 		// REST 통신을 하는 API에 맞는 컨트롤러 @ResponseBody 계속 붙힐 필요 없음 , 이 컨트롤러가 리턴하는 것은 자원DATA!
public class UserRESTController2 {
	private UserService userService;
	public UserRESTController2(UserService userService) {
		super();
		this.userService = userService;
	}
	
	// @ResponseBody	// 내가 리턴하는 값은 view 정보가 아니라 응답메세지의 body에 써야하는 내용이다. 객체를 줄 수 없음 so, xml이나 json으로 바꿔야함 자동으로 됨? 
	@GetMapping // 선행경로를 get방식으로 받는다
	public List<User> getUsers() {	// view로 안가니까 model안씀	
		return userService.getUsers();
	}
	
	// /api/users/xxx <-이게 바뀜 path variable
	// @ResponseBody
	@GetMapping("/{userId}")	// 계속 바뀌니까ㅑ
	public User getDetail(@PathVariable String userId) {		// 요청바라미터와 pathvariable은 다름!~!!!!
		return userService.getUser(userId);
	}
	
	
	// GET은 
	// @ResponseBody
	@PostMapping
	public boolean regiter(@RequestBody User user) {		// 요청파라미터를 가진 user가 아니라 요처아라미터의 바디에 있는 걸 컨버팅해서 담아주면 됨
		userService.register(user);
		return true; 
	}
	
	@PutMapping("/{id}")	// 원래 있는 자원 수정하는 거니까 put
	public boolean modifyUser(@PathVariable("id") String userId, @RequestBody User user) {		// 간단하게 만들기 위해 리턴값 boolean으로 줌
		userService.modifyUser(user); 
		return true;
	}
	
	
	@DeleteMapping("/{userId}")
	public boolean removeUser(@PathVariable String userId) {	
		userService.removeUser(userId);
		return true; 
	}
	
	
	
	/*
	 * SpringBoot
	 * 		: 과도한 설정으로 인한 프레임워크를 사용한 개발의 어려움 해결, 환경부스터 스프링부트개발환경으로 스프링을 개발하는 것
	 * - 설정이 내장되어있다: 	ex)encoding, dispatcher 설정, internal resource view resolver, enotation...
	 * 	    ㄴ 애노테이션 + 자바소스Config //xml보단 자바소스Config사용함, 그래도 사용가능
	 * - 부트 디펜던시: 지금까지는 live 디펜던시 다 세팅해서 썻는데 비슷한 것 모아저있는 디펜던시 세팅되어있음
	 * - 서버 내장: 지금까지
	 * 
	 * 
	 * 
	*/
	
}
