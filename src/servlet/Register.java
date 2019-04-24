package servlet;

import Dao.AdminDAO;
import Dao.Dbutil;
import Model.User;
import Model.UserAdd;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

/**
 * Created by ttop5 on 16-4-22.
 */
@WebServlet(urlPatterns = "/register", name = "register")
public class Register extends HttpServlet {
    Dbutil dbutil = new Dbutil();
    AdminDAO adminDAO = new AdminDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userID = new String(req.getParameter("userID").getBytes("ISO-8859-1"), "UTF-8");
        String name = new String(req.getParameter("name").getBytes("ISO-8859-1"), "UTF-8");
        String major = new String(req.getParameter("major").getBytes("ISO-8859-1"), "UTF-8");
        //String grade = new String(req.getParameter("grade").getBytes("ISO-8859-1"), "UTF-8");
      //  String school = new String(req.getParameter("school").getBytes("ISO-8859-1"), "UTF-8");
        String college = new String(req.getParameter("college").getBytes("ISO-8859-1"), "UTF-8");
        String team = new String(req.getParameter("team").getBytes("ISO-8859-1"), "UTF-8");
        String phone = new String(req.getParameter("phone").getBytes("ISO-8859-1"), "UTF-8");
        String email = new String(req.getParameter("email").getBytes("ISO-8859-1"), "UTF-8");
        String password = new String(req.getParameter("psw").getBytes("ISO-8859-1"), "UTF-8");
      //  String adress = new String(req.getParameter("adress").getBytes("ISO-8859-1"), "UTF-8");
        String role1 = new String(req.getParameter("role").getBytes("ISO-8859-1"), "UTF-8");
     
        int role=Integer.valueOf(role1).intValue();
        PrintWriter out=resp.getWriter();
        User user = new User();
        Connection con = null;
       // userAdd.set(userID);
       // user.setUser_id(userID);
        user.setName(name);
        user.setCollege(college);
        user.setTeam(team);
      //  user.setSex(sex);
       // userAdd.setGrade(grade);
        user.setMajor(major);
        user.setPhone(phone);
        user.setEmail(email);
        user.setPassword(password);
       // user.setAdress(adress);
        user.setRole(role);
        user.setUserID(userID);

        try {
            con = dbutil.getCon();
            adminDAO.useradd(con, user);
            out.write("<Script Language=\"JavaScript\">alert(\"success!\");window.location.href=\"index.jsp\";</Script>");
            //resp.sendRedirect("index.jsp");
        } catch (Exception e) {
            e.printStackTrace();
           
        }
//        try {
//			IsSuccess=stucheck.addStudent(stu);
//			if(IsSuccess==1)
//			{
//				out.println("<script> alert('注册成功');</script>");
//				
//				response.sendRedirect("../Login.jsp");
//			}
//			else{
//				out.println("<script> alert('注册失败,用户已存在');</script>");
//				out.println("<script> history.go(-1);</script>");
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    }
}