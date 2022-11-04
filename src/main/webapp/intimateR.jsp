<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Doctor LEAVES Details</title>
<style type="text/css">
	 .container	{
       		border-radius:	20px;
       		background-color: #f2f2f2;
       		box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.29);
       		padding: 2px;
       		      		
       		}
      	
	  .container th	{
	     	width: 140px;
	     	background-color:#2874A6;
	     	height: 25px;
	     	color: white;
	     	font-size: 20px;
  		   }	
  		.container td	{
  		   		text-align: center;
  		   		font-size:20px ;
  		   }
  		.container tr:nth-child(even)	{
  			background-color: white;
  			}
       .roundbox 	{
       	display: inline-block;
       	height: 40px;
       	background-color: #9C9E9E;
       	width: 180px;
       	text-align: center;
       	line-height: 40px;
       	border-radius:30px;
       	cursor: pointer;
       	text-decoration: none;
       color:yellow;
       }
       .welcome	{
       		display: inline-block;
       		float: right;
       		width: 365px;
  			line-height: 40px;
       		border-radius:30px;
      	 	cursor: pointer;
       }
       	 			
</style>
</head>
<body bgcolor="#ADD8E6">
	<%@page import="beans.intimateBean,daofiles.IntimateDao,java.util.*"%>
	<%@page import="dba.ConnectionProvider,java.sql.*"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<br>
	<div class="container">
	<ul>
		<a href="AdminHome.jsp"><li class="roundbox">Doctor's Details</li></a>
		<a href="AddDoctor.jsp"><li class="roundbox">Add Doctor</li></a>
		<a href="AdPatientDetails.jsp"><li class="roundbox">Patient Details</li></a>
		<a href="AdUpdate.jsp"><li class="roundbox">update</li></a>
		<a href="Logout"><li class="roundbox">Logout</li></a>
		<li class="welcome"><marquee>
		<% 

        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
        response.setHeader("Pragma", "no-cache");	  //HTTP 1.0    
        response.setHeader("Expires", "0");  	//	Proxies 	
				
			       if(session.getAttribute("email")==null){
					response.sendRedirect("ReporterHome.jsp");
					}
			       else if(session!=null)	{
					String email=(String) session.getAttribute("email");
					out.println("Hello ,  "+email);
					}
				
		
				%> </marquee></li>
	</ul>
		<center>
		<h1>Doctor leaves Detail's</h1>
		
		<%  
			List<intimateBean> list=IntimateDao.getleaveDoctors();  
			request.setAttribute("list",list);  
		%>  
		<table border="1px solid black">
			<tr>
				<th>Email</th>
				<th>Date</th>
				
				
							</tr>
			<c:forEach items="${list}" var="d">  
			<tr>
			<td>${d.getEmail()}</td>
			<td>${d.getDate()}</td> 
			
			
 			</tr>  
			</c:forEach>  	
		</table>
		
</body>
</html>