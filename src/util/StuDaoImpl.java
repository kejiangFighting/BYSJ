package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Dao.StuDao;
import Model.Student;
import conn.ConnectionFactory;


public class StuDaoImpl implements StuDao{

	public Student findStudent(String stuNo,String psw) throws Exception{
		Student stu = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
	
			conn = ConnectionFactory.getConn();
			String sql = "select * from stu_tb where StuNo=? and Password=?";
		
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,stuNo);
			pstmt.setString(2, psw);
		
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				String StuNo = rs.getString("StuNo");
				String stupsw = rs.getString("Password");
				stu=new Student(StuNo, stupsw);
			}
		} catch(Exception e){
			System.out.println(e.toString());
		}
		finally {
			ConnectionFactory.close(rs, pstmt, conn);
		}
		return stu;
	}

	public int addStudent(Student stu){
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1-2��ȡ���Ӷ���
			conn = ConnectionFactory.getConn();
			String sql = "insert into stu_tb(StuNo,Name,Major,Password) values(?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			//3 Ԥ����sql
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,stu.getStuNo());
			pstmt.setString(2, stu.getName());
			pstmt.setString(3, stu.getMajor());
			pstmt.setString(4, stu.getPassword());
			//4.ִ��sql
			pstmt.executeUpdate();
			return 1;
		} catch(Exception e){
			System.out.println(e.toString());
		}
		return 0;
	}

	public List<Student> findAll() throws Exception {
		List<Student> list = new ArrayList<Student>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ConnectionFactory.getConn();
			String sql = "select * from stu_tb";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				String stuno = rs.getString("StuNo");
				String stuname = rs.getString("Name");
				String  stumajor= rs.getString("Major");
				String stupsw = rs.getString("Password");
				String comno = rs.getString("ComNo");
				Student student=new Student(stuno, stuname,stumajor , stupsw,comno);
				list.add(student);
			}
		} finally {
			ConnectionFactory.close(rs, pstmt, conn);
		}
		return list;
	}

	public int deleteById(String stuno) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rs = 0;
		try {
			conn = ConnectionFactory.getConn();
			String sql = "delete from stu_tb where StuNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stuno);
			rs=pstmt.executeUpdate();
		} finally {
			ConnectionFactory.close(null, pstmt, conn);
		}
		return rs;
	}

