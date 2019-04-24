package servlet;  
  
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.WordGenerator;  
  

@WebServlet("/saveDocServlet")  
public class DownloadReportServlet extends HttpServlet {  
    private static final long serialVersionUID = 1L;  
  
    @Override  
    protected void service(HttpServletRequest req, HttpServletResponse resp)  
            throws ServletException, IOException {  
        req.setCharacterEncoding("utf-8");  
        Map<String, Object> map = new HashMap<String, Object>();  
        Enumeration<String> paramNames = req.getParameterNames();  
        // ͨ��ѭ���������������ֵ��ӳ����  
        while(paramNames.hasMoreElements()) {  
            String key = paramNames.nextElement();  
            String value = req.getParameter(key);  
            map.put(key, value);  
        }  
      
        // ��ʾ���ڵ��ù���������Word�ĵ�֮ǰӦ����������ֶ��Ƿ�����  
        // ����Freemarker��ģ�������ڴ���ʱ���ܻ���Ϊ�Ҳ���ֵ������ ������ʱ�������������  
        File file = null;  
        InputStream fin = null;  
        ServletOutputStream out = null;  
        try {  
            // ���ù�����WordGenerator��createDoc��������Word�ĵ�  
            file = WordGenerator.createDoc(map, "report");  
            fin = new FileInputStream(file);  
              
            resp.setCharacterEncoding("utf-8");  
            resp.setContentType("application/msword");  
            // ��������������صķ�ʽ������ļ�Ĭ����Ϊresume.doc  
            resp.addHeader("Content-Disposition", "attachment;filename=report.doc");  
              
            out = resp.getOutputStream();  
            byte[] buffer = new byte[512];  // ������  
            int bytesToRead = -1;  
            // ͨ��ѭ���������Word�ļ�������������������  
            while((bytesToRead = fin.read(buffer)) != -1) {  
                out.write(buffer, 0, bytesToRead);  
            }  
        } finally {  
            if(fin != null) fin.close();  
            if(out != null) out.close();  
            if(file != null) file.delete(); // ɾ����ʱ�ļ�  
        }  
    }  
  
}  