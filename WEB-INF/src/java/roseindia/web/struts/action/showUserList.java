package roseindia.web.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import roseindia.services.ServiceFinder;


public class showUserList {

	

	
	

	public class IndexAction extends Action
	{
	  public ActionForward execute(
	    ActionMapping mapping,
	    ActionForm form,
	    HttpServletRequest request,
	    HttpServletResponse response) throws Exception{

		  //Retrieve the DAO Reference
	  	  roseindia.dao.SpringHibernateDAO allcooljobsDAO = (roseindia.dao.SpringHibernateDAO) ServiceFinder.getContext(request)
	  		.getBean("SpringHibernateDao");
	  	  
		  try{
			  
			  
			  //latest jobs
			  
			  Collection col = allcooljobsDAO.getUsersList();
			  
			  request.setAttribute("userlist",col);
			  
			  System.out.println("col size:"+col.size());
			  
			  
			  
		  	  }catch(Exception e){
		  		String strError=e.getMessage();
				System.out.println("Error is: " + strError);
		  	  }
		  	  
		  	
		  	return mapping.findForward("success");
		   }
		  
		
	  }

	
	
	
}
