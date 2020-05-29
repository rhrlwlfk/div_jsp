package com.mvc2;

import java.io.FileNotFoundException;
import java.io.Reader;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisCommonFactory {
	public static SqlSessionFactory sqlSessionFactory = null;
	public static void init() {
		try { 
			String resource= "orm/mybatis/Configuration.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			sqlSessionFactory =
					new SqlSessionFactoryBuilder()
								.build(reader,"development");
		}catch (FileNotFoundException fe) {
			fe.toString();
		}catch (Exception e) {
			e.getMessage();
		}
	}
	public static SqlSessionFactory getSqlSessionFactory() {
		init();
		return sqlSessionFactory;
	}
}
