package com.jsL.MarondalGram.user.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jsL.MarondalGram.user.domain.User;

@Mapper
public interface UserRepository {
	
	public int insertUser(
			@Param("loginId")String loginId
			,@Param("password")String password
			,@Param("phoneNumber")String phoneNumber
			);
	
	public User selectUser(
			@Param("loginId")String loginId
			,@Param("password")String password
			);
	
	public int deleteUser(@Param("id")String id);
	
	
	public int selectCountByLoginId(@Param("loginId")String loginId);
	
	
	public User selectUserById(@Param("id") int id);
	
	
	
	
}
