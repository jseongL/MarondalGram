package com.jsL.MarondalGram.like.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsL.MarondalGram.like.domain.Like;

public interface LikeRepository extends JpaRepository<Like, Integer>{
	
	
	public boolean existsByPostIdAndUserId(int postId, int userId);

}
	