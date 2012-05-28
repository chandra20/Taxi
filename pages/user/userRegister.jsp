<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<html:html locale="true">

<head>
<LINK rel="stylesheet" type="text/css" name="anyname" href="<html:rewrite page='/css/style.css'/>">
<title></title>
<html:base/>
<SCRIPT LANGUAGE=javascript>

function checkEmail(email) {
if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email)){
return (true)
}
alert("Invalid E-mail Address! Please re-enter.")
return (false);
}


function validateForm(formObj){

if(formObj.userid.value.length==0){
alert("Please enter User ID!");
formObj.userid.focus();
return false;
}

if(formObj.password.value.length==0){
alert("Please enter password!");
formObj.password.focus();
return false;
}

if(formObj.email.value.length==0){
alert("Please enter Email!");
formObj.email.focus();
return false;
}

if(!checkEmail(formObj.email.value)){
   formObj.email.focus();
   return false;
}

if(formObj.address.value.length==0){
alert("Please enter address!");
formObj.address.focus();
return false;
}

if(formObj.phno.value.length==0){
alert("Please enter Phone No.!");
formObj.phno.focus();
return false;
}

if(isNaN(formObj.phno.value)){
alert("Please enter correct Phone No!");
formObj.phno.focus();
return false;
}


formObj.actionUpdateData.value="update";
return true;
}
//-->
</SCRIPT>
</head>
<body>


<%@ include file="../top.jsp"%>  

 <center>
 <!--
 <table width="60%"> 
	 <tr>
		 <td width="100%">
	 --> 
	 <html:form action="/userregister"  method="post" onsubmit="return validateForm(this);">
	   <html:hidden property="id" />
	   <html:hidden property="action"/>
	   <html:hidden property="actionUpdateData"/>
	   
	   
	   
	   <table width="50%" border="1" class="signup"  align="center">

	<tr> 
	<td colspan="2" align="center">
		   <font size="4" color="#660099">Please Enter the Following Details</font><br>
		  </td>
		  </tr>
			
		
		   <!--
		   <tr>
			  <td align="right" width="50%"><b>Id</b></td> 
			  <td width="50%" align="left">
				 <html:text property="id" size="30" maxlength="120"/>
			  </td>
		 </tr> 
		 -->
		  <tr><td colspan="2" align="center"><font color="red"><html:errors/></font>&nbsp;</td></tr>
		 <tr>
		  <td align="right" width="50%"><b>User Id<font color="#FF0000">*</font></b></td>
		  <td align="left" width="50%">
			 <html:text property="userid" size="30" maxlength="120"/>
		  </td>
	 </tr>
	  <tr>
		  <td align="right"><b>Password<font color="#FF0000">*</font></b></td>
		  <td align="left">
			 <html:password property="password" size="30" maxlength="120"/>
		  </td>
	 </tr>

	<tr>
		  <td align="right"><b>Email</b></td>
		  <td align="left">
			 <html:text property="email" size="30" maxlength="120"/>
		  </td>
	 </tr>

	  <tr>
		  <td align="right"><b>Address</b></td>
		  <td align="left">
			 <html:text property="address" size="30" maxlength="120"/>
		  </td>
	 </tr>
	  <tr>
		  <td align="right"><b>Phone No.<b></td>
		  <td align="left">
			 <html:text property="phno" size="30" maxlength="120"/>
		  </td>
	 </tr>
	 <tr><td colspan="2">&nbsp;</td></tr>
	   <tr>
		  <td align="center" colspan="2">
			  <html:submit>Save</html:submit>
								
		  </td>
	 </tr>
	 </table>
</html:form>
   <!--
		 </td>
	 </tr>
 </table>
</center>
-->
</body>
</html:html>
