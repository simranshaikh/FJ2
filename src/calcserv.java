

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class calcserv
 */
public class calcserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public calcserv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  System.out.println("calculate servlet");
	        int val1 = Integer.parseInt(request.getParameter("value1"));
	        int val2 = Integer.parseInt(request.getParameter("value2"));
	        int sum=val1+val2;
	        
	        request.setAttribute("sum_val", new Integer(sum));
	        
	        //ServletContext context = getServletConfig().getServletContext();
	        ServletConfig config = getServletConfig();
	        ServletContext context = config.getServletContext();
	        RequestDispatcher dispatch = context.getRequestDispatcher("/dispserv");
	        dispatch.forward(request, response);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
