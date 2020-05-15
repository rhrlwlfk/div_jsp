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
			ActionForward af = new ActionForward();
			af.setRedirect(false);//값을초기화 forward로 처리하겠다.
			af.setPath("jsonDeptList.jsp");
			if(af != null) {
				if(af.isRedirect()) {
					res.sendRedirect(af.getPath());
				}
				else {
					RequestDispatcher view = 
						req.getRequestDispatcher(af.getPath());
					view.forward(req, res);
				}
			}
			
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
