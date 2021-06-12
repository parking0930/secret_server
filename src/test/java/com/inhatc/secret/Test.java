package com.inhatc.secret;

import java.awt.List;
import java.util.ArrayList;

import javax.inject.Inject;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.inhatc.domain.BoardVO;
import com.inhatc.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})

public class Test {
	@Inject
	BoardDAO dao;
	
	@org.junit.Test
	public void Test() throws Exception{
		System.out.println(dao.array_boardview_5());
	}
}
