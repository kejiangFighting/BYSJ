package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Dao.AdmDao;
import Model.Admin;
import Model.Book;
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

}
