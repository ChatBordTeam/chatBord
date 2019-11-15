package com.chatbord.model;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO{

	//SQLSession 객체를 스프링에서 생성하여 주입
	//의존관계 주입(Dependency Injection), 느슨한 결합
	@Inject
	SqlSession sqlSession;	//mybatis 실행 객체
	
	//01. 회원 로그인 체크
	@Override
	public boolean loginCheck(MemberVO vo) {
		// TODO Auto-generated method stub
		String name = sqlSession.selectOne("member.loginCheck", vo);
		return (name == null) ? false : true;
	}

	//02. 회원 로그인 정보
	@Override
	public MemberVO viewMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("member.viewMember", vo);
	}

	//03. 회원 로그아웃
	@Override
	public void logout(HttpSession session) {
		// TODO Auto-generated method stub
	}
	

}
