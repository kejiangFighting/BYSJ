package Dao;

import Dao.Dbutil;
import Model.Company;
import Model.Message;
import Model.Notes;
import Model.UserAdd;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public class AdminDAO {
    public String getNotes(String title) throws SQLException {
    	 Statement stmt = null;
         Dbutil dbutil = new Dbutil();
         Connection con = null;
         ResultSet rs = null;  
         String str = "<table class=\"table table-bordered\" id=\"outside\">" +
                 "<tr><th>标题</th><th>开始时间</th><th>结束时间</th><th>公告内容</th><th>删除</th><th>修改</th></tr>";
         try {
             con = dbutil.getCon();
             stmt = con.createStatement();         
             String sql = "select * from notes where title='"+title+"'";
             rs = stmt.executeQuery(sql);
             while (rs.next()) {
                 str = str + "<tr>" + "<td>" + rs.getString("title") + "</td>" + "<td>" + rs.getString("start_time") + "</td>" + "<td>" + rs.getString("stop_time") + "</td>" + "<td>" + rs.getString("description") + "</td>" +
                        
                         "<td><form action=\"../notesdelete\" method=\"post\"><input name=\"notes_id\" type=\"hidden\" value=\"" + rs.getString("notes_id") + "\"/><input type=\"submit\" value=\"删除\"> </form></td>" +
                         "<td><form action=\"../admin/notesupdate.jsp\" method=\"post\"><input name=\"notes_id\" type=\"hidden\" value=\"" + rs.getString("notes_id") + "\"/><input type=\"submit\" value=\"修改\"> </form></td>" + "</tr>";
             } 
             return str + "</table>";
         } catch (Exception e) {
             e.printStackTrace();
         }
         return str;
     }
    public String getMessages(String receiver) throws SQLException {
   	 Statement stmt = null;
        Dbutil dbutil = new Dbutil();
        Connection con = null;
        ResultSet rs = null;    
        String str = "<table class=\"table table-bordered\" id=\"outside\">" +
                "<tr><th>消息编号</th><th>发送者</th><th>时间</th><th>内容</th><th>回复</th><th>标记</th></tr>";
        try {
            con = dbutil.getCon();
            stmt = con.createStatement();         
            String sql = "select * from message where conditions='1' and (receiver='"+receiver+"'or receiver='admin')";//conditions=1表示为未读
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                str = str + "<tr>" + "<td>" + rs.getString("id") + "</td>" + "<td>" + rs.getString("sender") + "</td>" + "<td>" + rs.getString("time") + "</td>" + "<td>" + rs.getString("message") + "</td>" +
                       
                        "<td><form action=\"../admin/huifu.jsp\" method=\"post\"><input name=\"sender\" type=\"hidden\" value=\"" + rs.getString("sender") + "\"/><input type=\"submit\" value=\"回复\"> </form></td>" +
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
    public String getReadMessages(String receiver) throws SQLException {
      	 Statement stmt = null;
           Dbutil dbutil = new Dbutil();
           Connection con = null;
           ResultSet rs = null;        
           String str = "<table class=\"table table-bordered\" id=\"outside\">" +
                   "<tr><th>消息编号</th><th>发送者</th><th>时间</th><th>内容</th><th>回复</th></tr>";
           try {
               con = dbutil.getCon();
               stmt = con.createStatement();            
               String sql = "select * from message where receiver='"+receiver+"'or receiver='admin' and conditions='0'";
               rs = stmt.executeQuery(sql);
               while (rs.next()) {
                   str = str + "<tr>" + "<td>" + rs.getString("id") + "</td>" + "<td>" + rs.getString("sender") + "</td>" + "<td>" + rs.getString("time") + "</td>" + "<td>" + rs.getString("message") + "</td>" +
                          
                           "<td><form action=\"../admin/huifu.jsp\" method=\"post\"><input name=\"sender\" type=\"hidden\" value=\"" + rs.getString("sender") + "\"/><input type=\"submit\" value=\"回复\"> </form></td>";
               } 
               return str + "</table>";
           } catch (Exception e) {
               e.printStackTrace();
           }
           return str;
       }
  
    public String queryCompany(String name) throws SQLException {
        Statement stmt = null;
        Dbutil dbutil = new Dbutil();
        Connection con = null;
        ResultSet rs = null;
        String str = "<table class=\"table table-bordered\" id=\"outside\">" +
                "<tr><th>公司编号</th><th>公司名</th><th>公司地址</th><th>联系电话</th><th>公司简介</th><th>容纳人数</th><th>修改</th><th>删除</th></tr>";
        try {
            con = dbutil.getCon();
            stmt = con.createStatement();
            String sql = "select * from company where company_name='" +name+ "'or company_id='"+name+"'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                str = str + "<tr>" + "<td>" + rs.getString("company_id") + "</td>" + "<td>" + rs.getString("company_name") + "</td>" +"<td>" + rs.getString("address") + "</td>" + "<td>" + rs.getString("tel") + "</td>" +"<td>" + rs.getString("introduce") + "</td>" +"<td>" + rs.getString("capacity") + "</td>" +
               		 "<td><form action=\"../companydelete\" method=\"post\"><input name=\"company_id\" type=\"hidden\" value=\"" + rs.getString("company_id") + "\"/><input type=\"submit\" value=\"删除\"> </form></td>" +
                        "<td><form action=\"../admin/companyupdate.jsp\" method=\"post\"><input name=\"company_id\" type=\"hidden\" value=\"" + rs.getString("company_id") + "\"/><input type=\"submit\" value=\"修改\"> </form></td>" + "</tr>";
            }
            return str + "</table>";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }


     public String getUser(String school_num) throws SQLException {
         Statement stmt = null;
         Dbutil dbutil = new Dbutil();
         Connection con = null;
         ResultSet rs = null;
         String str = "<table class=\"table table-bordered\" id=\"outside\">" +
                 "<tr><th>学号</th><th>姓名</th><th>性别</th><th>学院</th><th>专业</th><th>班级</th><th>QQ</th><th>电话</th><th>邮箱</th><th>地址</th><th>角色</th><th>实习公司</th><th>删除操作</th><th>修改操作</th></tr>";
         try {
             con = dbutil.getCon();
             stmt = con.createStatement();
             String sql = "select * from user where school_num='" +school_num+ "'or name='"+school_num+"'";
             rs = stmt.executeQuery(sql);
             while (rs.next()) {
                 str = str + "<tr>" + "<td>" + rs.getString("school_num") + "</td>" + "<td>" + rs.getString("name") + "</td>" + "<td>" + rs.getString("sex") + "</td>" + "<td>" + rs.getString("grade") + "</td>" + "<td>" + rs.getString("school") + "</td>" + "<td>" + rs.getString("major") + "</td>" + "<td>" + rs.getString("qq") + "</td>" + "<td>" + rs.getString("phone") + "</td>" + "<td>" + rs.getString("email") + "</td>" + "<td>" + rs.getString("adress") + "</td>" + "<td>" + rs.getString("role") + "</td>" + "<td>" + rs.getString("company") + "</td>" +
                		 "<td><form action=\"../userdelete\" method=\"post\"><input name=\"school_num\" type=\"hidden\" value=\"" + rs.getString("school_num") + "\"/><input type=\"submit\" value=\"删除\"> </form></td>" +
                         "<td><form action=\"../admin/userupdate.jsp\" method=\"post\"><input name=\"school_num\" type=\"hidden\" value=\"" + rs.getString("school_num") + "\"/><input type=\"submit\" value=\"修改\"> </form></td>" + "</tr>";
             }
             return str + "</table>";
         } catch (Exception e) {
             e.printStackTrace();
         }
         return str;
     }

     public String getCompany() throws SQLException {
         Statement stmt = null;
         Dbutil dbutil = new Dbutil();
         Connection con = null;
         ResultSet rs = null;
         String str = "<table class=\"table table-bordered\" id=\"outside\">" +
                 "<tr><th>公司编号</th><th>公司名</th><th>公司地址</th><th>联系电话</th><th>公司简介</th><th>容纳人数</th><th>修改</th><th>删除</th></tr>";
         try {
             con = dbutil.getCon();
             stmt = con.createStatement();
             String sql = "select * from company" + ";";
             rs = stmt.executeQuery(sql);
             while (rs.next()) {
                 str = str + "<tr>" + "<td>" + rs.getString("company_id") + "</td>" + "<td>" + rs.getString("company_name") + "</td>" +"<td>" + rs.getString("address") + "</td>" + "<td>" + rs.getString("tel") + "</td>" +"<td>" + rs.getString("introduce") + "</td>" +"<td>" + rs.getString("capacity") + "</td>" +
                		 "<td><form action=\"../companydelete\" method=\"post\"><input name=\"company_id\" type=\"hidden\" value=\"" + rs.getString("company_id") + "\"/><input type=\"submit\" value=\"删除\"> </form></td>" +
                         "<td><form action=\"../admin/companyupdate.jsp\" method=\"post\"><input name=\"company_id\" type=\"hidden\" value=\"" + rs.getString("company_id") + "\"/><input type=\"submit\" value=\"修改\"> </form></td>" + "</tr>";
             }
             return str + "</table>";
         } catch (Exception e) {
             e.printStackTrace();
         }
         return str;
     }

     public Notes notesadd(Connection con, Notes notes) throws SQLException {
         PreparedStatement pst = null;

         try {
             String sql = "insert into notes (title, start_time, stop_time, description,bumen,Writer) values (?,?,?,?,?,?)";
             pst = con.prepareStatement(sql);
             pst.setString(1, notes.getTitle());
             pst.setString(2, notes.getStart_time());
             pst.setString(3, notes.getStop_time());
             pst.setString(4, notes.getDescription());
             pst.setString(5, notes.getBumen());
             pst.setString(6, notes.getWriter());
             
             pst.executeUpdate();
         } catch (Exception e) {
             e.printStackTrace();
         }
         return null;
     }
     public void notesupdate(Connection con, Notes notes) throws SQLException {

         Statement stmt = null;
         Dbutil dbutil = new Dbutil();
         ResultSet rs = null;
         try {
			
			stmt = con.createStatement();
			//String sql = "update user set company='"+user.getCompany()+"', sex='"+user.getSex()+"', school='"+user.getSchool()+"', major='"+user.getMajor()+"', phone='"+user.getPhone()+"', password='"+user.getPassword()+"',name='"+user.getName()+"'where school_num='"+user.getSchool_num()+"'";
			String sql = "update notes set title='"+notes.getTitle()+"',start_time='"+notes.getStart_time()+"',description='"+notes.getDescription()+"'where notes_id='"+notes.getNotes_id()+"'";
			// String sql = "update notes set title=' "+notes.getTitle()+"'，start_time='"+notes.getStart_time()+"',stop_time='"+notes.getStop_time()+"', description='"+notes.getDescription()+"'where notes_id='"+notes.getNotes_id()+"'";
	         stmt.executeUpdate(sql);
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      

   }

     public UserAdd useradd(Connection con, UserAdd userAdd) throws SQLException {
         PreparedStatement pst = null;
         try {
             String sql = "insert into user (school_num, name, sex, grade, school, major, qq, phone, email, password, adress, role) values (?,?,?,?,?,?,?,?,?,?,?,?)";
             pst = con.prepareStatement(sql);
             pst.setString(1, userAdd.getSchool_num());
             pst.setString(2, userAdd.getName());
             pst.setString(3, userAdd.getSex());
             pst.setString(4, userAdd.getGrade());
             pst.setString(5, userAdd.getSchool());
             pst.setString(6, userAdd.getMajor());
             pst.setString(7, userAdd.getQq());
             pst.setString(8, userAdd.getPhone());
             pst.setString(9, userAdd.getEmail());
             pst.setString(10, userAdd.getPassword());
             pst.setString(11, userAdd.getAdress());
             pst.setString(12, userAdd.getRole());
//             System.out.print(name);
             pst.executeUpdate();
         
         } catch (Exception e) {
             e.printStackTrace();
             
         }
         return null;
     }

     public Company companyadd(Connection con, Company company) throws SQLException {
         PreparedStatement pst = null;
         try {
            String sql = "insert into company (company_id,company_name,address,tel,introduce, capacity) values (?,?,?,?,?,?)";
             pst = con.prepareStatement(sql);
             pst.setString(1, company.getCompany_id());
             pst.setString(2, company.getCompany_name());
             pst.setString(3, company.getAddress());
             pst.setString(4, company.getTel());
             pst.setString(5, company.getIntroduce());
             pst.setString(6, company.getCapacity());
            
             pst.executeUpdate();
         } catch (Exception e) {
             e.printStackTrace();
         }
         return null;
     }


    
     public Notes notesdelete(Connection con, Notes notes) throws SQLException {
         PreparedStatement pst = null;
         try {
             String sql = "delete from notes where notes_id = ?";
             pst = con.prepareStatement(sql);
             pst.setString(1, notes.getNotes_id());
             pst.execute();
         } catch (Exception e) {
             e.printStackTrace();
         }
         return null;
     }

	public void userdelete(Connection con, UserAdd user) {
		// TODO Auto-generated method stub
		 PreparedStatement pst = null;
         try {
             String sql = "delete from user where school_num = ?";
             pst = con.prepareStatement(sql);
             pst.setString(1, user.getSchool_num());
             pst.execute();
         } catch (Exception e) {
             e.printStackTrace();
         }
	}
	public void userupdate(Connection con, UserAdd user) {
		// TODO Auto-generated method stub
		 Statement stmt = null;
         Dbutil dbutil = new Dbutil();
         ResultSet rs = null;
         try {
			
			stmt = con.createStatement();
			String sql = "update user set company='"+user.getCompany()+"', sex='"+user.getSex()+"', school='"+user.getSchool()+"', major='"+user.getMajor()+"', phone='"+user.getPhone()+"', password='"+user.getPassword()+"',name='"+user.getName()+"'where school_num='"+user.getSchool_num()+"'";
			// String sql = "update notes set title=' "+notes.getTitle()+"'，start_time='"+notes.getStart_time()+"',stop_time='"+notes.getStop_time()+"', description='"+notes.getDescription()+"'where notes_id='"+notes.getNotes_id()+"'";
	         stmt.executeUpdate(sql);
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void companydelete(Connection con, Company company) throws SQLException {
        PreparedStatement pst = null;
        try {
            String sql = "delete from company where company_id = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, company.getCompany_id());
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
        	}
      
    }
	public void companyupdate(Connection con, Company company)throws SQLException {
		// TODO Auto-generated method stub
		Statement stmt = null;
        Dbutil dbutil = new Dbutil();
        ResultSet rs = null;
        try {
			
			stmt = con.createStatement();
			String sql = "update company set company_name='"+company.getCompany_name()+"', tel='"+company.getTel()+"', address='"+company.getAddress()+"', introduce='"+company.getIntroduce()+"', capacity='"+company.getCapacity()+"'where company_id='"+company.getCompany_id()+"'";
			// String sql = "update notes set title=' "+notes.getTitle()+"'，start_time='"+notes.getStart_time()+"',stop_time='"+notes.getStop_time()+"', description='"+notes.getDescription()+"'where notes_id='"+notes.getNotes_id()+"'";
	         stmt.executeUpdate(sql);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}

		}
	public void changepassword(Connection con, UserAdd user) throws SQLException{
		// TODO Auto-generated method stub
		Statement stmt = null;
        Dbutil dbutil = new Dbutil();
        ResultSet rs = null;
        try {
			
			stmt = con.createStatement();
			String sql = "update user set password='"+user.getPassword()+"'where school_num='"+user.getSchool_num()+"'";
			// String sql = "update notes set title=' "+notes.getTitle()+"'，start_time='"+notes.getStart_time()+"',stop_time='"+notes.getStop_time()+"', description='"+notes.getDescription()+"'where notes_id='"+notes.getNotes_id()+"'";
	         stmt.executeUpdate(sql);
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}

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
	}
