<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>管理员查看订单</title>
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
            <h1 style="line-height: 140px;text-align: center;">您已进入管理员的订单管理页面！</h1>
        </header>
        <!-- 头部header的制作 end-->

        <!-- 注册区域registerarea的制作 start-->
        <div class="registerarea" style="height: 800px;overflow: scroll;">
            <!-- 头部的制作 -->
            <div class="registerarea_hd">
                <h2 style="color: #c81623;position: absolute;margin-left: 465px;">您可以在此页面查看为发货的订单</h2>
            </div>
            <!-- 主体的制作 -->
            <div class="reg_form">
                <table>
                    <tr>
                        <td>商品名称</td>
                        <td>数量</td>
                        <td>单价</td>
                        <td>总价</td>
                        <td>创建时间</td>
                        <td>状态</td>
                        <td>是否已发货</td>
                    </tr>
                        <c:forEach items="${sessionScope.resultsManager}" var="result">
                            <tr>
                                <td>${result.name}</td>
                                <td>${result.count}</td>
                                <td>${result.price}</td>
                                <td>${result.totalPrice}</td>
                                <td>${result.createTime}</td>
                                <td>
                                    <c:if test="${result.status == 0}">未发货</c:if>
                                    <c:if test="${result.status == 1}">已发货</c:if>
                                    <c:if test="${result.status == 2}">已签收</c:if>
                                </td>
                            </tr>
                        </c:forEach>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
<%--                        <td><a href="orderServlet?action=sendOrder"><button style="width: 100px;height: 30px;font-size: 16px;background-color: #b1191a">是</button></a></td>--%>
                    </tr>
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