package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Dao.ComDao;
import Model.Company;
import conn.ConnectionFactory;




public class ComDaoImpl implements ComDao{

	public int addCom(Company com) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1-2获取链接对象
			conn = ConnectionFactory.getConn();
			String sql = "insert into team(ComNo,Name,Plan,Introduction) values(?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			//3 预处理sql
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,com.getComNo());
			pstmt.setString(2,com.getName());
			pstmt.setString(3, com.getPlan());
			pstmt.setString(4, com.getIntroduction());
			//4.执行sql
			pstmt.executeUpdate();
			return 1;
		} catch(Exception e){
			System.out.println(e.toString());
		}
		return 0;
	}

	public List<Company> findAll() throws Exception {
		List<Company> list = new ArrayList<Company>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ConnectionFactory.getConn();
			String sql = "select * from team";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				String comno = rs.getString("ComNo");
				String  name= rs.getString("Name");
				String intro = rs.getString("Introduction");
				String plan = rs.getString("Plan");
				String teano = rs.getString("TeaNo");
				Company company=new Company(comno, name , intro,plan,teano);
				list.add(company);
			}
		} finally {
			ConnectionFactory.close(rs, pstmt, conn);
		}
		return list;
	}

	public int deleteById(String comno) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rs = 0;
		System.out.println(comno);
		try {
			conn = ConnectionFactory.getConn();
			String sql = "delete from team where ComNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, comno);
			rs=pstmt.executeUpdate();
		} finally {
			ConnectionFactory.close(null, pstmt, conn);
		}
		return rs;
	}

	public Company findById(String comno) throws Exception {
		Company company = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//1-2获取链接对象
			conn = ConnectionFactory.getConn();
			String sql = "select * from team where ComNo=?";
			//3 预处理sql
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,comno);
			//4.执行sql
			rs = pstmt.executeQuery();
			//5.处理结果集
			while(rs.next()){
				String comid = rs.getString("ComNo");
				String name = rs.getString("Name");
				String plan = rs.getString("Plan");
				String intro = rs.getString("Introduction");
				String teano = rs.getString("TeaNo");
				company=new Company(comid, name,intro,plan,teano);
			}
		} catch(Exception e){
			System.out.println(e.toString());
		}
		finally {
			ConnectionFactory.close(rs, pstmt, conn);
		}
		return company;
	}

	public int updateById(Company c) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1-2获取链接对象
			conn = ConnectionFactory.getConn();
			String sql = "update team set Name= ?,Plan= ?,Introduction= ? where ComNo= ?";
			pstmt=conn.prepareStatement(sql);
			//3 预处理sql
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,c.getName());
			pstmt.setString(2, c.getPlan());
			pstmt.setString(3, c.getIntroduction());
			pstmt.setString(4,c.getComNo());
			//4.执行sql
			pstmt.executeUpdate();
			return 1;
		} catch(Exception e){
			System.out.println(e.toString());
		}
		return 0;
	}

	public int Select(String teano, String comno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1-2获取链接对象
			conn = ConnectionFactory.getConn();
			String sql = "update team set TeaNo=? where ComNo= ?";
			pstmt=conn.prepareStatement(sql);
			//3 预处理sql
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,teano);
			pstmt.setString(2,comno);
			//4.执行sql
			pstmt.executeUpdate();
			return 1;
		} catch(Exception e){
			System.out.println(e.toString());
			return 0;
		}
	}

	public int cancelById(String comno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1-2获取链接对象
			conn = ConnectionFactory.getConn();
			String sql = "update team set TeaNo='' where ComNo= ?";
			pstmt=conn.prepareStatement(sql);
			//3 预处理sql
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,comno);
			//4.执行sql
			pstmt.executeUpdate();
			return 1;
		} catch(Exception e){
			System.out.println(e.toString());
			return 0;
		}
	}

	public String hasTea(String comno) throws Exception {
		String teano=null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//1-2获取链接对象
			conn = ConnectionFactory.getConn();
			String sql = "select TeaNo from team where ComNo=?";
			//3 预处理sql
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,comno);
			//4.执行sql
			rs = pstmt.executeQuery();
			//5.处理结果集
			while(rs.next()){
				teano = rs.getString("TeaNo");
			}
			return teano;
		} catch(Exception e){
			System.out.println(e.toString());
		}
		finally {
			ConnectionFactory.close(rs, pstmt, conn);
		}
		return teano;
	}

}
