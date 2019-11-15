package com.chatbord.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.chatbord.model.*;

@Service
public class MemberServiceImpl implements MemberService{

	@Inject
	MemberDAO memberDao;
	
	//01. 회원 로그인 체크
	@Override
	public boolean loginCheck(MemberVO vo, HttpSession session) {
		// TODO Auto-generated method stub
		boolean result = memberDao.loginCheck(vo);
		if(result){	//true일 경우 세션에 등록
			MemberVO vo2 = viewMember(vo);
			
			//세션 변수 등록
			session.setAttribute("userId", vo2.getUserId());
			session.setAttribute("userName", vo2.getUserName());
		}
		return result;
	}

	//02. 회원 로그인 정보
	@Override
	public MemberVO viewMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return memberDao.viewMember(vo);
	}

	//03. 회원 로그아웃
	@Override
	public void logout(HttpSession session) {
		// TODO Auto-generated method stub
		//세션 변수 개별 삭제
		// session.removeAttribute("userId");
		//세션 정보를 초기화 시킴.
		session.invalidate();
		
	}


}
