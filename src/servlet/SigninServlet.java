package servlet;

import Dao.Dbutil;
import Dao.UserDao;
import Model.User;

import javax.faces.application.Application;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletContext;  

@WebServlet(urlPatterns = "/signin", name = "signin")
public class SigninServlet extends HttpServlet {
    Dbutil dbutil = new Dbutil();
    UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userID = req.getParameter("userID");
        String password = req.getParameter("password");
        req.setAttribute("userID", userID);
        req.setAttribute("password", password);
        ServletContext sc = getServletConfig().getServletContext(); 
        sc.setAttribute("userID", userID);
       //System.out.print(sc.getAttribute("email"));
        if (userID.isEmpty() || password.isEmpty()){
            req.setAttribute("error", "请确认账号再输入账号!");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
            return;
        }

        User user = new User(userID, password);
        Connection con = null;
        try {
            con = dbutil.getCon();
            User currentUser = userDao.signin(con, user);
            if (currentUser == null){
                req.setAttribute("error", "无此账号，请查证！");
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }
            else {
                HttpSession session = req.getSession();
                session.setAttribute("currentUser", currentUser);
                if (currentUser.getRole() == 2) {
                    resp.sendRedirect("jsp/main/Teaindex.jsp");
                } else if (currentUser.getRole() == 1){
                    resp.sendRedirect("jsp/main/Stuindex.jsp");
                } else {
                    resp.sendRedirect("jsp/main/Admindex.jsp/");
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                dbutil.closeCon(con);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
