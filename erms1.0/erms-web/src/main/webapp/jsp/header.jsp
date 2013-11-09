<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/effect.css">
<script language="javascript" src="${pageContext.request.contextPath}/js/height.js"></script>
<script type="text/javascript">
		function alter()
		{
			hide();			
		}
		function hide()
		{
			if(document.getElementById("hid").style.display=="block")
			{
				//把select元素设置成显示
				var array=document.getElementsByTagName("select");
				for(var i=0;i<array.length;i++)
				{
					array[i].style.display="block";
				}
				//在把原页面中的flash层隐藏
				if(document.getElementById("flashlayer")!=null)
				{
					document.getElementById("flashlayer").style.display="block";
				}
				document.getElementById("hid").style.display="none";				
			}
			else
			{
				//先要去把select元素设置成隐藏
				var array=document.getElementsByTagName("select");
				for(var i=0;i<array.length;i++)
				{
					array[i].style.display="none";
				}
				//在把原页面中的flash层隐藏
				if(document.getElementById("flashlayer")!=null)
				{
					document.getElementById("flashlayer").style.display="none";
				}
				document.getElementById("hid").style.display="block";
			}
		}
		function subt(paraval)
		{
			document.getElementById("sa").value=paraval;
			document.getElementById("f1").submit();
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
</script>
  		<div id=head_main>
	  		<div id="showmessage" style="width:50px;float:left;margin-left:200px;margin-top:40px;"></div> 	
	  		<c:if test="${not empty user}">
    			<div style="float:right;vertical-align:top;padding:8px 4px">Welcome，${user.name}；
    				Your Identity is：Common User[<a href="${pageContext.request.contextPath}/logout.do" >Logout</a>]<br>
    				<div style="clear:both;height:10px;"></div>
    		   </div>
    		</c:if>	    
    	</div>

