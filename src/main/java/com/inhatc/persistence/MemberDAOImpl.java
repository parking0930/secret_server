package com.inhatc.persistence;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.inhatc.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {


	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.inhatc.mapper.MemberMapper";
	
	@Override
	public int cntMemberById(String id) {
		return sqlSession.selectOne(namespace+".cntMemberById", id);
	}

	@Override
	public int cntMemberByNickname(String nickname) {
		return sqlSession.selectOne(namespace+".cntMemberByNickname", nickname);
	}

	@Override
	public void insertMember(MemberVO vo) {
		sqlSession.insert(namespace+".insertMember", vo);		
	}

	@Override
	public MemberVO selectMemberById(String id) {
		return sqlSession.selectOne(namespace+".selectMemberById", id);
	}

	@Override
	public String loginCheck(MemberVO vo) {
		// TODO Auto-generated method stub
		String name = sqlSession.selectOne(namespace + ".loginCheck", vo);
		return (name==null) ? "0" : "1";
	}

	@Override
	public MemberVO viewMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".viewMember", vo);
	}

	@Override
	public void logout(HttpSession session) {
		// TODO Auto-generated method stub
		
	}





}
