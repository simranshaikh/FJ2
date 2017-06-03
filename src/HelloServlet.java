

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public HelloServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("user");
		 ServletConfig config = getServletConfig();
	        String user = config.getInitParameter("username");
	        String pwd = config.getInitParameter("password");
	        
	        ServletContext context = getServletContext();
	        String path = context.getInitParameter("databasePath");
		PrintWriter pw=response.getWriter();
		pw.print("<marquee>welcome " +name+ " to my first web app</marquee>");
	        pw.print("<br/>User: " + user + "<br/> Password: " + pwd);
	        pw.print("<br/>DB Path: " + path );
	       // pw.close();
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
