package com.sist.model;

import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.vo.*;
import com.sist.controller.RequestMapping;
import com.sist.dao.*;

public class StoreModel {
	
	/*
	 * @RequestMapping("store/new.do") public String store_new(HttpServletRequest
	 * request, HttpServletResponse response) { String
	 * type=request.getParameter("type"); type="1"; String
	 * page=request.getParameter("page"); if(page==null) page="1";
	 * 
	 * // 페이지 지정 int curpage=Integer.parseInt(page); // 페이지에 해당되는 목록 GoodsDAO
	 * dao=new GoodsDAO(); List<GoodsVO> list=dao.goodsListData(curpage,
	 * Integer.parseInt(type)); int
	 * totalpage=dao.goodsTotalPage(Integer.parseInt(type));
	 * 
	 * final int BLOCK=10; int startPage=((curpage-1)/BLOCK*BLOCK)+1; int
	 * endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	 * 
	 * if(endPage>totalpage) endPage=totalpage;
	 * 
	 * // JSP에서 출력할 데이터를 전송 request.setAttribute("list", list);
	 * request.setAttribute("curpage", curpage); request.setAttribute("totalpage",
	 * totalpage); request.setAttribute("startPage", startPage);
	 * request.setAttribute("endPage", endPage);
	 * 
	 * request.setAttribute("store_jsp", "../store/new.jsp");
	 * request.setAttribute("main_jsp", "../store/store_main.jsp");
	 * 
	 * return "../main/main.jsp"; }
	 * 
	 * @RequestMapping("store/backpacking.do") public String
	 * store_backpacking(HttpServletRequest request, HttpServletResponse response) {
	 * String type=request.getParameter("type"); type="2"; String
	 * page=request.getParameter("page"); if(page==null) page="1";
	 * 
	 * // 페이지 지정 int curpage=Integer.parseInt(page); // 페이지에 해당되는 목록 GoodsDAO
	 * dao=new GoodsDAO(); List<GoodsVO> list=dao.goodsListData(curpage,
	 * Integer.parseInt(type)); int
	 * totalpage=dao.goodsTotalPage(Integer.parseInt(type));
	 * 
	 * final int BLOCK=10; int startPage=((curpage-1)/BLOCK*BLOCK)+1; int
	 * endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	 * 
	 * if(endPage>totalpage) endPage=totalpage;
	 * 
	 * // JSP에서 출력할 데이터를 전송 request.setAttribute("list", list);
	 * request.setAttribute("curpage", curpage); request.setAttribute("totalpage",
	 * totalpage); request.setAttribute("startPage", startPage);
	 * request.setAttribute("endPage", endPage);
	 * 
	 * request.setAttribute("store_jsp", "../store/backpacking.jsp");
	 * request.setAttribute("main_jsp", "../store/store_main.jsp");
	 * 
	 * return "../main/main.jsp"; }
	 * 
	 * @RequestMapping("store/long.do") public String store_long(HttpServletRequest
	 * request, HttpServletResponse response) { String
	 * type=request.getParameter("type"); type="3"; String
	 * page=request.getParameter("page"); if(page==null) page="1";
	 * 
	 * // 페이지 지정 int curpage=Integer.parseInt(page); // 페이지에 해당되는 목록 GoodsDAO
	 * dao=new GoodsDAO(); List<GoodsVO> list=dao.goodsListData(curpage,
	 * Integer.parseInt(type)); int
	 * totalpage=dao.goodsTotalPage(Integer.parseInt(type));
	 * 
	 * final int BLOCK=10; int startPage=((curpage-1)/BLOCK*BLOCK)+1; int
	 * endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	 * 
	 * if(endPage>totalpage) endPage=totalpage;
	 * 
	 * // JSP에서 출력할 데이터를 전송 request.setAttribute("list", list);
	 * request.setAttribute("curpage", curpage); request.setAttribute("totalpage",
	 * totalpage); request.setAttribute("startPage", startPage);
	 * request.setAttribute("endPage", endPage);
	 * 
	 * request.setAttribute("store_jsp", "../store/long.jsp");
	 * request.setAttribute("main_jsp", "../store/store_main.jsp");
	 * 
	 * return "../main/main.jsp"; }
	 * 
	 * @RequestMapping("store/travel.do") public String
	 * store_travel(HttpServletRequest request, HttpServletResponse response) {
	 * String type=request.getParameter("type"); type="4"; String
	 * page=request.getParameter("page"); if(page==null) page="1";
	 * 
	 * // 페이지 지정 int curpage=Integer.parseInt(page); // 페이지에 해당되는 목록 GoodsDAO
	 * dao=new GoodsDAO(); List<GoodsVO> list=dao.goodsListData(curpage,
	 * Integer.parseInt(type)); int
	 * totalpage=dao.goodsTotalPage(Integer.parseInt(type));
	 * 
	 * final int BLOCK=10; int startPage=((curpage-1)/BLOCK*BLOCK)+1; int
	 * endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	 * 
	 * if(endPage>totalpage) endPage=totalpage;
	 * 
	 * // JSP에서 출력할 데이터를 전송 request.setAttribute("list", list);
	 * request.setAttribute("curpage", curpage); request.setAttribute("totalpage",
	 * totalpage); request.setAttribute("startPage", startPage);
	 * request.setAttribute("endPage", endPage);
	 * 
	 * request.setAttribute("store_jsp", "../store/travel.jsp");
	 * request.setAttribute("main_jsp", "../store/store_main.jsp");
	 * 
	 * return "../main/main.jsp"; }
	 * 
	 * @RequestMapping("store/detail.do") public String
	 * store_detail(HttpServletRequest request, HttpServletResponse response) { //
	 * 사용자 => gno String gno=request.getParameter("gno"); String
	 * cno=request.getParameter("cno");
	 * 
	 * 
	 * // DB 연동 GoodsDAO dao=GoodsDAO.newInstance(); GoodsVO
	 * vo=dao.goodsDetailData(Integer.parseInt(cno),Integer.parseInt(gno));
	 * 
	 * request.setAttribute("vo", vo); request.setAttribute("store_jsp",
	 * "../store/detail.jsp"); request.setAttribute("main_jsp",
	 * "../store/store_main.jsp"); return "../main/main.jsp"; }
	 */
	 
   
   
   ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   
   @RequestMapping("store/detailex.do")
   public String store_detailex(HttpServletRequest request, HttpServletResponse response)
   {
	   //String gno=request.getParameter("gno");
       //String cno=request.getParameter("cno");
	   
	   //GoodsDAO dao=GoodsDAO.newInstance();
       //GoodsVO vo=dao.goodsDetailData(Integer.parseInt(cno),Integer.parseInt(gno));
      // request.setAttribute("vo", vo);
       request.setAttribute("store_jsp","../store/detailex.jsp");
       request.setAttribute("main_jsp","../store/store_main.jsp");
       return "../main/main.jsp";
   }
   @RequestMapping("store/new.do")
   public String store_new(HttpServletRequest request, HttpServletResponse response)
   {
	   String type=request.getParameter("type");
       	   type="1";
       String page=request.getParameter("page");
       if(page==null)
    	   page="1";
    
    // 페이지 지정
    int curpage=Integer.parseInt(page);
    // 페이지에 해당되는 목록
    GoodsDAO dao=new GoodsDAO();
    List<GoodsVO> list=dao.goodsListData(curpage, Integer.parseInt(type));
    int totalpage=dao.goodsTotalPage(Integer.parseInt(type));
                
    final int BLOCK=6;
    int startPage=((curpage-1)/BLOCK*BLOCK)+1;
    int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
                
    if(endPage>totalpage)
       endPage=totalpage;
                
    // JSP에서 출력할 데이터를 전송
    request.setAttribute("list", list);
    request.setAttribute("curpage", curpage);
    request.setAttribute("totalpage", totalpage);
    request.setAttribute("startPage", startPage);
    request.setAttribute("endPage", endPage);

	   
	   request.setAttribute("store_jsp","../store/new.jsp");
       request.setAttribute("main_jsp","../store/store_main.jsp");
       
       return "../main/main.jsp";
   }
   @RequestMapping("store/backpacking.do")
   public String store_backpacking(HttpServletRequest request, HttpServletResponse response)
   {
	   String type=request.getParameter("type");
       type="2";
    String page=request.getParameter("page");
    if(page==null)
       page="1";
    
    // 페이지 지정
    int curpage=Integer.parseInt(page);
    // 페이지에 해당되는 목록
    GoodsDAO dao=new GoodsDAO();
    List<GoodsVO> list=dao.goodsListData(curpage, Integer.parseInt(type));
    int totalpage=dao.goodsTotalPage(Integer.parseInt(type));
                
    final int BLOCK=10;
    int startPage=((curpage-1)/BLOCK*BLOCK)+1;
    int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
                
    if(endPage>totalpage)
       endPage=totalpage;
                
    // JSP에서 출력할 데이터를 전송
    request.setAttribute("list", list);
    request.setAttribute("curpage", curpage);
    request.setAttribute("totalpage", totalpage);
    request.setAttribute("startPage", startPage);
    request.setAttribute("endPage", endPage);

	   
	   request.setAttribute("store_jsp","../store/backpacking.jsp");
       request.setAttribute("main_jsp","../store/store_main.jsp");
       
       return "../main/main.jsp";
   }
   @RequestMapping("store/long.do")
   public String store_long(HttpServletRequest request, HttpServletResponse response)
   {
	   String type=request.getParameter("type");
       type="3";
    String page=request.getParameter("page");
    if(page==null)
       page="1";
    
    // 페이지 지정
    int curpage=Integer.parseInt(page);
    // 페이지에 해당되는 목록
    GoodsDAO dao=new GoodsDAO();
    List<GoodsVO> list=dao.goodsListData(curpage, Integer.parseInt(type));
    int totalpage=dao.goodsTotalPage(Integer.parseInt(type));
                
    final int BLOCK=10;
    int startPage=((curpage-1)/BLOCK*BLOCK)+1;
    int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
                
    if(endPage>totalpage)
       endPage=totalpage;
                
    // JSP에서 출력할 데이터를 전송
    request.setAttribute("list", list);
    request.setAttribute("curpage", curpage);
    request.setAttribute("totalpage", totalpage);
    request.setAttribute("startPage", startPage);
    request.setAttribute("endPage", endPage);

	   
	   request.setAttribute("store_jsp","../store/long.jsp");
       request.setAttribute("main_jsp","../store/store_main.jsp");
       
       return "../main/main.jsp";
   }
   @RequestMapping("store/travel.do")
   public String store_travel(HttpServletRequest request, HttpServletResponse response)
   {
	   String type=request.getParameter("type");
       	   type="4";
       String page=request.getParameter("page");
       if(page==null)
    	   page="1";
    
       // 페이지 지정
       int curpage=Integer.parseInt(page);
       // 페이지에 해당되는 목록
       GoodsDAO dao=new GoodsDAO();
       List<GoodsVO> list=dao.goodsListData(curpage, Integer.parseInt(type));
       int totalpage=dao.goodsTotalPage(Integer.parseInt(type));
                
       final int BLOCK=10;
       int startPage=((curpage-1)/BLOCK*BLOCK)+1;
       int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
                
       if(endPage>totalpage)
    	   endPage=totalpage;
                
       // JSP에서 출력할 데이터를 전송
       request.setAttribute("list", list);
       request.setAttribute("curpage", curpage);
       request.setAttribute("totalpage", totalpage);
       request.setAttribute("startPage", startPage);
       request.setAttribute("endPage", endPage);

	   
	   request.setAttribute("store_jsp","../store/travel.jsp");
       request.setAttribute("main_jsp","../store/store_main.jsp");
       
       return "../main/main.jsp";
   }
   
   
}