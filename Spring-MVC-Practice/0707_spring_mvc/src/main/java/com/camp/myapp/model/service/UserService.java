package com.camp.myapp.model.service;

import java.util.List;

import com.camp.myapp.model.dto.User;

public interface UserService {
	
	// 사용자 삭제 : 아이디로 삭제
	void removeUser(String userId);
	// 사용자 수정 : 아이디에 해당하는 사용자의 비밀번호, 이메일 수정
	void modifyUser(User user);
	// 사용자 목록조회 : 사용자 전체 리스트 조회
	List<User> getUsers();
	// 사용자 조회 : 아이디에 해당하는 사용자 조회
	User getUser(String userId);
	
	String login(User user);

	boolean register(User user);

}