package com.camp.myapp.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.camp.myapp.model.dto.Person;

@Controller	// controller 하나가 여러 메소드를 가질수 있고 이제 메서드 단위로 됨 다루는 domain data가 같은 애들끼리 뭉침 user controller안에 로그인 로그아웃 메소드...
public class HelloController {	// 포조인데 퍼펙트 포조는 아님, 
	
//	@RequestMapping(value = {"/hello.do", "/hi.do"}, method = RequestMethod.GET) // 요청 처리, 어떤 것이 들어왔을 때 반응할 것인가
	@GetMapping({"/hello.do", "/hi.do"})	//위에랑 같은데 method = RequestMethod.GET없어도 get만 처리
	public ModelAndView hello() {
		// service 연동 후 데이터 결과 생김
		ModelAndView mav = new ModelAndView();	//저장소 개념 request에 저장해줌
		mav.addObject("result", "Hello Spring!!"); //
		mav.setViewName("hello");	//기본이 forward redirection하고 싶으면 redirect:hello로
		return mav;
	}
	
	@GetMapping("/hello.camp")
	public String hello2(Model model) {	// Model 객체는 컨트롤러에서 데이터를 생성해 이를 JSP 즉 View에 전달하는 역할을 합니다. HashMap 형태를 갖고 있고, 키(key)와, 밸류(value) 값을 저장합니다.
		model.addAttribute("result", "Hello Spring2");
		return "hello"; // view name을 리턴 값으로 처리
	}
	
	
	@PostMapping("/param.do")
	public String helloUser(@RequestParam("name") String name, String gender, String[] hobby, Model model) {	// 일일히 받는 건 힘듬 so DTO로 포장하는 과정할것
		model.addAttribute("result", name+"/"+gender+"/"+Arrays.toString(hobby));
		return "hello";
	}
	
	//@PostMapping("/param.do")
	//public String helloUser2(Person person, Model model) {	// DTO로 포장(Person)
	//	model.addAttribute("result", person.getName()+"/"+person.getGender()+"/"+Arrays.toString(person.getHobby()));
	//	return "hello";
	//}
	
	
	
	@GetMapping("/param_form.do")
	public String paramForm() {
		return "param";		// redirect 안됨
	}
	

}
