package gaojun.test;

import gaojun.dao.GoodsDao;
import gaojun.dao.impl.GoodsDaoImpl;
import gaojun.pojo.Goods;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class GoodsDaoTest {
    private GoodsDao dao = new GoodsDaoImpl();

    @Test
    public void addGoods() {
        dao.addGoods(new Goods(null,"学习书籍",new BigDecimal(110.11),"upload/list.jpg"));
    }

    @Test
    public void deleteGoodsById() {
        dao.deleteGoodsById(1);
    }

    @Test
    public void updateGoods() {
        dao.updateGoods(new Goods(4,"不学习书籍",new BigDecimal(112.11),"upload/list.jpg"));
    }

    @Test
    public void queryGoodsById() {
        Goods goods = dao.queryGoodsById(4);
        System.out.println(goods);
    }

    @Test
    public void queryGoodss() {
        List<Goods> goods = dao.queryGoodss();
        System.out.println(goods);
    }
}