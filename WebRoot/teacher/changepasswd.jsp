<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="base.jsp"%>
<html>
<head>
    <title></title>
</head>
<body>

  <div class="container">
    <h5><b>当前位置</b>：个人信息 > 密码修改</h5>
    <hr>
    <div class="changepasswd">
      <form action="../changepassword" method="post">
       <div>
          <label style="padding-left: 15px" >编号：</label>
          <input type="text" name="school_num" value="${currentUser.school_num}"/>
        </div>
        <div>
          <label style="padding-left: 15px">旧密码:</label>
          <input type="password" name="old_password"/>
        </div>
        <div>
          <label style="padding-left: 15px">新密码:</label>
          <input type="password" name="new_password"/>
        </div>
        <div>
          <label>确认密码:</label>
          <input type="password" name="new_password"/>
        </div>
        <div style="padding-top: 15px">
          <button type="submit" class="btn btn-primary">提交</button>
          <button type="reset" class="btn btn-warning">重置</button>
        </div>
      </form>
    </div>
  </div>

</body>
</html>
