package com.sns.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/user")
@Controller
public class UserController {

	@GetMapping("/sign-up-view")
	public String signUpView() {
		return "user/signUp";
	}
	
	@GetMapping("/sign-in-view")
	public String signInView() {
		return "user/signIn";
	}
	
	@RequestMapping("/sign-out")
	public String signOut(HttpSession session) {
		// session 내용 비움
		session.removeAttribute("userId");
		session.removeAttribute("userLoginId");
		session.removeAttribute("userName");
		
		// 로그인 페이지로 이동
		return "redirect:/user/sign-in-view";
	}
}