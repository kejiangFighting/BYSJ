package Dao;

import Dao.Dbutil;
import Model.Company;
import Model.Message;
import Model.Notes;
import Model.UserAdd;
import Model.Report;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public class TeacherDAO {
	 public String getCompany() throws SQLException {
         Statement stmt = null;
         Dbutil dbutil = new Dbutil();
         Connection con = null;
         ResultSet rs = null;
         String str = "<table class=\"table table-bordered\" id=\"outside\">"+
                 "<tr><th>公司编号</th><th>公司名</th><th>公司地址</th><th>联系电话</th><th>公司简介</th><th>容纳人数</th><th>选择</th></tr>";
         try {
             con = dbutil.getCon();
             stmt = con.createStatement();
             String sql = "select * from company" + ";";
             rs = stmt.executeQuery(sql);
             while (rs.next()) {
                 str = str + "<tr>" + "<td>" + rs.getString("company_id") + "</td>" + "<td>" + rs.getString("company_name") + "</td>" +"<td>" + rs.getString("address") + "</td>" + "<td>" + rs.getString("tel") + "</td>" +"<td>" + rs.getString("introduce") + "</td>" +"<td>" + rs.getString("capacity") + "</td>" +
                         "<td><form action=\"../teacher/companyselect.jsp\" method=\"post\"><input name=\"company_name\" type=\"hidden\" value=\"" + rs.getString("company_name") + "\"/><input type=\"submit\" value=\"选择\"> </form></td>" + "</tr>";
             }
             return str + "</table>";
         } catch (Exception e) {
             e.printStackTrace();
         }
         return str;
     }
	 public String getReporter(String department) throws SQLException {
         Statement stmt = null;
         Dbutil dbutil = new Dbutil();
         Connection con = null;
         ResultSet rs = null;
         String str = "<table class=\"table table-bordered\" id=\"outside\">"+
                 "<tr><th>学号</th><th>姓名</th><th>专业</th><th>查看</th></tr>";
         try {
             con = dbutil.getCon();
             stmt = con.createStatement();
             String sql = "select * from report where department='"+department+"'";
             rs = stmt.executeQuery(sql);
             while (rs.next()) {
                 str = str + "<tr>" + "<td>" + rs.getString("school_num") + "</td>" + "<td>" + rs.getString("name") + "</td>" +"<td>" + rs.getString("major") + "</td>" + 
                         "<td><form action=\"../teacher/SeeReport.jsp\" method=\"post\"><input name=\"school_num\" type=\"hidden\" value=\"" + rs.getString("company_name") + "\"/><input type=\"submit\" value=\"查看\"> </form></td>" + "</tr>";
             }
             return str + "</table>";
         } catch (Exception e) {
             e.printStackTrace();
         }
         return str;
     }
	 public String searchReport(String query) throws SQLException {
         Statement stmt = null;
         Dbutil dbutil = new Dbutil();
         Connection con = null;
         ResultSet rs = null;
         String str = "<table class=\"table table-bordered\" id=\"outside\">"+
                 "<tr><th>学号</th><th>姓名</th><th>专业</th><th>查看</th><th>下载</th></tr>";
         try {
             con = dbutil.getCon();
             stmt = con.createStatement();
             String sql = "select * from report where school_num='"+query+"'or name='"+query+"'";
             rs = stmt.executeQuery(sql);
             while (rs.next()) {
                 str = str + "<tr>" + "<td>" + rs.getString("school_num") + "</td>" + "<td>" + rs.getString("name") + "</td>" +"<td>" + rs.getString("major") + "</td>" + 
                         "<td><form action=\"../teacher/SeeReport.jsp\" method=\"post\"><input name=\"school_num\" type=\"hidden\" value=\"" + rs.getString("school_num") + "\"/><input type=\"submit\" value=\"查看\"> </form></td>" + 
                         "<td><form action=\"../teacher/loadReport.jsp\" method=\"post\"><input name=\"school_num\" type=\"hidden\" value=\"" + rs.getString("school_num") + "\"/><input type=\"submit\" value=\"下载\"> </form></td>" + "</tr>";
             }
             return str + "</table>";
         } catch (Exception e) {
             e.printStackTrace();
         }
         return str;
     }
	 //未读信息
	    public String getMessages(String receiver,String company) throws SQLException {
	      	 Statement stmt = null;
	           Dbutil dbutil = new Dbutil();
	           Connection con = null;
	           ResultSet rs = null;    
	           String str = "<table class=\"table table-bordered\" id=\"outside\">" +
	                   "<tr><th>消息编号</th><th>发送者</th><th>时间</th><th>内容</th><th>回复</th><th>标记</th></tr>";
	           try {
	               con = dbutil.getCon();
	               stmt = con.createStatement();         
	               String sql = "select * from message where conditions='1' and (receiver='"+receiver+"'or receiver='allteach' or receiver='all' or receiver='"+company+"')";//conditions=1表示为未读
	               rs = stmt.executeQuery(sql);
	               while (rs.next()) {
	                   str = str + "<tr>" + "<td>" + rs.getString("id") + "</td>" + "<td>" + rs.getString("sender") + "</td>" + "<td>" + rs.getString("time") + "</td>" + "<td>" + rs.getString("message") + "</td>" +
	                          
	                           "<td><form action=\"../teacher/huifu.jsp\" method=\"post\"><input name=\"sender\" type=\"hidden\" value=\"" + rs.getString("sender") + "\"/><input type=\"submit\" value=\"回复\"> </form></td>" +
	                           "<td><form action=\"../yidu\" method=\"post\"><input name=\"id\" type=\"hidden\" value=\"" + rs.getString("id") + "\"/><input type=\"submit\" value=\"已读\"> </form></td>" + "</tr>";
	               } 
	               return str + "</table>";
	           } catch (Exception e) {
	               e.printStackTrace();
	           }
	           return str;
	       }
	    public String AlreadySendMessages(String receiver) throws SQLException {
	     	 Statement stmt = null;
	          Dbutil dbutil = new Dbutil();
	          Connection con = null;
	          ResultSet rs = null;    
	          String str = "<table class=\"table table-bordered\" id=\"outside\">" +
	                  "<tr><th>消息编号</th><th>接收者</th><th>时间</th><th>内容</th></tr>";
	          try {
	              con = dbutil.getCon();
	              stmt = con.createStatement();
	              String sql = "select * from message where sender='"+receiver+"'";//conditions=1表示为未读
	              rs = stmt.executeQuery(sql);
	              while (rs.next()) {
	                  str = str + "<tr>" + "<td>" + rs.getString("id") + "</td>" + "<td>" + rs.getString("receiver") + "</td>" + "<td>" + rs.getString("time") + "</td>" + "<td>" + rs.getString("message") + "</td>" ;
	 
	              } 
	              return str + "</table>";
	          } catch (Exception e) {
	              e.printStackTrace();
	          }
	          return str;
	      }
	    //已读消息
	    public String getReadMessages(String receiver,String company) throws SQLException {
	     	 Statement stmt = null;
	          Dbutil dbutil = new Dbutil();
	          Connection con = null;
	          ResultSet rs = null;       
	          String str = "<table class=\"table table-bordered\" id=\"outside\">" +
	                  "<tr><th>消息编号</th><th>发送者</th><th>时间</th><th>内容</th><th>回复</th></tr>";
	          try {
	              con = dbutil.getCon();
	              stmt = con.createStatement();            
	              String sql = "select * from message where (receiver='"+receiver+"'or receiver='allteach' or receiver='all' or receiver='"+company+"')and conditions='0'";
	              rs = stmt.executeQuery(sql);
	              while (rs.next()) {
	                  str = str + "<tr>" + "<td>" + rs.getString("id") + "</td>" + "<td>" + rs.getString("sender") + "</td>" + "<td>" + rs.getString("time") + "</td>" + "<td>" + rs.getString("message") + "</td>" +
	                         
	                          "<td><form action=\"../teacher/huifu.jsp\" method=\"post\"><input name=\"sender\" type=\"hidden\" value=\"" + rs.getString("sender") + "\"/><input type=\"submit\" value=\"回复\"> </form></td>";
	              } 
	              return str + "</table>";
	          } catch (Exception e) {
	              e.printStackTrace();
	          }
	          return str;
	      }
	    public String SendMessage(Connection con, Message messages) throws SQLException{
			// TODO Auto-generated method stub
			 PreparedStatement pst = null;

	         try {
	             String sql = "insert into message(sender,receiver,message,time,conditions) values (?,?,?,?,?)";
	             pst = con.prepareStatement(sql);
	             pst.setString(1, messages.getSender());
	             pst.setString(2, messages.getReceiver());
	            pst.setString(3, messages.getMessage());
	          
	            	pst.setString(4, messages.getTime());
	             pst.setString(5,messages.getConditions());
	             
	             pst.executeUpdate();
	         } catch (Exception e) {
	             e.printStackTrace();
	         }
	         return null;
	        
		}
		public void AlreadyRead(Connection con, Message message,String id) throws SQLException{
			// TODO Auto-generated method stub
			Statement stmt = null;
	        Dbutil dbutil = new Dbutil();
	        ResultSet rs = null;
	        try {
				
				stmt = con.createStatement();
				String sql = "update message set conditions='"+message.getConditions()+"'where id='"+id+"'";
				// String sql = "update notes set title=' "+notes.getTitle()+"'，start_time='"+notes.getStart_time()+"',stop_time='"+notes.getStop_time()+"', description='"+notes.getDescription()+"'where notes_id='"+notes.getNotes_id()+"'";
		         stmt.executeUpdate(sql);
		        
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
		}
	 public String searchStudent(String query) throws SQLException {
         Statement stmt = null;
         Dbutil dbutil = new Dbutil();
         Connection con = null;
         ResultSet rs = null;
         String str = "<table class=\"table table-bordered\" id=\"outside\">"+
                 "<tr><th>学号</th><th>姓名</th><th>性别</th><th>学院</th><th>专业</th><th>电话</th><th>邮箱</th><th>地址</th><th>角色</th><th>实习公司</th></tr>";
         try {
             con = dbutil.getCon();
             stmt = con.createStatement();
             String sql = "select * from user where school_num='"+query+"'or name='"+query+"'";
             rs = stmt.executeQuery(sql);
             while (rs.next()) {
                 str = str + "<tr>" + "<td>" + rs.getString("school_num") + "</td>" + "<td>" + rs.getString("name") + "</td>" +"<td>" + rs.getString("sex") + "</td>" + "<td>" + rs.getString("school") + "</td>" +"<td>" + rs.getString("major") + "</td>" + "<td>" + rs.getString("phone") + "</td>" +
                		 "<td>" + rs.getString("email") + "</td>" + "<td>" + rs.getString("adress") + "</td>" +"<td>" + rs.getString("role") + "</td>" + "<td>" + rs.getString("company") + "</td>";
                         
             }
             return str + "</table>";
         } catch (Exception e) {
             e.printStackTrace();
         }
         return str;
     }
	
	 public String getNotes(String titel) throws SQLException {
    	 Statement stmt = null;
         Dbutil dbutil = new Dbutil();
         Connection con = null;
         ResultSet rs = null;
        // String title = "放假";
         String str = "<table class=\"table table-bordered\" id=\"outside\">" +
                 "<tr><th>标题</th><th>开始时间</th><th>结束时间</th><th>公告内容</th><th>发布部门</th><th>发布者</th></tr>";
         try {
             con = dbutil.getCon();
             stmt = con.createStatement();
             //String sql = "select * from notes" + ";";
             String sql = "select * from notes where title='"+titel+"'";
             rs = stmt.executeQuery(sql);
             while (rs.next()) {
                 str = str + "<tr>" + "<td>" + rs.getString("title") + "</td>" + "<td>" + rs.getString("start_time") + "</td>" + "<td>" + rs.getString("stop_time") + "</td>" + "<td>" + rs.getString("description") + "</td>" +"<td>" + rs.getString("bumen") + "</td>" +"<td>"+ rs.getString("Writer") +"</td>"+ "</tr>";
       
             } 
             return str + "</table>";
         } catch (Exception e) {
             e.printStackTrace();
         }
         return str;
     } 

    public String getUser(String email) throws SQLException {
        Statement stmt = null;
        Dbutil dbutil = new Dbutil();
        Connection con = null;
        ResultSet rs = null;
        String str = "<table class=\"table table-bordered\" id=\"outside\">" +
                "<tr><th>工号</th><th>姓名</th><th>性别</th><th>学院</th><th>QQ</th><th>电话</th><th>邮箱</th><th>地址</th><th>角色</th><th>操作</th></tr>";
        try{
            con = dbutil.getCon();
            stmt = con.createStatement();
            String sql = "select * from user WHERE email='" + email + "';";
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                str = str + "<tr>" + "<td>" + rs.getString("school_num") + "</td>" + "<td>" + rs.getString("name") + "</td>" + "<td>" + rs.getString("sex") + "</td>" + "<td>" + rs.getString("school") + "</td>" + "<td>" + rs.getString("qq") + "</td>" + "<td>" + rs.getString("phone") + "</td>" + "<td>" + rs.getString("email") + "</td>" + "<td>" + rs.getString("adress") + "</td>" + "<td>" + rs.getString("role") + "</td>" +
                		 "<td><form action=\"../teacher/changemessage.jsp\" method=\"post\"><input name=\"school_num\" type=\"hidden\" value=\"" + rs.getString("school_num") + "\"/><input type=\"submit\" value=\"修改\"> </form></td>" + "</tr>";
            }
            return str + "</table>";
        }catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }
    public String getNewCompany(String email) throws SQLException {
        Statement stmt = null;
        Dbutil dbutil = new Dbutil();
        Connection con = null;
        ResultSet rs = null;
        String str = null;
        try{
            con = dbutil.getCon();
            stmt = con.createStatement();
            String sql = "select company from user WHERE email='" + email + "';";
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                str =rs.getString("company");
                       
            }
            return str ;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }
	public void userupdate(Connection con, UserAdd user) throws SQLException{
		// TODO Auto-generated method stub
		Statement stmt = null;
        Dbutil dbutil = new Dbutil();
        ResultSet rs = null;
        try {
			
			stmt = con.createStatement();
			String sql = "update user set company='"+user.getCompany()+"'where email='"+user.getEmail()+"'";
	         stmt.executeUpdate(sql);
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}
	public void InputScore(Connection con, Report report)throws SQLException {
		// TODO Auto-generated method stub
		Statement stmt = null;
        Dbutil dbutil = new Dbutil();
        ResultSet rs = null;
        try {
			
			stmt = con.createStatement();
			String sql = "update report set gradeP='"+report.getGradeP()+"',gradeK='"+report.getGradeK()+"',gradeZ='"+report.getGradeZ()+"'where school_num='"+report.getSchool_num()+"'";
		
	         stmt.executeUpdate(sql);
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}
	public void CompanyTeacher(String name,String company) throws SQLException{
		// TODO Auto-generated method stub
		 Statement stmt = null;
         Dbutil dbutil = new Dbutil();
         Connection con = null;
         
        try {
			
        	 con = dbutil.getCon();
             stmt = con.createStatement();
			String sql = "update company set teacher='"+name+"'where company_name='"+company+"'";
		
	         stmt.executeUpdate(sql);
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}
}
