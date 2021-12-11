package gaojun.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Last {
    private String name;
    private Integer count;
    private BigDecimal price;
    private BigDecimal totalPrice;
    private Date createTime;
    private Integer status;

    public Last() {
    }

    public Last(String name, Integer count, BigDecimal price, BigDecimal totalPrice, Date createTime, Integer status) {
        this.name = name;
        this.count = count;
        this.price = price;
        this.totalPrice = totalPrice;
        this.createTime = createTime;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Last{" +
                "name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", totalPrice=" + totalPrice +
                ", createTime=" + createTime +
                ", status=" + status +
                '}';
    }
}
