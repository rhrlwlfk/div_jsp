package com.mvc3;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class BoardController implements Controller2020 {
	Logger logger = Logger.getLogger(BoardController.class);
	String requestName =null;//반드시 null해서 초기화해서 써야한다. 그래야 유지할수 있다. 
	BoardLogic bLogic = null;
	public BoardController(String requestName) {
		// TODO Auto-generated constructor stub
		this.requestName = requestName;
		bLogic = new BoardLogic();
	}
	/***********************************
	 * @param ActionSupport에서넘겨준 주소번지를 사용함
	 * @return String
	 * 예시) "redirect:xxx.jsp"하거나 ,ㅣ forward:xx.jsp하면됨
	 */
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException {
		// TODO Auto-generated method stub
		logger.info("process:String호출");
		String path = null;
		//너 조회버튼 누른거야?"
		if("boardList".equals(requestName)) {
			List<Map<String, Object>> mList = null;
			Map<String, Object> pMap = new HashMap<String, Object>();
			mList = bLogic.boardList(pMap);
			req.setAttribute("boardList", mList);
			path = "forward:list.jsp"; //pageMove[]
		}		
		else if("boardINS".equals(requestName)) {
			Map<String, Object> pMap = new HashMap<String, Object>();
			int result=0;
			result = bLogic.boardINS(pMap);
			if(result==1) path = "boardInsOk.jsp";
			else if(result ==0) path="redirect:boardInsFail.jsp";
		
		}
		//너 수정하려고?
		else if("boardUPD".equals(requestName)) {
			Map<String, Object> pMap = new HashMap<String, Object>();
			int result=0;
			result = bLogic.boardUPD(pMap);
			if(result==1) path = "redirect:boardUpdOk.jsp";
			else if(result ==0) path="redirect:boardUpdFail.jsp";
		}
		//너 삭제하려구?
		else if("boardDEL".equals(requestName)) {
			Map<String, Object> pMap = new HashMap<String, Object>();
			int result=0;
			result = bLogic.boardDEL(pMap);
			if(result==1) path = "redirect:boardDelOk.jsp";
			else if(result ==0) path="redirect:boardDelFail.jsp";
			
		}
		return path;
	}

	@Override
	public ModelAndView process(String work, HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
}
