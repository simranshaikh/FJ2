

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PlaceOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PlaceOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getParameter("nop").equals(0)
		
		PrintWriter pw=response.getWriter();
		
		int n1=Integer.parseInt(request.getParameter("nop"));
		if(request.getParameter("nop").isEmpty()||n1==0)
		{
			pw.print("please enter correct values");
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("DisplayOrder");
			rd.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
