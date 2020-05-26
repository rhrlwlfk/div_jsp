package com.mvc2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class MemberController implements Controller{
	Logger logger = Logger.getLogger(MemberController.class);
	String crud = null;
	public MemberController(String crud) {
		this.crud = crud;
		// TODO Auto-generated constructor stub
	}
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException {
		logger.info("process 호출성공");//로그 확인 
		//여러가지 업무가 나눠질수 있으니까 
		if("login".equals(crud)) {
			//memberInsert 회원가입 
		}else if("memberInsert".equals(crud)) {
			
		}
		return "forward:memberList.jsp";
	}

}
