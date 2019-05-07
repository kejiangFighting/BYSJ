package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.mail.imap.protocol.Status;

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
		
		//查询是否有预约
		if(request.getParameter("chekTime")!=null){
			System.out.println("查询预约");
			int chek;
			String startTime=new String(request.getParameter("startTime").getBytes());
			String time=new String(request.getParameter("time").getBytes());
			String endTime=new String(request.getParameter("endTime").getBytes());
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
	          System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
	         String nowdate =df.format(new Date());
	         AdmDaoImpl admDaoImpl=new AdmDaoImpl();
	         Meeting m=new Meeting();
	         m.setTime(time);
	         try {
			      if (time.compareTo(nowdate)>=0) {
			    	  System.out.println("tongguo");
			    	  List<Meeting> meetList=admDaoImpl.checkMeeting(m);//获取预约当天的预约数据链表
			    	  chek=admDaoImpl.chekMeet(meetList,startTime,endTime);
			    	  //System.out.println("链表:"+meetList.get(0).getStartTime());
			    	  if (chek==0) {
			    		  out.println("<script> alert('查询时间冲突，请重新选择！');</script>"); 
		    			  out.println("<script> history.go(-1);</script>");
						
					} else {
						
						 out.println("<script> alert('当前时间段可以预约！')</script>");
						 out.println("<script> history.go(-1);</script>");
						
					}

					} else {
					out.println("<script> alert('请选择今天或之后时间段！');</script>");
					out.println("<script> history.go(-1);</script>");
				}	
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			
		}
		//添加预约会议室
		if(request.getParameter("AddMeeting")!=null)
		{
			System.out.println("添加预约");
			String userID=new String(request.getParameter("userno").getBytes());
			String title=new String(request.getParameter("title").getBytes());
			String names=new String(request.getParameter("names").getBytes());
			String startTime=new String(request.getParameter("startTime").getBytes());
			String time=new String(request.getParameter("time").getBytes());
			String endTime=new String(request.getParameter("endTime").getBytes());
			String nu=new String(request.getParameter("num").getBytes());
			int num=Integer.parseInt(nu);
			String phone=new String(request.getParameter("phone").getBytes());
			//String equips=new String(request.getParameter("equips").getBytes());
			String[] equip=request.getParameterValues("equips");
			String equips = "";
			for(int i=0;i<equip.length;i++)
				equips+=equip[i]+",";
			//System.out.println(delStr);
			System.out.println("设备："+equips);
			String status="已审批";
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
	          System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
	         String nowdate =df.format(new Date());
			Meeting m=new Meeting();
			m.setEndTime(endTime);
			m.setEquip(equips);
			m.setNames(names);
			m.setNum(num);
			m.setPhone(phone); 
			m.setStartTime(startTime);
			m.setTitle(title);
			m.setUserID(userID);
			m.setTime(time);
			m.setStatus(status);
			int chek;
			
			AdmDaoImpl admDaoImpl=new AdmDaoImpl();
			try {
				//chek=admDaoImpl.checkMeeting(m);
				//IsSuccess=admDaoImpl.addMeeing(m);
		      if (time.compareTo(nowdate)>=0) {
		    	  System.out.println("tongguo");
		    	  List<Meeting> meetList=admDaoImpl.checkMeeting(m);//获取预约当天的预约数据链表
		    	  chek=admDaoImpl.chekMeet(meetList,startTime,endTime);
		    	  //System.out.println("链表:"+meetList.get(0).getStartTime());
		    	  if (chek==0) {
		    		  out.println("<script> alert('预约时间冲突，请重新选择！');</script>"); 
	    			  out.println("<script> history.go(-1);</script>");
					
				} else {
					admDaoImpl.addMeeing(m);
					 out.println("<script> alert('预约成功');window.location.href='jsp/common/Meeting.jsp'</script>");
					
				}
//		    	  for (int i = 0;i<meetList.size(); i++) {
//		    		  if(startTime.compareTo(meetList.get(i).getEndTime())<=0&&endTime.compareTo(meetList.get(i).getStartTime())>=0){
//		    			  System.out.println("时间冲突");
//		    			  out.println("<script> alert('预约时间冲突，请重新选择！');</script>"); 
//		    			  out.println("<script> history.go(-1);</script>");
//		    		  }else {
//		    			  System.out.println("不冲突");
//		    			  IsSuccess=admDaoImpl.addMeeing(m);
//			    		  if(IsSuccess==1)
//							{	
//							  out.println("<script> alert('预约成功');window.location.href='jsp/common/Meeting.jsp'</script>");
//								//out.println("<script> alert('预约成功成功');</script>");
//								//request.getRequestDispatcher("jsp/common/Meeting.jsp").forward(request,response);
//							}
//							else{
//								out.println("<script> alert('预约失败');</script>");
//								out.println("<script> history.go(-1);</script>");
//							}
//					}
//				} 	
				} else {
				out.println("<script> alert('请选择今天或之后时间段！');</script>");
				out.println("<script> history.go(-1);</script>");
			}	
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		//添加书籍资料
		if(request.getParameter("AddBook")!=null)
		{
			System.out.println("添加书籍资料");
			String bookID=new String(request.getParameter("bookID").getBytes());
			String name=new String(request.getParameter("name").getBytes());
			String type=new String(request.getParameter("type").getBytes());
			String number=new String(request.getParameter("num").getBytes());    
			int num=Integer.parseInt(number);
			String time=new String(request.getParameter("time").getBytes());
			String introdu=new String(request.getParameter("introdu").getBytes());
			
			Book book=new Book();
			book.setBookID(bookID);
			book.setIntrodu(introdu);
			book.setName(name);
			book.setNum(num);
			book.setTime(time);
			book.setType(type);

			
			int IsSuccess;
			AdmDaoImpl admDaoImpl=new AdmDaoImpl();
			
		//	NoticeDaoImpl notice=new NoticeDaoImpl();
			try {
				
				IsSuccess=admDaoImpl.addBook(book);
				if(IsSuccess==1)
				{
					out.println("<script> alert('资料登记成功');</script>");
					request.getRequestDispatcher("jsp/admin/BookList.jsp").forward(request,response);
				}
				else{
					out.println("<script> alert('登记失败，请检查是否重复添加！');</script>");
					out.println("<script> history.go(-1);</script>");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(request.getParameter("AddEquip")!=null)
		{
			System.out.println("添加设备");
			System.out.println("修改了啊");
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
			
			int IsSuccess;
			EquipDaoImpl equipDaoImpl=new EquipDaoImpl();
			
			try {
				
				IsSuccess=equipDaoImpl.addEquip(n);
				if(IsSuccess==1)
				{
					out.println("<script> alert('添加成功');</script>");
					out.println("<script> history.go(-1);</script>");
					//request.getRequestDispatcher("jsp/admin/Report.jsp").forward(request,response);
				}
				else{
					out.println("<script> alert('请不要重复添加！');</script>");
					out.println("<script> history.go(-1);</script>");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//添加任务
		if(request.getParameter("AddTask")!=null)
		{
			System.out.println("添加任务");
			
			String FromNo=new String(request.getParameter("FromNo").getBytes());
			String name=new String(request.getParameter("name").getBytes());
			String ToNo=new String(request.getParameter("tono").getBytes());
			String neirong=new String(request.getParameter("neirong").getBytes());
			SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat(    
				     "yyyy-MM-dd HH:mm:ss");    
		   Date currentTime = new Date();    
		   String time = simpleDateFormat.format(currentTime).toString(); 
		    
		    Task t=new Task();
		    t.setFromNo(FromNo);
		    t.setName(name);
		    t.setNeirong(neirong);
		    t.setTime(time);
		    t.setToNo(ToNo);

			int IsSuccess;
			TeaDaoImpl teaDaoImpl=new TeaDaoImpl();
			try {
				
				IsSuccess=teaDaoImpl.addTask(t);
				if(IsSuccess==1)
				{
					
					 out.println("<script> alert('分配成功');window.location.href='jsp/teacher/Task.jsp'</script>");
					//request.getRequestDispatcher("jsp/admin/Report.jsp").forward(request,response);
				}
				else{
					out.println("<script> alert('发送失败');</script>");
					out.println("<script> history.go(-1);</script>");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//添加报告
		if(request.getParameter("AddReport")!=null)
		{
			System.out.println("添加报告");

			String teano=new String(request.getParameter("teano").getBytes());
			String name=new String(request.getParameter("name").getBytes());
			String StuNo=new String(request.getParameter("stuno").getBytes());
			String Time=new String(request.getParameter("time").getBytes());
			String neirong=new String(request.getParameter("neirong").getBytes());
//			SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat(    
//				     "yyyy-MM-dd HH:mm:ss");    
//		   Date currentTime = new Date();    
//		   String time = simpleDateFormat.format(currentTime).toString(); 
		    Report r=new Report();
		    r.setName(name);
		    r.setNeirong(neirong);
		    r.setStuNo(StuNo);
		    r.setTeaNO(teano);
		    r.setTime(Time);

			int IsSuccess;
			StuDaoImpl stuDaoImpl=new StuDaoImpl();
			//TeaDaoImpl teaDaoImpl=new TeaDaoImpl();
			try {
				
				IsSuccess=stuDaoImpl.addReport(r);
				if(IsSuccess==1)
				{
					
					out.println("<script> alert('上传成功');</script>");
					out.println("<script> history.go(-1);</script>");
				}
				else{
					out.println("<script> alert('上传失败');</script>");
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
