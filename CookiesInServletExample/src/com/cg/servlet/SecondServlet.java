package com.cg.servlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/secondServlet")
public class SecondServlet extends HttpServlet {

	 protected void doPost(HttpServletRequest request,
    HttpServletResponse response) throws ServletException, IOException {
        
		 Cookie email = new Cookie("email", request.getParameter("email"));
	     Cookie phone = new Cookie("phone", request.getParameter("phone"));

	     email.setMaxAge(6000);
	     phone.setMaxAge(6000);

	        response.addCookie( email );
	        response.addCookie( phone );
	            
	        PrintWriter writer = response.getWriter();
	        Cookie[] cookies = request.getCookies();


	        String firstName1 = null;
	        String lastName1 = null;
	        String email1 = null;
	        String phone1 = null;
	        for(Cookie cookie : cookies){
	        	
	            if("firstName".equals(cookie.getName())){
	            	firstName1 = cookie.getValue();
	            }else if("lastName".equals(cookie.getName())){
	            	lastName1 = cookie.getValue();}else if("email".equals(cookie.getName())){
		            	email1 = cookie.getValue();}else if("phone".equals(cookie.getName())){
			            	phone1 = cookie.getValue();}
	        }
   
        
    
    
    
    String htmlRespone = "<html>";
    htmlRespone += "<form method=\'post\' action=\'thirdServlet\'>";
    htmlRespone += "First Name: " + email1 + "<br/>";      
    htmlRespone += "Last Name: " + phone1 + "<br/>";
    htmlRespone += "Email: " + email1 + "<br/>";      
    htmlRespone += "Phone: " + phone1 + "<br/>"; 
    htmlRespone += "City: <input type='text' name='city'/><br/>";
    htmlRespone += "Country: <input type='text' name='country'/><br/>";
    htmlRespone += "<input type='submit' value='Submit'/>";
    
    
    htmlRespone += "</form></html>";
     
    writer.println(htmlRespone);
     
}
}
