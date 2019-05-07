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
@WebServlet(urlPatterns = "/DeleteUserServlet", name = "DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DeleteUserServlet() {
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
		if(request.getParameter("stuid")!=null)
		{	
			StuDaoImpl stu=new StuDaoImpl();
			String stuno=new String(request.getParameter("stuid").getBytes());
			try{
				int isSuccess=stu.deleteById(stuno);

				if (isSuccess>0)
				{
					out.println("<script> alert('删除成功');</script>");
					request.getRequestDispatcher("jsp/admin/StuManage.jsp").forward(request,response);
				}
				else
				{

					out.println("<script> alert('删除失败');</script>");
					out.println("<script> history.go(-1);</script>");
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(request.getParameter("teaid")!=null)
		{	
			TeaDaoImpl tea=new TeaDaoImpl();
			String teano=new String(request.getParameter("teaid").getBytes());
			try{
				int isSuccess=tea.deleteById(teano);
				if (isSuccess>0)
				{
					out.println("<script> alert('删除成功');</script>");
					request.getRequestDispatcher("jsp/admin/TeaManage.jsp").forward(request,response);
				}
				else
				{

					out.println("<script> alert('删除失败');</script>");
					out.println("<script> history.go(-1);</script>");
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(request.getParameter("noticeid")!=null)
		{	
			NoticeDaoImpl notice=new NoticeDaoImpl();
			String noticeno=new String(request.getParameter("noticeid").getBytes());
			try{
				int isSuccess=notice.deleteById(noticeno);
				if (isSuccess>0)
				{
					out.println("<script> alert('删除成功');</script>");
					request.getRequestDispatcher("jsp/admin/NoticeList.jsp").forward(request,response);
				}
				else
				{

					out.println("<script> alert('删除失败');</script>");
					out.println("<script> history.go(-1);</script>");
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(request.getParameter("equipID")!=null)
		{	
			EquipDaoImpl equipDaoImpl=new EquipDaoImpl();
			
		
			String EquipID=new String(request.getParameter("equipID").getBytes());
			try{
				
				int isSuccess=equipDaoImpl.deleteEqById(EquipID);
				if (isSuccess>0)
				{
					out.println("<script> alert('删除成功');</script>");
					request.getRequestDispatcher("jsp/admin/Report.jsp").forward(request,response);
				}
				else
				{

					out.println("<script> alert('删除失败');</script>");
					out.println("<script> history.go(-1);</script>");
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(request.getParameter("bookID")!=null)
		{	
			AdmDaoImpl admDaoImpl=new AdmDaoImpl();
			
			
		
			String bookID=new String(request.getParameter("bookID").getBytes());
			try{
				
				int isSuccess=admDaoImpl.deleteBook(bookID);
				if (isSuccess>0)
				{
					//out.println("<script> alert('删除成功');</script>");
					out.println("<script> alert('删除成功');window.location.href='jsp/admin/BookList.jsp'</script>");
					//request.getRequestDispatcher("jsp/admin/Report.jsp").forward(request,response);
				}
				else
				{

					out.println("<script> alert('删除失败');</script>");
					out.println("<script> history.go(-1);</script>");
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		//删除文件
//		if(request.getParameter("EbookID")!=null)
//		{	
//			AdmDaoImpl admDaoImpl=new AdmDaoImpl();
//			
//			
//		
//			String bookID=new String(request.getParameter("bookID").getBytes());
//			try{
//				
//				int isSuccess=admDaoImpl.deleteBook(bookID);
//				if (isSuccess>0)
//				{
//					//out.println("<script> alert('删除成功');</script>");
//					out.println("<script> alert('删除成功');window.location.href='jsp/admin/BookList.jsp'</script>");
//					//request.getRequestDispatcher("jsp/admin/Report.jsp").forward(request,response);
//				}
//				else
//				{
//
//					out.println("<script> alert('删除失败');</script>");
//					out.println("<script> history.go(-1);</script>");
//				}
//			}catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
		//取消预约
		if(request.getParameter("MeetingID")!=null)
		{	
			AdmDaoImpl admDaoImpl=new AdmDaoImpl();
			
			
		
			String ID=new String(request.getParameter("MeetingID").getBytes());
			try{
				
				int isSuccess=admDaoImpl.deleteMeeting(ID);
				if (isSuccess>0)
				{
					//out.println("<script> alert('删除成功');</script>");
					out.println("<script> alert('取消成功');window.location.href='jsp/common/MeetingList.jsp'</script>");
					//request.getRequestDispatcher("jsp/admin/Report.jsp").forward(request,response);
				}
				else
				{

					out.println("<script> alert('取消失败');</script>");
					out.println("<script> history.go(-1);</script>");
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(request.getParameter("repairID")!=null)
		{	
			EquipDaoImpl equipDaoImpl=new EquipDaoImpl();
			
		
			String EquipID=new String(request.getParameter("repairID").getBytes());
			try{
				
				int isSuccess=equipDaoImpl.deleteRepairById(EquipID);
				if (isSuccess>0)
				{
					out.println("<script> alert('删除成功');</script>");
					request.getRequestDispatcher("jsp/admin/RepairList.jsp").forward(request,response);
				}
				else
				{

					out.println("<script> alert('删除失败');</script>");
					out.println("<script> history.go(-1);</script>");
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(request.getParameter("comid")!=null)
		{	
			ComDaoImpl com=new ComDaoImpl();
			String comno=new String(request.getParameter("comid").getBytes());
			try{
				int isSuccess=com.deleteById(comno);
				if (isSuccess>0)
				{
					request.getRequestDispatcher("jsp/admin/ComList.jsp").forward(request,response);
					out.println("<script> alert('删除成功');</script>");
				}
				else
				{

					out.println("<script> alert('删除失败');</script>");
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		
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
