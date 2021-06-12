package com.inhatc.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.inhatc.domain.MemberVO;
import com.inhatc.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{

	@Inject
	public MemberDAO dao;
	
	@Override
	public int cntMemberById(String id) {
		return dao.cntMemberById(id);
	}

	@Override
	public int cntMemberByNickname(String nickname) {
		return dao.cntMemberByNickname(nickname);
	}

	@Override
	public void insertMember(MemberVO vo) {
		dao.insertMember(vo);
		return;
	}

	@Override
	public MemberVO selectMemberById(String id) {
		return dao.selectMemberById(id);
	}

	@Override
	public String loginCheck(MemberVO vo, HttpSession session) {
		// TODO Auto-generated method stub
		String result = dao.loginCheck(vo);
		if(result == "1") {
			MemberVO vo2 = viewMember(vo);
			session.setAttribute("userId", vo2.getId());
			session.setAttribute("userName", vo2.getNickname());
		}
		return result;
	}

	@Override
	public MemberVO viewMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return dao.viewMember(vo);
	}

	@Override
	public void logout(HttpSession session) {
		// TODO Auto-generated method stub
		session.invalidate(); // 세션 초기화
	}



}
