<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>购物车</title>
    <!-- 引入我们的初始化样式表 -->
    <link rel="stylesheet" href="css/base.css">
    <!-- 引入favicon网站图标 -->
    <link rel="shortcut icon" href="favicon.ico">
    <!-- 引入注册页面独有的样式表 -->
    <link rel="stylesheet" href="css/register.css">
    <style>
        .reg_form {
            font-size: 16px;
            height: 800px;
        }

        .reg_form table {
            /* margin-left: 280px; */
            text-align: center;
            /* margin: 0 auto; */
            border-spacing: 50px;
        }
        .reg_form td{
            width: 150px;
        }

        .reg_form td:first-child {
            width: 300px;
            /* margin-right: 100px; */
        }
    </style>
</head>

<body>
    <div class="w">
        <!-- 头部header的制作 start-->
        <header class="header">
            <h1>
                <a href="index.jsp" class="logo"></a>
            </h1>
            <h1 style="line-height: 140px;text-align: center;">您已进入购物车管理页面！</h1>
            <h2 style="position: absolute;top: 70px;right: 10px;"><a href="orderServlet?action=showMyOrders">
                <c:if test="${not empty sessionScope.user && not empty sessionScope.object}">
                    用户查看自己的订单
                </c:if>
            </a></h2>
            <h2 style="position: absolute;top: 100px;right: 10px;"><a href="orderServlet?action=showAllOrders">
                <c:if test="${'gj'.equals(sessionScope.user.name)}">
                    管理员查看所有的订单
                </c:if>
            </a></h2>
        </header>
        <!-- 头部header的制作 end-->

        <!-- 注册区域registerarea的制作 start-->
        <div class="registerarea" style="height: 800px;overflow: scroll;">
            <!-- 头部的制作 -->
            <div class="registerarea_hd">
                <h2 style="color: #c81623;position: absolute;margin-left: 465px;">您可以在此页面对商品进行操作</h2>
            </div>
            <!-- 主体的制作 -->
            <div class="reg_form">
                <table>
                    <tr>
                        <td>商品名称</td>
                        <td>数量</td>
                        <td>单价</td>
                        <td>总价</td>
                        <td colspan="2">操作</td>
                    </tr>
                    <c:if test="${empty sessionScope.cart || sessionScope.cart.items.size() == 0}">
                        <td colspan="5"><a href="listServlet" style="font-size:18px;font-weight: 700">啥？东西都不买还想来购物车看数据？抠抠搜搜的，给你个机会点我去买东西！</a></td>
                    </c:if>
                    <c:if test="${not empty sessionScope.cart}">
                        <c:forEach items="${sessionScope.cart.items}" var="entry">
                            <tr>
                                <td>${entry.value.name}</td>
                                <td>${entry.value.count}</td>
                                <td>${entry.value.price}</td>
                                <td>${entry.value.totalPrice}</td>
                                <td><a href="cartServlet?action=deleteItem&id=${entry.value.id}">删除</a></td>
                            </tr>
                        </c:forEach>
                    </c:if>

                    <c:if test="${not empty sessionScope.cart && sessionScope.cart.items.size() != 0}">
                        <tr>
                            <td colspan="5">您的购物车共有
                                <i style="color: #c81623;font-weight: 700;">${sessionScope.cart.totalCount}</i>
                                件商品，总价<i style="color: #c81623;font-weight: 700;">${sessionScope.cart.totalPrice}</i>元
                                &nbsp; &nbsp; &nbsp; &nbsp;
                                <a href="cartServlet?action=clear" style="color: #c81623;font-weight: 700;">清空购物车</a>&nbsp; &nbsp; &nbsp; &nbsp;
                                <a href="email.jsp" style="color: #c81623;font-weight: 700;">去结账</a>
                                <a href="list.jsp" style="margin-left:40px;color: #c81623;font-weight: 700;">返回商品页</a>
                            </td>
                        </tr>
                    </c:if>
                </table>
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