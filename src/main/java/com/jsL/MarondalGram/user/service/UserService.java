package com.jsL.MarondalGram.user.service;

import org.springframework.stereotype.Service;

import com.jsL.MarondalGram.user.common.MD5HashingEncoder;
import com.jsL.MarondalGram.user.domain.User;
import com.jsL.MarondalGram.user.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public boolean addUser(String loginId, String password, String phoneNumber) {
	
		String encyptPassword = MD5HashingEncoder.encode(password);
		
		int count = userRepository.insertUser(loginId, encyptPassword, phoneNumber);
		
		if(count > 0) {
			return true;
		}
		return false;
	}
	
	
	public User getUser(String loginId, String password) {
		
		String encyptPassword = MD5HashingEncoder.encode(password);
		
		User user = userRepository.selectUser(loginId, encyptPassword);
		return user;
	}
	
	
	
}
