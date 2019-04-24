package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.NoticeDao;
import Model.Notice;
import conn.ConnectionFactory;



public class NoticeDaoImpl implements NoticeDao {

	public int addNotice(Notice nt) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
	
			conn = ConnectionFactory.getConn();
			String sql = "insert into notice_tb(NoticeNo,Title,Name,Department,Time,Content) values(?,?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,nt.getNoticeNo());
			pstmt.setString(2,nt.getTitle());
			pstmt.setString(3, nt.getName());
			pstmt.setString(4, nt.getDepartment());
			pstmt.setString(5, nt.getTime());
			pstmt.setString(6, nt.getContent());
			
			pstmt.executeUpdate();
			return 1;
		} catch(Exception e){
			System.out.println(e.toString());
		}
		return 0;
	}

	
	public List<Notice> findAll() throws Exception {
		List<Notice> list = new ArrayList<Notice>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ConnectionFactory.getConn();
			String sql = "select * from notice_tb";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				String noticeno = rs.getString("NoticeNo");
				String title = rs.getString("Title");
				String content = rs.getString("Content");
				String  name= rs.getString("Name");
				String depar = rs.getString("Department");
				String time = rs.getString("Time");
				Notice notice=new Notice(noticeno, title ,content,time, depar,name);
				list.add(notice);
			}
		} finally {
			ConnectionFactory.close(rs, pstmt, conn);
		}
		return list;
	}
	

	public int deleteById(String noticeno) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rs = 0;
		try {
			System.out.println(noticeno);
			conn = ConnectionFactory.getConn();
			String sql = "delete from notice_tb where NoticeNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, noticeno);
			rs=pstmt.executeUpdate();
		} finally {
			ConnectionFactory.close(null, pstmt, conn);
		}
		return rs;
	}

	public Notice findById(String noticeno) throws Exception {
		Notice notice = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
		
			conn = ConnectionFactory.getConn();
			String sql = "select * from notice_tb where NoticeNo=?";
	
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,noticeno);

			rs = pstmt.executeQuery();

			while(rs.next()){
				String noticeid = rs.getString("NoticeNo");
				String title = rs.getString("Title");
				String content = rs.getString("Content");
				String time = rs.getString("Time");
				String department = rs.getString("Department");
				String name = rs.getString("Name");
				notice=new Notice(noticeid, title,content,time,department,name);
			}
		} catch(Exception e){
			System.out.println(e.toString());
		}
		finally {
			ConnectionFactory.close(rs, pstmt, conn);
		}
		return notice;
	}

	public int updateById(Notice n) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {

			conn = ConnectionFactory.getConn();
			String sql = "update notice_tb set Title= ?,Name= ?,Department= ?,Time= ?,Content= ? where NoticeNo= ?";
			pstmt=conn.prepareStatement(sql);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,n.getTitle());
			pstmt.setString(2, n.getName());
			pstmt.setString(3, n.getDepartment());
			pstmt.setString(4, n.getTime());
			pstmt.setString(5, n.getContent());
			pstmt.setString(6,n.getNoticeNo());

			pstmt.executeUpdate();
			return 1;
		} catch(Exception e){
			System.out.println(e.toString());
		}
		return 0;
	}

	public List<Notice> findNotices(int page, int count) throws SQLException {
		Connection conn = null;
		try {
			conn = ConnectionFactory.getConn();
			if(conn==null){
	            throw new NullPointerException("conn is null");
	        }
			PreparedStatement ps = conn.prepareStatement("SELECT NoticeNo,Title,Content,Name,Department,Time FROM notice_tb LIMIT ?,?");
			if(ps==null){
	            throw new NullPointerException("ps is null");
	        }
			ps.setInt(1, (page-1)*count);
	        ps.setInt(2, count);
	        ResultSet rs = ps.executeQuery();
	        if(rs==null){
	            throw new NullPointerException("rs is null");
	        }   
	        List<Notice> notices = new ArrayList<Notice>();
	        while (rs.next()) {
	        	Notice notice = new Notice();
	        	notice.setNoticeNo(rs.getString(1));
	        	notice.setTitle(rs.getString(2));
	        	notice.setContent(rs.getString(3));
	        	notice.setName(rs.getString(4));
	        	notice.setDepartment(rs.getString(5));
	        	notice.setTime(rs.getString(6));
	        	notices.add(notice);
	        }   
	        return notices;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public int count() throws SQLException {
		Connection conn = null;
		try {
			conn = ConnectionFactory.getConn();
			if(conn==null){
	            throw new NullPointerException("conn is null");
	        }
	        PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM notice_tb");
	        if(ps==null){
	            throw new NullPointerException("ps is null");
	        }
	        ResultSet rs = ps.executeQuery();

	        if(rs==null){
	            throw new NullPointerException("rs is null");
	        }   
	        int count = 0;
	        if (rs.next()) {
	            count = rs.getInt(1);
	        }
	        return count;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
