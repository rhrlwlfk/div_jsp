package jsp.ch13;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.net.httpserver.HttpsParameters;

public class HelloServlet extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res
					 ) throws IOException,ServletException
	{
		res.setContentType("text/html;charset=UTF-8");
		//사용자가 입력한 아이디를 알고싶어요
		//<input type="text" id="mem_id" name="mem_id"> 밑에게 이 뜻이다.
		//$("#mem_id")=> id 
		//이거를 실행하려면 html로 만들어야함  그래서 web.xml에다가 class를 넣어야한다??? 
		String mem_id = req.getParameter("mem_id");
		PrintWriter out = res.getWriter();//응답처리 할수있고  
		out.print(mem_id);
	}	
}
