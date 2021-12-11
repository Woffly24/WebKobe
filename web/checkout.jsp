<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>支付成功</title>
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
            <h1 style="line-height: 140px;text-align: center;">您已成功支付！</h1>
            <h2 style="position: absolute;top: 70px;right: 10px;"><a href="orderServlet?action=showMyOrders">用户查看自己的订单</a></h2>
            <h2 style="position: absolute;top: 100px;right: 10px;"><a href="orderServlet?action=showAllOrders">管理员可查看所有订单</a></h2>
        </header>
        <!-- 头部header的制作 end-->

        <!-- 注册区域registerarea的制作 start-->
        <div class="registerarea">
            <!-- 头部的制作 -->
            <div class="registerarea_hd">
<%--                <h2 style="color: #c81623;position: absolute;margin-left: 495px;">请选择您要执行的操作！</h2>--%>
            </div>
            <!-- 主体的制作 -->
            <div class="reg_form">
                    <h2 style="position: absolute;margin-left: 450px;margin-top: 100px;">您支付的订单号为${sessionScope.orderId}</h2>
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