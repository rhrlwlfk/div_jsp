package ch17;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderInsert extends HttpServlet{
	@Override
	public void doPost(HttpServletRequest req , HttpServletResponse res)
			throws IOException,ServletException {
			res.setContentType("text/html;charset=UTF-8");
			String mem_name = req.getParameter("mem_name");
			PrintWriter out = res.getWriter();
			out.print(mem_name);
	}
}
