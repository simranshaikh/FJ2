

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


public class searchproductservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public searchproductservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String product=request.getParameter("pname");
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
			
			//step 3:create ststement
			Statement st = con.createStatement();
			
			//step 4:fire query and get the resultset
			String query="select * from product where prodname=' "+product+" '" ;
			
			ResultSet rs=st.executeQuery(query);
			
			pw.print("Displaying data ");
			//step 5:fetch the data
			while(rs.next())
			{
				int no=rs.getInt(1);
				String name=rs.getString(2);
				int price=rs.getInt(3);
				String comp=rs.getString(4);
				pw.print("product no is "+no+" product name is "+name+" product price is "+price+" company is "+comp);
				
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
