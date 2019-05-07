package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Dao.TeaDao;
import Model.Task;
import Model.Teacher;
import conn.ConnectionFactory;



public class TeaDaoImpl implements TeaDao{

	public Teacher findTeacher(String teaNo,String psw) throws Exception{
		Teacher teacher = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//1-2获取链接对象
			conn = ConnectionFactory.getConn();
			String sql = "select * from tea_tb where TeaNo=? and Password=?";
			//3 预处理sql
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,teaNo);
			pstmt.setString(2, psw);
			//4.执行sql
			rs = pstmt.executeQuery();
			//5.处理结果集
			while(rs.next()){
				String TeaNo = rs.getString("TeaNo");
				String TeaPsw = rs.getString("Password");
				teacher=new Teacher(TeaNo, TeaPsw);
			}
		} catch(Exception e){
			System.out.println(e.toString());
		}
		finally {
			ConnectionFactory.close(rs, pstmt, conn);
		}
		return teacher;
	}

	public int addTeacher(Teacher tea) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1-2获取链接对象
			conn = ConnectionFactory.getConn();
			String sql = "insert into tea_tb(TeaNo,Name,Password) values(?,?,?)";
			pstmt=conn.prepareStatement(sql);
			//3 预处理sql
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,tea.getTeaNo());
			pstmt.setString(2, tea.getName());
			pstmt.setString(3, tea.getPassword());
			//4.执行sql
			pstmt.executeUpdate();
			return 1;
		} catch(Exception e){
			System.out.println(e.toString());
		}
		return 0;
	}

	public List<Teacher> findAll() throws Exception {
		List<Teacher> list = new ArrayList<Teacher>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ConnectionFactory.getConn();
			String sql = "select * from tea_tb";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				String teano = rs.getString("TeaNo");
				String teaname = rs.getString("Name");
				String teapsw = rs.getString("Password");
				String comno = rs.getString("ComNo");
				Teacher teacher=new Teacher(teano, teaname, teapsw,comno);
				list.add(teacher);
			}
		} finally {
			ConnectionFactory.close(rs, pstmt, conn);
		}
		return list;
	}

	public int deleteById(String teano) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rs=0;
		try {
			conn = ConnectionFactory.getConn();
			String sql = "delete from tea_tb where TeaNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, teano);
			rs=pstmt.executeUpdate();
		}  catch(Exception e){
			System.out.println(e.toString());
		}
		return rs;
	}

	public Teacher findById(String teaNo) throws Exception {
		Teacher teacher = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//1-2获取链接对象
			conn = ConnectionFactory.getConn();
			String sql = "select * from tea_tb where TeaNo=?";
			//3 预处理sql
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,teaNo);
			//4.执行sql
			rs = pstmt.executeQuery();
			//5.处理结果集
			while(rs.next()){
				String teano = rs.getString("TeaNo");
				String name = rs.getString("Name");
				String teapsw = rs.getString("Password");
				String comno = rs.getString("ComNo");
				teacher=new Teacher(teano, name,teapsw,comno);
			}
		} catch(Exception e){
			System.out.println(e.toString());
		}
		finally {
			ConnectionFactory.close(rs, pstmt, conn);
		}
		return teacher;
	}

	public int updateById(Teacher t) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1-2获取链接对象
			conn = ConnectionFactory.getConn();
			String sql = "update tea_tb set Name= ? ,Password= ?,ComNo= ? where TeaNo= ?";
			pstmt=conn.prepareStatement(sql);
			//3 预处理sql
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, t.getName());
			pstmt.setString(2, t.getPassword());
			pstmt.setString(3,t.getComNo());
			pstmt.setString(4, t.getTeaNo());
			//4.执行sql
			pstmt.executeUpdate();
			return 1;
		} catch(Exception e){
			System.out.println(e.toString());
		}
		return 0;
	}

	public int selectCom(String teano, String comno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1-2获取链接对象
			conn = ConnectionFactory.getConn();
			String sql = "update tea_tb set ComNo= ? where TeaNo= ?";
			pstmt=conn.prepareStatement(sql);
			//3 预处理sql
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,comno);
			pstmt.setString(2, teano);
			//4.执行sql
			pstmt.executeUpdate();
			return 1;
		} catch(Exception e){
			System.out.println(e.toString());
		}
		return 0;
	}

	public int changePsw(Teacher t) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1-2获取链接对象
			conn = ConnectionFactory.getConn();
			String sql = "update tea_tb set Password= ? where TeaNo= ?";
			pstmt=conn.prepareStatement(sql);
			//3 预处理sql
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, t.getPassword());
			pstmt.setString(2, t.getTeaNo());
			//4.执行sql
			pstmt.executeUpdate();
			return 1;
		} catch(Exception e){
			System.out.println(e.toString());
		}
		return 0;
	}

	public Teacher PswCheck(String teano) {
		Teacher tea = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//1-2获取链接对象
			conn = ConnectionFactory.getConn();
			String sql = "select * from tea_tb where TeaNo=?";
			//3 预处理sql
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, teano);
			//4.执行sql
			rs = pstmt.executeQuery();
			//5.处理结果集
			while(rs.next()){
				String teaNo = rs.getString("TeaNo");
				String psw = rs.getString("Password");
				tea=new Teacher(teaNo, psw);
			}
		} catch(Exception e){
			System.out.println(e.toString());
		}
		return tea;
	}

	public int selectComById(String comno, String teano) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1-2获取链接对象
			conn = ConnectionFactory.getConn();
			String sql = "update tea_tb set ComNo= ? where TeaNo= ?";
			pstmt=conn.prepareStatement(sql);
			//3 预处理sql
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, comno);
			pstmt.setString(2, teano);
			//4.执行sql
			pstmt.executeUpdate();
			return 1;
		} catch(Exception e){
			System.out.println(e.toString());
		}
		return 0;
	}

	public String hasCom(String teano) throws Exception {
		String hasCom=null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//1-2获取链接对象
			conn = ConnectionFactory.getConn();
			String sql = "select ComNo from tea_tb where TeaNo=?";
			//3 预处理sql
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,teano);
			//4.执行sql
			rs = pstmt.executeQuery();
			//5.处理结果集
			while(rs.next()){
				hasCom = rs.getString("ComNo");
			}
			return hasCom;
		} catch(Exception e){
			System.out.println(e.toString());
		}
		finally {
			ConnectionFactory.close(rs, pstmt, conn);
		}
		return hasCom;
	}

	public int addTask(Task t) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		String status="未完成";
		try {
			//1-2获取链接对象
			conn = ConnectionFactory.getConn();
			String sql = "insert into Task_tb(Name,FromNo,ToNo,Neirong,Time,Status) values(?,?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			//3 预处理sql
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,t.getName());
			pstmt.setString(2, t.getFromNo());
			pstmt.setString(3, t.getToNo());
			pstmt.setString(4, t.getNeirong());
			pstmt.setString(5, t.getTime());
			pstmt.setString(6, status);
			//4.执行sql
			pstmt.executeUpdate();
			return 1;
		} catch(Exception e){
			System.out.println(e.toString());
		}
		return 0;
	}

	public int UpdateReport(String pingyu, String neirong) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1-2获取链接对象
			conn = ConnectionFactory.getConn();
			String sql = "update Report_tb set Pingyu= ? where NeiRong= ?";
			pstmt=conn.prepareStatement(sql);
			//3 预处理sql
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pingyu);
			pstmt.setString(2, neirong);
			//4.执行sql
			pstmt.executeUpdate();
			return 1;
		} catch(Exception e){
			System.out.println(e.toString());
		}
		return 0;
	}


}
