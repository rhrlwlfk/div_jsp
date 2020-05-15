package jsp.dept;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.dao.SqlMapDeptDao;

public class DeptDao {
	Logger logger = Logger.getLogger(DeptDao.class);
	String resource= "orm/mybatis/Configuration.xml";
	SqlSessionFactory sqlMapper =null;
	public List<Map<String, Object>> deptList(Map<String, Object> rmap) {
		List<Map<String, Object>> dlist = null;
		 try {
	         Reader reader = Resources.getResourceAsReader(resource);
	         sqlMapper = new SqlSessionFactoryBuilder().build(reader);
	         SqlSession sqlSec = sqlMapper.openSession();
	         dlist = sqlSec.selectList("deptList",rmap);
	         System.out.println("조회 수 : "+dlist.size());
	      } catch (Exception e) {
	    	  System.out.println(e.toString());
	    	  e.printStackTrace();
	      }
		 return dlist;
	}
	public static void main(String[] args) {
		DeptDao deptDao =new DeptDao();
		Map<String, Object> rmap = new HashMap<String, Object>();
		rmap.put("deptno",10);
		deptDao.deptList(rmap);
		
	}
}
