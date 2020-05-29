package com.mvc2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class MemberController implements Controller{
	Logger logger = Logger.getLogger(MemberController.class);
	String crud = null;
	MemberLogic memLogic = null;
	public MemberController(String crud) {
		this.crud = crud;
		memLogic = new MemberLogic();
		// TODO Auto-generated constructor stub
	}
	public ModelAndView process(String work,HttpServletRequest req, HttpServletResponse res) throws ServletException {
		return new ModelAndView();
	}
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException {
		logger.info("process 호출성공, crud:" +crud);//로그 확인 
		//여러가지 업무가 나눠질수 있으니까 
		String path = "";
		if("login".equals(crud)) {
			String u_id = req.getParameter("mem_id");
			String u_pw = req.getParameter("mem_pw");
			Map<String, Object> pMap = new HashMap<>();
			pMap.put("mem_id", u_id);
			pMap.put("mem_pw", u_pw);
			String s_name = memLogic.login(pMap);
			HttpSession session = req.getSession();
			session.setAttribute("s_name", s_name);
			session.setAttribute("s_name","이순신");
			return "forward:mapDesign3.jsp";
			//memberInsert 회원가입 
		}else if("memberList".equals(crud)) {
			List<Map<String,Object>> memList = null;
			Map<String, Object> pMap = new HashMap<>();
			memList = memLogic.memberList(pMap);
			logger.info("memList ==>"+memList.size());
			if(memList==null) { 
				memList = new ArrayList<>();
			}
			req.setAttribute("memList", memList);
			path = "forward:/member/memberList.jsp";
		}
	else if("memberAdd".equals(crud)) {
		int result =0;//1이면 등록성공 ,0이면 실패
		logger.info("memberAddForm호출성공");
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("mem_id", req.getParameter("mem_id"));
		pMap.put("mem_name", req.getParameter("mem_name"));
		pMap.put("mem_pw", req.getParameter("mem_pw"));
		result = memLogic.memberAdd(pMap);
		path = "forward:/member/member.mvc2?crud=memberList";
	}
		return path;
	}

}
