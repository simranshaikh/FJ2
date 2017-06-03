

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ValidateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String u=request.getParameter("user");
		String p=request.getParameter("pwd");
		
		PrintWriter pw=response.getWriter();
		Connection con;
		try {
			//load the driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("driver loaded successfully");
			//since class not found exception: reason: .jar file not present
			
			//step 2:get the connection		
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
			System.out.println("connected successfully");
			
			//step 3:create statement
			Statement st = con.createStatement();
			
			//step 4:fire query and get the resultset
			String query="select * from login where USERNAME='"+u+"'and PASSWORD='"+p+"'";
			
			ResultSet rs=st.executeQuery(query);
			
			//pw.print("Record found");
			//step 5:fetch the data
			int i=0;
			while(rs.next())
			{
				if(rs.getString(1).equals(u)&&rs.getString(2).equals(p))
				{
					i=1;
				}
			}
			
			if(i==1)
			{
				pw.print("login successfull");
				response.sendRedirect("orderPizza.html");
			}
			else
			{
				if(u.isEmpty()||(p.isEmpty()))
				{
					response.sendRedirect("loginPizza.html");
				}
				
			}
		
			rs.close();
			st.close();
			con.close();
		}
		catch (ClassNotFoundException e)
		{	
			e.printStackTrace();
		} 
		catch (SQLException e)
		{		
			e.printStackTrace();
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
