<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String title = (String)request.getAttribute("title");	
%>
<header>
	<h1 id="top"><%=title %></h1>
</header>
<nav>
  <ul>
    <li><a href="home">홈</a></li>    
    <li class="dropdown">
      <a href="#" class="dropbtn">게시판</a>
      <div class="dropdown-content">
        <a href="boardList?btype=0">공지</a>
        <a href="boardList?btype=1">자유</a>
        <a href="boardList?btype=2">유머</a>        
      </div>
    </li>
  </ul>
</nav>