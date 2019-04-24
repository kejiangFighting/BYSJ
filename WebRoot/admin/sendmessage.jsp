
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
<div class="container">
    <h5><b>当前位置</b>：消息管理> 消息发送</h5>
    <hr>
        <div class="notesadd">
            <form  action="../senderMessage" method="post">
                <div>
      注意：对个人发送消息填写对方编号，对管理员可以填admin以及管理员编号，all表全体师生，allstu全体学生，allteach表全体教师，公司名表在此公司实习的所有师生发送消息！！！
                    <label style="padding-left: 28px">接收人：</label>
                    <input type="text" placeholder="请输入接收人账号" name="receiver" size="26px"/>
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

