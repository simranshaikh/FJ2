

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginservlet
 */
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//String name=request.getParameter("user");
		 ServletConfig config = getServletConfig();
	        String user = config.getInitParameter("username");
	        String pwd = config.getInitParameter("password");
	        
	        PrintWriter pw=response.getWriter();
	        
	        
	        if((user.equalsIgnoreCase("techm"))&&(pwd.equalsIgnoreCase("tls")))
	        {
			//pw.print("<h3>welcome " +name+ " to my first web app</h3>");
	        pw.print("You are a VALID User");
		        pw.print("<br/>User: " + user + "<br/> Password: " + pwd);
	        }
		        else
		        {
		        	pw.print("invalid user");
		        }
		
		pw.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
