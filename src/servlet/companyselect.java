package servlet;
import Dao.TeacherDAO;
import Dao.Dbutil;
import Model.UserAdd;
import Model.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

@WebServlet(urlPatterns = "/companysel", name = "companysel")
public class companyselect extends HttpServlet{
    Dbutil dbutil = new Dbutil();
    TeacherDAO teacherDAO = new TeacherDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	PrintWriter out =resp.getWriter();
        String company_name = new String(req.getParameter("company").getBytes("ISO-8859-1"), "UTF-8");
        
        String email = new String(req.getParameter("user_email").getBytes("ISO-8859-1"), "UTF-8");
        

        UserAdd user = new UserAdd();
        Connection con = null;
       user.setCompany(company_name);
       user.setEmail(email);


        try {
            con = dbutil.getCon();
            teacherDAO.userupdate(con, user);
            out.write("<Script Language=\"JavaScript\">alert(\"success!\");window.location.href=\"teacher/Scompany.jsp\";</Script>");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
