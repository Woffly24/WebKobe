package gaojun.web;

import gaojun.pojo.Cart;
import gaojun.pojo.CartItem;
import gaojun.pojo.Goods;
import gaojun.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CartServlet extends HttpServlet {
    GoodsServiceImpl dao = new GoodsServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if("addItem".equals(action)){
            addItem(req,resp);
        }
        if("deleteItem".equals(action)){
            deleteItem(req,resp);
        }
        if("clear".equals(action)){
            clear(req,resp);
        }
    }


    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        //首先查询book的信息
        Goods goods = dao.queryGoodsById(Integer.parseInt(id));
        //将book中的内容包装成为CartItem对象
        CartItem item = new CartItem(goods.getId(),goods.getName(),1,goods.getPrice(),goods.getPrice());
        //将item加入到Cart对象在购物车展示页面进行输出
        Cart cart = (Cart)req.getSession().getAttribute("cart");
        if(cart == null){
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(item);
//        System.out.println(cart);
        resp.sendRedirect(req.getContextPath()+"/list.jsp");
//        resp.sendRedirect(req.getHeader("Referer"));
    }


    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Cart cart = (Cart)req.getSession().getAttribute("cart");
        if(cart != null){
            cart.deleteItem(Integer.parseInt(id));
        }
        resp.sendRedirect(req.getContextPath()+"/shopcar.jsp");
    }
    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart)req.getSession().getAttribute("cart");
        if(cart != null){
            cart.clear();
        }
        resp.sendRedirect(req.getHeader("Referer"));
    }
}
