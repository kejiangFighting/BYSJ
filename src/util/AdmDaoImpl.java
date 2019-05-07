package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Dao.AdmDao;
import Model.Admin;
import Model.Book;
import Model.Equip;
import Model.Meeting;
import Model.Notice;
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

	public int addBook(Book book) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {	
			conn = ConnectionFactory.getConn();
			String sql = "insert into Book_tb(BookID,Name,Time,Introdu,Type,Num) values(?,?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,book.getBookID());
			pstmt.setString(2,book.getName());
			pstmt.setString(3, book.getTime());
			pstmt.setString(4, book.getIntrodu());
			pstmt.setString(5, book.getType());
			pstmt.setInt(6, book.getNum());
			
			pstmt.executeUpdate();
			return 1;
		} catch(Exception e){
			System.out.println(e.toString());
		}
		return 0;
	}
	public Book findBook(String bookID) throws Exception {
		Book book=null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ConnectionFactory.getConn();
			String sql = "select * from Book_tb where BookID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,bookID);
			rs = pstmt.executeQuery();
			while(rs.next()){
				String bookId=rs.getString("BookID");
				String name = rs.getString("Name");
				String introdu = rs.getString("Introdu");
				String type = rs.getString("Type");
				String time = rs.getString("Time");
				int num = rs.getInt("Num");	
				book=new Book(bookId, name, time, introdu, type, num);
			}
		} catch(Exception e){
			System.out.println(e.toString());
		}
		finally {
			ConnectionFactory.close(rs, pstmt, conn);
		}
		return book;
	}
	
	public int updateBook(Book n) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {

			conn = ConnectionFactory.getConn();
			String sql = "update Book_tb set Name= ?,Type= ?,Time= ?,Num= ? ,Introdu=? where BookID= ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,n.getName());
			pstmt.setString(2, n.getType());
			pstmt.setString(3, n.getTime());
			pstmt.setInt(4, n.getNum());
			pstmt.setString(5, n.getIntrodu());
			pstmt.setString(6,n.getBookID());

			pstmt.executeUpdate();
			return 1;
		} catch(Exception e){
			System.out.println(e.toString());
		}
		return 0;
	
	}

	public int deleteBook(String bookID) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rs = 0;
		try {
			System.out.println(bookID);
			conn = ConnectionFactory.getConn();
			String sql = "delete from Book_tb where bookID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,bookID);
			rs=pstmt.executeUpdate();
		} finally {
			ConnectionFactory.close(null, pstmt, conn);
		}
		return rs;
		
	}
	//搜索书本,模糊查询（返回的应该是list）···
	public List<Book> findAll(String search) throws Exception {
		List<Book> list = new ArrayList<Book>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ConnectionFactory.getConn();
			String sql = "select * from Book_tb where Type like ? or Name like ? order by Time desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"%"+search+"%");
			pstmt.setString(2,"%"+search+"%");
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				String bookId = rs.getString("BookID");
				String name= rs.getString("Name");
				String type = rs.getString("Type");
				String  introdu= rs.getString("Introdu");
				int num = rs.getInt("Num");
				String time = rs.getString("Time");
				Book book =new Book(bookId, name, time, introdu, type, num);
				list.add(book);
			}
		} finally {
			ConnectionFactory.close(rs, pstmt, conn);
		}
		return list;
	}

	public int addMeeing(Meeting m) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {	
			conn = ConnectionFactory.getConn();
			String sql = "insert into meeting_tb(UserID,Time,StartTime,EndTime,Title,Equip,Num,Names,Phone,Status) values(?,?,?,?,?,?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,m.getUserID());
			pstmt.setString(2,m.getTime());
			pstmt.setString(3, m.getStartTime());
			pstmt.setString(4, m.getEndTime());
			pstmt.setString(5, m.getTitle());
			pstmt.setString(6, m.getEquip());
			pstmt.setInt(7, m.getNum());
			pstmt.setString(8, m.getNames());
			pstmt.setString(9, m.getPhone());
			pstmt.setString(10, m.getStatus());
			
			
			pstmt.executeUpdate();
			return 1;
		} catch(Exception e){
			System.out.println(e.toString());
		}
		return 0;
	}
	//获取我的预约
	public List<Meeting> getMeeting(String user) throws Exception {
			// TODO Auto-generated method stub
			
			List<Meeting> list = new ArrayList<Meeting>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
	        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
	       String nowdate =df.format(new Date());
			try {
				conn = ConnectionFactory.getConn();
				String sql = "select * from meeting_tb where Time >=? and UserID=? order by Time asc";//desc
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,nowdate);
				pstmt.setString(2,user);
				
				rs = pstmt.executeQuery();
				while(rs.next()){
					String userID = rs.getString("UserID");
					String time= rs.getString("Time");
					String startTime = rs.getString("StartTime");
					String  endTime= rs.getString("EndTime");
					String status=rs.getString("Status");
					String title=rs.getString("Title");
					String names=rs.getString("Names");
					String equip=rs.getString("Equip");
					String phone=rs.getString("Phone");
					int num = rs.getInt("Num");
					int id =rs.getInt("ID");
					Meeting meeting=new Meeting(id,status, userID, time, startTime, endTime, title, names, equip, num, phone);
					
					
					list.add(meeting);
				}
			} finally {
				ConnectionFactory.close(rs, pstmt, conn);
			}
			return list;
		}
	//获取当前会议预约情况
	public List<Meeting> getMeeting() throws Exception {
		// TODO Auto-generated method stub
		
		List<Meeting> list = new ArrayList<Meeting>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
       String nowdate =df.format(new Date());
		try {
			conn = ConnectionFactory.getConn();
			String sql = "select * from meeting_tb where Time >=?  order by Time asc";//desc
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,nowdate);
			//pstmt.setString(2,"'"+m.getStartTime()+"'");
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				String userID = rs.getString("UserID");
				String time= rs.getString("Time");
				String startTime = rs.getString("StartTime");
				String  endTime= rs.getString("EndTime");
				String status=rs.getString("Status");
				String title=rs.getString("Title");
				String names=rs.getString("Names");
				String equip=rs.getString("Equip");
				String phone=rs.getString("Phone");
				int num = rs.getInt("Num");
				int id=rs.getInt("ID");
				Meeting meeting=new Meeting(id,status, userID, time, startTime, endTime, title, names, equip, num, phone);
				
				
				list.add(meeting);
			}
		} finally {
			ConnectionFactory.close(rs, pstmt, conn);
		}
		return list;
	}
	//获取我的预约记录（已过时）
	public List<Meeting> getOldMeeting(String user) throws Exception {
		// TODO Auto-generated method stub
		
		List<Meeting> list = new ArrayList<Meeting>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
       String nowdate =df.format(new Date());
		try {
			conn = ConnectionFactory.getConn();
			String sql = "select * from meeting_tb where Time <? and UserID=? order by Time desc";//desc
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,nowdate);
			pstmt.setString(2,user);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				String userID = rs.getString("UserID");
				String time= rs.getString("Time");
				String startTime = rs.getString("StartTime");
				String  endTime= rs.getString("EndTime");
				String status=rs.getString("Status");
				String title=rs.getString("Title");
				String names=rs.getString("Names");
				String equip=rs.getString("Equip");
				String phone=rs.getString("Phone");
				int num = rs.getInt("Num");
				int id=rs.getInt("ID");
				Meeting meeting=new Meeting(id,status, userID, time, startTime, endTime, title, names, equip, num, phone);
				
				
				list.add(meeting);
			}
		} finally {
			ConnectionFactory.close(rs, pstmt, conn);
		}
		return list;
	}
	//获取已过时的所有预约记录
	public List<Meeting> getOldMeeting() throws Exception {
		// TODO Auto-generated method stub
		
		List<Meeting> list = new ArrayList<Meeting>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
       String nowdate =df.format(new Date());
		try {
			conn = ConnectionFactory.getConn();
			String sql = "select * from meeting_tb where Time <? order by Time desc";//desc
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,nowdate);
			//pstmt.setString(2,user);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				String userID = rs.getString("UserID");
				String time= rs.getString("Time");
				String startTime = rs.getString("StartTime");
				String  endTime= rs.getString("EndTime");
				String status=rs.getString("Status");
				String title=rs.getString("Title");
				String names=rs.getString("Names");
				String equip=rs.getString("Equip");
				String phone=rs.getString("Phone");
				int num = rs.getInt("Num");
				int id=rs.getInt("ID");
				Meeting meeting=new Meeting(id,status, userID, time, startTime, endTime, title, names, equip, num, phone);
				
				
				list.add(meeting);
			}
		} finally {
			ConnectionFactory.close(rs, pstmt, conn);
		}
		return list;
	}
	//获取当前日期预约
	public List<Meeting> checkMeeting(Meeting m) throws Exception {
		// TODO Auto-generated method stub
		
		List<Meeting> list = new ArrayList<Meeting>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ConnectionFactory.getConn();
			String sql = "select * from meeting_tb where Time =?  order by Time desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,m.getTime());
			//pstmt.setString(2,"'"+m.getStartTime()+"'");
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				String userID = rs.getString("UserID");
				String time= rs.getString("Time");
				String startTime = rs.getString("StartTime");
				String  endTime= rs.getString("EndTime");
				String status=rs.getString("Status");
				String title=rs.getString("Title");
				String names=rs.getString("Names");
				String equip=rs.getString("Equip");
				String phone=rs.getString("Phone");
				int num = rs.getInt("Num");
				Meeting meeting=new Meeting(status, userID, time, startTime, endTime, title, names, equip, num, phone);
				
				
				list.add(meeting);
			}
		} finally {
			ConnectionFactory.close(rs, pstmt, conn);
		}
		return list;
	}
	//查看会议详情
	public Meeting findMeeting(String userID) throws Exception {
		Meeting meeting=null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ConnectionFactory.getConn();
			String sql = "select * from Meeting_tb where UserID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,userID);
			rs = pstmt.executeQuery();
			while(rs.next()){
				//String userID = rs.getString("UserID");
				String time= rs.getString("Time");
				String startTime = rs.getString("StartTime");
				String  endTime= rs.getString("EndTime");
				String status=rs.getString("Status");
				String title=rs.getString("Title");
				String names=rs.getString("Names");
				String equip=rs.getString("Equip");
				String phone=rs.getString("Phone");
				int num = rs.getInt("Num");
				meeting=new Meeting(status, userID, time, startTime, endTime, title, names, equip, num, phone);
			}
		} catch(Exception e){
			System.out.println(e.toString());
		}
		finally {
			ConnectionFactory.close(rs, pstmt, conn);
		}
		return meeting;
	}
	//时间冲突处理
	public int chekMeet(List<Meeting> meetList, String startTime, String endTime) {
		
		// TODO Auto-generated method stub
		if (meetList.size()>0) {
			 for (int i = 0;i<meetList.size(); i++) {
		   		  if(startTime.compareTo(meetList.get(i).getEndTime())<0&&endTime.compareTo(meetList.get(i).getStartTime())>0){
		   			  System.out.println("时间冲突");
		   			  return 0;
		   		  }  
			}
			 return 1;
		} else {
			return 1;
		}
		
	}
	//取消预约
	public int deleteMeeting(String ID) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rs = 0;
		try {
			//System.out.println();
			conn = ConnectionFactory.getConn();
			String sql = "delete from meeting_tb where ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,ID);
			rs=pstmt.executeUpdate();
		} finally {
			ConnectionFactory.close(null, pstmt, conn);
		}
		return rs;
	
	}
	//取消审批
	public int UpdateMeet(String iD, String status) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {

			conn = ConnectionFactory.getConn();
			String sql = "update meeting_tb set Status= ? where ID= ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,status);
			pstmt.setString(2, iD);
		

			pstmt.executeUpdate();
			return 1;
		} catch(Exception e){
			System.out.println(e.toString());
		}
		return 0;
	}

	
	
}
