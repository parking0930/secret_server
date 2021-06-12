package com.inhatc.secret;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.inhatc.domain.BoardVO;
import com.inhatc.domain.MemberVO;
import com.inhatc.domain.SchoolVO;
import com.inhatc.service.BoardService;
import com.inhatc.service.MemberService;
import com.inhatc.service.SchoolService;

@Controller
public class SecretController {
	
	@Inject
	private MemberService service;
	
	@Inject
	private BoardService board_service;
	
	@Inject
	private SchoolService school_service;
	
	@ResponseBody
	@RequestMapping(value = "/selectMember") // 맴버 받아오기
	public Map<String, Object> selectMember(HttpServletRequest request) {
		String id = request.getParameter("id");
        System.out.println(id+"들어옴");
		MemberVO member = service.selectMemberById(id); // 1이면 아이디 존재
		
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("member", member);
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/idCheck") // 아이디 체크
	public Map<String, Object> idCheck(HttpServletRequest request) {
		String id = request.getParameter("id");
		int idchk = service.cntMemberById(id); // 1이면 아이디 존재
		
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("idchk", idchk);
        System.out.println(id+"들어옴");
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/nickCheck") // 닉네임 체크
	public Map<String, Object> nickCheck(HttpServletRequest request) {
		String nickname = request.getParameter("nickname");
        int nickchk = service.cntMemberByNickname(nickname); // 1이면 닉네임 존재
		
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("nickchk", nickchk);
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/joinMember")
	public Map<String, Object> joinMember(HttpServletRequest request) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String id = request.getParameter("id");
        String pw = request.getParameter("pw");
        String nickname = request.getParameter("nickname");
        String school = request.getParameter("school");
        String birth = request.getParameter("birth");
        //Date birth = sdf.parse(request.getParameter("birth"));
        
        
        MemberVO member = new MemberVO();
        member.setId(id);
        member.setPw(pw);
        member.setNickname(nickname);
        member.setSchool(school);
        member.setBirth(birth);
        System.out.println(member.toString());
        // 회원 가입 전 아이디, 닉네임 2차 중복 검증, 둘 중 하나라도 1이면(존재하면) 가입 불가
        int idchk = service.cntMemberById(id);
        int nickchk = service.cntMemberByNickname(nickname);
        
        Map<String, Object> map = new HashMap<String, Object>();
        
        if(idchk==1||nickchk==1)
        	map.put("result", "0"); // 실패 시 result에 0을 담아 보냄
        else { // 일치하면 회원가입 후 result에 1을 담아 보냄
        	service.insertMember(member);
        	map.put("result", "1");
        }
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/login")
	public Map<String, Object> login(@ModelAttribute MemberVO vo, HttpSession session, HttpServletRequest request) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		String result = service.loginCheck(vo, session);
		String ismember;
		System.out.println(result);
		map.put("result", result);
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/viewMember")
	public MemberVO viewMember(@ModelAttribute MemberVO vo, HttpSession session, HttpServletRequest request) throws Exception{
		MemberVO result = service.viewMember(vo);
		System.out.println(result.toString());
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/board_create")
	public void board_create(@ModelAttribute BoardVO vo, HttpServletRequest request) throws Exception{
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(writer);
		
		board_service.regist(vo);
	}
	
	@ResponseBody
	@RequestMapping(value = "/getLastBoard", produces="text/plain;charset=UTF-8")
	public String getLastBoard(HttpServletRequest request) throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		BoardVO board = board_service.getLastBoard();
		String jsonString = mapper.writeValueAsString(board);
		return jsonString;
	}
	
	@ResponseBody
	@RequestMapping(value = "/board_mainview_5", produces="text/plain;charset=UTF-8")
	public String board_mainview_5(@ModelAttribute BoardVO vo,HttpServletRequest request) throws Exception{
		List<BoardVO> vo_List = board_service.array_boardview_5();
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(vo_List);
		System.out.println("Testing------------------------------------jsonString"+jsonString);
		return jsonString;
	}
	
	@ResponseBody
	@RequestMapping(value = "/freeboard_view_50", produces="text/plain;charset=UTF-8")
	public String freeboard_view_50(HttpServletRequest request) throws Exception{
		List<BoardVO> vo_List = board_service.listAll();
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(vo_List);
		System.out.println(jsonString);
		return jsonString;
	}
	@ResponseBody
	@RequestMapping(value = "/viewcntupdate")
	public void viewcntupdate(HttpServletRequest request) throws Exception{
		String bno = request.getParameter("bno");
		board_service.viewcntupadte(bno);
	}
	

	@ResponseBody
	@RequestMapping(value = "/getSchool", produces="text/plain;charset=UTF-8")
	public String getSchool(HttpServletRequest request) throws Exception{
		String school = request.getParameter("school");
		ObjectMapper mapper = new ObjectMapper();
		SchoolVO vo = school_service.getSchool(school);
		String jsonString = mapper.writeValueAsString(vo);
		return jsonString;
	}
}
