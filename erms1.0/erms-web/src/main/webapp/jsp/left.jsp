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
					<table width="200" cellspacing=1 cellpadding=1 class="opr_Item" border=0 bgcolor=#6281BF><!-- 管理员管理 -->						
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
									<li ><a href="${pageContext.request.contextPath}/jsp/addUser.jsp">Add User</a></li>
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
					<table width="200" cellspacing=1 cellpadding=1 class="opr_Item" border=0 bgcolor=#6281BF><!-- 渠道专员管理 -->						
						<tr bgcolor=#FFFFFF>				
							<td>	
								<a href=# onclick="show_switch(2)" style="TEXT-DECORATION:none;">
									<table width="200" cellspacing=0 cellpadding=0 class=left_class>
										<tr>
											<td nowrap class=leftTitle>
											<img src="${pageContext.request.contextPath}/images/channelmanager.gif" class=title_dec />&nbsp;渠道专员管理</td>											
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
									<li ><a href="${pageContext.request.contextPath}/admin/listCommissioners.do">渠道专员列表</a></li>
									<li ><a href="${pageContext.request.contextPath}/admin/addCommissioner.jsp">添加渠道专员</a></li>
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
					<table width="200" cellspacing=1 cellpadding=1 class="opr_Item" border=0 bgcolor=#6281BF><!-- 渠道专员管理 -->						
						<tr bgcolor=#FFFFFF>				
							<td>	
								<a href=# onclick="show_switch(3)" style="TEXT-DECORATION:none;">
									<table width="200" cellspacing=0 cellpadding=0 class=left_class>
										<tr>
											<td nowrap class=leftTitle>
											<img src="${pageContext.request.contextPath}/images/channelmanager.gif" class=title_dec />&nbsp;市场人员管理</td>											
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
									<li ><a href="${pageContext.request.contextPath}/admin/listMarketers.do">市场人员列表</a></li>
									<li ><a href="${pageContext.request.contextPath}/admin/addMarketer.jsp">添加市场人员</a></li>
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
					<table width="200" cellspacing=1 cellpadding=1 class="opr_Item" border=0 bgcolor=#6281BF><!-- 代理商管理 -->						
						<tr bgcolor=#FFFFFF>
							<td>	
								<a href=# onclick="show_switch(4)" style="TEXT-DECORATION:none;">
									<table width="200" cellspacing=0 cellpadding=0  class=left_class>
										<tr>
											<td nowrap class=leftTitle>
											<img src="${pageContext.request.contextPath}/images/agentmanager.gif" class=title_dec />&nbsp;代理商管理</td>											
											<td width=28><img id="img4"  src="${pageContext.request.contextPath}/images/line_03.gif" border=0/></td>
										</tr>
									</table>
								</a>
							</td>
						</tr>
						<tr id=sec4>				<!-- 可隐藏项 -->
							<td class="option_td" >	
								<table width="200" cellspacing=8 cellpadding=4 class=listItem>
								<tr><td>
									<li ><a href="${pageContext.request.contextPath}/admin/listAgents.do">代理商列表</a></li>
									<li ><a href="${pageContext.request.contextPath}/admin/toAddAgent.do">添加代理商</a></li>
									<li><a href="${pageContext.request.contextPath}/admin/listAgentTypes.do">代理商类型</a></li>															
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
					<table width="200" cellspacing=1 cellpadding=1 class="opr_Item" border=0 bgcolor=#6281BF><!-- 用户管理 -->						
						<tr bgcolor=#FFFFFF>				
							<td>	
								<a href=# onclick="show_switch(5)" style="TEXT-DECORATION:none;">
									<table width="200" cellspacing=0 cellpadding=0 class=left_class>
										<tr>
											<td nowrap class=leftTitle>
											<img src="${pageContext.request.contextPath}/images/usermanager.gif" class=title_dec />&nbsp;用户管理</td>											
											<td width=28><img id="img5" src="${pageContext.request.contextPath}/images/line_03.gif" border=0/></td>
										</tr>
									</table>
								</a>
							</td>
						</tr>
						<tr  id=sec5>				<!-- 可隐藏项 -->
							<td class="option_td">	
								<table width="200" cellspacing=8 cellpadding=4 class=listItem>
								<tr><td>
									<li ><a href="${pageContext.request.contextPath}/admin/listUsers.do">用户列表</a></li>
									<li ><a href="${pageContext.request.contextPath}/admin/listPastUsers.do">过期用户列表</a></li>
									<li ><a href="${pageContext.request.contextPath}/admin/to_add_user.do">添加用户</a></li>
									<li ><a href="${pageContext.request.contextPath}/admin/list_tmp_users.do">试注册用户</a></li>
									<li ><a href="${pageContext.request.contextPath}/admin/manage_ind_class.do">用户行业编辑</a></li>
									<li ><a href="${pageContext.request.contextPath}/admin/searchUsers.jsp">域名绑定</a></li>
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
					<table width="200" cellspacing=1 cellpadding=1 class="opr_Item" border=0 bgcolor=#6281BF><!-- 产品管理 -->						
						<tr bgcolor=#FFFFFF>				
							<td>	
								<a href=# onclick="show_switch(6)" style="TEXT-DECORATION:none;">
									<table width="200" cellspacing=0 cellpadding=0 class=left_class>
										<tr>
											<td nowrap class=leftTitle>
											<img src="${pageContext.request.contextPath}/images/productmanager.gif" class=title_dec />&nbsp;产品管理</td>											
											<td width=28><img id="img6"  src="${pageContext.request.contextPath}/images/line_03.gif" border=0/></td>

										</tr>
									</table>
								</a>
							</td>
						</tr>
						<tr  bgcolor=#FFFFFF id=sec6>				<!-- 可隐藏项 -->
							<td class="option_td" >
								<table width="200" cellspacing=8 cellpadding=4 class=listItem>
									<tr><td>
									<li ><a href="${pageContext.request.contextPath}/admin/listUserTypes.do">产品类型</a></li>									
									<li ><a href="${pageContext.request.contextPath}/admin/listSkins.do">皮肤管理</a></li>
									<li ><a href="${pageContext.request.contextPath}/admin/to_play_config.do">公播设置</a></li>
									<li ><a href="${pageContext.request.contextPath}/admin/listAllNews.do">新消息设置</a></li>
									<li ><a href="${pageContext.request.contextPath}/admin/showAllSuggestion.do">意见建议</a></li>
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
					<table width="200" cellspacing=1 cellpadding=1 class="opr_Item" border=0 bgcolor=#6281BF><!-- 产品促销管理 -->						
						<tr bgcolor=#FFFFFF>				
							<td>	
								<a href=# onclick="show_switch(7)" style="TEXT-DECORATION:none;">
									<table width="200" cellspacing=0 cellpadding=0 class=left_class>
										<tr>
											<td nowrap class=leftTitle>
											<img src="${pageContext.request.contextPath}/images/channelmanager.gif" class=title_dec />&nbsp;产品促销管理</td>											
											<td width=28><img id="img7" src="${pageContext.request.contextPath}/images/line_03.gif" border=0/></td>

										</tr>
									</table>
								</a>
							</td>
						</tr>
						<tr id=sec7  bgcolor=#FFFFFF>				<!-- 可隐藏项 -->
							<td class="option_td" >
								<table width="200" cellspacing=8 cellpadding=4 class=listItem>
									<tr><td>
									<li ><a href="${pageContext.request.contextPath}/admin/preaddonsale.do">添加产品促销</a></li>
									<li ><a href="${pageContext.request.contextPath}/admin/showOnsale.do">产品促销记录</a></li>
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
					<table width="200" cellspacing=1 cellpadding=1 class="opr_Item" border=0 bgcolor=#6281BF><!-- 产品促销管理 -->						
						<tr bgcolor=#FFFFFF>				
							<td>	
								<a href=# onclick="show_switch(8)" style="TEXT-DECORATION:none;">
									<table width="200" cellspacing=0 cellpadding=0 class=left_class>
										<tr>
											<td nowrap class=leftTitle>
											<img src="${pageContext.request.contextPath}/images/channelmanager.gif" class=title_dec />&nbsp;服务器管理</td>											
											<td width=28><img id="img8" src="${pageContext.request.contextPath}/images/line_03.gif" border=0/></td>

										</tr>
									</table>
								</a>
							</td>
						</tr>
						<tr id=sec8  bgcolor=#FFFFFF>				<!-- 可隐藏项 -->
							<td class="option_td" >
								<table width="200" cellspacing=8 cellpadding=4 class=listItem>
									<tr><td>
									<li ><a href="${pageContext.request.contextPath}/admin/addserver.do">添加服务器</a></li>
									<li ><a href="${pageContext.request.contextPath}/admin/serverlist.do">服务器列表</a></li>
									<li ><a href="${pageContext.request.contextPath}/admin/fieldlist.jsp">域列表</a></li>
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
					<table width="200" cellspacing=1 cellpadding=1 class="opr_Item" border=0 bgcolor=#6281BF><!-- 用户卡管理 -->						
						<tr bgcolor=#FFFFFF>				
							<td>	
								<a href=# onclick="show_switch(9)" style="TEXT-DECORATION:none;">
									<table width="200" cellspacing=0 cellpadding=0 class=left_class>
										<tr>
											<td nowrap class=leftTitle>
											<img src="${pageContext.request.contextPath}/images/channelmanager.gif" class=title_dec />&nbsp;用户卡管理</td>											
											<td width=28><img id="img9" src="${pageContext.request.contextPath}/images/line_03.gif" border=0/></td>

										</tr>
									</table>
								</a>
							</td>
						</tr>
						<tr id=sec9  bgcolor=#FFFFFF>				<!-- 可隐藏项 -->
							<td class="option_td" >
								<table width="200" cellspacing=8 cellpadding=4 class=listItem>
									<tr><td>
									<li ><a href="${pageContext.request.contextPath}/admin/addusercard.do">添加用户卡</a></li>
									<li ><a href="${pageContext.request.contextPath}/admin/addSingleUserCard.do">手动添加单用户</a></li>
									<li ><a href="${pageContext.request.contextPath}/admin/usercardlist.do">用户卡列表</a></li>
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
					<table width="200" cellspacing=1 cellpadding=1 class="opr_Item" border=0 bgcolor=#6281BF><!-- 其他管理 -->						
						<tr bgcolor=#FFFFFF>			
							<td>	
								<a href=# onclick="show_switch(10)" style="TEXT-DECORATION:none;">
									<table width="200" cellspacing=0 cellpadding=0 class=left_class>
										<tr>
											<td nowrap class=leftTitle>
											<img src="${pageContext.request.contextPath}/images/others.gif" class=title_dec />&nbsp;其他</td>											
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
	
									<li ><a href="${pageContext.request.contextPath}/logout.do">退出系统</a></li>								
								</td></tr></table>
							</td>
						</tr>													
					</table>
				</td>				
			</tr>
	
								
			
		</table>				
	</body>
</html>




