package com.mvc2;

import org.apache.log4j.Logger;

public class ControllerMapper {
	public static Controller getController(String command, String crud) {
		Logger logger = Logger.getLogger(ControllerMapper.class);
		logger.info("command:" + command + ", crud:" + crud);
		//파라미터 2개입력삭제를 받을수 있을것이다.
		Controller controller  = null;
		String commands[] = command.split("/");
		//머가 들어온지 볼려고 
		for(String str:commands) {
			logger.info("str:"+ str);
		}
		//갯수가 2개가있어야한다. 
		if(commands.length==2) {
			String work = commands[0];
			String requestName = commands[1];
			if("member".equals(work)) {
				controller = new MemberController(crud);
			}
		}
		return controller;
	}//end of Controller
}
