package com.jsL.MarondalGram.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsL.MarondalGram.user.domain.User;
import com.jsL.MarondalGram.user.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserRestController {
	
	private final UserService userService;
	
	public UserRestController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/join")
	public Map<String, String>join(
			@RequestParam("loginId")String loginId
			,@RequestParam("password")String password
			,@RequestParam("phoneNumber")String phoneNumber
			){
		
		boolean result = userService.addUser(loginId, password, phoneNumber);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(result) {
			resultMap.put("result", "success");
		}
		else {
			resultMap.put("result", "fail");
		}
		return resultMap;
	}

	
	
	@PostMapping("/login")
	public Map<String, String>login(
			@RequestParam("loginId")String loginId
			,@RequestParam("password")String password
			,HttpServletRequest request
			){
		
		User user = userService.getUser(loginId, password);
		
		Map<String, String>resultMap = new HashMap<>();
		
		if(user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", user.getId());
			session.setAttribute("userLoginId", user.getLoginId());
			resultMap.put("result", "success");
		}
		else {
			resultMap.put("result", "fail");
		}
		return resultMap;
	}
	
	
	
	
}
