package com.mvc2;

import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import jsp.dept.DeptDao;

public class MemberDao {
	Logger logger = Logger.getLogger(MemberDao.class);
	String resource= "orm/mybatis/Configuration.xml";
	SqlSessionFactory sqlMapper =null;
	public String login(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		logger.info("login호출 성공");
		String s_name = null;
		 try {
	         Reader reader = Resources.getResourceAsReader(resource);
	         sqlMapper = new SqlSessionFactoryBuilder().build(reader);
	         SqlSession sqlSec = sqlMapper.openSession();
	         s_name = sqlSec.selectOne("login",pMap);
	         logger.info("s_name" + s_name);
	      } catch (Exception e) {
	    	  System.out.println(e.toString());
	    	  e.printStackTrace();
	      }
		return s_name;
	}
	public List<Map<String, Object>> memberList(Map<String, Object> pMap) {
		logger.info("MemberDao memberList호출 성공");
		List<Map<String,Object>> memList = null; 
		try {
	         Reader reader = Resources.getResourceAsReader(resource);
	         sqlMapper = new SqlSessionFactoryBuilder().build(reader);
	         SqlSession sqlSec = sqlMapper.openSession();
	         memList = sqlSec.selectOne("memList",pMap);
	         logger.info("List<Map<String,Object>>:" + memList.size());
	      } catch (Exception e) {
	    	  System.out.println(e.toString());
	    	  e.printStackTrace();
	      }
		return null;
	}

}
