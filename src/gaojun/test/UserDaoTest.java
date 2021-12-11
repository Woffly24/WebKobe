package gaojun.test;

import gaojun.dao.impl.UserDaoImpl;
import gaojun.pojo.User;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;

import static org.junit.Assert.*;

public class UserDaoTest {
    UserDaoImpl userDao = new UserDaoImpl();


    @Test
    public void queryUserByUsername() {
        if(userDao.queryUserByUsername("admin") == null)
            System.out.println("用户名可用！");
        else
            System.out.println("用户名已存在！");
    }

    @Test
    public void queryUserByUsernameAndPassword() {

        if(userDao.queryUserByUsernameAndPassword("admin1", "gj521") == null)
            System.out.println("用户名或者密码错误！");
        else
            System.out.println("登录成功！");
    }

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new User(null,"gao","521")));
    }
}