package gaojun.web;

import gaojun.pojo.Goods;
import gaojun.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.SoundbankResource;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class GoodsServlet extends HttpServlet {
    private GoodsServiceImpl dao = new GoodsServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if("list".equals(action)){
            list(req,resp);
        }
        if("add".equals(action)){
            add(req,resp);
        }
        if("delete".equals(action)){
            delete(req,resp);
        }
        if("getGoods".equals(action)){
            getGoods(req,resp);
        }
        if("update".equals(action)){
            update(req,resp);
        }
    }
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Goods> goods = dao.queryGoodss();
        req.setAttribute("goods",goods);
        req.getRequestDispatcher("/manager.jsp").forward(req,resp);
    }
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String p = req.getParameter("price");
        BigDecimal price = new BigDecimal(Double.parseDouble(p));
        Goods goods = new Goods(null, name, price,"/upload/list.jpg");
        dao.addGoods(goods);
        resp.sendRedirect(req.getContextPath()+"/manager/goodsServlet?action=list");
    }
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        dao.deleteGoodsById(Integer.parseInt(id));
        resp.sendRedirect(req.getContextPath()+"/manager/goodsServlet?action=list");
    }
    protected void getGoods(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Goods goods = dao.queryGoodsById(Integer.parseInt(id));
        req.setAttribute("goods",goods);
        req.getRequestDispatcher("/goods.jsp").forward(req,resp);
    }
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String p = req.getParameter("price");
        String id = req.getParameter("id");
        BigDecimal price = new BigDecimal(Double.parseDouble(p));
        System.out.println(name);
        System.out.println(price);
        System.out.println(id);
        Goods goods = new Goods(Integer.parseInt(id), name, price,"/upload/list.jpg");
        dao.updateGoods(goods);
        resp.sendRedirect(req.getContextPath()+"/manager/goodsServlet?action=list");
    }
}
