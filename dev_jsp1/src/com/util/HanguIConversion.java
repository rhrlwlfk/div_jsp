package com.util;
/*
 * POST방식으로 전송시 사용함.
 */
public class HanguIConversion {
	public static String toUTF(String en) {
		if(en==null) return null;
		try {
			return new String(en.getBytes("8859_1"),"UTF-8");
		}catch (Exception e) {
			return en;
		}
	}
}
