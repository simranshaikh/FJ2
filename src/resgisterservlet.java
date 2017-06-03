

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

/**
 * Servlet implementation class resgisterservlet
 */
public class resgisterservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public resgisterservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user=request.getParameter("username");
		String pwd=request.getParameter("password");
		//int id=Integer.parseInt(request.getParameter("empid"));
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		
		PrintWriter pw=response.getWriter();
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
			//step 4:fire query and get the resultset
			String query="insert into Login values('"+user+"' , '"+pwd+"')";
			 st = con.createStatement();
			 st.executeUpdate(query);
			String query1="select * from Login";
			 rs=st.executeQuery(query1);
			 pw.print("query executed");
		
			//step 5:fetch the data
			while(rs.next())
			{
				
				String n=rs.getString(1);
				String d=rs.getString(2);
				//System.out.println(id+" : "+ n +" : "+d);
				pw.print("<h2>"+ n +" : "+d+"</h2>");
			}
			
		}
		catch (ClassNotFoundException e)
		{	
			e.printStackTrace();
		} 
		catch (SQLException e)
		{		
			e.printStackTrace();
		}
	finally
	{
		try {
			//rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
