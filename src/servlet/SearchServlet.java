package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Model.*;

import util.*;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/Search", name = "Search")
public class SearchServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SearchServlet() {
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

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");

//		//搜索书刊
		if(request.getParameter("searchBook")!=null)
		{	
			AdmDaoImpl admDaoImpl=new AdmDaoImpl();
			
			String search=new String(request.getParameter("search").getBytes());
			
		
			try{
				
				List<Book> isSuccess=admDaoImpl.findAll(search);
				if (isSuccess==null)
				{
					out.println("<script> alert('查无此信息');</script>");
					out.println("<script> history.go(-1);</script>");
				}
				else
				{	
					request.getRequestDispatcher("jsp/admin/SearchBook.jsp").forward(request,response);

				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		//搜索书刊（普通人员）
		if(request.getParameter("minsearchBook")!=null)
		{	
			AdmDaoImpl admDaoImpl=new AdmDaoImpl();
			
			String search=new String(request.getParameter("search").getBytes());
			
		
			try{
				
				List<Book> isSuccess=admDaoImpl.findAll(search);
				if (isSuccess==null)
				{
					out.println("<script> alert('查无此信息');</script>");
					out.println("<script> history.go(-1);</script>");
				}
				else
				{	
					request.getRequestDispatcher("jsp/common/SearchBook.jsp").forward(request,response);

				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		//搜索设备
		if(request.getParameter("searchEquip")!=null)
		{	
			EquipDaoImpl equip=new EquipDaoImpl();
			
			String search=new String(request.getParameter("search").getBytes());
			
		
			try{
				Equip isSuccess=equip.findEquip(search);
				if (isSuccess==null)
				{
					out.println("<script> alert('查无此信息');</script>");
					out.println("<script> history.go(-1);</script>");
				}
				else
				{	
					request.getRequestDispatcher("jsp/common/SearchEquip.jsp").forward(request,response);

				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		//搜索设备（管理員）
		if(request.getParameter("AdminsearchEquip")!=null)
		{	
			EquipDaoImpl equip=new EquipDaoImpl();
			
			String search=new String(request.getParameter("search").getBytes());
			
		
			try{
				Equip isSuccess=equip.findEquip(search);
				if (isSuccess==null)
				{
					out.println("<script> alert('查无此信息');</script>");
					out.println("<script> history.go(-1);</script>");
				}
				else
				{	
					request.getRequestDispatcher("jsp/admin/SearchEquip.jsp").forward(request,response);

				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		//修改教师信息
		if(request.getParameter("updateTea")!=null)
		{	
			TeaDaoImpl tea=new TeaDaoImpl();
			ComDaoImpl com=new ComDaoImpl();	
			String teano=new String(request.getParameter("teano").getBytes());
			String name=request.getParameter("name");
			String comno=new String(request.getParameter("comno").getBytes());
			String psw=new String(request.getParameter("teapsw").getBytes());
			Teacher t=new Teacher();
			Teacher check=new Teacher();
			String hasTea,hasCom;
			int teaSuccess = 0;
			int comSuccess = 0;
			int cancelSuccess=0;
			t.setTeaNo(teano);
			t.setName(name);
			t.setComNo(comno);
			t.setPassword(psw);
			try {
				check=tea.findById(teano);
				//若没修改实习公司
				if (check.getComNo().equals(comno))
				{
					teaSuccess=tea.updateById(t);
					if (teaSuccess>0)
					{				
						out.println("<script> alert('修改成功');</script>");
						out.println("<script> history.go(-1);</script>");
					}
					else
					{

						out.println("<script> alert('修改失败');</script>");
						out.println("<script> history.go(-1);</script>");
					}
				}
				//修改了实习公司
				else
				{
					Company c=com.findById(comno);		
					if(c!=null)
					{
						hasTea=com.hasTea(comno);
						//该公司没有带队老师,判断老师是否已选实习公司
						if(hasTea==null || hasTea.equals(""))
						{
							hasCom=tea.hasCom(teano);					
							//该老师未选取实习公司
							if(hasCom==null || hasCom.equals(""))
							{
								//更新教师信息表实习公司信息，更新实习公司带队老师信息
								teaSuccess=tea.updateById(t);
								comSuccess=com.Select(teano, comno);
								if (teaSuccess>0 & comSuccess>0)
								{				
									out.println("<script> alert('修改成功');</script>");
									out.println("<script> history.go(-1);</script>");
								}
								else
								{
			
									out.println("<script> alert('修改失败');</script>");
									out.println("<script> history.go(-1);</script>");
								}
							}
							//该老师已选取实习公司，取消原公司带队老师信息，更新教师信息表实习公司信息，更新实习公司带队老师信息
							else
							{						
								cancelSuccess=com.cancelById(hasCom);
								teaSuccess=tea.updateById(t);
								comSuccess=com.Select(teano, comno);
								//取消成功，实习公司带队老师信息更新成功，教师实习公司更新成功
								if (cancelSuccess>0 & teaSuccess>0 & comSuccess>0)
								{				
									out.println("<script> alert('修改成功');</script>");
									out.println("<script> history.go(-1);</script>");
								}
								else
								{
									out.println("<script> alert('修改失败');</script>");
									out.println("<script> history.go(-1);</script>");
								}
							}
						}
						//若该公司已有带队老师，拒绝选取请求
						else
						{			
							out.println("<script> alert('修改失败，公司已被其他老师选取');</script>");
							out.println("<script> history.go(-1);</script>");
						}
					}
					else
					{
						out.println("<script> alert('实习公司编号输入有误');</script>");
						out.println("<script> history.go(-1);</script>");
					}
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		//修改公告信息
		if(request.getParameter("updateNotice")!=null)
		{	
			NoticeDaoImpl notice=new NoticeDaoImpl();
			String noticeno=new String(request.getParameter("noticeno").getBytes());
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
			n.setTime(time);
			n.setContent(content);
			try{
				int isSuccess=notice.updateById(n);
				if (isSuccess>0)
				{
					out.println("<script> alert('修改成功');</script>");
					request.getRequestDispatcher("../jsp/admin/NoticeList.jsp").forward(request,response);
				}
				else
				{

					out.println("<script> alert('修改失败');</script>");
					out.println("<script> history.go(-1);</script>");
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		//修改公司信息
		if(request.getParameter("updateCom")!=null)
		{	
			ComDaoImpl com=new ComDaoImpl();
			String comno=new String(request.getParameter("comNo").getBytes());
			System.out.println(comno);
			String name=new String(request.getParameter("name").getBytes());
			String plan=new String(request.getParameter("plan").getBytes());
			String intro=new String(request.getParameter("intro").getBytes());
			Company c=new Company();
			c.setComNo(comno);
			c.setName(name);
			c.setPlan(plan);
			c.setIntroduction(intro);
			try{
				int isSuccess=com.updateById(c);
				if (isSuccess>0)
				{
					out.println("<script> alert('修改成功');</script>");
					request.getRequestDispatcher("../jsp/admin/ComList.jsp").forward(request,response);
				}
				else
				{

					out.println("<script> alert('修改失败');</script>");
					out.println("<script> history.go(-1);</script>");
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(request.getParameter("SelectScoreByMajor")!=null)
		{

			String Major=new String(request.getParameter("major").getBytes());
			System.out.println(Major);
		}
		//管理员修改密码
		if(request.getParameter("ChangeAdminPsw")!=null)
		{
			System.out.println("ChangeAdminPsw");
			String adminno=new String(request.getParameter("adminno").getBytes());
			String oldpsw=new String(request.getParameter("oldpsw").getBytes());
			String newpsw=new String(request.getParameter("newpsw").getBytes());
			int isSuccess;
			Admin a=new Admin();
			a.setAdmNo(adminno);
			a.setPassword(newpsw);
			System.out.println("新密码："+newpsw);
			AdmDaoImpl check=new AdmDaoImpl();	
			Admin checkpsw=new Admin();
			checkpsw=check.PswCheck(adminno);
			System.out.println("查询到旧密码："+checkpsw.getPassword());
			if(oldpsw.equals(checkpsw.getPassword()))
			{
				isSuccess=check.changePsw(a);
				if (isSuccess>0)
				{
					out.println("<script> alert('修改成功');</script>");
				}
				else
				{

					out.println("<script> alert('修改失败');</script>");
					out.println("<script> history.go(-1);</script>");
				}
			}
			else
			{
				out.println("<script> alert('修改失败');</script>");
				out.println("<script> history.go(-1);</script>");
			}
		}
		//学生修改密码
		if(request.getParameter("ChangeStuPsw")!=null)
		{
			String stuno=new String(request.getParameter("stuno").getBytes());
			String oldpsw=new String(request.getParameter("oldpsw").getBytes());
			String newpsw=new String(request.getParameter("newpsw").getBytes());
			int isSuccess;
			Student s=new Student();
			s.setStuNo(stuno);
			s.setPassword(newpsw);
			StuDaoImpl check=new StuDaoImpl();	
			Student checkpsw=new Student();
			checkpsw=check.PswCheck(stuno);
			if(oldpsw.equals(checkpsw.getPassword()))
			{
				isSuccess=check.changePsw(s);
				if (isSuccess>0)
				{
					out.println("<script> alert('修改成功');</script>");
				}
				else
				{

					out.println("<script> alert('修改失败');</script>");
					out.println("<script> history.go(-1);</script>");
				}
			}
			else
			{
				out.println("<script> alert('修改失败');</script>");
				out.println("<script> history.go(-1);</script>");
			}
		}
		//教师修改密码
		if(request.getParameter("ChangeTeaPsw")!=null)
		{
			String teano=new String(request.getParameter("teano").getBytes());
			String oldpsw=new String(request.getParameter("oldpsw").getBytes());
			String newpsw=new String(request.getParameter("newpsw").getBytes());
			int isSuccess;
			Teacher t=new Teacher();
			t.setTeaNo(teano);
			t.setPassword(newpsw);
			TeaDaoImpl check=new TeaDaoImpl();	
			Teacher checkpsw=new Teacher();
			checkpsw=check.PswCheck(teano);
			if(oldpsw.equals(checkpsw.getPassword()))
			{
				isSuccess=check.changePsw(t);
				if (isSuccess>0)
				{
					out.println("<script> alert('修改成功');</script>");
				}
				else
				{

					out.println("<script> alert('修改失败');</script>");
					out.println("<script> history.go(-1);</script>");
				}
			}
			else
			{
				out.println("<script> alert('修改失败');</script>");
				out.println("<script> history.go(-1);</script>");
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
