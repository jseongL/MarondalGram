package com.jsL.MarondalGram.post;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	public String list(HttpSession session, Model model) {
	    int userId = (Integer) session.getAttribute("userId");

	    // 게시글 리스트 불러오기
	    List<CardView> cardList = postService.getPostList();

	    // 각 카드마다 like 상태 조회
//	    Map<Integer, Boolean> likeList = new HashMap<>();
//	    for (CardView card : cardList) {
//	        Optional<Like> likeStatus = postService.getLikeList(userId, card.getPostId());
//	        likeList.put(card.getPostId(), likeStatus.isPresent());
//	    }

	    model.addAttribute("cardList", cardList);
	    //model.addAttribute("likeStatusMap", likeList);

	    return "post/list";
	}
	
	
	

	
	
	
	
	
	
	
	@GetMapping("/write-view")
	public String write() {
		return "post/write";
	}
	
	
	
	
	
	
	
	
	
}
