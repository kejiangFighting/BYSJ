package servlet;
import Dao.AdminDAO;
import Dao.Dbutil;
import Model.UserAdd;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;


@WebServlet(urlPatterns = "/userdelete", name = "userdelete")
public class UserdeleteServlet extends HttpServlet{
    Dbutil dbutil = new Dbutil();
    AdminDAO adminDAO = new AdminDAO();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String school_num = new String(req.getParameter("school_num").getBytes("ISO-8859-1"), "UTF-8");
        PrintWriter out =resp.getWriter();
        UserAdd user = new UserAdd();
        Connection con = null;

       user.setSchool_num(school_num);


        try {
            con = dbutil.getCon();
            adminDAO.userdelete(con, user);
            out.write("<Script Language=\"JavaScript\">alert(\"success!\");window.location.href=\"admin/users.jsp\";</Script>");
            //resp.sendRedirect("admin/user.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
