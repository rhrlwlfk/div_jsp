package com.mvc3;

import org.apache.log4j.Logger;
//폴더명대로 가는 ㄱㅗㅅ
public class ControllerMapper3 {
	public static Controller2020 getController(String command) {
		Logger logger = Logger.getLogger(ControllerMapper3.class);
		logger.info("command:" + command );
		//파라미터 2개입력삭제를 받을수 있을것이다.
		Controller2020 controller  = null;
		String commands[] = command.split("/");
		//머가 들어온지 볼려고 

		//갯수가 2개가있어야한다. 
		if(commands.length==2) {
			String work = commands[0];
			String requestName = commands[1];
			logger.info("work: " + work);
			logger.info("commands[1]:" + commands[1]);
			if("member".equals(work)) {
				logger.info("MemberController 인스턴스화!");
				logger.info("work:" + work);
			
				controller = new MemberController3(requestName);
			}
			//계층형 게시판 컨트롤러 생성하기 
			else if("board".equals(work)) {
				logger.info("board:" + work);
				controller = new BoardController(requestName);
				//work가들어오면 board를 채워야한다.
			}
		}
		return controller;
	}//end of Controller
}
