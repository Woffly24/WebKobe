package gaojun.dao.impl;

import gaojun.dao.UserDao;
import gaojun.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String name) {
        String sql = "select `id`,`name`,`password` from customer where name = ?";
        return queryForOne(User.class, sql, name);
    }

    @Override
    public User queryUserByUsernameAndPassword(String name, String password) {
        String sql = "select `id`,`name`,`password` from customer where name = ? and password = ?";
        return queryForOne(User.class, sql, name,password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into customer(`name`,`password`) values(?,?)";
        return update(sql, user.getName(),user.getPassword());
    }
}
