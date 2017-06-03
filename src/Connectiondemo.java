import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.Scanner;


public class Connectiondemo 
{
	public static void main(String[] args)
	{
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
			String query="select * from emp";
			/*System.out.println("enter record");
			int n1=sc.nextInt();
			String n2=sc.next();
			String n3=sc.next();
			String query1="insert into emp values("+n1+",'"+n2+"','"+n3+"')";
			st.executeUpdate(query1);*/
			ResultSet rs=st.executeQuery(query);
			//step 5:fetch the data
			while(rs.next())
			{
				int id=rs.getInt(1);
				String n=rs.getString(2);
				String d=rs.getString(3);
				System.out.println(id+" : "+ n +" : "+d);
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
}
