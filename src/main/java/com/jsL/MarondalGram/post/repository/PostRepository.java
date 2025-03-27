package com.jsL.MarondalGram.post.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsL.MarondalGram.post.domain.Post;
import com.jsL.MarondalGram.post.dto.CardView;


public interface PostRepository extends JpaRepository<Post, Integer> {
	
	public List<Post>findByUserIdOrderByIdDesc(int userId);
	//public Optional<Like> findByUserIdAndPostId(int userId, int postId);
	
}
