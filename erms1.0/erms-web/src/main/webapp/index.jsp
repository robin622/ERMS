<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>Login</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
		<style type="text/css">
			td img{
				margin-left:50;	margin-right:5;	margin-bottom:2;	
			}
		</style>
		<script language="javascript">
		if(self.location!=top.location) top.location=self.location;
		function validate(){
    		var id = form.loginName.value;
    		var pwd = form.loginPassword.value;
    		if(id==null||id==""){
    			alert("User name can not be empty"); 
    			form.loginName.focus();   			
    			return false;
    		}	
    		if(pwd==null||pwd==""){
    			alert("User password can not be empty");
    			form.loginPassword.focus();
    			return false;
    		}	
    		return true;
    	}
    	function correctPNG() 
   {
   for(var i=0; i<document.images.length; i++)
      {
      var img = document.images[i]
      var imgName = img.src.toUpperCase()
      if (imgName.substring(imgName.length-3, imgName.length) == "PNG")
         {
         var imgID = (img.id) ? "id='" + img.id + "' " : ""
         var imgClass = (img.className) ? "class='" + img.className + "' " : ""
         var imgTitle = (img.title) ? "title='" + img.title + "' " : "title='" + img.alt + "' "
         var imgStyle = "display:inline-block;" + img.style.cssText 
         if (img.align == "left") imgStyle = "float:left;" + imgStyle
         if (img.align == "right") imgStyle = "float:right;" + imgStyle
         if (img.parentElement.href) imgStyle = "cursor:hand;" + imgStyle        
         var strNewHTML = "<span " + imgID + imgClass + imgTitle
         + " style=\"" + "width:" + img.width + "px; height:" + img.height + "px;" + imgStyle + ";"
         + "filter:progid:DXImageTransform.Microsoft.AlphaImageLoader"
         + "(src=\'" + img.src + "\', sizingMethod='scale');\"></span>" 
         img.outerHTML = strNewHTML
         i = i-1
         }
      }
   }
	window.attachEvent("onload", correctPNG);
	window.onload=function(){
	var browser=navigator.appName;
	if(browser=="Microsoft Internet Explorer")
	{
		document.getElementById("secondimg").style.cssText="float:right;margin-right:140px;";
	}
	}
    </script>
	</head>	
	<body class=index_body style=background:url("./images/logobg.gif") repeat-x;>
		<div style="height:20%;"></div>
		<form  name=form method="post" action="${pageContext.request.contextPath}/LoginServlet">		
		<img src="${pageContext.request.contextPath}/images/logobg.png"></img>
		<div style="margin-top:-315px;">
		<table align="center" border="0" cellpadding="4" cellspacing="0" width=445 height=314 background="" >
			<tr>   			
   				<td colspan=2 height=120 >
				</td>   			 
 		 	</tr>		
			<tr>
			    <td nowrap width=30%><img src="${pageContext.request.contextPath}/images/login_dec1.gif" border=0 />Username</td>
			    <td><input style="background-color:transparent;" type="text" size="20" name="loginName" value="${loginName}" class=logininput onMouseOver="this.focus()" ></td>        
			</tr>
			<tr>
			    <td  nowrap><img src="${pageContext.request.contextPath}/images/login_dec1.gif" border=0 />Passowrd</td>
			    <td>
			       <input style="background-color:transparent;" type="password" size="20"  name="loginPassword" class=logininput onMouseOver="this.focus()" >
			    </td>        
			</tr>    
			<tr>
			    <td nowrap><img src="${pageContext.request.contextPath}/images/login_dec1.gif" border=0 />Identitys</td>
			    <td>	
			        	<select name="role">			        	
			        		<option value="1" selected>Customer</option>
			        		<option value="0" >Admin</option>
			        	</select>            
			    </td>        
			</tr>   
			<tr>
				<td  colspan=2 align=right>					
		  			  <input type="submit" class="loginButton" value="Login" onclick="return validate()"><input type=button style="width:11px;visibility:hidden;" value="" /><input type="reset"  class="loginButton" value="Reset" ><input  type=button style="width:37px;visibility:hidden;" value="" />			  
    			</td>
    		</tr>
    		<tr>
    			<td  colspan=2 height=10>							
						<center style="color:red">${message}</center>				    		
		    	</td>
		    </tr>
		    <tr>
    			<td  colspan=2 height=20></td>
		    </tr>			    
    		</table>    
    		</div>		
		</form>		
	</body>
</html>