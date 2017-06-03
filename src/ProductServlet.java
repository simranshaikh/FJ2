

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no=Integer.parseInt(request.getParameter("pno"));
		String name=request.getParameter("pname");
		int quant=Integer.parseInt(request.getParameter("pq"));
		int price=Integer.parseInt(request.getParameter("price"));
		
		
		request.setAttribute("n", no);
		request.setAttribute("na", name);
		request.setAttribute("q", quant);
		request.setAttribute("p", price);
		RequestDispatcher rd=request.getRequestDispatcher("AmountServlet");
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
