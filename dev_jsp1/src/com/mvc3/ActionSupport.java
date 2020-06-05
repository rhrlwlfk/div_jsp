package com.mvc3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.mvc2.Controller;
import com.mvc2.ControllerMapper;
import com.mvc2.MemberController;

public class ActionSupport extends HttpServlet {
	  Logger logger = Logger.getLogger(ActionSupport.class);
	  public void doService(HttpServletRequest req,
	            HttpServletResponse res) throws ServletException, IOException {
		  	String requestURI  = req.getRequestURI();// PORT번호다음 경로를 가져온것이다. 현재주소를가져온다
			logger.info("requestURL:"+requestURI);//memberList.mvc2?crud=sel&6
			// ==> dev_jsp
			String contextPath = req.getContextPath();//프로젝트명
			// ==> /member/memberList.mvc2
			logger.info("contexPath:" +contextPath);
			
			String command = requestURI.substring(contextPath.length() +1);
			logger.info("before command :" + command);	
			
			String cud = req.getParameter("cud");
			int end = command.lastIndexOf(".");
			logger.info("cud:" + cud);
			String requestName = null;
			requestName = command.substring(0,end); //crud?memberList대신 쓰겠다.
			//member/memberList.mvc3 memberList를 쓰겠다. 
			Controller2020 controller = null;
			logger.info("after command :" + requestName);	
			//insert here - 인스턴스화 and process call 
			try { 
				controller = ControllerMapper3.getController(requestName);
			}catch (Exception e) {
				// TODO: handle exception
			}
			if(controller != null) {
				String pageMove[] = null;
				try {
					//Object에 오는 타입이 2가지이다. 
					//하나는 ModelAndview 나머지 하나는 String
					Object robj = null;
					if(cud == null) {
						 robj = controller.process(command,req,res);
						
					}else {//입력이야? 수정할거니? 삭제하려구해
						logger.info("cud가 널이아니면");
						robj = controller.process(req, res);
					}
					//ModelAndView인지 아니면 String인지 찍어보자 
					logger.info("robj :" +robj);
					if(robj instanceof String) {
						pageMove = robj.toString().split(":");
						logger.info("pageMove[0]=" + pageMove[0]+ ", pageMove[1]"+pageMove[1]);
					}
					else if(robj instanceof ModelAndView) {
						
						ModelAndView mav = (ModelAndView)robj;
						pageMove = new String[2];
						pageMove[0] = "forward";
						pageMove[1] = mav.getViewName();
					}
				} catch (Exception e) {
					// TODO: handle exception
					logger.info("Exception :" + e.toString());
				}
				//값을 꺼내는 시점일때는 널체크를 해줘야한다.
				//INSERT HERE - redirect인 경우와 forward인 경우를 쪼개기
				//힌트: return "redirect:/member/memberList.mvc3
				
				if(pageMove !=null) {
					String path = pageMove[1];
					if("redirect".equals(pageMove[0])) {//너 redirect할거야?
						res.sendRedirect(path);
					}
				else  {//너 forward할려고 그래? 
					if("forward".equals(pageMove[0])) {
						RequestDispatcher view = req.getRequestDispatcher(path);
					view.forward(req,res);	
					}else {
						res.sendRedirect("/error/pageMoveFail.jsp");
					}
				}
			}
	
		}
		}////////////////////end of Controller가 널이 아닐때
	  ///////////////////////end of Service///////////////////////
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
