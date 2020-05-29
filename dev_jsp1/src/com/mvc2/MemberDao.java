package com.mvc2;

import java.io.Reader;

import java.util.HashMap;
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
	public MemberDao() { 
		sqlMapper = MyBatisCommonFactory.getSqlSessionFactory();
	}
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
	         SqlSession sqlSec = sqlMapper.openSession();
	         memList = sqlSec.selectList("memberList",pMap);
	         logger.info("List<Map<String,Object>>:" + memList.size());
	      } catch (Exception e) {
	    	  System.out.println(e.toString());
	    	  e.printStackTrace();
	      }
		return memList;
	}
	public int memberAdd(Map<String, Object> pMap) {
		logger.info("MemberDao memberList호출 성공");
		int result =0;
		try {
	         SqlSession sqlSec = sqlMapper.openSession();
	         result = sqlSec.insert("memIns",pMap);
	         logger.info("memIns:" + result);
	      } catch (Exception e) {
	    	  System.out.println(e.toString());
	      }
	    	  return result;
	}
	public static void main(String[] args) {
		MemberDao mdao = new MemberDao();
		Map<String,Object> rmap = new HashMap<String, Object>();
		rmap.put("mem_id", "tkdgus");
		rmap.put("mem_pw", 123);
		rmap.put("mem_name", "tkd");
		mdao.memberAdd(rmap);
		
	}
}
