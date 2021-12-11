<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 网站三大标签SEO优化之T -->
    <title>Woffly-正品低价、品质保障、配送及时、轻松购物！</title>
    <!-- 网站三大标签SEO优化之D -->
    <meta name="description" content="Woffly-专业的综合网上购物商城，为您提供正品低价的购物选择、优质便捷的服务体验。
    商品来自全球数十万品牌商家，囊括家电、手机、电脑、服装、居家、母婴、美妆、个护、食品、生鲜等丰富品类，满足各种购物需求。">
    <!-- 网站三大标签SEO优化之K -->
    <meta name="keyword" content="网上购物,网上商城,家电,手机,电脑,服装,居家,母婴,美妆,个护,食品,生鲜,京东">
    <!-- 引入我们的初始化样式表 -->
    <link rel="stylesheet" href="css/base.css">
    <!-- 引入我们的公共样式表 -->
    <link rel="stylesheet" href="css/common.css">
    <!-- 引入我们的index独有样式表 -->
    <link rel="stylesheet" href="css/list.css">
    <!-- 引入favicon网站图标 -->
    <link rel="shortcut icon" href="favicon.ico">
    <style>
        .sk_bd i {
            font-size: 16px;
            font-weight: 700;
            margin-top: 10px;
        }

        .sk_bd strong {
            color: #c81623;
        }

        .sk_bd button {
            margin-top: 10px;
            width: 200px;
            height: 50px;
            margin-left: 40px;
            background-color: #c81623;
            font-size: 16px;
            color: black;
            font-weight: 700;
        }
        .sk_bd {
            overflow: hidden;
        }
        .sk_bd ul li {
            margin-right: 10px;
            margin-bottom: 20px;
            float: left;
            width: 290px;
            height: 500px;
        }
        .sk_bd ul li:hover{
            border:1px solid black;
        }
        .sk_bd ul li:hover img{
            border:0px solid black;
        }
    </style>
</head>

<body>
<!-- 导航栏的制作 start-->
<div class="shortcut">
    <!-- 嵌入版心 -->
    <div class="w">
        <!-- 导航栏分为两个部分：左边浮动 -->
        <div class="fl">
            <!-- 内容部分用ul来制作 -->
            <ul>
                <li>Woffly(作者QQ网名)欢迎您!&nbsp;</li>
                <!-- “登录”和“免费注册”一般是一起出现，因此只用了两个li -->

                <c:if test="${empty sessionScope.name}">
                    <li>
                        <a href="login.jsp" class="style_red">请登录&nbsp;</a>
                        <a href="register.jsp" class="style_red">免费注册</a>
                    </li>
                </c:if>
                <c:if test="${not empty sessionScope.name}">
                    <li>
                        <a href="#" class="style_red">${sessionScope.name}&nbsp;</a>
                        <a href="outServlet" class="style_red">注销账号</a>
                    </li>
                </c:if>
            </ul>
        </div>
        <div class="fr">
            <!-- 导航栏右侧的制作 -->
            <ul>
                <c:if test="${not empty sessionScope.name}">
                    <li>我的订单</li>
                    <li></li>
                    <li class="arrow-icon">我的浏览</li>
                    <li></li>
                </c:if>
                <li>Woffly会员</li>
                <li></li>
                <li>企业采购</li>
                <li></li>
                <li class="arrow-icon">关注Woffly</li>
                <li></li>
                <li class="arrow-icon">客户服务</li>
                <li></li>
                <li class="arrow-icon">网站导航</li>
            </ul>
        </div>
    </div>
</div>
<!-- 导航栏的制作 end-->

<!-- header栏的制作 start-->
<header class="header w">
    <!-- 左侧logo的制作 -->
    <div class="logo">
        <h1>
            <a href="index.jsp" title="品优购">品优购</a>
        </h1>
    </div>
    <!-- 中间搜索框的制作 -->
    <div class="search">
        <!-- 注意清除搜索框和button的样式 -->
        <input type="search" placeholder="Mamba Never Out">
        <button>搜索</button>
    </div>
    <!-- 中间hotwords的制作 -->
    <div class="hotwords">
        <a href="#" class="style_red">Kobe</a>
        <a href="#">Mamba</a>
        <a href="#">Champion</a>
        <a href="#">MVP</a>
        <a href="#">4:00 in the morning</a>
        <a href="#" class="end">Insist</a>
    </div>
    <!-- 右侧shopcar的制作 -->
    <a href="shopcar.jsp">
        <div class="shopcar">
            我的购物车
            <!-- 购物数量 -->
            <i class="count" style="color:black;font-weight: 700">
                    ${sessionScope.cart.totalCount}
            </i>
        </div>
    </a>
    <%--        <div class="fl style_red" style="position:absolute;margin-left: 900px;margin-top: 25px;">--%>
    <%--            <p style="font-size: 26px;font-weight: 700;">THIS IS WHY WE PLAY</p>--%>
    <%--        </div>--%>
