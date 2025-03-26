package com.jsL.MarondalGram.like.service;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.stereotype.Service;

import com.jsL.MarondalGram.like.domain.Like;
import com.jsL.MarondalGram.like.repository.LikeRepository;

@Service
public class LikeService {
	
	private final LikeRepository likeRepository; 
	
	public LikeService(LikeRepository likeRepository) {
		this.likeRepository = likeRepository;
	}

	public boolean addLike(int postId, int userId){
		
		Like like = Like.builder()
		.postId(postId)
		.userId(userId)
		.build();//값 넣기
		
		try {
		likeRepository.save(like);
		}catch(PersistenceException e) {
			return false;
		}
		return true;
	}
	
	
	
	
	
	
	
	
	
	public boolean isLikeByUserIdAndPostId(int postId, int userId){
		return likeRepository.existsByPostIdAndUserId(postId, userId);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
