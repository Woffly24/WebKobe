<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>个人登录</title>
    <!-- 引入我们的初始化样式表 -->
    <link rel="stylesheet" href="css/base.css">
    <!-- 引入favicon网站图标 -->
    <link rel="shortcut icon" href="favicon.ico">
    <!-- 引入注册页面独有的样式表 -->
    <link rel="stylesheet" href="css/register.css">
</head>

<body>
    <div class="w">
        <!-- 头部header的制作 start-->
        <header class="header">
            <h1>
                <a href="index.jsp" class="logo"></a>
            </h1>
            <h1 style="line-height: 140px;text-align: center;">欢迎来到登录页面！</h1>
        </header>
        <!-- 头部header的制作 end-->
        <!-- 注册区域registerarea的制作 start-->
        <div class="registerarea">
            <!-- 头部的制作 -->
            <div class="registerarea_hd">
                <h2>登录</h2>
                <h2 style="color: #c81623;position: absolute;margin-left: 460px;">
                    <%=request.getAttribute("info") == null?"":request.getAttribute("info")%>
                </h2>
                <div class="right">
                    没有账号，去<a href="register.jsp">注册</a>
                </div>
            </div>
            <!-- 主体的制作 -->
            <div class="reg_form">
                <form action="loginServlet" method="get">
                    <c:if test="${not empty sessionScope.please}">
                        <h2 style="color:#c81623; margin-left: 550px;">${sessionScope.please}</h2>
                    </c:if>
                    <ul>
                        <!-- 错误的制作 -->
                        <li><label for="">用户名：</label><input type="text" name="name" value="<%=request.getAttribute("name") == null?"":request.getAttribute("name")%>">
                        </li>
                        <li><label for="">密码：</label><input type="text" name="password">
                        </li>
                        <!-- 同意按钮的制作 -->
                        <li class="agree"><input type="checkbox">
                            同意协议并登录&nbsp;<a href="#">《Woffly用户协议》</a>
                        </li>
                        <!-- 提交的制作 -->
                        <li class="submit"><input type="submit" value="登录" class="but"></li>
                    </ul>
                </form>
            </div>
        </div>
        <!-- 注册区域registerarea的制作 end-->

        <!-- footer的制作 -->
        <!-- mod_copyright的制作 -->
        <div class="mod_copyright">
            <div class="links">
                <a href="#">关于我们</a>|
                <a href="#">联系我们</a>|
                <a href="#">联系客服</a>|
                <a href="#">商家入驻</a>|
                <a href="#">营销中心</a>|
                <a href="#">手机Woffly</a>|
                <a href="#">友情链接</a>|
                <a href="#">销售联盟</a>
            </div>
            <div class="copyright">
                <p>地址：华南理工大学大学城校区C12计算机科学与工程学院 电话：1008611</p>
                <p>粤ICP备08001421号粤公网安备110108007702</p>
            </div>
        </div>
    </div>

</body>

</html>