package com.jsL.MarondalGram.post;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsL.MarondalGram.like.domain.Like;
import com.jsL.MarondalGram.post.dto.CardView;
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
		//int postId = (Integer)session.getAttribute("postId");
		
		
		//List<Post>postList = postService.getProfile(userId);
		
		List<CardView> cardList = postService.getPostList();
		
		
		//Optional<Like> likeList = postService.getLikeList(userId, postId);
		
		
		//model.addAttribute("postList", postList);
		model.addAttribute("cardList", cardList);
		//model.addAttribute("likeList", likeList);
		
		return "post/list";
	}
	
	
	

	
	
	
	
	
	
	
	@GetMapping("/write-view")
	public String write() {
		return "post/write";
	}
	
	
	
	
	
	
	
	
	
}
