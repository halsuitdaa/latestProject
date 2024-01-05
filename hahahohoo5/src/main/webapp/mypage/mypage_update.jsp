<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- 회원가입 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="../shadow/css/shadowbox.css">
<link rel="stylesheet" href="font.css"> -->
<style type="text/css">
.listcontent{
	margin-top: 170px;
}
.row1 {
      margin: 0px auto;
      width: 600px;
    }
.div{
   width:200px;
   white-space:nowrap; /* 자동 줄바꿈 해제 */
   overflow:hidden; /* 초과된 글자를 감춘다 . . . */
   text-overflow: ellipsis; /* 글자가 초과되는 경우 */
   /* 자동으로  . . . 으로 출력 | 글자가 벗어나면 줄바꿈없이 감추기 */
</style>

</head>
<body>


<div class="listcontent">
	<div class="container">
		<div class="row">
			<h3> 회원 정보 수정</h1>
		</div>
	    <div class="row row1"> 
	      <table class="table">
	     <tr>
	      <th class="text-right" width="15%">ID</th>
	      <td width="85%" class="inline">
	       <input type="text" size=15 class="input-sm" 
	          readonly name="id" id="id">
	       <input type="button" value="중복확인"
	         class="btn-sm btn-info" id="checkBtn">
	      </td>
	     </tr>
	     
	     <tr>
	      <th class="text-right" width="15%">비밀번호</th>
	      <td width="85%" class="inline">
	       <input type="password" size=15 class="input-sm" name="pwd" id="pwd">
	       &nbsp;비밀번호 재입력:<input type="password" size=15 class="input-sm" id="pwd1">
	      </td>
	     </tr>
	     
	     <tr>
	      <th class="text-right" width="15%">이름</th>
	      <td width="85%">
	       <input type="text" size=15 class="input-sm" name="name" id="name">
	      </td>
	     </tr>
	     
	     <tr>
	      <th class="text-right" width="15%">성별</th>
	      <td width="85%" class="inline">
	       <input type="radio" name="sex" value="male" checked>남자
	       <input type="radio" name="sex" value="female">여자
	      </td>
	     </tr>
	     
	     <tr>
	      <th class="text-right" width="15%">생년월일</th>
	      <td width="85%">
	       <input type="date" size=20 class="input-sm" name="birthday" id="day">
	      </td>
	     </tr>
	     
	     <tr>
	      <th class="text-right" width="15%">이메일주소</th>
	      <td width="85%">
	       <input type="email" size=10 class="input-sm"> @
	       <input type="email" id="email" name="email" list="emailList" autocomplete="off" class="input-sm">
	        <datalist id="emailList">
	        <option value="naver.com"></option>
	       <option value="daum.net"></option>
	         <option value="icloud.com"></option>
	         </datalist>    
	       </td>
	        </tr>
	        
	        <tr>
	        <th class="text-right" width="15%">전화번호</th>
	        <td width="85%">
	           <select class="input-sm">
	             <option>010</option>
	             <option>011</option>
	             <option>016</option>
	             <option>017</option>
	             <option>018</option>
	             <option>019</option>
	           </select>
	        <input type="text" size=20 class="input-sm" name="phone2" id="phone2">
	         </td>
	        </tr>
	        
	      <tr>
	      <th class="text-right" width="15%">우편번호</th>
	      <td width="85%" class="inline">
	       <input type="text" size=7 class="input-sm" name="post1" readonly id="post1">-
	       <input type="text" size=7 class="input-sm" name="post2" readonly id="post2">
	       <input type=button value="우편번호검색"
	         class="btn btn-sm btn-primary" id="postBtn">
	      </td>
	     </tr>
	     
	     <tr>
	      <th class="text-right" width="15%">주소</th>
	      <td width="85%">
	       <input type="text" size=50 class="input-sm" name="addr1" readonly id="addr1">
	      </td>
	      </tr>
	     
	      <tr>
	      <th class="text-right" width="15%">상세주소</th>
	      <td width="85%">
	      <input type="text" size=50 class="input-sm" name="addr2">
	      </td>
	      </tr>
	       <td colspan="2" class="text-center inline">
	        <input type="submit" value="회원정보수정"
	         class="btn-sm btn-info" id="joinBtn">
	        <input type=button value="취소"
	         class="btn-sm btn-warning"
	         onclick="javascript:history.back()"
	        >
	        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	        <input type="submit" value="회원탈퇴"
	         class="btn-sm btn-danger" id="joinBtn">
	       </td>
	     </tr>
	    </table>
	    </form>
	   </div>
	</div>
 </div>
</body>
</html>