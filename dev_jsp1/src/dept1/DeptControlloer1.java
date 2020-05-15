package dept1;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class DeptControlloer1 extends HttpServlet {
	Logger logger = Logger.getLogger(DeptControlloer1.class);
	public void doService(HttpServletRequest req,
			HttpServletResponse res) throws ServletException,IOException{
	}
	public void doPost(HttpServletRequest req ,
			HttpServletResponse res)throws ServletException,IOException{
		
	}
	
	public void doGet(HttpServletRequest req, 
			HttpServletResponse res)throws ServletException,IOException{		
		logger.info("doGet 호출성공");
		DeptDao1 dDAO =new DeptDao1();
		List<Map<String, Object>> deptList = dDAO.deptList();
		req.setAttribute("deptList", deptList);
		RequestDispatcher view = req.getRequestDispatcher("jsonDeptList");
		//
	}
}
