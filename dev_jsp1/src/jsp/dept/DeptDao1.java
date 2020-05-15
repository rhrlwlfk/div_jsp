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

public class DeptDao1 {
	Logger logger = Logger.getLogger(DeptDao1.class);
	String resource= "orm/mybatis/Configuration.xml";
	SqlSessionFactory sqlMapper =null;//connection과 관련된거다 -연결통보확보
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
	    	  //
	    	  //e.printStackTrace();
	      }
		 return dlist;
	}
	public static void main(String[] args) {
		DeptDao1 deptDao =new DeptDao1();
		Map<String, Object> rmap = new HashMap<String, Object>();
		deptDao.deptList(rmap);
	}
}
