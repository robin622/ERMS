<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>User List</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/style.css">
			
	<script language="javascript">
		function validate(){
   		var searchName = searchForm.searchName;
   		   		    		
   		if(searchName.value.length==0){
   			alert("请输入要查询的用户名"); 
   			searchName.focus();   			
   			return false;
   		}	
   		return true;
    	}
    </script>
	</head>
	<script language="javascript" src="${pageContext.request.contextPath}/js/height.js"></script>
	<body onload = "javascript:updateDisplaySize()">
	<jsp:include page="header.jsp" />
		<table id="mainTableInThisPage" width="100%" align="center" border="0" cellpadding="0" cellspacing="0" height="60">
			<tr valign="top">
				<td width="20%"><jsp:include page="left.jsp" /></td>
				<td width="80%" height=600 bgcolor=#FFFFFF style="padding:2px;">
				<div class=daohang>You current position<img src="${pageContext.request.contextPath}/images/icon02.gif" style="margin-top:10px;"/><font>Check User List</font></div>
					
				
			
			<c:if test="${not empty userList }">
				
		
				<table class=listFile cellspacing=1>
				<caption>User List</caption>
						
				<thead>
					<tr>
						
						<th>name</th>
						<th>Email</th>
						<th>action</th>
					</tr>
				</thead>
				<tbody>	
				<c:forEach items="${userList}" var="user" >	
					<tr align=center>						
						<td>${user.name }</td>
						<td >${user.email }</td>
						<td><a href="${pageContext.request.contextPath}/admin/toModifyAdmin.do?id=${admin.id}">modify</a> 
						| <a href="${pageContext.request.contextPath}/admin/removeAdmin.do?id=${admin.id}">remove</a>
						</td>
					</tr>
				</c:forEach>
				</tbody>					
			</table>				<br />
			
			</c:if>
				
		</td>
				
	</tr>
</table>
<jsp:include page="footer.jsp" />
	</body>
</html>
