package gaojun.dao;

import gaojun.pojo.Goods;

import java.util.List;

public interface GoodsDao {
    public int addGoods(Goods goods);

    public int deleteGoodsById(Integer id);

    public int updateGoods(Goods goods);

    public Goods queryGoodsById(Integer id);

    public List<Goods> queryGoodss();
}
