package com.jsL.MarondalGram.post.service;

import org.springframework.stereotype.Service;

import com.jsL.MarondalGram.post.repository.PostRepository;

@Service
public class PostService {
	
	private PostRepository postRepository;
	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
	
	public boolean addProfile(
			String title
			,String contents
			) {
		
		int count = postRepository.insertProfile(title, contents);
		
		if(count > 0) {
			return true;
		}
		return false;
	}

	
	
	
	
	
	
	
	
	
}
