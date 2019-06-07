package dto;


import io.swagger.models.auth.In;

import javax.persistence.*;

@Table
@Entity(name = "price")


public class Price {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name="product_id")
    private Integer productId;
    private int value;
    private int mult;
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private String active;
    private String deliverydays;

    public Price() {
    }

    @Override
    public String toString() {
        return "Price{" +
                "id=" + id +
                ", productId=" + productId +
                ", value=" + value +
                ", mult=" + mult +
                ", count=" + count +
                ", active='" + active + '\'' +
                ", deliverydays='" + deliverydays + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getMult() {
        return mult;
    }

    public void setMult(int mult) {
        this.mult = mult;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getDeliverydays() {
        return deliverydays;
    }

    public void setDeliverydays(String deliverydays) {
        this.deliverydays = deliverydays;
    }

    public Price(Long id, Integer productId, int value, int mult, int count, String active, String deliverydays) {
        this.id = id;
        this.productId = productId;
        this.value = value;
        this.mult = mult;
        this.count = count;
        this.active = active;
        this.deliverydays = deliverydays;
    }

    {

    }
}