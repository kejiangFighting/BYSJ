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


@WebServlet(urlPatterns = "/companyadd", name = "companyadd")
public class CompanyServlet extends HttpServlet{
    Dbutil dbutil = new Dbutil();
    AdminDAO adminDAO = new AdminDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	PrintWriter out =resp.getWriter();
        String company_name = new String(req.getParameter("company_name").getBytes("ISO-8859-1"), "UTF-8");
        String capacity = new String(req.getParameter("capacity").getBytes("ISO-8859-1"), "UTF-8");
        String company_id= new String(req.getParameter("company_id").getBytes("ISO-8859-1"), "UTF-8");
        String introduce = new String(req.getParameter("introduce").getBytes("ISO-8859-1"), "UTF-8");
        String address = new String(req.getParameter("address").getBytes("ISO-8859-1"), "UTF-8");
       String tel = new String(req.getParameter("tel").getBytes("ISO-8859-1"), "UTF-8");
        Company company = new Company();
        Connection con = null;
       company.setCompany_name(company_name);
        company.setCapacity(capacity);
        company.setAddress(address);      
        company.setCompany_id(company_id);
        company.setIntroduce(introduce);
        company.setTel(tel);
        try {
            con = dbutil.getCon();
            adminDAO.companyadd(con, company);
            out.write("<Script Language=\"JavaScript\">alert(\"success!\");window.location.href=\"admin/company.jsp\";</Script>");
            //resp.sendRedirect("admin/company.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
