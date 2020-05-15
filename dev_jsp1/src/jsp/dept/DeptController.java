package jsp.dept;

import java.io.IOException;
import java.util.ArrayList;
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

public class DeptController extends HttpServlet{
	Logger logger = Logger.getLogger(DeptController.class);
	public void doService(HttpServletRequest req,
            HttpServletResponse res) throws ServletException, IOException {
			DeptDao deptdao = new DeptDao();
			HashMapBinder hash = new HashMapBinder(req);
//			Map<String, Object> hmap = new HashMap<>();
//			Map<String, Object> rmap = hash.binder(hmap);
			Map<String,Object> hmap = new HashMap<>();
			Map<String,Object> rmap = hash.binder(hmap);
			//Map<String,Object> rma1 = new HashMap<>();
			//List<Map<String,Object>> rlist = deptdao.deptList(rma1);
			List<Map<String, Object>> rlist = deptdao.deptList(rmap);
			req.setAttribute("rlist", rlist);
			RequestDispatcher view = req.getRequestDispatcher("jsonDeptList.jsp");
			view.forward(req, res);
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
