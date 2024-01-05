<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Spinner Start -->
        <div id="spinner" class="show w-100 vh-100 bg-white position-fixed translate-middle top-50 start-50  d-flex align-items-center justify-content-center">
            <div class="spinner-grow text-primary" role="status"></div>
        </div>
        <!-- Spinner End -->
		
		<div class="modal fade" id="searchModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-fullscreen">
                <div class="modal-content rounded-0">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Search by keyword</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body d-flex align-items-center">
                        <div class="input-group w-75 mx-auto d-flex">
                            <input type="search" class="form-control p-3" placeholder="keywords" aria-describedby="search-icon-1">
                            <span id="search-icon-1" class="input-group-text p-3"><i class="fa fa-search"></i></span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Modal Search End -->

        <!-- Navbar start -->
        <div class="container-fluid fixed-top">
            <div class="container topbar bg-primary d-none d-lg-block">
                <div class="d-flex justify-content-between">
                    <div class="top-info ps-2">
                        <small class="me-3"><i class="fas fa-map-marker-alt me-2 text-secondary"></i> <a href="#" class="text-white">경기도 뉴욕</a></small>
                        <small class="me-3"><i class="fas fa-envelope me-2 text-secondary"></i><a href="#" class="text-white">barocamp@gmai.com</a></small>
                    </div>
                    <div class="top-link pe-2">
                      <c:if test="${sessionScope.id!=null }">
                        <div class="text-right">
					     <form method="post" action="../member/logout.do">
					      ${sessionScope.name}(${sessionScope.admin=='y'?"관리자":"일반" }) 님 로그인되었습니다
					      <input type="submit" value="로그아웃"
					        class="btn-sm btn-success">
					     </form>
					   </div>
					  </c:if>
					  <c:if test="${sessionScope.id==null }">
                        <div class="text-right">
					     <form method="post" action="../member/login.do">
					      <input type="submit" value="로그인"
					        class="btn-sm btn-success">
					     </form>
					   </div>
					  </c:if>
                        <a href="../member/join.do" class="text-white"><small class="text-white mx-2">회원가입</small>/</a>
                        <a href="#" class="text-white"><small class="text-white ms-2">고객센터</small></a>
                    </div>
                </div>
            </div>
            <div class="container px-0">
                <nav class="navbar navbar-light bg-white navbar-expand-xl">
                    <a href="../main/main.do" class="navbar-brand"><h1 class="text-primary display-6">바로캠핑</h1></a>
                    <button class="navbar-toggler py-2 px-3" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                        <span class="fa fa-bars text-primary"></span>
                    </button>
                    <div class="collapse navbar-collapse bg-white" id="navbarCollapse">
                        <div class="navbar-nav mx-auto">
                            <a href="../main/main.do" class="nav-item nav-link active">홈</a>
                            <a href="../gocamping/list.do" class="nav-item nav-link">캠핑예약</a>
                            <!-- <a href="shop-detail.html" class="nav-item nav-link">Shop Detail</a> -->
                            <div class="nav-item dropdown">
                                <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">캠핑용품</a>
                                <div class="dropdown-menu m-0 bg-secondary rounded-0">
                                    <a href="../store/new.do" class="dropdown-item">신규등록상품</a>
                                    <a href="../store/backpacking.do" class="dropdown-item">백패킹/하이킹</a>
                                    <a href="../store/long.do" class="dropdown-item">장박추천용품</a>
                                    <a href="../store/travel.do" class="dropdown-item">여행용품</a>
                                </div>
                            </div>
                            <div class="nav-item dropdown">
                                <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">커뮤니티</a>
                                <div class="dropdown-menu m-0 bg-secondary rounded-0">
                                    <a href="../board/list.do" class="dropdown-item">자유게시판</a>
                                    <a href="../databoard/list.do" class="dropdown-item">자료실</a>
                                   
                                </div>
                            </div>
                        </div>
                        <div class="d-flex m-3 me-0">
                            
                            <a href="#" class="position-relative me-4 my-auto">
                                <i class="fa fa-shopping-bag fa-2x"></i>
                                <span class="position-absolute bg-secondary rounded-circle d-flex align-items-center justify-content-center text-dark px-1" style="top: -5px; left: 15px; height: 20px; min-width: 20px;">3</span>
                            </a>
                            <a href="../mypage/mypage_nav.do" class="my-auto">
                                <i class="fas fa-user fa-2x"></i>
                            </a>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
</body>
</html>