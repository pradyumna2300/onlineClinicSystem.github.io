

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		 response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
	        response.setHeader("Pragma", "no-cache");	  //HTTP 1.0    
	        response.setHeader("Expires", "0");  	//	Proxies 	
	        
		PrintWriter out=response.getWriter();
		 response.setContentType("text/html");
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<title>AdminLogout</title>");
	        out.println("</head>");
	        out.print("<body>");
//	        out.print("<p>!!You Successfully Log Out....  </p>");
       		        
	        HttpSession session=request.getSession();
	        session.removeAttribute("email");
	       	session.invalidate();
	   	    response.sendRedirect("Home.jsp");
	       
	        
	        out.println("</body>");
	        out.println("</html>");

		

			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		      
	}

}
