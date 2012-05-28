package roseindia.web.struts.action;

import roseindia.web.struts.form.UserForgetPasswordForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionMessage;


import roseindia.services.ServiceFinder;

public class UserForgetPasswordAction extends Action
{
  public ActionForward execute(
    ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response) throws Exception{

	  //Retrieve the DAO Reference
	  roseindia.dao.SpringHibernateDAO springHibernateDAO = (roseindia.dao.SpringHibernateDAO) ServiceFinder.getContext(request)
		.getBean("SpringHibernateDao");

//		Retrieve the DAO Reference
	  roseindia.web.common.SendMail mailBean = (roseindia.web.common.SendMail) ServiceFinder.getContext(request).getBean(roseindia.web.common.ProjectConstants.MAIL_BEAN);

	  
     //	Create object of ActionMesssages
      ActionMessages errors = new ActionMessages();
	  
      UserForgetPasswordForm forgetform = (UserForgetPasswordForm) form;
       
     
      
	  String strUserName=forgetform.getUsername();
      String strEmail=forgetform.getEmail();
     
    
	   String[] strPasswordEmail = springHibernateDAO.retriveUserForgetPassword(strUserName,strEmail);
	  
       if(strPasswordEmail[0] != null && strPasswordEmail[1] != null){
		   System.out.println("Password:"+strPasswordEmail[0]);
		   System.out.println("email:"+strPasswordEmail[1]);
		   
		   //sending mail
		   
		   
		   String [] reciepent={strPasswordEmail[1]};
		   
		   String username=strPasswordEmail[2];
		   
		   String subject="Your username & password "; 
		   
		   String message="Hi,"+username;
		   message+="\n Your username is "+username+".";
		   message+="\n Your password is "+strPasswordEmail[0]+".";
		   message+="\n Please login to the web site with your username and password.";
		   message+="\n \n Thanks";
		   message+="\n \n \n Regards";
		   
		   // getting from emailid from allcooljobs.web.common.CollJobsConstants
		   
		   String from=roseindia.web.common.ProjectConstants.FROM_MAIL;

		   try{
			   mailBean.sendMail(reciepent,subject,message,from);
		   
		   }catch(Exception e){
				  System.out.println("Error in sending mail:"+e);
		   }
			   
		   return mapping.findForward("success");
       }else{
    	   
    	   errors.add("invalid",new ActionMessage("error.usernameEmail.invalid"));
           saveErrors(request,errors);
		   
           return mapping.findForward("failure");
       }
      
	  
  }
}