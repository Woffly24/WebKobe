package gaojun.test;

import com.sun.org.apache.xml.internal.res.XMLErrorResources_tr;
import gaojun.pojo.Cart;
import gaojun.pojo.CartItem;
import gaojun.pojo.Order;
import gaojun.pojo.OrderItem;
import gaojun.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class OrderServiceTest {
    OrderServiceImpl dao = new OrderServiceImpl();

    @Test
    public void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"高俊",1,new BigDecimal(11),new BigDecimal(22)));
        cart.addItem(new CartItem(1,"高俊",1,new BigDecimal(11),new BigDecimal(22)));
        cart.addItem(new CartItem(2,"高俊",1,new BigDecimal(11),new BigDecimal(22)));

        System.out.println(dao.createOrder(cart,1));
    }

    @Test
    public void showAllOrder() {
        List<Order> orders = dao.showAllOrder();
        System.out.println(orders);
    }

    @Test
    public void sendOrder() {
        dao.sendOrder("16388640360471");
    }

    @Test
    public void showOrderDetail() {
        List<OrderItem> orderItems = dao.showOrderDetail("16388640360471");
        System.out.println(orderItems);
    }

    @Test
    public void showMyOrders() {
        List<Order> orders = dao.showMyOrders(1);
        System.out.println(orders);
    }

    @Test
    public void receiverOrder() {
        dao.receiverOrder("16388640360471");
    }
}