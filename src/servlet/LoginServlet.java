package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Admin;
import Model.Student;
import Model.Teacher;
import util.AdmDaoImpl;
import util.StuDaoImpl;
import util.TeaDaoImpl;


@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/Login", name = "login")
public class LoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("gbk");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		
		String no=new String(request.getParameter("userNo").getBytes());
		String psw=new String(request.getParameter("form-password").getBytes());
		String roles=(String)request.getParameter("roles");
		String role =new String(roles.getBytes("ISO8859-1"), "UTF-8");
		
		AdmDaoImpl adcheck=new AdmDaoImpl();
		Admin admin=new Admin();
		TeaDaoImpl teacheck=new TeaDaoImpl();
		Teacher tea=new Teacher();
		StuDaoImpl stucheck=new StuDaoImpl();
		Student stu=new Student();
		
		if(role.equals("学生"))
		{
			try {
				stu=stucheck.findStudent(no, psw);
				if(stu!=null){
					out.println("<script> alert('成功');</script>");
					request.getSession().setAttribute("student", no);
					response.sendRedirect("jsp/main/Stuindex.jsp");
				}
				else{
					out.println("<script> alert('失败');</script>");
					out.println("<script> history.go(-1);</script>");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(role.equals("管理员"))
		{
			try {
				admin=adcheck.findAdmin(no, psw);
				if(admin!=null){
					out.println("<script> alert('登录成功');</script>");
					request.getSession().setAttribute("admin", no);
					response.sendRedirect("jsp/main/Admindex.jsp");
				}
				else{
					out.println("<script> alert('检查账号');</script>");
					out.println("<script> history.go(-1);</script>");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(role.equals("教师"))
		{
			try {
				tea=teacheck.findTeacher(no, psw);
				if(tea!=null){
					out.println("<script> alert('登录成功');</script>");
					request.getSession().setAttribute("teacher", no);
					response.sendRedirect("jsp/main/Teaindex.jsp");
				}
				else{
					out.println("<script> alert('失败');</script>");
					out.println("<script> history.go(-1);</script>");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
