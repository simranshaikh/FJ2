

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		{
			System.out.println("in loginSessionServlet... do get method......");
			PrintWriter out = response.getWriter();	
			String name = request.getParameter("username");
				String pass = request.getParameter("password");
				if(name!=null && pass!=null)
				{
					if(name.length()!=0 && pass.length()!=0)
					{
						if(name.equals("techm")&&pass.equals("techm"))
						{
							HttpSession session = request.getSession(true);
							
							session.setAttribute("lname", name);
							session.setAttribute("passwd", pass);
							
							out.print("<B> Congratulations! you successfully logged in</b>");
							out.print("<br>click on below button to proceed<br>");
							out.print("<form action=\"CategoryServlet\">");
							out.print("<input type=submit name=submit value=submit/>");
							out.print("</form>");
						}
					}
					else
					{
						out.print("<b> empty name and value is not allowed</b><br>");
						out.print("click on below link to go to login page<br>");
						out.print("<a href=\"Login.html\">click here</a>");
					}
				}
				else
				{
					out.print("<b> null values not allowed</b><br>");
					out.print("click on below link to go to login page<br>");
					out.print("<a href=\"Login.html\">click here</a>");
				}

		}
	}

	
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
