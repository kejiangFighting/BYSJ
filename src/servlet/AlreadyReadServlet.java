package servlet;


import Dao.Dbutil;
import Dao.AdminDAO;
import Model.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTML;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;


@WebServlet(urlPatterns = "/yidu", name = "yidu")
public class AlreadyReadServlet extends HttpServlet{
    Dbutil dbutil = new Dbutil();
    AdminDAO adminDAO = new AdminDAO();
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	PrintWriter out =resp.getWriter();
    	String id = new String(req.getParameter("id").getBytes("ISO-8859-1"), "UTF-8");
    	String conditons="0";
        System.out.print(id);

      Message message = new Message();
        Connection con = null;
      message.setConditions(conditons);
      

        try {
            con = dbutil.getCon();
            adminDAO.AlreadyRead(con, message,id);
            out.write("<Script Language=\"JavaScript\">alert(\"success!\");window.location.href=\"admin/querymessage.jsp\";</Script>");
            //resp.sendRedirect("admin/notesmanage.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}