

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


public class ProductStoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ProductStoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no=Integer.parseInt(request.getParameter("pno"));
		String name=request.getParameter("pname");
		int price=Integer.parseInt(request.getParameter("pprice"));
		String company=request.getParameter("pcom");
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
			String query="insert into product values("+no+" , ' "+name+" ',"+price+",' " +company+" ')";
			
			ResultSet rs=st.executeQuery(query);
			
			pw.print("Record inserted successfully");
			//step 5:fetch the data
			/*while(rs.next())
			{
				int id=rs.getInt(1);
				String n=rs.getString(2);
				String d=rs.getString(3);
				System.out.println(id+" : "+ n +" : "+d);
			}*/
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
