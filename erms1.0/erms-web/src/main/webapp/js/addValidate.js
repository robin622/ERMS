function validate(){
	var nameObj=document.formx.name.value;
	
	if(!isName(nameObj)){
		document.formx.name.focus();
		return false;
	}
	var emailObj=document.formx.email.value;
	if(!isEmail(emailObj)){
		alert("Email format is not valid!");
		document.formx.email.focus();
		return false;
	}
	var passwordObj=document.formx.password;
	var repasswordObj=document.formx.repassword;
	if(passwordObj){
		if(!isPassword(passwordObj,repasswordObj)){
			return false;
		}
		var pwd=document.formx.password.value;
		if(pwd.length<6){
			alert("Password should be larger than 6!");
			document.formx.password.focus();
			return false;
		}
		var repwd=document.formx.repassword.value;
		if(repwd.length<6||pwd!=repwd){
			alert("Password is not the same!");
			document.formx.repassword.focus();
			return false;
		}
	}
	return true;
}

//validate name 
function isName(nameObj){
	if(nameObj.length==0 ){
		alert("Please input user name!");
		return false;
	}
	else if( nameObj.indexOf(" ")>-1){
		alert("username can not contain blank space!");
		return false;
	}
	return true;
}
//validate password
function isPassword(passwordObj,repasswordObj){
	if(passwordObj.value.length==0){
		alert("password can not empty!");
		passwordObj.focus();
		return false;
	}
	else if(passwordObj.value.indexOf(" ")>-1){
		alert("password can not contain blank space");
		passwordObj.focus();
		return false;
	}
	else if(repasswordObj.value.length==0){
		alert("input password again");
		repasswordObj.focus();
		return false;
	}
	else if(passwordObj.value != repasswordObj.value){
		alert("password is not the same");
		passwordObj.focus();
		return false;
	}
	return true;
}
//validate email
function isEmail(emailObj){	
	 if(emailObj.length != 0  ){
        	var i=emailObj.indexOf("@");
        	var j=emailObj.lastIndexOf("@");
        	var k=emailObj.indexOf(".");
        	if(!isEnglish(emailObj)|| i==-1 || k==-1 || i!=j ||i==emailObj.length-1)
				return false;
	}        	
     return true;   
}
 function isEnglish(obj){
    	if(obj.length==0)
    		return false;
    	for(i = 0;i<obj.length;i++){
    		if(obj.charCodeAt(i)>128)
    			return false;
    	}
	return true;
}