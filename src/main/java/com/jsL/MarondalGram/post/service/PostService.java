package com.jsL.MarondalGram.post.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jsL.MarondalGram.like.service.LikeService;
import com.jsL.MarondalGram.post.domain.Post;
import com.jsL.MarondalGram.post.dto.CardView;
import com.jsL.MarondalGram.post.repository.PostRepository;
import com.jsL.MarondalGram.user.domain.User;
import com.jsL.MarondalGram.user.service.UserService;

@Service
public class PostService {
	private UserService userService;
	private PostRepository postRepository;
	private final LikeService likeService;
	public PostService(PostRepository postRepository, UserService userService, LikeService likeService) {
		this.postRepository = postRepository;
		this.userService = userService;
		this.likeService = likeService;
	}
	
	
	public boolean addProfile(
			int userId
			,String title
			,String contents
			) {
		Post post = Post.builder()
		 		.userId(userId)
		 		.title(title)
		 		.contents(contents)
		 		.build();
		try {			
 			postRepository.save(post);
 		} catch(PersistenceException e) {
 			return false;
 		}
 		
 		return true;
		
	}
	
	
	
	
	
	public List<Post> getProfile(int userId) {
		
		List<Post> post = postRepository.findByUserIdOrderByIdDesc(userId);
		return post;
	}
	
	
//	public Optional<Like> getLikeList(int userId, int postId){
//		Optional<Like> like = postRepository.findByUserIdAndPostId(userId, postId);
//		return like;
//	}
	
	

	
	public List<CardView> getPostList() {
 		List<Post> postList = postRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
 		
 		List<CardView> cardList = new ArrayList<>();
 		for(Post post:postList) {
 			
 			User user = userService.getUserById(post.getUserId());
 			
 			int likeCount = likeService.getLikeCount(post.getId());
 			
 			
 			CardView cardView = CardView.builder()
 			.postId(post.getId())
 			.title(post.getTitle())
 			.contents(post.getContents())
 			//.imagePath(post.getImagePath())
 			.userId(post.getUserId())
 			.loginId(user.getLoginId())
 			.likeCount(likeCount)
 			.build();
 			
 			cardList.add(cardView);
 		}
 		
 		return cardList;
 		
 	}
	
	
	
	
	
	
	
}
