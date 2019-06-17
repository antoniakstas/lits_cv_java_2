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
    private Long productId;
    private Long value;
    private Long mult;
    private Long count;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public Long getMult() {
        return mult;
    }

    public void setMult(Long mult) {
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

    public Price(Long id, Long productId, Long value, Long mult, Long count, String active, String deliverydays) {
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