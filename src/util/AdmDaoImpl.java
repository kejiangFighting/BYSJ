package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Dao.AdmDao;
import Model.Admin;
import conn.ConnectionFactory;



public class AdmDaoImpl implements AdmDao {

	public Admin findAdmin(String ano,String apsw) throws Exception{
		Admin admin = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
		
			conn = ConnectionFactory.getConn();
			String sql = "select * from adm_tb where AdmNo=? and Password=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,ano);
			pstmt.setString(2, apsw);

			rs = pstmt.executeQuery();
	
			while(rs.next()){
				String AdmNo = rs.getString("AdmNo");
				String psw = rs.getString("Password");
				admin=new Admin(AdmNo, psw);
			}
		} catch(Exception e){
			System.out.println(e.toString());
		}
		finally {
			ConnectionFactory.close(rs, pstmt, conn);
		}
		return admin;
	}

	public Admin PswCheck(String adminno) {
		Admin admin = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
		
			conn = ConnectionFactory.getConn();
			String sql = "select * from adm_tb where AdmNo=?";
	
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, adminno);
	
			rs = pstmt.executeQuery();
		
			while(rs.next()){
				String AdmNo = rs.getString("AdmNo");
				String psw = rs.getString("Password");
				admin=new Admin(AdmNo, psw);
			}
		} catch(Exception e){
			System.out.println(e.toString());
		}
		return admin;
	}



	public int changePsw(Admin a) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
	
			conn = ConnectionFactory.getConn();
			String sql = "update adm_tb set Password= ? where AdmNo= ?";
			pstmt=conn.prepareStatement(sql);
		
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, a.getPassword());
			pstmt.setString(2, a.getAdmNo());

			pstmt.executeUpdate();
			return 1;
		} catch(Exception e){
			System.out.println(e.toString());
		}
		return 0;
	}

}
