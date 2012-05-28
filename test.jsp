<%@page language="java" import="roseindia.tutorial.services.*,java.util.*"%>


hello

<%

roseindia.dao.SpringHibernateDAO hiberSpringDAO = (roseindia.dao.SpringHibernateDAO) ServiceFinder.getContext(request)
				.getBean("SpringHibernateDao");


%>
