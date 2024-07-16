package com.sns.timeline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sns.user.entity.UserEntity;

public interface PostRepository extends JpaRepository<UserEntity, Integer >{
	
	public PostEntity findOrderByIdDesc();
}
