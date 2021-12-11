package gaojun.test;

import gaojun.pojo.Cart;
import gaojun.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"高俊",1,new BigDecimal(11),new BigDecimal(22)));
        cart.addItem(new CartItem(1,"高俊",1,new BigDecimal(11),new BigDecimal(22)));
        cart.addItem(new CartItem(2,"高俊",1,new BigDecimal(11),new BigDecimal(22)));
        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"高俊",1,new BigDecimal(11),new BigDecimal(22)));
        cart.addItem(new CartItem(1,"高俊",1,new BigDecimal(11),new BigDecimal(22)));
        cart.addItem(new CartItem(2,"高俊",1,new BigDecimal(11),new BigDecimal(22)));
        cart.deleteItem(1);
        System.out.println(cart);
    }

    @Test
    public void clear() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"高俊",1,new BigDecimal(11),new BigDecimal(22)));
        cart.addItem(new CartItem(1,"高俊",1,new BigDecimal(11),new BigDecimal(22)));
        cart.addItem(new CartItem(2,"高俊",1,new BigDecimal(11),new BigDecimal(22)));
        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void updateCount() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"高俊",1,new BigDecimal(11),new BigDecimal(22)));
        cart.addItem(new CartItem(1,"高俊",1,new BigDecimal(11),new BigDecimal(22)));
        cart.addItem(new CartItem(2,"高俊",1,new BigDecimal(11),new BigDecimal(22)));
        cart.updateCount(1,1);
        System.out.println(cart);
    }
}