<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="base.jsp"%>
<html>
<head>
    <title></title>
</head>
<body>
       <% java.sql.Timestamp currentDate = new java.sql.Timestamp(System.currentTimeMillis());         
         %>
      当前时间：<%=currentDate %>
      <% response.setContentType("text/html;charset=utf-8");
 		request.setCharacterEncoding("utf-8");
        String t=request.getParameter("sender");%>
<div class="container">
    <h5><b>当前位置</b>：消息管理> 消息回复</h5>
    <hr>
        <div class="notesadd">
            <form  action="../senderMessage" method="post">
                <div>
                    <label style="padding-left: 28px">接收人：</label>
                    <input type="text" placeholder="请输入接收人账号" name="receiver" size="26px"value="<%=t%>"/>
                </div>
                <div>
                    <label style="padding-top: 6px">发送时间</label>
                    <input type="text" placeholder="" name="time"value="<%=currentDate %>"/>
                </div>
                
                <div>
                   <label>发送内容</label>
                    <textarea rows="15" cols="75" name="message"></textarea>
                </div>
                
                <div style="padding-top: 15px">
                    <button type="submit" class="btn btn-primary">发送</button>
                    <button type="reset" class="btn btn-warning">重置</button>
                </div>
            </form>
        </div>
</div>

</body>
</html>

