package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Dao.MsgDao;
import conn.ConnectionFactory;
import Model.Message;


public class MsgDaoImpl implements MsgDao {

	public int addMsg(Message m) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1-2��ȡ���Ӷ���
			conn = ConnectionFactory.getConn();
			String sql = "insert into msg_tb(UserNo,FromNo,Content,Status) values(?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			//3 Ԥ����sql
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,m.getUserNo());
			pstmt.setString(2, m.getFromNo());
			pstmt.setString(3, m.getContent());
			pstmt.setInt(4, m.getStatus());
			//4.ִ��sql
			pstmt.executeUpdate();
			return 1;
		} catch(Exception e){
			System.out.println(e.toString());
		}
		return 0;
	}

	public int ChangeStatus(int msgid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1-2��ȡ���Ӷ���
			conn = ConnectionFactory.getConn();
			String sql = "update msg_tb set Status= ? where MsgNo= ? ";
			pstmt=conn.prepareStatement(sql);
			//3 Ԥ����sql
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 0);
			pstmt.setInt(2, msgid);
			//4.ִ��sql
			pstmt.executeUpdate();
			return 1;
		} catch(Exception e){
			System.out.println(e.toString());
		}
		return 0;
	}

	public int deleteMsg(String id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rs = 0;
		try {
			conn = ConnectionFactory.getConn();
			String sql = "delete from msg_tb where UserNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeUpdate();
		} finally {
			ConnectionFactory.close(null, pstmt, conn);
		}
		return rs;
	}

	public  List<Message> ReadedMsg(String id) throws Exception {
		List<Message> msglist = new ArrayList<Message>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//1-2��ȡ���Ӷ���
			conn = ConnectionFactory.getConn();
			String sql = "select * from msg_tb where UserNo=? and Status='0'";
			//3 Ԥ����sql
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			//4.ִ��sql
			rs = pstmt.executeQuery();
			//5.��������
			while(rs.next()){
				int msgno=rs.getInt("MsgNo");
				String userno = rs.getString("UserNo");
				String fromno = rs.getString("FromNo");
				String content = rs.getString("Content");
				Message msg=new Message(msgno,userno, fromno,content);
				msglist.add(msg);
			}
		} catch(Exception e){
			System.out.println(e.toString());
		}
		finally {
			ConnectionFactory.close(rs, pstmt, conn);
		}
		return msglist;
	}

	//����Ա�ѷ���Ϣ
	public List<Message> findAllFromAdm() throws Exception {
		List<Message> msglist = new ArrayList<Message>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//1-2��ȡ���Ӷ���
			conn = ConnectionFactory.getConn();
			String sql = "select * from msg_tb where FromNo='root'";
			//3 Ԥ����sql
			pstmt = conn.prepareStatement(sql);
			//4.ִ��sql
			rs = pstmt.executeQuery();
			//5.��������
			while(rs.next()){
				String userno = rs.getString("UserNo");
				String content = rs.getString("Content");
				Message m=new Message(userno, content);
				msglist.add(m);
			}
		} catch(Exception e){
			System.out.println(e.toString());
		}
		finally {
			ConnectionFactory.close(rs, pstmt, conn);
		}
		return msglist;
	}

	public List<Message> NeverRead(String id) throws Exception {
		List<Message> msglist = new ArrayList<Message>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//1-2��ȡ���Ӷ���
			conn = ConnectionFactory.getConn();
			String sql = "select * from msg_tb where Status='1' and UserNo=?";
			//3 Ԥ����sql
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			//4.ִ��sql
			rs = pstmt.executeQuery();
			//5.��������
			while(rs.next()){
				int msgno=rs.getInt("MsgNo");
				String userno =rs.getString("UserNo");
				String fromno = rs.getString("FromNo");
				String content = rs.getString("Content");
				Message m=new Message(msgno,userno,fromno, content);
				msglist.add(m);
			}
		} catch(Exception e){
			System.out.println(e.toString());
		}
		finally {
			ConnectionFactory.close(rs, pstmt, conn);
		}
		return msglist;
	}
}
