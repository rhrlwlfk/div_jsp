package ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class BoardAction extends HttpServlet {
	Logger logger = Logger.getLogger(BoardAction.class);
	@Override
	public void doGet(HttpServletRequest req
			, HttpServletResponse res) 
		throws ServletException,IOException
		{
			logger.info("doGet호출");
			String mem_id = getInitParameter("mem_id");
			logger.info("mem_id:"+mem_id);
			ServletContext ctx = this.getServletContext();
			String driver = ctx.getInitParameter("driver");
			String id =  ctx.getInitParameter("user");
			logger.info("driver:" +driver);
			logger.info("id:"+id);
			res.setContentType("text/html;charset=utf-8");
			PrintWriter out = res.getWriter();
			out.print("뻐큐충식");
		}
	}