//	public Score findscoreById(String stuno) throws Exception {
//		Score grade = null;
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			//1-2��ȡ���Ӷ���
//			conn = ConnectionFactory.getConn();
//			String sql = "select * from score_tb where StuNo=?";
//			//3 Ԥ����sql
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1,stuno);
//			//4.ִ��sql
//			rs = pstmt.executeQuery();
//			//5.��������
//			while(rs.next()){
//				String StuNo = rs.getString("StuNo");
//				Float pscore = Float.parseFloat(rs.getString("p_score"));
//				Float tscore = Float.parseFloat(rs.getString("t_score"));
//				Float score = Float.parseFloat(rs.getString("score"));
//				grade=new Score(StuNo, pscore,tscore,score);
//			}
//		} catch(Exception e){
//			System.out.println(e.toString());
//		}
//		finally {
//			ConnectionFactory.close(rs, pstmt, conn);
//		}
//		return grade;
//	}

	public Student findById(String stuNo) throws Exception {
		Student stu = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//1-2��ȡ���Ӷ���
			conn = ConnectionFactory.getConn();
			String sql = "select * from stu_tb where StuNo=?";
			//3 Ԥ����sql
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,stuNo);
			//4.ִ��sql
			rs = pstmt.executeQuery();
			//5.��������
			while(rs.next()){
				String stuno = rs.getString("StuNo");
				String name = rs.getString("Name");
				String major = rs.getString("Major");
				String stupsw = rs.getString("Password");
				String comno = rs.getString("ComNo");
				stu=new Student(stuno, name,major,stupsw,comno);
			}
		} catch(Exception e){
			System.out.println(e.toString());
		}
		finally {
			ConnectionFactory.close(rs, pstmt, conn);
		}
		return stu;
	}

	public int updateById(Student s) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1-2��ȡ���Ӷ���
			conn = ConnectionFactory.getConn();
			String sql = "update stu_tb set Name= ? ,Major= ?,Password= ?,ComNo= ? where StuNo= ?";
			pstmt=conn.prepareStatement(sql);
			//3 Ԥ����sql
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s.getName());
			pstmt.setString(2, s.getMajor());
			pstmt.setString(3, s.getPassword());
			pstmt.setString(4,s.getComNo());
			pstmt.setString(5, s.getStuNo());
			//4.ִ��sql
			pstmt.executeUpdate();
			return 1;
		} catch(Exception e){
			System.out.println(e.toString());
		}
		return 0;
	}

	public int selectCom(String stuno, String comno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1-2��ȡ���Ӷ���
			conn = ConnectionFactory.getConn();
			String sql = "update stu_tb set ComNo= ? where StuNo= ?";
			pstmt=conn.prepareStatement(sql);
			//3 Ԥ����sql
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, comno);
			pstmt.setString(2, stuno);
			//4.ִ��sql
			pstmt.executeUpdate();
			return 1;
		} catch(Exception e){
			System.out.println(e.toString());
		}
		return 0;
	}

	public Student PswCheck(String stuno) {
		Student stu=new Student();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//1-2��ȡ���Ӷ���
			conn = ConnectionFactory.getConn();
			String sql = "select * from stu_tb where StuNo=?";
			//3 Ԥ����sql
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stuno);
			//4.ִ��sql
			rs = pstmt.executeQuery();
			//5.��������
			while(rs.next()){
				String stuNo = rs.getString("StuNo");
				String psw = rs.getString("Password");
				stu=new Student(stuNo, psw);
			}
		} catch(Exception e){
			System.out.println(e.toString());
		}
		return stu;
	}

	public int changePsw(Student a) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1-2��ȡ���Ӷ���
			conn = ConnectionFactory.getConn();
			String sql = "update stu_tb set Password= ? where StuNo= ?";
			pstmt=conn.prepareStatement(sql);
			//3 Ԥ����sql
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, a.getPassword());
			pstmt.setString(2, a.getStuNo());
			//4.ִ��sql
			pstmt.executeUpdate();
			return 1;
		} catch(Exception e){
			System.out.println(e.toString());
		}
		return 0;
	}

	public List<Student> findByComId(String comno) throws Exception {
		List<Student> list = new ArrayList<Student>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//1-2��ȡ���Ӷ���
			conn = ConnectionFactory.getConn();
			String sql = "select * from stu_tb where ComNo=?";
			//3 Ԥ����sql
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,comno);
			//4.ִ��sql
			rs = pstmt.executeQuery();
			//5.��������
			while(rs.next()){
				String stuno = rs.getString("StuNo");
				String name = rs.getString("Name");
				String major = rs.getString("Major");
				Student stu=new Student(stuno, name,major,comno);
				list.add(stu);
			}
		} catch(Exception e){
			System.out.println(e.toString());
		}
		finally {
			ConnectionFactory.close(rs, pstmt, conn);
		}
		return list;
	}

	public List<Student> findByMajor(String major) throws Exception {

		List<Student> list = new ArrayList<Student>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//1-2��ȡ���Ӷ���
			conn = ConnectionFactory.getConn();
			String sql = "select * from stu_tb where Major=?";
			//3 Ԥ����sql
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,major);
			//4.ִ��sql
			rs = pstmt.executeQuery();
			//5.��������
			while(rs.next()){
				String stuno = rs.getString("StuNo");
				String name = rs.getString("Name");
				Student stu=new Student(stuno, name,major);
				list.add(stu);
			}
		} catch(Exception e){
			System.out.println(e.toString());
		}
		finally {
			ConnectionFactory.close(rs, pstmt, conn);
		}
		return list;
	}
}
