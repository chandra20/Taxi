
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
          
<table border="0" width="100%" cellpadding="0" cellspacing="0"> 
<tr>
				<td align="left" colspan="2" width="50%">
<p><font size="6" face="Monotype Corsiva"><a href="#" style="color: #6699CC">My Company</a></font></p>				
				</td>
				
				
				     
  </tr>

          <tr>
				<td align="center" bgcolor="#6699CC" width="25%">

					
					<html:link page=""><font color="white">Home</font></html:link>
					
					</td>


                    <td bgcolor="#6699CC" align="center" width="25%">

						 <%if((String)session.getAttribute("userID") != null){ %> <html:link page="/userregister.do?action=Edit"><font color="white">Update Profile</font></html:link> <%}else{%>
                        <html:link page="/pages/user/userRegister.jsp"><font color="white">Register</font></html:link>
                       <%}%>
					</td>
                 

				    <td width="25%" align="center" bgcolor="#6699CC">

                      <html:link page="/pages/user/forgetpassword.jsp"><font color="white">Forget Password</font></html:link>
                       
					</td>

					<td width="25%" align="center" bgcolor="#6699CC">

                       <%if((String)session.getAttribute("userID") != null){ %> <html:link page="/logout.do"><font color="white">Logout</font></html:link> <%}else{%>
											
						<html:link page="/pages/user/userlogin.jsp"><font color="white">Login</font></html:link>
                        <%}%>
					</td>

									
				   			
           </tr>
			
<tr> <td colspan="4">&nbsp;</td></tr>
</table>
  
	  
