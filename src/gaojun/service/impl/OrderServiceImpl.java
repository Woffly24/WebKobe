package gaojun.service.impl;

import gaojun.dao.impl.OrderDaoImpl;
import gaojun.dao.impl.OrderItemDaoImpl;
import gaojun.pojo.Cart;
import gaojun.pojo.CartItem;
import gaojun.pojo.Order;
import gaojun.pojo.OrderItem;
import gaojun.service.OrderService;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements OrderService {
    private OrderDaoImpl dao = new OrderDaoImpl();
    private OrderItemDaoImpl daoItem = new OrderItemDaoImpl();
    @Override
    public String createOrder(Cart cart, Integer userId) {
        //先创建一个订单然后才有订单内容
        //订单号的生成
        String orderId = System.currentTimeMillis()+""+userId;
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);
        dao.saveOrder(order);
        //将这个订单的详细内容保存
        for(Map.Entry<Integer, CartItem>entry:cart.getItems().entrySet()){
            CartItem cartItem = entry.getValue();
            OrderItem orderItem = new OrderItem(null, cartItem.getName(), cartItem.getCount(), cartItem.getPrice(), cartItem.getTotalPrice(), orderId);
            daoItem.saveOrderItem(orderItem);
        }
        cart.clear();
        return orderId;
    }

    @Override
    public List<Order> showAllOrder() {
        return dao.queryOrders();
    }

    @Override
    public int sendOrder(String orderId) {
        return dao.changeOrderStatus(orderId,1);
    }

    @Override
    public List<OrderItem> showOrderDetail(String orderId) {
        return daoItem.queryOrderItemsByOrderId(orderId);
    }

    @Override
    public List<Order> showMyOrders(Integer userId) {
        return dao.queryOrdersByUserId(userId);
    }

    @Override
    public int receiverOrder(String orderId) {
        return dao.changeOrderStatus(orderId,2);
    }
}