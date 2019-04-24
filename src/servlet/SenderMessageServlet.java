package servlet;
import Model.Message;

import Dao.Dbutil;
import Dao.AdminDAO;
import Model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.HTML;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;


@WebServlet(urlPatterns = "/senderMessage", name = "senderMessage")
public class SenderMessageServlet extends HttpServlet{
    Dbutil dbutil = new Dbutil();
    AdminDAO adminDAO = new AdminDAO();
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	PrintWriter out =resp.getWriter();
    	HttpSession session  = req.getSession();
    	String conditions="1";
    	String sender=((User)session.getAttribute("currentUser")).getSchool_num(); 
    	String receiver = new String(req.getParameter("receiver").getBytes("ISO-8859-1"), "UTF-8");
    	String time = new String(req.getParameter("time").getBytes("ISO-8859-1"), "UTF-8");
    	String message = new String(req.getParameter("message").getBytes("ISO-8859-1"), "UTF-8");
        System.out.println(sender);
        System.out.println(receiver);
        System.out.println(time);
        System.out.println(message);
        System.out.println(conditions);
        Message messages = new Message();
        Connection con = null;
        messages.setSender(sender);
        messages.setMessage(message);
        messages.setReceiver(receiver);
        messages.setTime(time);
        messages.setConditions(conditions);
       
    

        try {
            con = dbutil.getCon();
            adminDAO.SendMessage(con, messages);
            out.write("<Script Language=\"JavaScript\">alert(\"success!\");window.location.href=\"admin/index.jsp\";</Script>");
          //  resp.sendRedirect("admin/notesmanage.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}