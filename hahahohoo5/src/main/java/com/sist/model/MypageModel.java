package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.RequestMapping;

public class MypageModel {
	@RequestMapping("mypage/mypage_nav.do")
	public String mypage_mypage_nav(HttpServletRequest request , HttpServletResponse response)
	{
		
		
		request.setAttribute("main_jsp", "../mypage/mypage_nav.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("mypage/mypage_update.do")
	public String mypage_mypage_update(HttpServletRequest request , HttpServletResponse response)
	{
		
		
		request.setAttribute("main_jsp", "../mypage/mypage_update.jsp");
		return "../main/main.jsp";
	}
}
