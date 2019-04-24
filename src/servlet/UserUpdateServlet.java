package servlet;


import Dao.Dbutil;
import Dao.AdminDAO;
import Model.User;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTML;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;


@WebServlet(urlPatterns = "/userupdate", name = "userupdate")
public class UserUpdateServlet extends HttpServlet{
    Dbutil dbutil = new Dbutil();
    AdminDAO adminDAO = new AdminDAO();
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	PrintWriter out =resp.getWriter();
    	//String name = new String(req.getParameter("name").getBytes("ISO-8859-1"), "UTF-8");
    	
    	String major = new String(req.getParameter("major").getBytes("ISO-8859-1"), "UTF-8");
        String college = new String(req.getParameter("college").getBytes("ISO-8859-1"), "UTF-8");
        String team = new String(req.getParameter("team").getBytes("ISO-8859-1"), "UTF-8");
        String email = new String(req.getParameter("email").getBytes("ISO-8859-1"), "UTF-8");
        
        String phone= new String(req.getParameter("phone").getBytes("ISO-8859-1"), "UTF-8");
        String userID= new String(req.getParameter("userID").getBytes("ISO-8859-1"), "UTF-8");
       
        User user = new User();
        Connection con = null;
      //user.setName(name);
      user.setMajor(major);
      user.setCollege(college);
      user.setTeam(team);
      user.setPhone(phone);
      user.setUserID(userID);
      user.setEmail(email);
//      System.out.println("更新ID"+userID);
//      System.out.println("更新user"+college);
//      System.out.println("更新user"+email);
//      System.out.println("更新ID"+team);
//      System.out.println("更新user"+phone);
//      System.out.println("更新user"+major);
        try {
            con = dbutil.getCon();
            int isSuccess=adminDAO.userupdate(con, user);
            if (isSuccess>0)
			{
				
				out.println("<script> alert('update successfully!');</script>");
			}
			else
			{
//
				out.println("<script> alert('change failed!');</script>");
				out.println("<script> history.go(-1);</script>");
			}
		
    	}catch (Exception e) {
	// TODO: handle exception
    	e.printStackTrace();

    	}
    }
    }
    
