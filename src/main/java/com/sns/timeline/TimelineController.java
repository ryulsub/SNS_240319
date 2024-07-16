package com.sns.timeline;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sns.timeline.bo.PostBO;

import jakarta.servlet.http.HttpSession;

@Controller
public class TimelineController {
	
	@Autowired
	private PostBO postBO;
	
	@GetMapping("/timeline/timeline-view")
	public String timelineView(Model model) {
		// 로그인 여부 확인
	
	// DB 조회 
	List<PostEntity> postList = postBO.getPostEntityList();
	
	// 모델에 담기
	model.addAttribute("postList", postList);
	
	return "timeline/timeline";
}
}