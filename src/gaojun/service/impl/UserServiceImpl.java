package gaojun.service.impl;


import gaojun.dao.UserDao;
import gaojun.dao.impl.UserDaoImpl;
import gaojun.pojo.User;
import gaojun.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getName(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String name) {

        if (userDao.queryUserByUsername(name) == null) {
           // 等于null,说明没查到，没查到表示可用
           return false;
        }

        return true;

    }
}
