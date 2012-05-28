package roseindia.web.struts.form;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.*;

public class UserRegisterForm extends ActionForm{


	   private String action="add";
	   private String actionUpdateData;
	  
	    private Integer id;
		
		  private String userid;
		  private String password;
		 
		  private String email;
		  private String address;
		  private String phno;

	 
		  

		  public void reset(ActionMapping mapping,HttpServletRequest request){
			  
			  this.id = null;
			  this.userid=null;
			  this.password=null;
			  this.email=null;
			  this.address=null;
			  this.phno=null;
			 
			  this.action="add";
			  this.actionUpdateData="";

		  }


	      public ActionErrors validate( 

	      ActionMapping mapping, HttpServletRequest request ) {
	      ActionErrors errors = new ActionErrors();
	      
	      return errors;
	  }


		public String getAction() {
			return action;
		}


		public void setAction(String action) {
			this.action = action;
		}


		public String getAddress() {
			return address;
		}


		public void setAddress(String address) {
			this.address = address;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public String getPhno() {
			return phno;
		}

	
		
		public void setPhno(String phno) {
			this.phno = phno;
		}


		public String getUserid() {
			return userid;
		}


		public void setUserid(String userid) {
			this.userid = userid;
		}

		public String getActionUpdateData() {
			return actionUpdateData;
		}

		public void setActionUpdateData(String actionUpdateData) {
			this.actionUpdateData = actionUpdateData;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		} 
	
	
	
	
}
