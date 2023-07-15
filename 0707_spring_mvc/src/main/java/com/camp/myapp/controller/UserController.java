package com.camp.myapp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.camp.myapp.model.dto.User;
import com.camp.myapp.model.service.UserService;


@RequestMapping("/user")	// 선행 공통 경로 
@Controller
public class UserController {

	private UserService userService;
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/list.do")
	public String getUsers(Model model) {	// 하이퍼링크로 오니까 get방식
		model.addAttribute("users", userService.getUsers());
		return "user/list";
	}
	
	@GetMapping("/register_form.do")
	public String registerForm() {
		return "user/register";		// forward만 되면 됨
	}
	
	@PostMapping("/register.do")
	public String regiter(User user) {
		userService.register(user);
		return "redirect:/"; // homecontroller 타서 index 가니까 forward되니까 rediect 붙혀줘야함
	}
	
	@GetMapping("/detail.do")		// 하이퍼링크로 오니까
	public String getDetail(String userId, Model model) {		// User user로 넘겨도 작동됨	
		model.addAttribute("user", userService.getUser(userId));
		return "user/detail";
	}
	
	@PostMapping("/modify.do")
	public String modifyUser(User user) {	// Model로 옮긴다는건 정보를 Model에 저장한다는 것
		userService.modifyUser(user);
		// 1번. userService.getUsers();	자기가 직접 getUsers호출한다
		return "redirect:/user/list.do"; // "/user.list.do";	// 이건 forward임 근데 이렇게 보내면 url이상해짐
	}
	
	@GetMapping("/remove.do")
	public String removeUser(String userId) {	// Model로 옮긴다는건 정보를 Model에 저장한다는 것
		userService.removeUser(userId);
		return "redirect:/user/list.do"; // "/user.list.do";	// 이건 forward임 근데 이렇게 보내면 url이상해짐 사실 포워딩으로 보낼 필요 없음 so,redirect로 보냄
	}
	
	@PostMapping("/login.do")
	public String login(User user, HttpSession session, Model model) {	// User DTO가 있기 때문에 편하게 가능 안쓰면 map으로도 가능하다,  // name값을 저장하고 있어야하니까 session으로 저장해둠
		String name = userService.login(user); 	// 성공시 name이 오고 실패시 null이 옴
		if (name != null) {
			session.setAttribute("userName", name);
			session.setAttribute("userId", user.getUserId());	
			return "redirect:/";
		}else {
			model.addAttribute("errorMsg", "아이디 또는 비밀번호가 일치하지 않습니다.");	// 이건 session처럼 계속 저장학 있을 필요 없으니까
			return "user/login";
		}
	}
	
	@GetMapping("/logout.do")
	public String logout(HttpSession session) {	// 로그앗웃은 파라미터 필요없지만 session 소멸시켜야하니까 session을 가짐
		session.invalidate(); 	// 삭제
		return "redirect:/";
	}
	
	
	// 예외처리를 local하게 처리 이건 이 controller에서 발생하는 예외만 처리
	@ExceptionHandler(Exception.class) // 일단 예외 다 잡기		// 처리하고 싶은 예외 유형 여러가지 불 수 있음
	public String handelException(Exception e, Model model) {	// Exception 우리가 사용할 수 있으니까 가지고 옴
		model.addAttribute("message", e.getMessage());		// e.getMessage()로 에러 그대로 보낼 수 있음 내가 보내고 싶은 메세지를 보낼 수 있음 "~"
		return "common/error";		// 포워딩 될때 앞에 views 붙으니까
		
	}
	
	
	
	
	
}
