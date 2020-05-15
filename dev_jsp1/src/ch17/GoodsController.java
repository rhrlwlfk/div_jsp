package ch17;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class GoodsController {
	Logger logger = Logger.getLogger(GoodsController.class);
	GoodsDao mDao = new GoodsDao();
	public void execute(HttpServletRequest req, HttpServletResponse rs) {
		logger.info("excute 호출");
		//너 회원가입 할꺼야?
		if(1==1) {
			
		}
		//너 회원조회할거니?
		else if(1==1) {
			
		}
		//너 회원탈퇴 하려구?
		else if(1==1) {
			
		}
		//너 이사갔다며?
		else if(1==1) {
			
		}
	}
}
