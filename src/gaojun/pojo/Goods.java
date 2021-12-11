package gaojun.pojo;

import java.math.BigDecimal;

public class Goods {
    private Integer id;
    private String name;
    private BigDecimal price;
    //这个地址作为默认图片地址
    private String imgPath = "upload/list.jpg";

    public Goods() {
    }

    public Goods(Integer id, String name, BigDecimal price, String imgPath) {
        this.id = id;
        this.name = name;
        this.price = price;
        if(imgPath != null && !"".equals(imgPath))
            this.imgPath = imgPath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}
