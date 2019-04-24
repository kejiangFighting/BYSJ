package servlet;

import Dao.AdminDAO;
import Dao.Dbutil;
import Model.Company;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;


@WebServlet(urlPatterns = "/companydelete", name = "companydelete")
public class CompanydeleteServlet extends HttpServlet{
    Dbutil dbutil = new Dbutil();
    AdminDAO adminDAO = new AdminDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String company_id = new String(req.getParameter("company_id").getBytes("ISO-8859-1"), "UTF-8");
        PrintWriter out =resp.getWriter();
        Company company = new Company();
        Connection con = null;

        company.setCompany_id(company_id);


        try {
            con = dbutil.getCon();
            adminDAO.companydelete(con, company);
            out.write("<Script Language=\"JavaScript\">alert(\"success!\");window.location.href=\"admin/company.jsp\";</Script>");
           // resp.sendRedirect("admin/company.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
