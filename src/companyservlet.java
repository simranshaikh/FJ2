

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class companyservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public companyservlet() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String company=request.getParameter("com");

		PrintWriter pw=response.getWriter();
		ResultSet rs=null;
		//pw.write(company);
		;
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
			Statement st = con.createStatement();
			String com=request.getParameter("com");
			String query=" select * from product where COMPANY='"+com+"' ";
			ResultSet rs1 = st.executeQuery(query);
			//pw.print("data found");
			while(rs1.next()	);
			{
			
				int a = rs1.getInt(1);
				String b= rs1.getString(2);
				int c= rs1.getInt(3);
				String d= rs1.getString(4);
				pw.print(+a+ ":" +b+  ":" +c+ ":" +d);
			}

			//step 4:fire query and get the resultset
			/*String query="select count(*) from product where company like '"+company+"'" ;
			pw.write(query);
			rs=st.executeQuery(query);*/
			rs.next();
			pw.write("  "+rs.getInt(1));
			//pw.print("Displaying data ");
			//step 5:fetch the data
			/*while(rs.next())
			{
				int no=rs.getInt(1);
				String name=rs.getString(2);
				int price=rs.getInt(3);
				String comp=rs.getString(4);
				pw.print( no+" : " +name+" : "+price+" : " +comp );

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
