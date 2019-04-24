package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.*;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/selCompany", name = "selCompany")
public class selectComServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public selectComServlet() {
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

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
	
		if(request.getParameter("stuno")!=null)
		{	
			StuDaoImpl stu=new StuDaoImpl();
			String stuno=new String(request.getParameter("stuno").getBytes());
			String comno=new String(request.getParameter("comno").getBytes());
			System.out.println(stuno);
			System.out.println(comno);
			try{
				int isSuccess=stu.selectCom(stuno,comno);

				if (isSuccess>0)
				{
					out.println("<script> alert('操作成功');</script>");
					request.getRequestDispatcher("jsp/student/ComList.jsp?stuno=<%=stuno %>").forward(request,response);
				}
				else
				{

					out.println("<script> alert('失败');</script>");
					out.println("<script> history.go(-1);</script>");
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(request.getParameter("teano")!=null)
		{	
			TeaDaoImpl tea=new TeaDaoImpl();
			ComDaoImpl com=new ComDaoImpl();
			String teano=new String(request.getParameter("teano").getBytes());
			String comno=new String(request.getParameter("comno").getBytes());
			String hasTea;
			int teaSuccess = 0;
			int comSuccess = 0;
			int cancelSuccess=0;
			try{
				hasTea=com.hasTea(comno);
				//�ù�˾û�д�����ʦ���жϸ���ʦ�Ƿ���ѡʵϰ��˾
				if(hasTea==null || hasTea.equals(""))
				{
					//System.out.println("��˾�޴�����ʦ");
					String hasCom=tea.hasCom(teano);					
					//����ʦδѡȡʵϰ��˾
					if(hasCom==null || hasCom.equals(""))
					{
						//System.out.println("��ʦ��ʵϰ��˾");
						//���½�ʦ��Ϣ��ʵϰ��˾��Ϣ������ʵϰ��˾������ʦ��Ϣ
						teaSuccess=tea.selectComById(comno,teano);
						comSuccess=com.Select(teano, comno);
						if (teaSuccess>0 & comSuccess>0)
						{				
							out.println("<script> alert('成功');</script>");
							request.getRequestDispatcher("../jsp/teacher/TeaComList.jsp?teano=<%=teano %>").forward(request,response);
						}
						else
						{
							out.println("<script> alert('失败');</script>");
							out.println("<script> history.go(-1);</script>");
						}
					}
					
					else
					{
					
						cancelSuccess=com.cancelById(hasCom);
						teaSuccess=tea.selectComById(comno,teano);
						comSuccess=com.Select(teano, comno);
						
						if (cancelSuccess>0 & teaSuccess>0 & comSuccess>0)
						{				
							out.println("<script> alert('成功');</script>");
							out.println("<script> history.go(-1);</script>");
						}
						else
						{
							out.println("<script> alert('失败');</script>");
							out.println("<script> history.go(-1);</script>");
						}
					}
				}
				//���ù�˾���д�����ʦ���ܾ�ѡȡ����
				else
				{
					out.println("<script> alert('失败');</script>");
					out.println("<script> history.go(-1);</script>");
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
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
