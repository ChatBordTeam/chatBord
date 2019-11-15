package com.chatbord.service;

import javax.servlet.http.HttpSession;

import com.chatbord.model.MemberVO;

public interface MemberService {

	//01. 회원 로그인 체크
	public boolean loginCheck(MemberVO vo, HttpSession session);
	//02. 회원 로그인 정보
	public MemberVO viewMember(MemberVO vo);
	//03. 회원 로그아웃
	public void logout(HttpSession session);
	
}
