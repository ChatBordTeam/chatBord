package com.chatbord.controller;


import com.chatbord.model.MemberVO;
import com.chatbord.service.*;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/*")

public class LoginController {

	//로깅을 위한 변수
	private static final Logger logger =  (Logger) LoggerFactory.getLogger(LoginController.class);
	
	@Inject
	MemberService memberService;
	
	//01. 로그인 화면
	@RequestMapping("login.do")
	public String login(){
		return "admin/loginPage";
	}
	
	//02.로그인 처리
	@RequestMapping("loginCheck.do")
	public ModelAndView loginCheck(@ModelAttribute MemberVO vo, HttpSession session){
		boolean result = memberService.loginCheck(vo, session);
		ModelAndView mav = new ModelAndView();
		if(result == true){	//로그인 성공
			//main.jsp로 이동
			mav.setViewName("main");	
			mav.addObject("msg", "success");
		} else {	//로그인 실패
			//loginPage.jsp로 이동
			mav.setViewName("admin/loginPage");	
			mav.addObject("msg", "falure");
		}
		
		return mav;
	}
	
	//03.로그아웃 처리
	@RequestMapping("logout.do")
	public ModelAndView logout(HttpSession session){
		memberService.logout(session);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/logout");
		mav.addObject("msg", "logout");
		return mav;
	}

}
