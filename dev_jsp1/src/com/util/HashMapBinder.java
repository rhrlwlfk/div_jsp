package com.util;

import java.util.Enumeration;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class HashMapBinder {
	//요청 객체는 사용자가 요청했을때 요청을 받아주는 서블릿에서
	//주소번지를 받아와야한다.
	//그래야 그사람에 대한 요청 정보를 확인 할수 있는 것이다.
	//이 말을 이해하고 설명할수 있는지 확인해볼것
	HttpServletRequest req = null;
	public HashMapBinder() {}
	public HashMapBinder(HttpServletRequest req) {
		this.req = req;
	}
	public Map<String, Object> binder(Map<String,Object> pMap) {
		//기존에 들어있던 값이 있다면 모두 비운다
		pMap.clear();
		Enumeration<String> en = req.getParameterNames();//하나의 객체로 저장하고, Enumeration으로 써야한다.
		//enumeration 값이 들어있는지 체크해 줌.
		while(en.hasMoreElements()) {
			String key = en.nextElement();//name,address,pet
			pMap.put(key,HanguIConversion.toUTF(req.getParameter(key)));
		}
		return pMap;
	}
}
