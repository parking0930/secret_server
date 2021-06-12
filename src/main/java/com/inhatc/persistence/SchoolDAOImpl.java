package com.inhatc.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.inhatc.domain.SchoolVO;

@Repository
public class SchoolDAOImpl implements SchoolDAO{

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.inhatc.mapper.SchoolMapper";
	
	@Override
	public SchoolVO getSchool(String school) {
		return sqlSession.selectOne(namespace+".getSchool", school);
	}

}
