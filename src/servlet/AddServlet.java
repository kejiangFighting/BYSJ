package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.*;

import util.*;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/AddServlet", name = "AddServlet")
public class AddServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
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
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		if(request.getParameter("AddCom")!=null)
		{
			System.out.println("添加研究团队");
			String comNo=new String(request.getParameter("comNo").getBytes());
			String name=new String(request.getParameter("name").getBytes());
			String plan=new String(request.getParameter("plan").getBytes());
			String intro=new String(request.getParameter("intro").getBytes());
			
			Company com=new Company();
			ComDaoImpl comdo=new ComDaoImpl();
			int IsSuccess;
			
			com.setComNo(comNo);
			com.setName(name);
			com.setPlan(plan);
			com.setIntroduction(intro);
			
			try {
				IsSuccess=comdo.addCom(com);
				if(IsSuccess==1)
				{
					out.println("<script> alert('添加成功');</script>");
					request.getRequestDispatcher("jsp/admin/ComList.jsp").forward(request,response);
				}
				else{
					out.println("<script> alert('添加失败');</script>");
					out.println("<script> history.go(-1);</script>");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(request.getParameter("AddNotice")!=null)
		{
			System.out.println("添加公告");
			String noticeno=new String(request.getParameter("noticeNo").getBytes());
			String title=new String(request.getParameter("title").getBytes());
			String name=new String(request.getParameter("name").getBytes());
			String department=new String(request.getParameter("department").getBytes());
			String time=new String(request.getParameter("time").getBytes());
			String content=new String(request.getParameter("content").getBytes());
			
			Notice n=new Notice();
			n.setNoticeNo(noticeno);
			n.setTitle(title);
			n.setName(name);
			n.setDepartment(department);
			n.setContent(content);
			n.setTime(time);
			
			int IsSuccess;
			NoticeDaoImpl notice=new NoticeDaoImpl();
			try {
				IsSuccess=notice.addNotice(n);
				if(IsSuccess==1)
				{
					out.println("<script> alert('添加成功');</script>");
					request.getRequestDispatcher("jsp/admin/NoticeList.jsp").forward(request,response);
				}
				else{
					out.println("<script> alert('添加失败');</script>");
					out.println("<script> history.go(-1);</script>");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(request.getParameter("AddRepair")!=null)
		{
			System.out.println("添加报修信息");
			String userID=new String(request.getParameter("stuno").getBytes());
			System.out.println(userID);
			String time=new String(request.getParameter("time").getBytes());
			System.out.println(time);
			String equipID=new String(request.getParameter("equipID").getBytes());
			System.out.println(equipID);
			
			String describe=new String(request.getParameter("describe").getBytes());
			Repair r =new Repair();
			//Report r=new Report();
			//r.setStuNo(stuno);
			r.setUserID(userID);
			r.setDescribe(describe);
			r.setTime(time);
			r.setEquipID(equipID);
			Equip e=new Equip();
			e.setEquipID(equipID);
			e.setStatus("报修中");
			int IsSuccess,k;
			EquipDaoImpl equip=new EquipDaoImpl();
			
			try {
				//修改状态
				IsSuccess=equip.changeStatus(e);
				if(IsSuccess==1)
				{
					out.println("<script> alert('修改成功');</script>");
					out.println("<script> history.go(-1);</script>");
				}
				else{
					out.println("<script> alert('修改失败');</script>");
					out.println("<script> history.go(-1);</script>");
				}
			
				//添加报修信息
				k=equip.addRepair(r);
				if(k==1)
				{
					out.println("<script> alert('报修成功');</script>");
					out.println("<script> history.go(-1);</script>");
				}
				else{
					out.println("<script> alert('报修失败');</script>");
					out.println("<script> history.go(-1);</script>");
				}
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(request.getParameter("StuRegister")!=null)
		{
			System.out.println("学生注册");
			int IsSuccess;
			String userno=new String(request.getParameter("userno").getBytes());
			String psw=new String(request.getParameter("psw").getBytes());
			String major=new String(request.getParameter("major").getBytes());
			String name=new String(request.getParameter("name").getBytes());
			StuDaoImpl stucheck=new StuDaoImpl();
			Student stu=new Student();
			stu.setStuNo(userno);
			stu.setName(name);
			stu.setMajor(major);
			stu.setPassword(psw);
			System.out.println(userno);
			System.out.println(major);
			System.out.println(name);
			try {
				IsSuccess=stucheck.addStudent(stu);
				if(IsSuccess==1)
				{
					out.println("<script> alert('注册成功');</script>");
					// out.write("<Script Language=\"JavaScript\">alert(\"success!\");window.location.href=\"admin/company.jsp\";</Script>");
					response.sendRedirect("index.jsp");
				}
				else{
					out.println("<script> alert('注册失败,用户已存在');</script>");
					out.println("<script> history.go(-1);</script>");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(request.getParameter("TeaRegister")!=null)
		{
			System.out.println("教师注册");
			String userno=new String(request.getParameter("userno").getBytes());
			String psw=new String(request.getParameter("psw").getBytes());
			String name=new String(request.getParameter("name").getBytes());
			TeaDaoImpl teacheck=new TeaDaoImpl();
			Teacher tea=new Teacher();
			tea.setTeaNo(userno);
			tea.setName(name);
			tea.setPassword(psw);
			int IsSuccess;
			try {
				IsSuccess=teacheck.addTeacher(tea);
				if(IsSuccess==1)
				{
					out.println("<script> alert('注册成功');</script>");				
					response.sendRedirect("index.jsp");
				}
				else{
					out.println("<script> alert('注册失败,用户已存在');</script>");
					out.println("<script> history.go(-1);</script>");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
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
