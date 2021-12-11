package gaojun.test;

import gaojun.dao.impl.UserDaoImpl;
import gaojun.pojo.User;
import gaojun.service.UserService;
import gaojun.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceImplTest {

    UserServiceImpl dao = new UserServiceImpl();
    @Test
    public void registUser() {
        dao.registUser(new User(null,"gaok","123"));
    }

    @Test
    public void login() {
        User gaok = dao.login(new User(null, "gaok", "123"));
        System.out.println(gaok);
    }

    @Test
    public void existsUsername() {
        boolean gaok = dao.existsUsername("gaok");
        System.out.println(gaok);
    }
}