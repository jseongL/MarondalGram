package com.jsL.MarondalGram.post.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jsL.MarondalGram.post.domain.Post;
import com.jsL.MarondalGram.post.repository.PostRepository;

@Service
public class PostService {
	
	private PostRepository postRepository;
	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
	
	public boolean addProfile(
			int userId
			,String title
			,String contents
			) {
		
		int count = postRepository.insertProfile(userId, title, contents);
		
		if(count > 0) {
			return true;
		}
		return false;
	}
	
	
	
	
	
	public List<Post> getProfile(int userId) {
		
		List<Post> post = postRepository.selectProfile(userId);
		return post;
	}

	
	
	
	
	
	
	
	
	
}
