<%@page import="java.util.Date"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="java.io.*,java.net.*" %>
   <%
		  	String clientId = "HhYnb2O2RzO8HTZf_UlL"; //애플리케이션 클라이언트 아이디값";
			String clientSecret = "ToNCRyBUXT"; //애플리케이션 클라이언트 시크릿값";
			
			String key = "jgTcXm4UpJR4lk2z";
			String apiURL = "https://openapi.naver.com/v1/captcha/ncaptcha.bin?key=" + key;
			
	        Map<String, String> requestHeaders = new HashMap<>();
	        requestHeaders.put("X-Naver-Client-Id", clientId);
	        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
			
	        URL url = new URL(apiURL);
	        HttpURLConnection connect = (HttpURLConnection)url.openConnection();
	try{
		        connect.setRequestMethod("GET");
		        
	        for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                connect.setRequestProperty(header.getKey(), header.getValue());
            }
            int responseCode = connect.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
            	byte[] bytes = new byte[1024];
                // 랜덤한 이름으로  파일 생성
                int read;
                String filename = Long.valueOf(new Date().getTime()).toString();
                File f = new File(filename + ".jpg");
                try(OutputStream outputStream = new FileOutputStream(f)){
                    f.createNewFile();
                    while ((read = connect.getInputStream().read(bytes)) != -1) {
                        outputStream.write(bytes, 0, read);
                    }
                    out.print("이미지가 캡쳐되었습니다.");
                } catch (IOException e) {
                	e.printStackTrace();
                }
            }
	}catch(Exception e){
		out.print(e.toString());
		e.printStackTrace();
	}
	
   %>