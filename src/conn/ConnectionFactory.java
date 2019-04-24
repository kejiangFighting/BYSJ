package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionFactory {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://127.0.0.1:3306/sc?useUnicode=true&characterEncoding=UTF-8";
	private static String user = "root";
	private static String password = "123456";
	
	/**
	 * 获取链接
	 * */
	public static Connection getConn() 
			throws Exception {
		Class.forName(driver);
		return DriverManager.getConnection(url, user, password);
	}
	/**
	 * 释放资源
	 * */
	public static void close(ResultSet rs , 
			PreparedStatement pstmt, Connection conn) 
					throws Exception{
		if(rs!=null){
			rs.close();
		}
		if(pstmt!=null){
			pstmt.close();
		}
		if(conn!=null){
			conn.close();
		}
	}
}
