package com.jsL.MarondalGram.post;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsL.MarondalGram.post.domain.Post;
import com.jsL.MarondalGram.post.service.PostService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/post")
public class PostController {
	
	private final PostService postService;
	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	
	@GetMapping("/list-view")
	public String list(
			HttpSession session
			,Model model
			) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		List<Post>postList = postService.getProfile(userId);
		
		
		model.addAttribute("postList", postList);
		
		
		return "post/list";
	}
	
	
	@GetMapping("/write-view")
	public String write() {
		return "post/write";
	}
	
	
	
	
	
	
	
	
	
}
