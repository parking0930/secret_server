package com.inhatc.service;

import javax.servlet.http.HttpSession;

import com.inhatc.domain.MemberVO;

public interface MemberService {
	public MemberVO selectMemberById(String id); // 아이디로 맴버 정보 받아옴
	public int cntMemberById(String id); // 아이디로 맴버 있는 지 찾음 (아이디 중복 확인 시 사용)
	public int cntMemberByNickname(String nickname); // 아이디로 맴버 있는 지 찾음 (닉네임 중복 확인 시 사용)
	public void insertMember(MemberVO vo);
	
	public String loginCheck(MemberVO vo, HttpSession session); // 로그인 체크
	public MemberVO viewMember(MemberVO vo); // 로그인 정보
	public void logout(HttpSession session); // 로그아웃
}
