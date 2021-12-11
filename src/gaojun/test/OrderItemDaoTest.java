package gaojun.test;

import gaojun.dao.impl.OrderDaoImpl;
import gaojun.dao.impl.OrderItemDaoImpl;
import gaojun.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class OrderItemDaoTest {
    OrderItemDaoImpl dao = new OrderItemDaoImpl();

    @Test
    public void saveOrderItem() {
        dao.saveOrderItem(new OrderItem(null,"数学书",2,new BigDecimal(10),new BigDecimal(20),"2220"));
        dao.saveOrderItem(new OrderItem(null,"语文书",2,new BigDecimal(10),new BigDecimal(20),"2221"));
        dao.saveOrderItem(new OrderItem(null,"英语书",2,new BigDecimal(10),new BigDecimal(20),"2222"));
    }

    @Test
    public void queryOrderItemsByOrderId() {
        List<OrderItem> orderItems = dao.queryOrderItemsByOrderId("2220");
        System.out.println(orderItems);
    }
}