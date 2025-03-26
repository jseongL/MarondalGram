package com.jsL.MarondalGram.post.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter

public class CardView{
	 	
	 	private int postId;
	 	private String title;
	 	private String contents;
//	 	private String imagePath;
//	 	private String tagPeople;
//		private String musicName;
//		private String place;
//		private String share;
	 	private int userId;
	 	private String loginId;

	 	
	 	
	 	
	 	
	 	
	 	
	 	

	 	private int likeCount;

}
