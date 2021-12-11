package gaojun.test;

import gaojun.dao.impl.OrderDaoImpl;
import gaojun.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class OrderDaoTest {
    OrderDaoImpl dao = new OrderDaoImpl();

    @Test
    public void saveOrder() {
        dao.saveOrder(new Order("2220",new Date(),new BigDecimal(11),0,2));
        dao.saveOrder(new Order("2221",new Date(),new BigDecimal(12),0,2));
        dao.saveOrder(new Order("2222",new Date(),new BigDecimal(13),0,2));
    }

    @Test
    public void queryOrders() {
        List<Order> orders = dao.queryOrders();
        System.out.println(orders);
    }

    @Test
    public void changeOrderStatus() {
        dao.changeOrderStatus("2020",1);
    }

    @Test
    public void queryOrdersByUserId() {
        List<Order> orders = dao.queryOrdersByUserId(2);
        System.out.println(orders);
    }
}