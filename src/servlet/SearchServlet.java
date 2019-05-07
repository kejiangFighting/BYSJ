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

//		//�����鿯
		if(request.getParameter("searchBook")!=null)
		{	
			AdmDaoImpl admDaoImpl=new AdmDaoImpl();
			
			String search=new String(request.getParameter("search").getBytes());
			
		
			try{
				
				List<Book> isSuccess=admDaoImpl.findAll(search);
				if (isSuccess==null)
				{
					out.println("<script> alert('���޴���Ϣ');</script>");
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
		//�����鿯����ͨ��Ա��
		if(request.getParameter("minsearchBook")!=null)
		{	
			AdmDaoImpl admDaoImpl=new AdmDaoImpl();
			
			String search=new String(request.getParameter("search").getBytes());
			
		
			try{
				
				List<Book> isSuccess=admDaoImpl.findAll(search);
				if (isSuccess==null)
				{
					out.println("<script> alert('���޴���Ϣ');</script>");
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
		//�����豸
		if(request.getParameter("searchEquip")!=null)
		{	
			EquipDaoImpl equip=new EquipDaoImpl();
			
			String search=new String(request.getParameter("search").getBytes());
			
		
			try{
				Equip isSuccess=equip.findEquip(search);
				if (isSuccess==null)
				{
					out.println("<script> alert('���޴���Ϣ');</script>");
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
		//�����豸������T��
		if(request.getParameter("AdminsearchEquip")!=null)
		{	
			EquipDaoImpl equip=new EquipDaoImpl();
			
			String search=new String(request.getParameter("search").getBytes());
			
		
			try{
				Equip isSuccess=equip.findEquip(search);
				if (isSuccess==null)
				{
					out.println("<script> alert('���޴���Ϣ');</script>");
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
		//�޸Ľ�ʦ��Ϣ
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
				//��û�޸�ʵϰ��˾
				if (check.getComNo().equals(comno))
				{
					teaSuccess=tea.updateById(t);
					if (teaSuccess>0)
					{				
						out.println("<script> alert('�޸ĳɹ�');</script>");
						out.println("<script> history.go(-1);</script>");
					}
					else
					{

						out.println("<script> alert('�޸�ʧ��');</script>");
						out.println("<script> history.go(-1);</script>");
					}
				}
				//�޸���ʵϰ��˾
				else
				{
					Company c=com.findById(comno);		
					if(c!=null)
					{
						hasTea=com.hasTea(comno);
						//�ù�˾û�д�����ʦ,�ж���ʦ�Ƿ���ѡʵϰ��˾
						if(hasTea==null || hasTea.equals(""))
						{
							hasCom=tea.hasCom(teano);					
							//����ʦδѡȡʵϰ��˾
							if(hasCom==null || hasCom.equals(""))
							{
								//���½�ʦ��Ϣ��ʵϰ��˾��Ϣ������ʵϰ��˾������ʦ��Ϣ
								teaSuccess=tea.updateById(t);
								comSuccess=com.Select(teano, comno);
								if (teaSuccess>0 & comSuccess>0)
								{				
									out.println("<script> alert('�޸ĳɹ�');</script>");
									out.println("<script> history.go(-1);</script>");
								}
								else
								{
			
									out.println("<script> alert('�޸�ʧ��');</script>");
									out.println("<script> history.go(-1);</script>");
								}
							}
							//����ʦ��ѡȡʵϰ��˾��ȡ��ԭ��˾������ʦ��Ϣ�����½�ʦ��Ϣ��ʵϰ��˾��Ϣ������ʵϰ��˾������ʦ��Ϣ
							else
							{						
								cancelSuccess=com.cancelById(hasCom);
								teaSuccess=tea.updateById(t);
								comSuccess=com.Select(teano, comno);
								//ȡ���ɹ���ʵϰ��˾������ʦ��Ϣ���³ɹ�����ʦʵϰ��˾���³ɹ�
								if (cancelSuccess>0 & teaSuccess>0 & comSuccess>0)
								{				
									out.println("<script> alert('�޸ĳɹ�');</script>");
									out.println("<script> history.go(-1);</script>");
								}
								else
								{
									out.println("<script> alert('�޸�ʧ��');</script>");
									out.println("<script> history.go(-1);</script>");
								}
							}
						}
						//���ù�˾���д�����ʦ���ܾ�ѡȡ����
						else
						{			
							out.println("<script> alert('�޸�ʧ�ܣ���˾�ѱ�������ʦѡȡ');</script>");
							out.println("<script> history.go(-1);</script>");
						}
					}
					else
					{
						out.println("<script> alert('ʵϰ��˾�����������');</script>");
						out.println("<script> history.go(-1);</script>");
					}
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		//�޸Ĺ�����Ϣ
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
					out.println("<script> alert('�޸ĳɹ�');</script>");
					request.getRequestDispatcher("../jsp/admin/NoticeList.jsp").forward(request,response);
				}
				else
				{

					out.println("<script> alert('�޸�ʧ��');</script>");
					out.println("<script> history.go(-1);</script>");
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		//�޸Ĺ�˾��Ϣ
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
					out.println("<script> alert('�޸ĳɹ�');</script>");
					request.getRequestDispatcher("../jsp/admin/ComList.jsp").forward(request,response);
				}
				else
				{

					out.println("<script> alert('�޸�ʧ��');</script>");
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
		//����Ա�޸�����
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
			System.out.println("�����룺"+newpsw);
			AdmDaoImpl check=new AdmDaoImpl();	
			Admin checkpsw=new Admin();
			checkpsw=check.PswCheck(adminno);
			System.out.println("��ѯ�������룺"+checkpsw.getPassword());
			if(oldpsw.equals(checkpsw.getPassword()))
			{
				isSuccess=check.changePsw(a);
				if (isSuccess>0)
				{
					out.println("<script> alert('�޸ĳɹ�');</script>");
				}
				else
				{

					out.println("<script> alert('�޸�ʧ��');</script>");
					out.println("<script> history.go(-1);</script>");
				}
			}
			else
			{
				out.println("<script> alert('�޸�ʧ��');</script>");
				out.println("<script> history.go(-1);</script>");
			}
		}
		//ѧ���޸�����
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
					out.println("<script> alert('�޸ĳɹ�');</script>");
				}
				else
				{

					out.println("<script> alert('�޸�ʧ��');</script>");
					out.println("<script> history.go(-1);</script>");
				}
			}
			else
			{
				out.println("<script> alert('�޸�ʧ��');</script>");
				out.println("<script> history.go(-1);</script>");
			}
		}
		//��ʦ�޸�����
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
					out.println("<script> alert('�޸ĳɹ�');</script>");
				}
				else
				{

					out.println("<script> alert('�޸�ʧ��');</script>");
					out.println("<script> history.go(-1);</script>");
				}
			}
			else
			{
				out.println("<script> alert('�޸�ʧ��');</script>");
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
