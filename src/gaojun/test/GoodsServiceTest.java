package gaojun.test;

import gaojun.pojo.Goods;
import gaojun.service.GoodsService;
import gaojun.service.impl.GoodsServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class GoodsServiceTest {
    GoodsService dao = new GoodsServiceImpl();
    @Test
    public void addGoods() {
        dao.addGoods(new Goods(null,"可以",new BigDecimal(99.99),"upload/list.jpg"));
    }

    @Test
    public void deleteGoodsById() {
        dao.deleteGoodsById(5);
    }

    @Test
    public void updateGoods() {
        dao.updateGoods(new Goods(5,"不可以",new BigDecimal(99.99),"upload/list.jpg"));
    }

    @Test
    public void queryGoodsById() {
        System.out.println(dao.queryGoodsById(4));
    }

    @Test
    public void queryGoodss() {
        System.out.println(dao.queryGoodss());
    }
}