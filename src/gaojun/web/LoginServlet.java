package gaojun.web;

import gaojun.pojo.User;
import gaojun.service.UserService;
import gaojun.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取name和password参数
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        //用户名和密码匹配，登录成功
        User user = userService.login(new User(null, name, password));
        if(user != null){
            req.getSession().setAttribute("name",name);
            req.getSession().setAttribute("user",user);
            resp.sendRedirect("success.jsp");
        }
        //用户名和密码不匹配，登录失败
        else{
            req.setAttribute("info","用户名或密码错误！请重新输入！");
            req.setAttribute("name",name);
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }
}
