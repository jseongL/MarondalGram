package com.jsL.MarondalGram.post;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsL.MarondalGram.post.service.PostService;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/post")
@RestController
public class PostRestController {
	
	private PostService postService;
	public PostRestController(PostService postService) {
		this.postService = postService;
	}
	

	
	@PostMapping("/createProfile")
	public Map<String, String>createPrifile(
			@RequestParam String title
			,@RequestParam String contents
//			,@RequestParam(required=false) String imagePath
//			,@RequestParam(required=false) String tagPeople
//			,@RequestParam(required=false) String musicName
//			,@RequestParam(required=false) String place
//			,@RequestParam(required=false) String share
			,HttpSession session
			){
		
		int userId = (Integer)session.getAttribute("userId");
		
		boolean result = postService.addProfile(userId, title, contents);
		
		Map<String, String>resultMap = new HashMap<>();
		
		if(result) {
			resultMap.put("result", "success");
		}
		else {
			resultMap.put("result", "success");
		}
		return resultMap;
		
	}
	
	
	
	
	
	
	
	
	
	
}
