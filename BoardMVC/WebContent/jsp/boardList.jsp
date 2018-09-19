<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="kr.itedu.boardmvc.*" %>
<%
	ArrayList<BoardVO> result = (ArrayList<BoardVO>)
	request.getAttribute("data");
	//result.clear();
%>

<% if(result != null && result.size() > 0) { %>
<div class="tableContainer">
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th style="width:80%;">제목</th>
				<th>등록일시</th>
			</tr>
		</thead>
		<tbody>
		<% for(BoardVO vo : result) { %>
			<tr>
				<td class="txtct"><%=vo.getBid() %></td>
				<td>
					<a href="boardDetail?bypte=<%=vo.getBtype() %>&bid=<%=vo.getBid() %>">
					<%=vo.getBtitle() %>
					</a>
				</td>
				<td><%=vo.getBregdate() %></td>
			</tr>			 
		<% } %>
		</tbody>
	</table>
	
	<div class="bottom">
		<a href="boardRegMod?btype=${param.btype}&bid=0"><button>글쓰기</button></a>
	</div>	
</div>
<% } else { %>
	게시글이 없습니다.
<% } %>






