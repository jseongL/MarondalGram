package com.jsL.MarondalGram.post;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/post")
public class PostController {
	
	@GetMapping("/list-view")
	public String list() {
		return "post/list";
	}
	
	
	@GetMapping("/write-view")
	public String write() {
		return "post/write";
	}
	
	
	
	
	
	
	
	
	
}
