package ers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;
import dao.UserDAO;
import dao.UserDaoImpl;

/**
 * Servlet implementation class EmployeeServlet
 */
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//String someName = (String)request.getAttribute("username");
		UserDAO u = null;
		u = new UserDaoImpl(); ;
		List<User> li = new ArrayList<User>();
		
		try
		{
			li = u.getAllUsers();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<html> <body> <p>");
		pw.println("<table>");
		pw.println("<tr>");
			pw.println("<th>IdNo.</th>");
			pw.println("<th>Username</th>");
			pw.println("<th>First Name</th>");
			pw.println("<th>Last Name</th>");
			pw.println("<th>Is Manager?</th>");
			
		pw.println("</tr>");
		
		if(li.isEmpty())
		{
			pw.println("Empty!");
		}
		
		for(User i: li)
		{	
			pw.println("<tr>");
			pw.println("<td>" + i.getEid() +"</td>");
			pw.println("<td>" + i.getUsername() +"</td>");
			pw.println("<td>" + i.getFirstname() +"</td>");
			pw.println("<td>" + i.getLastname() +"</td>");
			pw.println("<td>" + i.getIsManager() +"</td>");
			
			pw.println("</tr>");
		}
		pw.println("</table>");	
		pw.println("</html> </body> </p>");

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
