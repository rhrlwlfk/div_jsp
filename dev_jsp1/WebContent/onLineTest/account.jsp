<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie[] cookies = request.getCookies();
	String h_no = null;
	String users [] = new String[4];
	
	if(cookies!=null && cookies.length > 0) {
		for(int i=0;i<cookies.length;i++) {
			if("c_hno".equals(cookies[i].getName())){
				h_no = cookies[i].getValue();
			}else if("c_htest1".equals(cookies[i].getName())){
				users[0] = cookies[i].getValue(); 				
			}else if("c_htest2".equals(cookies[i].getName())){
				users[1] = cookies[i].getValue(); 				
			}else if("c_htest3".equals(cookies[i].getName())){
				users[2] = cookies[i].getValue(); 				
			}else if("c_htest4".equals(cookies[i].getName())){
				users[3] = cookies[i].getValue(); 				
			}
		}
	}
	out.print("h_no:" + h_no+ " ");
	out.print("<br>");
	String daps[] = {"1","1","2","3"};
	//수험자가 입력한값 
	//배열의 초기화 
		int sum=0;
		int imsi =0;
		for(int i=0; i<users.length;i++) {
			for(int j=0;j<daps.length;j++){
				if(daps[i].equals(users[j])){
					if(i==j){
						
						out.print(users[j]);
						sum+=25;
						imsi +=1;
					}
				}
			
			}
		}
		out.print("<br>");
			out.print("맞춘갯수" + imsi);
		out.print("<br>");
		out.print("점수"+sum);
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