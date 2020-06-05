package com.mvc3;
import javax.servlet.http.HttpServletRequest;
/*
 * 1단계 : 리턴타입은 void였다.
 * 2단계 : 리턴타입을 String으로 바꾸어서 redirect와 forward를 분기
 * 3단계 : 리턴타입을 ModelAndView로 바꾸어서 유지 내용에 대한 부분
 * 		   까지도 포함시켜본다.(request scope에 대한 반영 필요) 
 * 사용자 정의 클래스인 ModelAndView의 scope를 request로 설계해 본다.
 * 화면에 대한 이름(결정)도 추가 할 수 있도록 지원해 본다. 
 * 내가 설계한 POJO프레임워크는 req와 res에 의존적이다.|아니다. 
 */
import javax.servlet.http.HttpServletResponse;

public class ModelAndView {
	//다른 메소드를 쓸려면 전역 변수, 
	//인스턴스 변수로 호출할수있는 변수 
	HttpServletRequest req = null;
	HttpServletResponse res = null;
	String viewName = null;
	//생성자 - 디폴트 생성자와 파라미터 생성자의 차이점에 대해 말할 수  있고 
	// 		 활용할 수 있다.(POJO 플임워크에 반영 해보기)
	public ModelAndView() {
	  
	}
	public ModelAndView(HttpServletRequest req , HttpServletResponse res) {
		this.req = req;
		this.res = res;
	}
	//.jsp를 붙이면 //member/memberList.jsp.jsp가 된다. 
	public void setViewName(String viewName) {
	  this.viewName = viewName;
	  //this.viewName = req.getContextPath() + "/WEB-INF/view/" + ".jsp";
	}
	public String getViewName() {
		return viewName;
	}
	public void addObject(String name, Object obj) { 
		req.setAttribute(name, obj);
	}
}
