package servlet;

import java.awt.AWTError;
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
@WebServlet(urlPatterns = "/update", name = "update")
public class updateServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public updateServlet() {
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
		request.setCharacterEncoding("utf-8");
		
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
	
		doPost(request, response);
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
//		if(request.getParameter("SingleEnterScore")!=null)
//		{
//			System.out.println("单个录入或更新成绩表");
//			ScoreDaoImpl score=new ScoreDaoImpl();
//			Float pscore;
//			Float tscore;
//			Score s;
//			String stuno=new String(request.getParameter("StuNo").getBytes());
//			String p_score=new String(request.getParameter("pscore").getBytes());
//			String t_score=new String(request.getParameter("tscore").getBytes());
//			pscore=Float.parseFloat(p_score);
//			tscore=Float.parseFloat(t_score);
//			try {
//				s = score.findById(stuno);
//				if(s==null)
//				{
//					score.addScore(stuno, pscore, tscore);
//				}
//				else
//				{
//					score.updateById(stuno, pscore, tscore);
//				}
//			} catch (Exception e1) {
//				e1.printStackTrace();
//			}
//		}
//		if(request.getParameter("EnterScore")!=null)
//		{
//			System.out.println("集体录入过更新成绩表");
//			ScoreDaoImpl score=new ScoreDaoImpl();
//			String[] stulist=request.getParameterValues("StuNo");
//			String[] plist=request.getParameterValues("pscore");
//			String[] tlist=request.getParameterValues("tscore");
//			String stuno;
//			Float pscore;
//			Float tscore;
//			if(stulist!=null&&stulist.length>0) {
//				for(int i= 0 ;i<stulist.length;i++){
//					stuno=stulist[i];
//					pscore=Float.parseFloat(plist[i]);
//					tscore=Float.parseFloat(tlist[i]);
//					Score s;
//					try {
//						s = score.findById(stuno);
//						if(s==null)
//						{
//							score.addScore(stuno, pscore, tscore);
//						}
//						else
//						{
//							score.updateById(stuno, pscore, tscore);
//						}
//					} catch (Exception e1) {
//						e1.printStackTrace();
//					}
//				}
//			}
//		}
//		
		//修改学生信息
		if(request.getParameter("updateStu")!=null)
		{	
			StuDaoImpl stu=new StuDaoImpl();
			String stuno=new String(request.getParameter("stuno").getBytes());
			String name=request.getParameter("name");
			String major=request.getParameter("major");
			String comno=new String(request.getParameter("comno").getBytes());
			String psw=new String(request.getParameter("stupsw").getBytes());
			Student s=new Student();
			s.setStuNo(stuno);
			s.setName(name);
			s.setMajor(major);
			s.setComNo(comno);
			s.setPassword(psw);
			try{
				int isSuccess=stu.updateById(s);
				if (isSuccess>0)
				{
					out.println("<script> alert('修改成功');</script>");
					out.println("<script> history.go(-1);</script>");
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
				//若没修改tuandui
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
				//修改了研究团队
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
					request.getRequestDispatcher("jsp/admin/NoticeList.jsp").forward(request,response);
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
		//修改设备
		if(request.getParameter("updateEquip")!=null)
		{	
			EquipDaoImpl equipDaoImpl=new EquipDaoImpl();
			
		
			String equipID=new String(request.getParameter("equipID").getBytes());
			String name=new String(request.getParameter("name").getBytes());
			String manufacturer=new String(request.getParameter("manufacture").getBytes());
			String type=new String(request.getParameter("type").getBytes());
			String status=new String(request.getParameter("status").getBytes());
			String specification=new String(request.getParameter("specification").getBytes());
			Equip n=new Equip();
			n.setEquipID(equipID);
			n.setManufacturer(manufacturer);
			n.setName(name);
			n.setSpecification(specification);
			n.setType(type);
			n.setStatus(status);			
			try{
				int isSuccess=equipDaoImpl.updateById(n);
				if (isSuccess>0)
				{	
					out.println("<script> alert('修改成功');window.location.href='jsp/admin/Report.jsp'</script>");
					//out.println("<script> alert('修改成功');</script>");
					//request.getRequestDispatcher("jsp/admin/Report.jsp").forward(request,response);
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
		//取消审批
		if(request.getParameter("MeetingID")!=null)
		{	
			AdmDaoImpl admDaoImpl=new AdmDaoImpl();
			String ID=new String(request.getParameter("MeetingID").getBytes());
			
			String status="拒绝";
			System.out.println("取消审批");
			System.out.println(ID);
			try{
				int isSuccess=admDaoImpl.UpdateMeet(ID,status);
				if (isSuccess>0)
				{
					out.println("<script> alert('取消成功');window.location.href='jsp/admin/MeetingList.jsp'</script>");
					 // out.write("<Script Language=\"JavaScript\">alert(\"success!\");window.location.href=\"jsp/admin/updateBook.jsp\";</Script>");
					//request.getRequestDispatcher("jsp/admin/updateBook.jsp").forward(request,response);
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
		//点评报告
		if(request.getParameter("updatePingyu")!=null)
		{	
			TeaDaoImpl teaDaoImpl=new TeaDaoImpl();
			String pingyu=new String(request.getParameter("pingyu").getBytes());
			
			String neirong=new String(request.getParameter("name").getBytes());
			System.out.println("点评："+neirong+pingyu);
			try{
				int isSuccess=teaDaoImpl.UpdateReport(pingyu,neirong);
				if (isSuccess>0)
				{
					out.println("<script> alert('点评成功');window.location.href='jsp/teacher/ReportList.jsp'</script>");
					 // out.write("<Script Language=\"JavaScript\">alert(\"success!\");window.location.href=\"jsp/admin/updateBook.jsp\";</Script>");
					//request.getRequestDispatcher("jsp/admin/updateBook.jsp").forward(request,response);
				}
				else
				{

					out.println("<script> alert('点评失败');</script>");
					out.println("<script> history.go(-1);</script>");
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		//修改图书
				if(request.getParameter("updateBook")!=null)
				{	
					AdmDaoImpl admDaoImpl=new AdmDaoImpl();
					String bookID=new String(request.getParameter("bookID").getBytes());
					System.out.println(bookID);
					String name=new String(request.getParameter("name").getBytes());
					String time=new String(request.getParameter("time").getBytes());
					String type=new String(request.getParameter("type").getBytes());
					String numb=new String(request.getParameter("num").getBytes());
					int num=Integer.parseInt(numb);
					String introdu=new String(request.getParameter("introdu").getBytes());
					Book b=new Book();
					b.setBookID(bookID);
					b.setIntrodu(introdu);
					b.setName(name);
					b.setNum(num);
					b.setType(type);
					b.setTime(time);
					try{
						int isSuccess=admDaoImpl.updateBook(b);
						if (isSuccess>0)
						{
							out.println("<script> alert('修改成功');window.location.href='jsp/admin/BookList.jsp'</script>");
							 // out.write("<Script Language=\"JavaScript\">alert(\"success!\");window.location.href=\"jsp/admin/updateBook.jsp\";</Script>");
							//request.getRequestDispatcher("jsp/admin/updateBook.jsp").forward(request,response);
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
				//修改任务完成状态
				if(request.getParameter("TaskID")!=null)
				{	
					
					
					StuDaoImpl stu=new StuDaoImpl();
					
					String id=new String(request.getParameter("TaskID").getBytes());
					
					try{
						int isSuccess=stu.updateTask(id);
						if (isSuccess>0)
						{	
							out.println("<script> alert('修改成功');window.location.href='jsp/student/seeTask.jsp'</script>");
							
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
		//报修设备修复
		if(request.getParameter("repairID")!=null)
		{	
			EquipDaoImpl equipDaoImpl=new EquipDaoImpl();
			Equip aEquip=new Equip();
	
			String EquipID=new String(request.getParameter("repairID").getBytes());
			System.out.println("repairIDdsad:"+EquipID);
			Repair repair=new Repair();
			repair.setEquipID(EquipID);
			repair.setStatus("已修复");
			aEquip.setStatus("正常");
			aEquip.setEquipID(EquipID);
			try{
				int isSuccess=equipDaoImpl.updateRepairById(repair);
				System.out.println(isSuccess);
				
				int k=equipDaoImpl.changeStatus(aEquip);
				if (isSuccess>0 )
				{	
					System.out.println("k:"+k);
					out.println("<script> alert('修改成功');</script>");
					//out.println("<script> history.go(-1);</script>");
					request.getRequestDispatcher("jsp/admin/Report.jsp").forward(request,response);
					//return;
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
