package com.jsL.MarondalGram.post.domain;

import java.time.LocalDateTime;

import com.jsL.MarondalGram.post.dto.CardView;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;





@Builder(toBuilder=true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name="`profile`")
@Entity
public class Post {
	@Id
 	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int userId;
	private String title;
	private String contents;
//	private String imagePath;
//	private String tagPeople;
//	private String musicName;
//	private String place;
//	private String share;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	

}
