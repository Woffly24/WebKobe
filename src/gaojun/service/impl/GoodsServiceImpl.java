package gaojun.service.impl;



import gaojun.dao.GoodsDao;
import gaojun.dao.impl.GoodsDaoImpl;
import gaojun.pojo.Goods;
import gaojun.service.GoodsService;

import java.util.List;

public class GoodsServiceImpl implements GoodsService {

    private gaojun.dao.GoodsDao goodsDao = new GoodsDaoImpl();

    @Override
    public void addGoods(Goods goods) {
        goodsDao.addGoods(goods);
    }

    @Override
    public void deleteGoodsById(Integer id) {
        goodsDao.deleteGoodsById(id);
    }

    @Override
    public void updateGoods(Goods goods) {
        goodsDao.updateGoods(goods);
    }

    @Override
    public Goods queryGoodsById(Integer id) {
        return goodsDao.queryGoodsById(id);
    }

    @Override
    public List<Goods> queryGoodss() {
        return goodsDao.queryGoodss();
    }
}
