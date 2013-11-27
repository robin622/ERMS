<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
	<head>
		<title>Request List</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/style.css">
	</head>
	<script language="javascript" src="${pageContext.request.contextPath}/js/height.js"></script>
	<body onload = "javascript:updateDisplaySize()">
	<jsp:include page="header.jsp" />
		<table id="mainTableInThisPage" width="100%" align="center" border="0" cellpadding="0" cellspacing="0" height="60">
			<tr valign="top">
				<td width="20%"><jsp:include page="left.jsp" /></td>
				<td width="80%" height=600 bgcolor=#FFFFFF style="padding:2px;">
				<div class=daohang>You current position<img src="${pageContext.request.contextPath}/images/icon02.gif" style="margin-top:10px;"/><font>Check Request List</font></div>
			<c:if test="${not empty requestList }">
			<form name="userform" action="${pageContext.request.contextPath}/admin/removeUser.do" method="post">
				<table class="listFile" cellspacing=1 id="listRequest">
				<caption>Request List</caption>
				<thead>
					<tr>
						<th>name</th>
						<th>Content</th>
						<th>Owner</th>
						<th>Create date</th>
						<th>Due Date</th>
						<th>action</th>
					</tr>
				</thead>
				<tbody>	
				<c:forEach items="${requestList}" var="request" >	
					<tr align=center>						
						<td>${request.name }</td>
						<td >${request.content }</td>
						<td >${request.owner}</td>
						<td ><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${request.createtime}" /></td>
						<td ><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${request.endtime}" /></td>
						<td>
						<a href="${pageContext.request.contextPath}/DeleteUserServlet?userId=${user._id}" onclick="return confirm('Are you sure to delete the user?');">delete</a>
						</td>
					</tr>
				</c:forEach>
				</tbody>					
			</table>				<br />
			</form>
			</c:if>
			<c:if test="${empty requestList}">
					<center>
						No Request exists.
					</center>
			</c:if>
		</td>
	</tr>
</table>
<jsp:include page="footer.jsp" />
		<script type="text/javascript">
				toreplace('listRequest');
		</script>
	</body>
</html>
