package gaojun.dao.impl;


import gaojun.dao.OrderDao;
import gaojun.pojo.Order;

import java.util.List;

public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`) values(?,?,?,?,?)";

        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }

    @Override
    public List<Order> queryOrdersByUserId(Integer id) {
        String sql = "select order_id orderId,create_time createTime,price,status,user_id  userId from t_order where user_id=?";
        return queryForList(Order.class,sql,id);
    }

    @Override
    public List<Order> queryOrders() {
        String sql = "select order_id orderId,create_time createTime,price,status,user_id  userId from t_order";
        return queryForList(Order.class,sql);
    }

    @Override
    public int changeOrderStatus(String orderId, Integer status) {
        String sql = "update t_order set status=? where order_id=?";
        return update(sql,status,orderId);
    }
}
