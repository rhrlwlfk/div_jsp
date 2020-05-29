package com.mvc2;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.util.HashMapBinder;

import jsp.dept.DeptDao;

public class FrontMVC2 extends HttpServlet {
	Logger logger = Logger.getLogger(FrontMVC2.class);
	public void doService(HttpServletRequest req,
            HttpServletResponse res) throws ServletException, IOException {
			logger.info("doGet 호출성공");
			//==>dev_jsp/member/meberList.mvc2
			String requestURI  = req.getRequestURI();// PORT번호다음 경로를 가져온것이다. 현재주소를가져온다
			logger.info("requestURL:"+requestURI);//memberList.mvc2?crud=sel&6
			// ==> dev_jsp
			String contextPath = req.getContextPath();//프로젝트명
			// ==> /member/memberList.mvc2
			logger.info("contexPath:" +contextPath);
			String command 	   = requestURI.substring(contextPath.length() +1);
			Controller controller = null;
			logger.info("command :" + command);	
			//insert here - 인스턴스화 and process call 
			String crud = null;
			crud = req.getParameter("crud");
			logger.info("crud==>" +crud);
			//insert here - 인스턴스화 an d process call
			try { 
				controller = ControllerMapper.getController(command, crud);
			}catch (Exception e) {
				// TODO: handle exception
			}
			if(controller instanceof MemberController) {
				logger.info("MemberController타입이면...회원관리 업무임.");
				String path = controller.process(req, res);
				String pageMove[]  = null;
				pageMove = path.split(":");
				for(int i=0;i<pageMove.length;i++) {
					logger.info("pageMove:" + pageMove[i]);
				}
				
				//안전하게 처리
				if(pageMove !=null) {
					String path2 = pageMove[1];
					if("redirect".equals(pageMove[0])) {
						res.sendRedirect(path2);
					}else {
						RequestDispatcher view  = req.getRequestDispatcher(path2);
						view.forward(req, res);
					}
				}
			}
	}
	  @Override
	  public void doGet(HttpServletRequest req,
			  HttpServletResponse res)throws ServletException,IOException {
		  //예외처리는 반드시 있어야한다.
		  logger.info("doGet 호출성공");
		  doService(req, res);
	  }
	   @Override
	   public void doPost(HttpServletRequest req,
	             HttpServletResponse res) throws ServletException, IOException {
		   logger.info("doPost 호출성공");
		   doService(req, res);
	     
	   }
}
