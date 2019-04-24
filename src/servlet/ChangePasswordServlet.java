package servlet;


import Dao.Dbutil;
import Dao.AdminDAO;
import Model.User;
import Model.UserAdd;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTML;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;


@WebServlet(urlPatterns = "/changepassword", name = "changepassword")
public class ChangePasswordServlet extends HttpServlet{
    Dbutil dbutil = new Dbutil();
    AdminDAO adminDAO = new AdminDAO();
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	PrintWriter out =resp.getWriter();
    	String oldpassword = new String(req.getParameter("oldpass").getBytes("ISO-8859-1"), "UTF-8");
    	String password = new String(req.getParameter("newpass").getBytes("ISO-8859-1"), "UTF-8");
    	 System.out.print(password);
           // req.getSession().getAttribute("currentUsert");
    	String userID = new String(req.getParameter("userID").getBytes("ISO-8859-1"), "UTF-8");
        System.out.print(password);
        //String userID="123456";
        //System.out.print(school_num);
        User user = new User();
        User user1 = new User();
        Connection con = null;
        user.setPassword(password);
        user.setUserID(userID);
        user1.setPassword(oldpassword);
        user1.setUserID(userID);
       // user.setSchool_num(school_num);

        try {
            con = dbutil.getCon();
            String chekpass=adminDAO.chekUser(con,userID).getPassword();
            if(oldpassword.equals(chekpass))
        		{
       			int isSuccess=adminDAO.changepassword(con, user);
       			
        			if (isSuccess>0)
        			{
        				
        				out.println("<script> alert('modify successfully!');</script>");
        				//req.getRequestDispatcher("index.jsp").forward(req,resp);
        			}
        			else
       			{
        //
        				out.println("<script> alert('change failed!');</script>");
        				out.println("<script> history.go(-1);</script>");
        			}
        		}
        		else
        		{
        			out.println("<script> alert('change failed');</script>");
        		}
        }catch (Exception e) {
			// TODO: handle exception
        	e.printStackTrace();
		}

    }
}