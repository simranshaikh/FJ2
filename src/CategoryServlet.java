

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		PrintWriter out = response.getWriter();
		String name = (String)session.getAttribute("lname");
		String pass = (String)session.getAttribute("passwd");
		out.print("<B> Hello </b> <i>"+name+"</i>");
		System.out.println(pass);
		out.print("<br>below is the list of activities you can perform ...");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
