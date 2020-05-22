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
			String requestURI  = req.getRequestURI();
			String contextPath = req.getContextPath();
			String command 	   = requestURI.substring(contextPath.length() +1);
			Controller controller = null;
			logger.info("command" + command);
		
	}
	  @Override
	  public void doGet(HttpServletRequest req,
			  HttpServletResponse res)throws ServletException,IOException {
		  //예외처리는 반드시 있어야한다.
		  doService(req, res);
		  logger.info("doGet 호출성공");
	  }
	   @Override
	   public void doPost(HttpServletRequest req,
	             HttpServletResponse res) throws ServletException, IOException {
		   doService(req, res);
		   logger.info("doPost 호출성공");
	     
	   }
}
