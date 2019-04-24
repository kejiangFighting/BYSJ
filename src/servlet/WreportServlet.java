package servlet;

import Dao.Dbutil;
import Dao.StudentDAO;
import Model.report;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTML;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;


@WebServlet(urlPatterns = "/wreport", name = "wreport")
public class WreportServlet extends HttpServlet{
    Dbutil dbutil = new Dbutil();
   StudentDAO teacherDAO = new StudentDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String school_num = new String(req.getParameter("school_num").getBytes("ISO-8859-1"), "UTF-8");
        String name = new String(req.getParameter("name").getBytes("ISO-8859-1"), "UTF-8");
        String gradeK = new String(req.getParameter("gradeK").getBytes("ISO-8859-1"), "UTF-8");
        String department = new String(req.getParameter("department").getBytes("ISO-8859-1"), "UTF-8");
        String major = new String(req.getParameter("major").getBytes("ISO-8859-1"), "UTF-8");
        String tel = new String(req.getParameter("tel").getBytes("ISO-8859-1"), "UTF-8");
        String time = new String(req.getParameter("time").getBytes("ISO-8859-1"), "UTF-8");
        String teacher = new String(req.getParameter("teacher").getBytes("ISO-8859-1"), "UTF-8");
        String summary = new String(req.getParameter("summary").getBytes("ISO-8859-1"), "UTF-8");
        report report=new report();
        report.setDepartment(department);
        report.setGradeK(gradeK);
        report.setTel(tel);
        report.setMajor(major);
        report.setTeacher(teacher);
        report.setTime(time);
        report.setName(name);
        report.setSummary(summary);
        report.setSchool_num(school_num);
        PrintWriter out =resp.getWriter();
        Connection con = null;
        
        try {
            con = dbutil.getCon();
            teacherDAO.Reportadd(con, report);
            out.write("<Script Language=\"JavaScript\">alert(\"success!\");window.location.href=\"student/Wreport.jsp\";</Script>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
