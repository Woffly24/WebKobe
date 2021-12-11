package gaojun.web;

import com.sun.org.apache.xpath.internal.operations.Or;
import gaojun.pojo.*;
import gaojun.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class OrderServlet extends HttpServlet {
    private OrderServiceImpl dao = new OrderServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if("buy".equals(action)){
            buy(req,resp);
        }
        if("showAllOrders".equals(action)){
            showAllOrders(req,resp);
        }
        if("sendOrder".equals(action)){

        }
        if("showMyOrders".equals(action)){
            showMyOrders(req,resp);
        }
        if("receiverOrder".equals(action)){
            receiverOrder(req,resp);
        }
    }
    protected void buy(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart)req.getSession().getAttribute("cart");
        User user = (User)req.getSession().getAttribute("user");
        if(user == null){
            req.getSession().setAttribute("please","请先登录！");
            resp.sendRedirect(req.getContextPath()+"/login.jsp");
            return;
        }
        else{
            String orderId = dao.createOrder(cart, user.getId());
            req.getSession().setAttribute("orderId",orderId);
            Object o = new Object();
            req.getSession().setAttribute("object",o);
            resp.sendRedirect(req.getContextPath()+"/checkout.jsp");
        }
    }
    protected void showAllOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> orders = dao.showAllOrder();
        List<Last> resultsManager = new ArrayList<>();
        for(Order order:orders){
            Date createTime = order.getCreateTime();
//
//            BigDecimal price = order.getPrice();
            Integer status = order.getStatus();
            String orderId = order.getOrderId();
            List<OrderItem> orderItems = dao.showOrderDetail(orderId);
            for(OrderItem orderItem:orderItems){
                String name = orderItem.getName();
                Integer count = orderItem.getCount();
                BigDecimal price = orderItem.getPrice();
                BigDecimal totalPrice = orderItem.getTotalPrice();
                Last last = new Last(name, count, price, totalPrice, createTime, status);
                resultsManager.add(last);
            }
        }
        req.getSession().setAttribute("resultsManager",resultsManager);
        resp.sendRedirect(req.getContextPath()+"/orderManager.jsp");
    }
    protected void sendOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    protected void showMyOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User)req.getSession().getAttribute("user");
        List<Last> results = new ArrayList<>();
        List<Order> orders = dao.showMyOrders(user.getId());
        for(Order order:orders){
            Date createTime = order.getCreateTime();
//            BigDecimal price = order.getPrice();
            Integer status = order.getStatus();
            String orderId = order.getOrderId();
            List<OrderItem> orderItems = dao.showOrderDetail(orderId);
            for(OrderItem orderItem:orderItems){
                String name = orderItem.getName();
                Integer count = orderItem.getCount();
                BigDecimal price = orderItem.getPrice();
                BigDecimal totalPrice = orderItem.getTotalPrice();
                Last last = new Last(name, count, price, totalPrice, createTime, status);
                results.add(last);
            }
        }
        req.getSession().setAttribute("results",results);
        resp.sendRedirect(req.getContextPath()+"/orderUser.jsp");
    }
    protected void receiverOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = (String)req.getSession().getAttribute("orderId");
        List<Last> results = (List)req.getSession().getAttribute("results");
        dao.receiverOrder(orderId);
        for(Last result:results){
            result.setStatus(2);

        }
        req.getSession().setAttribute("results",results);
        resp.sendRedirect(req.getContextPath()+"/orderUser.jsp");
    }
}
