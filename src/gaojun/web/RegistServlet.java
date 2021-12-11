package gaojun.web;

import gaojun.pojo.User;
import gaojun.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserServiceImpl userService = new UserServiceImpl();

        //获取name和password
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        //1、检查该用户名是否被占用
        //1.1、被占用，跳回注册页面
        //1.2、没有被占用，加入数据库，注册成功跳转到登录页面
        if(userService.existsUsername(name)){
            req.setAttribute("info","用户名已存在，请重新注册！");
            req.setAttribute("name",name);
            req.getRequestDispatcher("/register.jsp").forward(req,resp);
        }else{
            User user = new User(null, name, password);
            userService.registUser(user);
//            req.getSession().setAttribute("user",user);
            resp.sendRedirect("login.jsp");
        }

    }
}
