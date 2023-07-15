package com.camp.myapp.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

@CrossOrigin("*")		
@RequestMapping("/api/users")	// 선행 공통 경로 
@RestController 		// REST 통신을 하는 API에 맞는 컨트롤러 @ResponseBody 계속 붙힐 필요 없음 , 이 컨트롤러가 리턴하는 것은 자원DATA!
public class UserRESTController {
	private UserService userService;
	public UserRESTController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping // 선행경로를 get방식으로 받는다
	public ResponseEntity<List<User>> getUsers() {	
		return new ResponseEntity<List<User>>(userService.getUsers(), HttpStatus.OK); // (바디, 상태)		// 응답을 세분화 : 응답내용, 응답 헤더, 상태코드 다 세팅할 수 있다
	}
	
	@GetMapping("/{userId}")	// 계속 바뀌니까ㅑ
	public ResponseEntity<?> getDetail(@PathVariable String userId) {		// 리턴이 뭐가 올지 모르기 때문에 ResponseEntity<?>함 -> 안쓰는게 좋음
		User user =  userService.getUser(userId);
		if(user != null) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}else {
			return ResponseEntity.notFound().build();		// ResponseEntity도 객체 빌더 패턴이 적용됨, 위의 형태로 notfound404로 세팅하고 리턴하고 리턴타입 맞춰둬도됨
		}
	}

	@PostMapping
	public ResponseEntity regiter(@RequestBody User user) {		
		boolean result = userService.register(user);
		if(result) {
			return ResponseEntity.created(URI.create("/api/users"+user.getUserId())).build();	// header?
		}else{
			return ResponseEntity.internalServerError().build(); 
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity modifyUser(@PathVariable("id") String userId, @RequestBody User user) {
		userService.modifyUser(user);
		return ResponseEntity.ok().build();		// 바디에 아무것도 안감 그냥상태ㅏㄴ
	}
	
	
	@DeleteMapping("/{userId}")		// 없어도 예외발생 안하면 성공 204으로 뜸
	public ResponseEntity removeUser(@PathVariable String userId) {	
		userService.removeUser(userId);
		return ResponseEntity.noContent().build(); 
	}
	
	
	
	
	
}
