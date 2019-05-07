package servlet;


import Dao.Dbutil;
import Dao.TeacherDAO;
import Model.Report;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTML;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;


@WebServlet(urlPatterns = "/inputscore", name = "inputscore")
public class InputScoreServlet extends HttpServlet{
    Dbutil dbutil = new Dbutil();
 TeacherDAO teacherDAO = new TeacherDAO();
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	PrintWriter out =resp.getWriter();
    	String school_num = new String(req.getParameter("school_num").getBytes("ISO-8859-1"), "UTF-8");
    	String gradeP = new String(req.getParameter("gradeP").getBytes("ISO-8859-1"), "UTF-8");
       
        String gradeK = new String(req.getParameter("gradeK").getBytes("ISO-8859-1"), "UTF-8");
      
        String proportion = new String(req.getParameter("proportion").getBytes("ISO-8859-1"), "UTF-8");
        float P = Float.parseFloat(gradeP);
        float  K =Float.parseFloat(gradeK);
        float  b =Float.parseFloat(proportion);
        float Z=P*b+K*(1-b);
        String gradeZ=Float.toString(Z);
        Report report = new Report();
        Connection con = null;
       report.setGradeP(gradeP);
       report.setGradeK(gradeK);
       report.setGradeZ(gradeZ);
       report.setSchool_num(school_num);

        try {
            con = dbutil.getCon();
            teacherDAO.InputScore(con, report);
            out.write("<Script Language=\"JavaScript\">alert(\"success!\");window.location.href=\"teacher/inputscore.jsp\";</Script>");
            //resp.sendRedirect("admin/notesmanage.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}