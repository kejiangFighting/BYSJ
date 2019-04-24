package servlet;


import Dao.Dbutil;
import Dao.AdminDAO;
import Model.Notes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTML;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;


@WebServlet(urlPatterns = "/notesupdate", name = "notesupdate")
public class NotesUpdateServlet extends HttpServlet{
    Dbutil dbutil = new Dbutil();
    AdminDAO adminDAO = new AdminDAO();
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	PrintWriter out =resp.getWriter();
    	String title = new String(req.getParameter("title").getBytes("ISO-8859-1"), "UTF-8");
       String notes_id = new String(req.getParameter("notes_id").getBytes("ISO-8859-1"), "UTF-8");
        System.out.print(title);
        System.out.print(notes_id);
        String start_time = new String(req.getParameter("start_time").getBytes("ISO-8859-1"), "UTF-8");
        String stop_time = new String(req.getParameter("stop_time").getBytes("ISO-8859-1"), "UTF-8");
        String description = new String(req.getParameter("description").getBytes("ISO-8859-1"), "UTF-8");


        Notes notes = new Notes();
        Connection con = null;
       notes.setNotes_id(notes_id);
        notes.setTitle(title);
        notes.setStart_time(start_time);
        notes.setStop_time(stop_time);
        notes.setDescription(description);

        try {
            con = dbutil.getCon();
            adminDAO.notesupdate(con, notes);
            out.write("<Script Language=\"JavaScript\">alert(\"success!\");window.location.href=\"admin/notes.jsp\";</Script>");
            //resp.sendRedirect("admin/notesmanage.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}