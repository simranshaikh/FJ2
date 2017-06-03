

import java.io.IOException;
import java.sql.Connection;
//import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class StoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public StoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i=Integer.parseInt(request.getParameter("id"));
		String n=request.getParameter("name");
		int b=Integer.parseInt(request.getParameter("b_id"));
		String d=request.getParameter("j_date");
		String s=request.getParameter("str");
		Connection con;
		try {
			//load the driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("driver loaded successfully");
			//since class not found exception: reason: .jar file not present
			
			//step 2:get the connection		
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
			System.out.println("connected successfully");
			//Scanner sc=new Scanner(System.in);
			
			//step 3:create ststement
			Statement st = con.createStatement();
			
			//step 4:fire query and get the resultset
			String query="insert into participant values("+i+",' "+n+" ',"+b+",' "+d+" ',' "+s+" ')";
			
			ResultSet rs=st.executeQuery(query);
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