</header>
<!-- header栏的制作 end-->

    <!-- nav栏的制作 start -->
    <nav class="nav w">
        <!-- nav左侧的制作 -->
        <div class="sk_list fl">
            <ul>
                <li><a href="#">品优秒杀</a></li>
                <li><a href="#">即将售罄</a></li>
                <li><a href="#">超值低价</a></li>
            </ul>
        </div>
        <!-- nav右侧的制作 -->
        <div class="sk_content fl">
            <ul>
                <li><a href="#">女装</a></li>
                <li><a href="#">女鞋</a></li>
                <li><a href="#">男装</a></li>
                <li><a href="#">男鞋</a></li>
                <li><a href="#">母婴童装</a></li>
                <li><a href="#">食品</a></li>
                <li><a href="#">智能数码</a></li>
                <li><a href="#">运动户外</a></li>
                <li><a href="#">更多分类</a></li>
            </ul>
        </div>
    </nav>
    <!-- nav栏的制作 end -->

    <!-- 列表页主体部分的制作 start-->
    <div class="sk_container w">
        <!-- 列表页头部的制作 -->
        <div class="sk_hd">
            <img src="#" alt="">
        </div>
        <!-- 列表页内容的制作 -->
        <div class="sk_bd" style="text-align: left;">
            <ul>
                <c:forEach items="${sessionScope.goods}" var="book">
                    <li>
                        <img src="upload/list.jpg" alt="list">
                        <br>
                        <br>
                        <i>商品名：${book.name}</i><br>
                        <i>商品价格：<strong>${book.price}元</strong></i><br>
                        <a href="cartServlet?action=addItem&id=${book.id}"><button>加入购物车</button></a>
                    </li>
                </c:forEach>

            </ul>
        </div>
    </div>
    <!-- 列表页主体部分的制作 last-->

    <!-- 底部footer的制作 start -->
    <footer class="footer" style="margin-top: 50px;">
        <div class="w">
            <!-- mod_service的制作 -->
            <div class="mod_service">
                <ul>
                    <li class="first">
                        <h5></h5>
                        <div class="mod_service_text">
                            <h2>正品保障</h2>
                            <p>正品保障，提供发票</p>
                        </div>
                    </li>
                    <li class="second">
                        <h5></h5>
                        <div class="mod_service_text">
                            <h2>急速物流</h2>
                            <p>急速物流，急速送达</p>
                        </div>
                    </li>
                    <li class="third">
                        <h5></h5>
                        <div class="mod_service_text">
                            <h2>无忧售后</h2>
                            <p>七天无理由退换货</p>
                        </div>
                    </li>
                    <li class="fourth">
                        <h5></h5>
                        <div class="mod_service_text">
                            <h2>特色服务</h2>
                            <p>私人订制家电套餐</p>
                        </div>
                    </li>
                </ul>
            </div>
            <!-- mod_help的制作 -->
            <div class="mod_help">
                <dl>
                    <dt><a href="#">购物指南</a></dt>
                    <dd><a href="#">购物流程</a></dd>
                    <dd><a href="#">会员介绍</a></dd>
                    <dd><a href="#">生活旅行/团购</a></dd>
                    <dd><a href="#">常见问题</a></dd>
                    <dd><a href="#">大家电</a></dd>
                    <dd><a href="#">联系客服</a></dd>
                </dl>
                <dl>
                    <dt><a href="#">购物指南</a></dt>
                    <dd><a href="#">购物流程</a></dd>
                    <dd><a href="#">会员介绍</a></dd>
                    <dd><a href="#">生活旅行/团购</a></dd>
                    <dd><a href="#">常见问题</a></dd>
                    <dd><a href="#">大家电</a></dd>
                    <dd><a href="#">联系客服</a></dd>
                </dl>
                <dl>
                    <dt><a href="#">购物指南</a></dt>
                    <dd><a href="#">购物流程</a></dd>
                    <dd><a href="#">会员介绍</a></dd>
                    <dd><a href="#">生活旅行/团购</a></dd>
                    <dd><a href="#">常见问题</a></dd>
                    <dd><a href="#">大家电</a></dd>
                    <dd><a href="#">联系客服</a></dd>
                </dl>
                <dl>
                    <dt><a href="#">购物指南</a></dt>
                    <dd><a href="#">购物流程</a></dd>
                    <dd><a href="#">会员介绍</a></dd>
                    <dd><a href="#">生活旅行/团购</a></dd>
                    <dd><a href="#">常见问题</a></dd>
                    <dd><a href="#">大家电</a></dd>
                    <dd><a href="#">联系客服</a></dd>
                </dl>
                <dl>
                    <dt><a href="#">购物指南</a></dt>
                    <dd><a href="#">购物流程</a></dd>
                    <dd><a href="#">会员介绍</a></dd>
                    <dd><a href="#">生活旅行/团购</a></dd>
                    <dd><a href="#">常见问题</a></dd>
                    <dd><a href="#">大家电</a></dd>
                    <dd><a href="#">联系客服</a></dd>
                </dl>
                <dl class="code">
                    <dt><a href="#">帮助中心</a></dt>
                    <dd>
                        <img src="images/code.jpg" alt="code">
                    </dd>
                </dl>
            </div>
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
    </footer>
    <!-- 底部footer的制作 end -->
</body>

</html>