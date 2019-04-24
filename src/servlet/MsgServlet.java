package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.*;

import util.*;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/MsgServlet", name = "MsgServlet")
public class MsgServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public MsgServlet() {
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
		MsgDaoImpl message=new MsgDaoImpl();
		System.out.println("修改状态");
		String mgno=new String(request.getParameter("msgno").getBytes());
		int msgno=Integer.parseInt(mgno);
		System.out.println(msgno);
		try {
			int delete=message.ChangeStatus(msgno);
			if(delete==1)
			{
				out.println("<script> alert('状态修改成功');</script>");
				out.println("<script> history.go(-1);</script>");
			}
			else
			{
				out.println("<script> alert('状态修改失败');</script>");
				out.println("<script> history.go(-1);</script>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		String content=new String(request.getParameter("content").getBytes());
		Message msg=new Message();
		MsgDaoImpl message=new MsgDaoImpl();
		StuDaoImpl student=new StuDaoImpl();
		TeaDaoImpl teacher=new TeaDaoImpl();
		msg.setStatus(1);
		msg.setContent(content);
		//管理员发送消息处理
		if(request.getParameter("AdminSendMsg")!=null)
		{
			msg.setFromNo("root");
			List<Student> stulist = new ArrayList<Student>();//存储全体学生信息
			List<Teacher> tealist = new ArrayList<Teacher>();//存储全体教师信息
			try {
				stulist=student.findAll();//获取全体学生信息
				tealist=teacher.findAll();//获取全体教师信息
				String[] values=request.getParameterValues("recieve");//存储消息接受者信息
				if(values!=null&&values.length>0) {
					for(int i= 0 ;i<values.length;i++)
						if(values[i].equals("全体学生"))//获取复选框的值，判断接受者的信息，若接收者对象为"全体学生"
						{
							System.out.print("全体学生");
							if(stulist.size()>0){//若已获取到的学生信息不为空
								for(Student s:stulist){//遍历已获取的全体学生信息list
									msg.setUserNo(s.getStuNo());//设置接收消息对象为学生学号
									message.addMsg(msg);//添加消息到消息表
								}
							}
						}
						else if(values[i].equals("全体导师"))
						{
							System.out.print("全体导师");
							if(tealist.size()>0){
								for(Teacher t:tealist){
									System.out.print(t.getTeaNo());
									msg.setUserNo(t.getTeaNo());
									message.addMsg(msg);
								}
							}
						}
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			out.println("<script> alert('发送成功');</script>");
			out.println("<script> history.go(-1);</script>");
		}
		if(request.getParameter("SendMsg")!=null)
		{
			String userNo=new String(request.getParameter("userno").getBytes());
			System.out.println("接收方编号："+userNo);
			String fromno=new String(request.getParameter("fromno").getBytes());
			System.out.println("发送方编号："+fromno);
			msg.setFromNo(fromno);
			if(fromno.equals(userNo))
			{
				out.println("<script> alert('发送失败,不能发消息给自己');</script>");
				out.println("<script> history.go(-1);</script>");
			}
			else
			{
				try {
					Student s=student.findById(userNo);
					Teacher t=teacher.findById(userNo);
					if(s==null & t==null & !userNo.equals("root"))
					{
						out.println("<script> alert('发送失败,无该用户');</script>");
						out.println("<script> history.go(-1);</script>");
					}
					else
					{
						msg.setUserNo(userNo);
						int addSuccess=message.addMsg(msg);
						if(addSuccess==1)
						{
							out.println("<script> alert('发送成功');</script>");
							out.println("<script> history.go(-1);</script>");
						}
						else
						{
							out.println("<script> alert('发送失败');</script>");
							out.println("<script> history.go(-1);</script>");
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		if(request.getParameter("SendTeamMsg")!=null)
		{
			String teano=new String(request.getParameter("teano").getBytes());
			System.out.println("发送教师"+teano+"学生队伍消息");
			msg.setFromNo(teano);
	  		try {
				Teacher t=teacher.findById(teano);
				if(t.getComNo().isEmpty() || t.getComNo().equals(""))
				{
					out.println("<script> alert('导师未选择研究团队，无法发送队伍消息');</script>");
					out.println("<script> history.go(-2);</script>");
				}
				else
				{
					List<Student> studentlist=student.findByComId(t.getComNo());
					if(studentlist.size()>0){
						for(Student s:studentlist){
							msg.setUserNo(s.getStuNo());
							message.addMsg(msg);
						}
					}

					out.println("<script> alert('发送成功');</script>");
					out.println("<script> history.go(-2);</script>");
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
