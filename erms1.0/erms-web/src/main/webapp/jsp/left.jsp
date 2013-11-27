<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>Left Navigation</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/left.css">
		<script language="JavaScript">
			function show_switch(num){
				var secname = 'sec'+num;
				var imgname = 'img'+num;
				var hiddenobj = document.getElementById(secname);
				var imgobj = document.getElementById(imgname);
				
				if(hiddenobj.style.display=='none'){
					hiddenobj.style.display='';
					imgobj.src='${pageContext.request.contextPath}/images/line_03.gif';
				}else{
					hiddenobj.style.display='none';					
					imgobj.src='${pageContext.request.contextPath}/images/line_07.gif';
				}
			}
		</script>

	</head> 
	<body class=bgbody>	
		 <table class=leftpart cellspacing=0 cellpadding=0 nowrap>
		 	<tr valign="top">
				<td height=20>							
					<table width="200" cellspacing=1 cellpadding=1 class="opr_Item" border=0 bgcolor=#6281BF><!-- User Management -->						
						<tr bgcolor=#FFFFFF>				
							<td>	
								<a href=# onclick="show_switch(1)" style="TEXT-DECORATION:none;">
									<table width="200" cellspacing=0 cellpadding=0 class=left_class>
										<tr>
											<td nowrap class=leftTitle>
											<img src="${pageContext.request.contextPath}/images/managemanager.gif" class=title_dec />&nbsp;User Management</td>											
											<td width=28><img id="img1" src="${pageContext.request.contextPath}/images/line_03.gif" border=0/></td>

										</tr>
									</table>
								</a>
							</td>
						</tr>
						<tr id=sec1  bgcolor=#FFFFFF>				<!-- 可隐藏项 -->
							<td class="option_td" >
								<table width="200" cellspacing=8 cellpadding=4 class=listItem>
									<tr><td>
									<li ><a href="${pageContext.request.contextPath}/ListUserServlet">User List</a></li>
									<li ><a href="${pageContext.request.contextPath}/jsp/addUser.jsp">Add a User</a></li>
								</td></tr></table>
							</td>
						</tr>													
					</table>
				</td>				
			</tr>
			<tr>
				<td height=10></td>
			</tr>	
			<tr valign="top">
				<td height=20>							
					<table width="200" cellspacing=1 cellpadding=1 class="opr_Item" border=0 bgcolor=#6281BF><!-- Request Management -->						
						<tr bgcolor=#FFFFFF>				
							<td>	
								<a href=# onclick="show_switch(2)" style="TEXT-DECORATION:none;">
									<table width="200" cellspacing=0 cellpadding=0 class=left_class>
										<tr>
											<td nowrap class=leftTitle>
											<img src="${pageContext.request.contextPath}/images/requestmanager.gif" class=title_dec />&nbsp;Request Management</td>											
											<td width=28><img id="img2" src="${pageContext.request.contextPath}/images/line_03.gif" border=0/></td>

										</tr>
									</table>
								</a>
							</td>
						</tr>
						<tr id=sec2  bgcolor=#FFFFFF>				<!-- 可隐藏项 -->
							<td class="option_td" >
								<table width="200" cellspacing=8 cellpadding=4 class=listItem>
									<tr><td>
									<li ><a href="${pageContext.request.contextPath}/listRequest.do">Request(s) send to me</a></li>
									<li ><a href="${pageContext.request.contextPath}/listRequest.do">My created request(s)</a></li>
									<li ><a href="${pageContext.request.contextPath}/listRequest.do">Other request(s)</a></li>
									<li ><a href="${pageContext.request.contextPath}/AddRequestServlet?operation=init">Add a new request</a></li>
								</td></tr></table>
							</td>
						</tr>													
					</table>
				</td>				
			</tr>
			<tr>
				<td height=10></td>
			</tr>	
			<tr valign="top">
				<td height=20>							
					<table width="200" cellspacing=1 cellpadding=1 class="opr_Item" border=0 bgcolor=#6281BF><!-- statistics -->						
						<tr bgcolor=#FFFFFF>				
							<td>	
								<a href=# onclick="show_switch(3)" style="TEXT-DECORATION:none;">
									<table width="200" cellspacing=0 cellpadding=0 class=left_class>
										<tr>
											<td nowrap class=leftTitle>
											<img src="${pageContext.request.contextPath}/images/statistics.gif" class=title_dec />&nbsp;Statistics</td>											
											<td width=28><img id="img3" src="${pageContext.request.contextPath}/images/line_03.gif" border=0/></td>
										</tr>
									</table>
								</a>
							</td>
						</tr>
						<tr id=sec3  bgcolor=#FFFFFF>				<!-- 可隐藏项 -->
							<td class="option_td" >
								<table width="200" cellspacing=8 cellpadding=4 class=listItem>
									<tr><td>
									<li ><a href="${pageContext.request.contextPath}/admin/listMarketers.do">1</a></li>
									<li ><a href="${pageContext.request.contextPath}/admin/addMarketer.jsp">2</a></li>
								</td></tr></table>
							</td>
						</tr>													
					</table>
				</td>				
			</tr>
			<tr>
				<td height=10></td>
			</tr>							
			<tr valign="top">
				<td height=20 >							
					<table width="200" cellspacing=1 cellpadding=1 class="opr_Item" border=0 bgcolor=#6281BF><!-- others -->						
						<tr bgcolor=#FFFFFF>			
							<td>	
								<a href=# onclick="show_switch(10)" style="TEXT-DECORATION:none;">
									<table width="200" cellspacing=0 cellpadding=0 class=left_class>
										<tr>
											<td nowrap class=leftTitle>
											<img src="${pageContext.request.contextPath}/images/others.gif" class=title_dec />&nbsp;Others</td>											
											<td width=28><img id="img10" src="${pageContext.request.contextPath}/images/line_03.gif" border=0/></td>
										</tr>
									</table>
								</a>
							</td>
						</tr>
						<tr  id=sec10>				<!-- 可隐藏项 -->
							<td class="option_td">	
								<table width="200" cellspacing=8 cellpadding=4 class=listItem>
								<tr><td>
	
									<li ><a href="${pageContext.request.contextPath}/logout.do">Exit</a></li>								
								</td></tr></table>
							</td>
						</tr>													
					</table>
				</td>				
			</tr>
	
								
			
		</table>				
	</body>
</html>




