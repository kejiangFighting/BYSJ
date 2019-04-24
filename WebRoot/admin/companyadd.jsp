<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="base.jsp"%>
<html>
<head>
    <title></title>
</head>
<body>

    <div class="container">
        <h5><b>当前位置</b>：实习公司管理> 添加公司</h5>
        <hr>
        <div class="companyadd">
           <form action="../companyadd" method="post">
               <div>
                   <label>公司编号</label>
                   <input type="text" name="company_id" placeholder=""/>
               </div>
                <div>
                   <label>公司名称</label>
                   <input type="text" name="company_name" placeholder=""/>
               </div>
                <div>
                    <label>公司简介</label>
                    <textarea rows="15" cols="75" name="introduce"></textarea>
               </div>
                 <div>
                   <label>公司地址</label>
                   <input type="text" name="address" placeholder=""/>
                   
               </div>
               <div>
                   <label>联系电话</label>
                   <input type="text" name="tel" placeholder=""/>
               </div>
               <div>
                   <label>容纳人数</label>
                   <input type="text" name="capacity" placeholder="如：80"/>
               </div>
               <div style="padding-top: 15px">
                   <button type="submit" class="btn btn-primary">添加</button>
                   <button type="reset" class="btn btn-warning">重置</button>
               </div>
           </form>
        </div>
    </div>

</body>
</html>
