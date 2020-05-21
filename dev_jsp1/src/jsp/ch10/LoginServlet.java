package jsp.ch10;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.log4j.Logger;

import project_resturant.RestaurantDao;

public class LoginServlet  extends HttpServlet {
	Logger logger = Logger.getLogger(LoginServlet.class);
	Date time = new Date();
	SimpleDateFormat formtter = new SimpleDateFormat();
	@Override
	public void doGet(HttpServletRequest req,
			HttpServletResponse res)throws ServletException, IOException 
	{
		
		logger.info("doGet 호출 성공");
		HttpSession session = req.getSession();
		   String mem_id = req.getParameter("mem_id");
		   String mem_pw = req.getParameter("mem_pw");
		   RestaurantDao rdao = new RestaurantDao();
		   String msg = null;
		   msg = rdao.login(mem_id, mem_pw);
		   session.setAttribute("s_name", msg);
		   logger.info("session ID:" +session.getId());
		   time.setTime(session.getCreationTime());
		   logger.info("session생성시간:" +formtter.format(time));
		   //logger.info("msg:" +msg);
		   res.sendRedirect("mapDesign3Account.jsp");
	}
}
