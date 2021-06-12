package com.inhatc.service;

import java.util.List;

import com.inhatc.domain.BoardVO;

public interface BoardService {

  public void regist(BoardVO board) throws Exception;
  public List<BoardVO> array_boardview_5() throws Exception; // 글 보이기
  public List<BoardVO> listAll() throws Exception; // 글보이기 50개
  public void viewcntupadte(String bno) throws Exception;
  public BoardVO getLastBoard() throws Exception;
  
  
  public BoardVO read(Integer bno) throws Exception;

  public void modify(BoardVO board) throws Exception;
  
  public void modifyPage(BoardVO board) throws Exception;

  public void remove(Integer bno) throws Exception;

  


//  public List<BoardVO> listCriteria(Criteria cri) throws Exception;
//
//  public int listCountCriteria(Criteria cri) throws Exception;
//
//  public List<BoardVO> listSearchCriteria(SearchCriteria cri) 
//      throws Exception;
//
//  public int listSearchCount(SearchCriteria cri) throws Exception;

}
