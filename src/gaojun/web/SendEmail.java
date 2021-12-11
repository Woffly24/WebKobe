package gaojun.web;


import gaojun.pojo.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.mail.*;
import javax.mail.internet.*;

/**
 * Servlet implementation class SendEmail
 */
@WebServlet("/SendEmail")
public class SendEmail extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendEmail() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String email = request.getParameter("email");
        System.out.println(email);
        User user = (User)request.getSession().getAttribute("user");
        if(user == null){
            request.getSession().setAttribute("please","请先登录！");
            response.sendRedirect(request.getContextPath()+"/login.jsp");
            return;
        }
        String orderId = (String)request.getSession().getAttribute("orderId");

        Properties props = new Properties();
        // 表示SMTP发送邮件，必须进行身份验证
        props.put("mail.smtp.auth", "true");
        //此处填写SMTP服务器
        props.put("mail.smtp.host", "smtp.qq.com");
        //端口号，QQ邮箱给出了两个端口，但是另一个我一直使用不了，所以就给出这一个587
        props.put("mail.smtp.port", "587");
        // 此处填写你的账号
        props.put("mail.user","2420850076@qq.com");
        // 此处的密码就是前面说的16位STMP口令
        props.put("mail.password","dyxjezkaxdcsdijg");

        // 构建授权信息，用于进行SMTP进行身份验证
        Authenticator authenticator = new Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        // 使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(props, authenticator);
        // 创建邮件消息
        MimeMessage message = new MimeMessage(mailSession);
        // 设置发件人
        InternetAddress form;
        try {
            form = new InternetAddress(
                    props.getProperty("mail.user"));

            message.setFrom(form);


            // 设置收件人的邮箱
            InternetAddress to = new InternetAddress(email);
            message.setRecipient(Message.RecipientType.TO, to);

            // 设置邮件标题
            message.setSubject("Woffly商品发送邮件");

            // 设置邮件的内容体
            User userT = (User)request.getSession().getAttribute("user");
            String str = "亲爱的"+userT.getName()+"，您已成功支付订单";
            message.setContent(str+"。您的商品已全部发货，您可以到自己的订单中去签收了哦~~~", "text/html;charset=UTF-8");

            // 最后当然就是发送邮件啦
            Transport.send(message);
            response.sendRedirect(request.getContextPath()+"/orderServlet?action=buy");
        } catch (AddressException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//        response.sendRedirect(request.getContextPath()+"/checkout.jsp");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
