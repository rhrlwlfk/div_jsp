package ch17;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

//어노테이션이라고 한다.
@WebServlet(urlPatterns="/ch17/order.nhn")
public class OrderServlet extends HttpServlet {
	Logger logger = Logger.getLogger(OrderServlet.class);
	ServletConfig config= null;
	public void init(ServletConfig config) throws ServletException{
		logger.info("init호출성공");
		this.config = config;
		this.init();
	}
   @Override
   public void doGet(HttpServletRequest req,
                   HttpServletResponse res) throws ServletException, IOException 
   {
	   logger.info("doGet 호출성공");
	   String mem_name = req.getParameter("mem_name");
	   logger.info("입력한 사람은" +mem_name);
	   //res.sendRedirect("");
	   //유지시킬List를 쓴다
	   
	   List<Map<String,Object>> olist= new ArrayList<>();
	   Map<String,Object> rmap = new HashMap<>();
	   rmap.put("deptno",10);
	   rmap.put("dname","총무");
	   rmap.put("loc","인천");
	   olist.add(rmap);
			   req.setAttribute("olist", olist);
			   //forword가를 쓸려고 RequestDispatcer를쓰겠다.
	   RequestDispatcher view = 
	   req.getRequestDispatcher("./orderList.jsp");
	   view.forward(req, res);
	   res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		out.print(mem_name);
   }
   @Override
   public void doPost(HttpServletRequest req,
             HttpServletResponse res) throws ServletException, IOException 
   {
	   logger.info("doPost 호출성공");
	   	String mem_name = req.getParameter("mem_name");
	   logger.info("입력한 사람은" +mem_name);
   }
}
   
   
