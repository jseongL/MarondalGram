package com.jsL.MarondalGram.post.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PostRepository {
	
	public int insertProfile(
			@Param("title")String title
			,@Param("contents")String contents
			);

}
