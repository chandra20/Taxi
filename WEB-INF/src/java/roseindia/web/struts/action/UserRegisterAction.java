package roseindia.web.struts.action;

import roseindia.services.ServiceFinder;
import roseindia.web.struts.form.UserRegisterForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

public class UserRegisterAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserRegisterForm objForm = (UserRegisterForm) form;

		//Utilities util=new Utilities();
		//			Retrieve the DAO Reference
		roseindia.dao.SpringHibernateDAO springHibernateDAO = (roseindia.dao.SpringHibernateDAO) ServiceFinder
				.getContext(request).getBean("SpringHibernateDao");
		//By Default show the Add/Edit Page
		String forwardToPage = "input";
		String strError = "";

		try {

			

			String strParent = "0";

			boolean ValidUsernameStatus = springHibernateDAO
					.checkValidUserName(objForm.getUserid());
			

			

			//In case of form submit Add/Update the data
			if (objForm.getActionUpdateData().equals("update")) {
				//In case of Add, Add the data into database
				
				if (objForm.getAction().equals("add")) {

					if (ValidUsernameStatus == false) {

						
						roseindia.dao.hibernate.Login pojoObj = new roseindia.dao.hibernate.Login();

						pojoObj.setLoginid(objForm.getUserid());
						pojoObj.setPassword(objForm.getPassword());
						pojoObj.setAddress(objForm.getAddress());
						pojoObj.setPhno(Integer.parseInt(objForm.getPhno()));
						pojoObj.setId(objForm.getId());
						pojoObj.setEmail(objForm.getEmail());
						//Add the data
						springHibernateDAO.addUser(pojoObj);
						
						forwardToPage = "success";

					} else {

						//   Create object of ActionMesssages
						ActionMessages errors = new ActionMessages();

						errors.add("invalidUsername", new ActionMessage(
								"error.invalidUsername.invalid"));
						saveErrors(request, errors);
						
						return mapping.findForward("input");
					}

				}//User updates the data, update the user details
				if (objForm.getAction().equals("update")) {
					//System.out.println("Update the Data");
					roseindia.dao.hibernate.Login pojoObj = springHibernateDAO
							.loadUser(objForm.getId().toString());
					pojoObj.setLoginid(objForm.getUserid());
					pojoObj.setPassword(objForm.getPassword());
					pojoObj.setAddress(objForm.getAddress());
					pojoObj.setPhno(Integer.parseInt(objForm.getPhno()));
					pojoObj.setId(objForm.getId());
					pojoObj.setEmail(objForm.getEmail());
					//Update the data
					springHibernateDAO.updateUser(pojoObj);
					forwardToPage = "updated";
				}
			}
			//In case of Edit retrieve the data from datbase and set the values in the form obj
			if (objForm.getAction().equals("Edit")) {

				
				HttpSession session = request.getSession();
				String id = (String)session.getAttribute("ID");

				
				//Retrieve the data from database
				roseindia.dao.hibernate.Login pojoObj = springHibernateDAO.loadUser(id);
				
				objForm.setId(pojoObj.getId());
				objForm.setUserid(pojoObj.getLoginid());
				objForm.setPassword(pojoObj.getPassword());
				objForm.setAddress(pojoObj.getAddress());
				objForm.setEmail(pojoObj.getEmail());

				objForm.setPhno(String.valueOf(pojoObj.getPhno()));
				//for the edit form
				forwardToPage = "input";
				//Set the action to update
				objForm.setAction("update");
			}

		} catch (Exception e) {
			forwardToPage = "input";
			strError = e.getMessage();

			System.out.println("===> Error:" + strError);
		}
		//Display the registration form to the user
		return mapping.findForward(forwardToPage);

	}
}
