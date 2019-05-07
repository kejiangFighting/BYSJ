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
//			System.out.println("����¼�����³ɼ���");
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
//			System.out.println("����¼������³ɼ���");
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
		//�޸�ѧ����Ϣ
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
					out.println("<script> alert('�޸ĳɹ�');</script>");
					out.println("<script> history.go(-1);</script>");
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
				//��û�޸�tuandui
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
				//�޸����о��Ŷ�
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
					request.getRequestDispatcher("jsp/admin/NoticeList.jsp").forward(request,response);
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
		//�޸��豸
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
					out.println("<script> alert('�޸ĳɹ�');window.location.href='jsp/admin/Report.jsp'</script>");
					//out.println("<script> alert('�޸ĳɹ�');</script>");
					//request.getRequestDispatcher("jsp/admin/Report.jsp").forward(request,response);
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
		//ȡ������
		if(request.getParameter("MeetingID")!=null)
		{	
			AdmDaoImpl admDaoImpl=new AdmDaoImpl();
			String ID=new String(request.getParameter("MeetingID").getBytes());
			
			String status="�ܾ�";
			System.out.println("ȡ������");
			System.out.println(ID);
			try{
				int isSuccess=admDaoImpl.UpdateMeet(ID,status);
				if (isSuccess>0)
				{
					out.println("<script> alert('ȡ���ɹ�');window.location.href='jsp/admin/MeetingList.jsp'</script>");
					 // out.write("<Script Language=\"JavaScript\">alert(\"success!\");window.location.href=\"jsp/admin/updateBook.jsp\";</Script>");
					//request.getRequestDispatcher("jsp/admin/updateBook.jsp").forward(request,response);
				}
				else
				{

					out.println("<script> alert('ȡ��ʧ��');</script>");
					out.println("<script> history.go(-1);</script>");
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		//��������
		if(request.getParameter("updatePingyu")!=null)
		{	
			TeaDaoImpl teaDaoImpl=new TeaDaoImpl();
			String pingyu=new String(request.getParameter("pingyu").getBytes());
			
			String neirong=new String(request.getParameter("name").getBytes());
			System.out.println("������"+neirong+pingyu);
			try{
				int isSuccess=teaDaoImpl.UpdateReport(pingyu,neirong);
				if (isSuccess>0)
				{
					out.println("<script> alert('�����ɹ�');window.location.href='jsp/teacher/ReportList.jsp'</script>");
					 // out.write("<Script Language=\"JavaScript\">alert(\"success!\");window.location.href=\"jsp/admin/updateBook.jsp\";</Script>");
					//request.getRequestDispatcher("jsp/admin/updateBook.jsp").forward(request,response);
				}
				else
				{

					out.println("<script> alert('����ʧ��');</script>");
					out.println("<script> history.go(-1);</script>");
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		//�޸�ͼ��
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
							out.println("<script> alert('�޸ĳɹ�');window.location.href='jsp/admin/BookList.jsp'</script>");
							 // out.write("<Script Language=\"JavaScript\">alert(\"success!\");window.location.href=\"jsp/admin/updateBook.jsp\";</Script>");
							//request.getRequestDispatcher("jsp/admin/updateBook.jsp").forward(request,response);
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
				//�޸��������״̬
				if(request.getParameter("TaskID")!=null)
				{	
					
					
					StuDaoImpl stu=new StuDaoImpl();
					
					String id=new String(request.getParameter("TaskID").getBytes());
					
					try{
						int isSuccess=stu.updateTask(id);
						if (isSuccess>0)
						{	
							out.println("<script> alert('�޸ĳɹ�');window.location.href='jsp/student/seeTask.jsp'</script>");
							
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
		//�����豸�޸�
		if(request.getParameter("repairID")!=null)
		{	
			EquipDaoImpl equipDaoImpl=new EquipDaoImpl();
			Equip aEquip=new Equip();
	
			String EquipID=new String(request.getParameter("repairID").getBytes());
			System.out.println("repairIDdsad:"+EquipID);
			Repair repair=new Repair();
			repair.setEquipID(EquipID);
			repair.setStatus("���޸�");
			aEquip.setStatus("����");
			aEquip.setEquipID(EquipID);
			try{
				int isSuccess=equipDaoImpl.updateRepairById(repair);
				System.out.println(isSuccess);
				
				int k=equipDaoImpl.changeStatus(aEquip);
				if (isSuccess>0 )
				{	
					System.out.println("k:"+k);
					out.println("<script> alert('�޸ĳɹ�');</script>");
					//out.println("<script> history.go(-1);</script>");
					request.getRequestDispatcher("jsp/admin/Report.jsp").forward(request,response);
					//return;
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
