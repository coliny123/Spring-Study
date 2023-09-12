package com.camp.myapp.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


// 예외처리는 global 예외처리,Hello, Home, User 마다 local하게 예외처리 가능
// 이건 글로벌 
@ControllerAdvice
public class GlobalExceptionAdvice {// pojo니까 메소드 마음대로 만들 수 있ㅇㅁ
	
	@ExceptionHandler(Exception.class) // 일단 예외 다 잡기		// 처리하고 싶은 예외 유형 여러가지 불 수 있음
	public String handelException(Exception e, Model model) {	// Exception 우리가 사용할 수 있으니까 가지고 옴
		model.addAttribute("message", e.getMessage());		// e.getMessage()로 에러 그대로 보낼 수 있음 내가 보내고 싶은 메세지를 보낼 수 있음 "~"
		return "common/error";		// 포워딩 될때 앞에 views 붙으니까
		
	}

}


/*
 * -REST(REpresentational Status Transfer)란?
 * 네트워크 상의 자원을 uri(리소스에대한 식별자)로 표현하고 데이터를 주고 받는 방법에 대한 아키텍쳐(구조)
 * 자주 사용되는 http 프로토콜을 처리
 * 지금까지 우리는 view 종속적으로 개발해서 controller도 view 타입에 종속적이엇는데 
 * 실제는 백엔드가 data 기반 응답 으로 data만 제공해주면됨 -> 다양한 view에 처리에 필요한 data제공할 수 있다. 화면 보여주는 건 프론트가 해줌, controller를 재사용할 수 있다.
 * 
 * -REST(HTTP) 구성요소
 * 1. 자원 식별: URL(HTTP의 URI) ex) ~~~/users , ~~~~~/boards url의 규칙은 표준화x
 * 						~~~/users/java, ~~~~~/boards/1
 * 2. 작업: 달라, 삭제, 수정 등 처리작업은 HTTP의 주로 Method(요청방식)사용해서 식별,구분,처리
 * 		url이 같아도 요청방식이 다르면 다른 controller로 봄(요청방식까지 같으면 안됨)
 * 			get : 자원 조회
 * 			post : 자원 생성(등록)
 * 			put : 자원 수정,	patch : 자원 {일부} 수정
 * 			delete : 자원 삭제
 * 	3. 표현: 자원데이터(조회일경우) + 처리 상태
 * 			=> 자원데이터 : text, csv, tsv, xml(서로다른플렛폼간), json(자바스크립트로 객체표현)
 * 			=> 처리 상태 : http status(200, 404, 500 등등)
 * 
 * 
 *-RESTful : REST 아키텍쳐를 잘 준수한 
 *-RESTful API : RESTful하게 만든 서비스
 *
 * 리펙토링할 때 model은 바뀌는것 없고 controller만 바뀜
 *
 *
*/