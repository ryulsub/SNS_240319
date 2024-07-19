package com.sns.timeline;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sns.post.bo.PostBO;
import com.sns.post.entity.PostEntity;

import jakarta.servlet.http.HttpSession;

@Controller
public class TimelineController {

	@Autowired
	private PostBO postBO;
	
	@GetMapping("/timeline/timeline-view")
	public String timelineView(Model model) {
		List<PostEntity> postList = postBO.getPostEntityList();
		
		model.addAttribute("postList", postList);
		
		return "timeline/timeline";
	}
	
	@GetMapping("/post-create-view")
	public String timelineCreateView() {
		return "post/postCreate";
	}
	
	@GetMapping("/post-detail-view")
	public String postDetailView(
			@RequestParam("postId") int postId,
			Model model, HttpSession session) {
		
		// db 조회 - userId, postId
		int userId = (int) session.getAttribute("userId");
		Post post = postBO.getPostByPostIdUserId(userId, postId);
		
		// model에 담기
		model.addAttribute("post", post);
		
		// 화면 이동
		return "post/postDetail";
	}
}