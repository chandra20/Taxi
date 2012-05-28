package roseindia.web.struts.action;

import roseindia.web.struts.form.UserLoginForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import roseindia.services.ServiceFinder;




//import roseindia.services.ServiceFinder;




public class UserLoginAction  extends Action{

	 public ActionForward execute(
			    ActionMapping mapping,
			    ActionForm form,
			    HttpServletRequest request,
			    HttpServletResponse response) throws Exception{
				  
		       
	       
		        //Retrieve the DAO Reference
		  	  roseindia.dao.SpringHibernateDAO springHibernateDAO = (roseindia.dao.SpringHibernateDAO) ServiceFinder.getContext(request)
		  		.getBean("SpringHibernateDao");
		  	  
		  	  
//		  	Create object of ActionMesssages
		        ActionMessages errors = new ActionMessages();
		  	  
		        UserLoginForm objForm = (UserLoginForm) form;
		         
		           String strUserid=objForm.getUserid();
		      	  
		      	   String strPassword=objForm.getPassword();
		      	   boolean loginStatus = springHibernateDAO.checkUserLogin(strUserid,strPassword);
		      	   if(loginStatus==true){
		      		   
		      		   HttpSession  session = request.getSession();
		  			   session.setAttribute("userID", strUserid); 
		  			   
		  			   //int id =springHibernateDAO.getUserId(strUserid);
		  			   
		  			   String id=String.valueOf(springHibernateDAO.getUserId(strUserid));
		  			   	
		  			   //Integer idvalue=new Integer(id);
		  			    
		  			   session.setAttribute("ID", id); 
		  			   
		  			   System.out.println("Session value:"+session.getAttribute("userID"));

		             return mapping.findForward("success");
		         } else {
		             // not allowed
		      	   
		      	   errors.add("login",new ActionMessage("error.login.invalid"));
		             saveErrors(request,errors);
		      	   
		             return mapping.findForward("failure");
		         }
	       }
	}

	
	

	

