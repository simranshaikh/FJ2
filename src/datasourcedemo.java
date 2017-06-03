

import java.io.IOException;
import java.sql.Connection;



import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


public class datasourcedemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public datasourcedemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//step1:create obj of initialcontext
			InitialContext iContext=new InitialContext();
			//step2:lookup for JNDI, gives ds
			DataSource ds=(DataSource)iContext.lookup("MyDS");
			
			//DataSource ds=(DataSource)iContext.lookup("MyDS");
			//step3:get conn from pool
			Connection con=ds.getConnection();
			//step4:use conn in same traditional way
			System.out.println("got the conn from pool : "+con);
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
