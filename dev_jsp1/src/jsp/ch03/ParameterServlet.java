package jsp.ch03;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

import org.apache.log4j.Logger;

import com.util.HashMapBinder;

public class ParameterServlet extends HttpServlet {
	Logger logger = Logger.getLogger(ParameterServlet.class);
	@Override
	public void doGet(HttpServletRequest req
					,HttpServletResponse res) throws IOException,ServletException
	{
		Map<String, Object> pMap = new HashMap<>();
		HashMapBinder hmb = new HashMapBinder(req);//req를 계속유지하기위해 req파라미터를 써줌 
		hmb.binder(pMap);
		Object keys[] = null;//toArray를 써야되서 Object타입으로 쓴거다.
		keys = pMap.keySet().toArray();
		for(int i=0;i<keys.length;i++) {
			logger.info(pMap.get(keys[i]));
		}
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException,ServletException {
		Map<String,Object> rmap = new HashMap<String, Object>();
		HashMapBinder hmb = new HashMapBinder();
		hmb.binder(rmap);
		Object key[] = null;
		key = rmap.keySet().toArray();
		for(int i=0;i<key.length;i++) {
			logger.info("keys"+ rmap.get(key[i]));
		}
	}
}
