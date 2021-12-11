package gaojun.service;

import gaojun.pojo.Cart;
import gaojun.pojo.Order;
import gaojun.pojo.OrderItem;

import java.util.List;

public interface OrderService {
    /**
     * 创建一个订单
     * @param cart 加入的购物车对象信息
     * @param userId 哪个用户加入的
     *               返回订单号
     */
    public String createOrder(Cart cart,Integer userId);

    /**
     * 查询所有的订单
     * @return 返回订单列表
     */
    public List<Order> showAllOrder();

    /**
     * 发货
     * @param orderId 根据订单号来确定具体的订单进行发货
     */
    public int sendOrder(String orderId);

    /**
     * 查询订单详情
     * @param orderId 返回一个具体的订单内容对象
     * @return
     */
    public List<OrderItem> showOrderDetail(String orderId);

    /**
     * 查询具体客户的订单
     * @param userId 具体的客户
     * @return
     */
    public List<Order> showMyOrders(Integer userId);

    /**
     * 签收订单
     * @param orderId 具体的订单号用来区分不同的订单便于签收
     */
    public int receiverOrder(String orderId);
}
