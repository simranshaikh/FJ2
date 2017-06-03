

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AmountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AmountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		int number=(Integer) request.getAttribute("n");
		String name=(String) request.getAttribute("na");
		int quantity=(Integer) request.getAttribute("q");
		int price=(Integer) request.getAttribute("p");
		
		
		int total=quantity*price;
		pw.print("<table border=1>");
		pw.print("<tr><td>Product No	</td>    <td>Name</td>     <td>Quantity</td>   	<td>Price</td>	<td>Total Amount</td></tr>");
		pw.print("<tr><td>"+number+"</td>    <td>"+name+"</td>     <td>"+quantity+"</td>   	<td>"+price+"</td>	<td>"+total+"</td></tr>");
		pw.print("</table>");

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
