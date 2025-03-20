package com.jsL.MarondalGram.post.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jsL.MarondalGram.post.domain.Post;

@Mapper
public interface PostRepository {
	
	public int insertProfile(
			@Param("userId")int userId
			,@Param("title")String title
			,@Param("contents")String contents
			);
	
	
	
	public List<Post> selectProfile(@Param("userId")int userId);

}
