package com.mvc2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc3.ModelAndView;

public interface Controller {
	public String process(HttpServletRequest req ,HttpServletResponse res)
			throws ServletException;
	public ModelAndView process(String work,HttpServletRequest req,HttpServletResponse res)
			throws ServletException;
	}
