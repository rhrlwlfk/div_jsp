package jsp.dept;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.util.HashMapBinder;

@WebServlet(urlPatterns="/dept1/deptList.km")
public class DeptController2 extends HttpServlet{
	Logger logger = Logger.getLogger(DeptController2.class);
	public void doService(HttpServletRequest req,
            HttpServletResponse res) throws ServletException, IOException {
		
			
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
	      doService(req,res);
	   }
}
