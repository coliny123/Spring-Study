package com.camp.myapp.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.camp.myapp.model.dto.User;

@Mapper
public interface UserDAO {

	// 사용자 삭제 : 아이디로 삭제
	void deleteUser(String userId);
	// 사용자 수정 : 아이디에 해당하는 사용자의 비밀번호, 이메일 수정
	void updateUser(User user);
	// 사용자 목록조회 : 사용자 전체 리스트 조회
	List<User> selectUsers();
	
	String selectName(User user);

	User selectUser(String userId);

	void add(User user);
	

}