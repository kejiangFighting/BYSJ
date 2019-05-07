package db;
import java.sql.*;

public class db {
	
	private String dbDriver="com.mysql.jdbc.Driver";

	 private String sConnStr = "jdbc:mysql://localhost:3306/sc?useUnicode=true&amp;amp;amp;amp;amp;characterEncoding=gb2312"; 
	  public Connection connect = null;
	  public ResultSet rs=null;
	  public db() {
	    try {
	    	
	      Class.forName(dbDriver).newInstance(); 
	     
	      connect = DriverManager.getConnection(sConnStr,"root","123456"); 
	     
	    }
	    catch (Exception ex) {
	      System.out.println("12121");
	    }
	  }
	
	  
	  public ResultSet executeQuery(String sql) {
			try{
				connect=DriverManager.getConnection(sConnStr,"root","123456");
				Statement stmt=connect.createStatement();
				rs=stmt.executeQuery(sql);

			}catch(SQLException ex){
				System.err.println(ex.getMessage());
			}
			return rs;
		}
	  public void executeUpdate(String sql)
	    {
	    	
	    	Statement stmt=null;
	    	rs=null;
	    	try
	    	{   connect=DriverManager.getConnection(sConnStr,"root","123456");
	    		stmt=connect.createStatement();
	    		stmt.executeUpdate(sql);
	    		stmt.close();
	    		connect.close();
	    		
	    	
	    	}
	    	catch(SQLException ex)
	    	{
	    		System.err.println(ex.getMessage());
	    		
	    	}
	    
	    	
	    }
}
