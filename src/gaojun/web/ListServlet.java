package gaojun.web;

import gaojun.pojo.Goods;
import gaojun.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GoodsServiceImpl dao = new GoodsServiceImpl();
        List<Goods> goods = dao.queryGoodss();
        req.getSession().setAttribute("goods",goods);
        resp.sendRedirect(req.getContextPath()+"/list.jsp");
    }
}
