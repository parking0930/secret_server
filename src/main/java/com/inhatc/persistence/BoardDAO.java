package com.inhatc.persistence;

import java.util.ArrayList;
import java.util.List;

import com.inhatc.domain.BoardVO;

public interface BoardDAO {

  public void create(BoardVO vo) throws Exception; // 글쓰기
  public List<BoardVO> array_boardview_5() throws Exception; // 글 보이기
  public List<BoardVO> listAll() throws Exception;
  public void viewcntupadte(String bno) throws Exception;
  public BoardVO getLastBoard() throws Exception;
  
  
  
  public BoardVO read(Integer bno) throws Exception;

  public void update(BoardVO vo) throws Exception;

  public void delete(Integer bno) throws Exception;

  

  public List<BoardVO> listPage(int page) throws Exception;

//  public List<BoardVO> listCriteria(Criteria cri) throws Exception;
//
//  public int countPaging(Criteria cri) throws Exception;
//  
//  //use for dynamic sql
//  
//  public List<BoardVO> listSearch(SearchCriteria cri)throws Exception;
//  
//  public int listSearchCount(SearchCriteria cri)throws Exception;

}
