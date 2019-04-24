package servlet;

import Dao.AdminDAO;
import Dao.Dbutil;
import Model.Notes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;


@WebServlet(urlPatterns = "/notesdelete", name = "notesdelete")
public class NotesdeleteServlet extends HttpServlet{
    Dbutil dbutil = new Dbutil();
    AdminDAO adminDAO = new AdminDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String notes_id = new String(req.getParameter("notes_id").getBytes("ISO-8859-1"), "UTF-8");
        PrintWriter out =resp.getWriter();
        Notes notes = new Notes();
        Connection con = null;

        notes.setNotes_id(notes_id);


        try {
            con = dbutil.getCon();
            adminDAO.notesdelete(con, notes);
            out.write("<Script Language=\"JavaScript\">alert(\"success!\");window.location.href=\"admin/notes.jsp\";</Script>");
           // resp.sendRedirect("admin/notes.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
