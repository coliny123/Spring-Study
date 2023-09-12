package com.camp.myapp.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET) // servlet의 do get과 같다 post로 바꾸면 do post ... 요청을 받아서 처리하는 메소드다 get방식만 허용 "/"으로 들어오면 반응한다~?
	public String home() {	//포조? = pojo
		return "index";	// 뷰 네임 이거로는 이동 못함 Dispatch servlet가 view resolver에게 물어봐서 찾음 WEB-INF의 views의 home.jsp(view page)가 실행됨
	}
	
}
