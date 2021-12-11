package gaojun.dao.impl;

import gaojun.dao.GoodsDao;
import gaojun.pojo.Goods;

import java.util.List;

public class GoodsDaoImpl extends BaseDao implements GoodsDao {
    @Override
    public int addGoods(Goods goods) {

        String sql = "insert into goods(`name`,`price`,`img_path`) values(?,?,?)";

        return update(sql, goods.getName(),goods.getPrice(),goods.getImgPath());

    }

    @Override
    public int deleteGoodsById(Integer id) {
        String sql = "delete from goods where id = ?";
        return update(sql, id);
    }

    @Override
    public int updateGoods(Goods goods) {
        String sql = "update goods set `name`=?,`price`=?,`img_path`=? where id = ?";
        return update(sql,goods.getName(),goods.getPrice(),goods.getImgPath(),goods.getId());
    }

    @Override
    public Goods queryGoodsById(Integer id) {
        String sql = "select `id`,`name`,`price`,`img_path` imgPath from goods where id = ?";
        return queryForOne(Goods.class, sql,id);
    }

    @Override
    public List<Goods> queryGoodss() {
        String sql = "select `id`,`name`, `price`, `img_path` imgPath from goods";
        return queryForList(Goods.class, sql);
    }
}
