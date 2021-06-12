package com.inhatc.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.inhatc.domain.SchoolVO;
import com.inhatc.persistence.SchoolDAO;

@Service
public class SchoolServiceImpl implements SchoolService{
	
	@Inject
	private SchoolDAO dao;
	
	@Override
	public SchoolVO getSchool(String school) {
		return dao.getSchool(school);
	}

}
