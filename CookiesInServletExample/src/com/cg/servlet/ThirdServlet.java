package com.cg.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/thirdServlet")
public class ThirdServlet extends HttpServlet {
 
	protected void doPost(HttpServletRequest request,
		    HttpServletResponse response) throws ServletException, IOException {
		        
		 Cookie city = new Cookie("city", request.getParameter("city"));
	     Cookie country = new Cookie("country", request.getParameter("country"));

	     city.setMaxAge(0);
	     country.setMaxAge(0);

	        response.addCookie( city );
	        response.addCookie( country );
	            
	        PrintWriter writer = response.getWriter();
	        Cookie[] cookies = request.getCookies();


	        String firstName1 = null;
	        String lastName1 = null;
	        String email1 = null;
	        String phone1 = null;
	        String city1 = null;
	        String country1 = null;
	        for(Cookie cookie : cookies){
	        	
	            if("firstName".equals(cookie.getName())){
	            	firstName1 = cookie.getValue();
	            }else if("lastName".equals(cookie.getName())){
	            	lastName1 = cookie.getValue();}else if("email".equals(cookie.getName())){
		            	email1 = cookie.getValue();}else if("phone".equals(cookie.getName())){
			            	phone1 = cookie.getValue();}else if("country".equals(cookie.getName())){
			            	country1 = cookie.getValue();}else if("city".equals(cookie.getName())){
				            	city1 = cookie.getValue();}
	        }

		     
		        
		        
		    
		    String htmlRespone = "<html>";
		    htmlRespone += "<form method=\'post\' action=\'thirdServlet\'>";
		    htmlRespone += "First Name: " + firstName1 + "<br/>";      
		    htmlRespone += "Last Name: " + lastName1 + "<br/>";
		    htmlRespone += "Email: " + email1 + "<br/>";      
		    htmlRespone += "Phone: " + phone1 + "<br/>"; 
		    htmlRespone += "City: " + city1 + "<br/>";      
		    htmlRespone += "Country: " + country1 + "<br/>";
		    
		    
		    htmlRespone += "</form></html>";
		     
		    writer.println(htmlRespone);
		     
		}
		}
