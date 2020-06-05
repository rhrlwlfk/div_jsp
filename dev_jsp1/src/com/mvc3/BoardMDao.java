package com.mvc3;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

public class BoardMDao {
	Logger logger = Logger.getLogger(BoardMDao.class);
	SqlSessionFactory sqlMapper =null;
	SqlSession sqlSes = null;
	public BoardMDao() {
		sqlMapper = MyBatisCommonFactory.getSqlSessionFactory();
		sqlSes = sqlMapper.openSession();
	}
	public List<Map<String, Object>> boardList(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		logger.info("boardList 호출 성공");
		List<Map<String, Object>> bList = null;
		bList =sqlSes.selectList("boardList",pMap);
		logger.info("bList" + bList);
		return bList;
	}

	public int boardMINS(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		logger.info("boardMINS 호출 성공");
		return 0;
	}

	public int boardUPD(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		logger.info("boardUPD 호출 성공");
		return 0;
	}

	public int boardDEL(Map<String, Object> pMap) {
		logger.info("boardDEL 호출 성공");
		// TODO Auto-generated method stub
		return 0;
	}

}
