package com.sns.timeline.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostBO {

	@Autowired
	private PostRepository postRepository;
	
	// input: 로그인 된사람의 userId
	// output: List<PostEntity>
	public List<PostEntity> getPostEntityList() {
		return postRepository.findOrderByIdDesc();
	}
	

}
