

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.AppointmentBean;
import daofiles.AppointmentDao;

/**
 * Servlet implementation class AppointmentReg
 */
@WebServlet("/AppointmentReg")
public class AppointmentReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppointmentReg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		   out.println("<html>");
		   out.println("<head>");
	       out.println("<title>Book Appointment</title>");
	       out.println("</head>");
	       out.print("<body>");  	
	  	       
			String name =request.getParameter("name");
			String email=request.getParameter("email");
			String contact =request.getParameter("contact");
			int age=Integer.parseInt(request.getParameter("age"));
			String day=request.getParameter("day");
			String specialty =request.getParameter("specialty");
			String description=request.getParameter("description");
			String dayssinceinfected=request.getParameter("dayssinceinfected");
			String time=request.getParameter("time");
			int id=Integer.parseInt(request.getParameter("docid"));
			
			AppointmentBean ab =new AppointmentBean();
			ab.setName(name);
			ab.setEmail(email);
			ab.setContact(contact);
			ab.setAge(age);
			ab.setDay(day);
			ab.setSpecialty(specialty);//java.sql.SQLException: ORA-00904: "SPECIALTY": invalid identifier
			ab.setDescription(description);
			ab.setDayssinceinfected(dayssinceinfected);
			ab.setTime(time);
			ab.setId(id);
			
			 int status=AppointmentDao.save(ab);  
		        if(status>0){  
		            request.getRequestDispatcher("PatientViewAppointment.jsp").forward(request, response);  
		        }else{  
		            out.println("Sorry! unable to save record");  
		        }  
		          
		        out.close();  
		    			
			out.print("</body>");
			out.print("</html>");
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
