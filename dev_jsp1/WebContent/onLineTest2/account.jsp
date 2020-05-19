<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie[] cookies = request.getCookies();
	String h_no = null;
	if(cookies!=null && cookies.length > 0) {
		for(int i=0;i<cookies.length;i++) {
			if("c_hno".equals(cookies[i].getName())){
				h_no = cookies[i].getValue();
			}
		}
	}
	out.print("h_no:" + h_no+" ");
	String daps[] = {"1","1","2","3"};
	String htest1 = request.getParameter("htest1");
	String htest2 = request.getParameter("htest2");
	String htest3 = request.getParameter("htest3");
	String htest4 = request.getParameter("htest4");
	//수험자가 입력한값 
	String users [] = new String[4];
	//배열의 초기화 
		users[0] = htest1;
		users[1] = htest2;
		users[2] = htest3;
		users[3] = htest4;
		int sum=0;
		for(int i=0; i<users.length;i++) {
			for(int j=0;j<daps.length;j++){
				if(daps[i].equals(users[j])){
					if(i==j){
						out.print(users[j]);
						sum+=25;
					}
				}
				
			}
		}
		out.print(sum);
	/* out.print(htest1 +" " + htest2 +" " +htest3 +" " + htest4+"\n"); 
	out.print(" <br> ");
		if(htest1.equals("1")){
			sum+=25;
	     }
		if(htest2.equals("1")){
			sum+=25;
		}
		if(htest3.equals("2")){
			sum+=25;
		}
		if(htest4.equals("3")){
			sum+=25;
		}
	out.print(sum); */
	%>