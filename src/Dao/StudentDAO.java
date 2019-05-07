package Dao;
import Model.Message;
import Model.User;
import Model.UserAdd;
import Model.Report;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class StudentDAO {
    public String getNotes() throws SQLException{
    	Statement stmt = null;
        Dbutil dbutil = new Dbutil();
        Connection con = null;
        ResultSet rs = null;
        String str = "<table class=\"table table-bordered\" id=\"outside\">" +
                "<tr><th>标题</th><th>开始时间</th><th>结束时间</th><th>公告内容</th><th>发布者</th></tr>";
        try{
            con = dbutil.getCon();
            stmt = con.createStatement();
            String sql = "select * from notes" + ";";
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                str = str + "<tr>" + "<td>" + rs.getString("title") + "</td>" + "<td>" + rs.getString("start_time") + "</td>" + "<td>" + rs.getString("stop_time") + "</td>" + "<td>" + rs.getString("description") + "</td>" + "<td>" + rs.getString("Writer") + "</td>"+"</tr>";
            }
            return str + "</table>";
        }catch (Exception e) {
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
               String sql = "select * from message where conditions='1' and (receiver='"+receiver+"'or receiver='allstu' or receiver='all' or receiver='"+company+"')";//conditions=1表示为未读
               rs = stmt.executeQuery(sql);
               while (rs.next()) {
                   str = str + "<tr>" + "<td>" + rs.getString("id") + "</td>" + "<td>" + rs.getString("sender") + "</td>" + "<td>" + rs.getString("time") + "</td>" + "<td>" + rs.getString("message") + "</td>" +
                          
                           "<td><form action=\"../student/huifu.jsp\" method=\"post\"><input name=\"sender\" type=\"hidden\" value=\"" + rs.getString("sender") + "\"/><input type=\"submit\" value=\"回复\"> </form></td>" +
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
              String sql = "select * from message where (receiver='"+receiver+"'or receiver='allstu' or receiver='all' or receiver='"+company+"')and conditions='0'";
              rs = stmt.executeQuery(sql);
              while (rs.next()) {
                  str = str + "<tr>" + "<td>" + rs.getString("id") + "</td>" + "<td>" + rs.getString("sender") + "</td>" + "<td>" + rs.getString("time") + "</td>" + "<td>" + rs.getString("message") + "</td>" +
                         
                          "<td><form action=\"../student/huifu.jsp\" method=\"post\"><input name=\"sender\" type=\"hidden\" value=\"" + rs.getString("sender") + "\"/><input type=\"submit\" value=\"回复\"> </form></td>";
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
    public String getScore(String school_num) throws SQLException{
        Statement stmt = null;
        Dbutil dbutil = new Dbutil();
        Connection con = null;
        ResultSet rs = null;
        String str = "<table class=\"table table-bordered\" id=\"outside\">" +
                "<tr><th>实习公司</th><th>平时成绩</th><th>考核成绩</th><th>最终成绩</th></tr>";
        try{
            con = dbutil.getCon();
            stmt = con.createStatement();
            String sql = "select department,gradeP, gradeK, gradeZ from report where school_num='" + school_num + "';";
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                str = str + "<tr>" + "<td>" + rs.getString("department") + "</td>" + "<td>" + rs.getString("gradeP") + "</td>" + "<td>" + rs.getString("gradeK") + "</td>" + "<td>" + rs.getString("gradeZ") + "</td>";
            }
            return str + "</table>";
        }catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }
    public String getCompany() throws SQLException {
        Statement stmt = null;
        Dbutil dbutil = new Dbutil();
        Connection con = null;
        ResultSet rs = null;
        String str = "<table class=\"table table-bordered\" id=\"outside\">"+
                "<tr><th>公司编号</th><th>公司名</th><th>公司地址</th><th>联系电话</th><th>公司简介</th><th>容纳人数</th><th>带队教师</th><th>选择</th></tr>";
        try {
            con = dbutil.getCon();
            stmt = con.createStatement();
            String sql = "select * from company" + ";";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                str = str + "<tr>" + "<td>" + rs.getString("company_id") + "</td>" + "<td>" + rs.getString("company_name") + "</td>" +"<td>" + rs.getString("address") + "</td>" + "<td>" + rs.getString("tel") + "</td>" +"<td>" + rs.getString("introduce") + "</td>" +"<td>" + rs.getString("capacity") + "</td>"+"<td>" + rs.getString("teacher") + "</td>" +
                        "<td><form action=\"../student/companyselect.jsp\" method=\"post\"><input name=\"company_name\" type=\"hidden\" value=\"" + rs.getString("company_name") + "\"/><input type=\"submit\" value=\"选择\"> </form></td>" + "</tr>";
            }
            return str + "</table>";
        } catch (Exception e) {
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
    public String getUser(String email) throws SQLException{
        Statement stmt = null;
        Dbutil dbutil = new Dbutil();
        Connection con = null;
        ResultSet rs = null;
        String str = "<table class=\"table table-bordered\" id=\"outside\">" +
                "<tr><th>学号</th><th>姓名</th><th>性别</th><th>年级</th><th>学院</th><th>专业</th><th>班级</th><th>QQ</th><th>电话</th><th>邮箱</th><th>地址</th><th>角色</th></tr>";
        try{
            con = dbutil.getCon();
            stmt = con.createStatement();
            String sql = "select * from user WHERE email='" + email + "';";
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                str = str + "<tr>" + "<td>" + rs.getString("school_num") + "</td>" + "<td>" + rs.getString("name") + "</td>" + "<td>" + rs.getString("sex") + "</td>" +"<td>" + rs.getString("grade") + "</td>" + "<td>" + rs.getString("school") + "</td>" + "<td>" + rs.getString("major") + "</td>" + "<td>" + rs.getString("class") + "</td>" + "<td>" + rs.getString("qq") + "</td>" + "<td>" + rs.getString("phone") + "</td>" + "<td>" + rs.getString("email") + "</td>" + "<td>" + rs.getString("adress") + "</td>" + "<td>" + rs.getString("role") + "</td>" +
                        "<td><button type=\"button\" class=\"btn btn-success\">编辑</button></td>" + "</tr>";
            }
            return str + "</table>";
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
			// String sql = "update notes set title=' "+notes.getTitle()+"'，start_time='"+notes.getStart_time()+"',stop_time='"+notes.getStop_time()+"', description='"+notes.getDescription()+"'where notes_id='"+notes.getNotes_id()+"'";
	         stmt.executeUpdate(sql);
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void Reportadd(Connection con, Report report)throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pst = null;

        try {
            String sql = "insert into report (school_num,name,major,tel,teacher,summary,department,time) values (?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, report.getSchool_num());
            pst.setString(2, report.getName());
            pst.setString(3, report.getMajor());
            pst.setString(4, report.getTel());
            pst.setString(5, report.getTeacher());
            pst.setString(6, report.getSummary());
            pst.setString(7, report.getDepartment());
            pst.setString(8, report.getTime());
            
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
     
	}

}
