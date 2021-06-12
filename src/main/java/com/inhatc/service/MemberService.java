package com.inhatc.service;

import javax.servlet.http.HttpSession;

import com.inhatc.domain.MemberVO;

public interface MemberService {
	public MemberVO selectMemberById(String id); // ���̵�� �ɹ� ���� �޾ƿ�
	public int cntMemberById(String id); // ���̵�� �ɹ� �ִ� �� ã�� (���̵� �ߺ� Ȯ�� �� ���)
	public int cntMemberByNickname(String nickname); // ���̵�� �ɹ� �ִ� �� ã�� (�г��� �ߺ� Ȯ�� �� ���)
	public void insertMember(MemberVO vo);
	
	public String loginCheck(MemberVO vo, HttpSession session); // �α��� üũ
	public MemberVO viewMember(MemberVO vo); // �α��� ����
	public void logout(HttpSession session); // �α׾ƿ�
}
