package gaojun.dao;

import gaojun.pojo.OrderItem;

import java.util.List;

public interface OrderItemDao {
    public int saveOrderItem(OrderItem orderItem);
    public List<OrderItem> queryOrderItemsByOrderId(String orderId);
}
