package dto;


import javax.persistence.*;

@Table
@Entity(name = "price")


public class Price {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name="product_id")
    private int productId;
    private int value;
    private int mult;
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
                ", active='" + active + '\'' +
                ", deliverydays='" + deliverydays + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
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

    public Price(int id, int productId, int value, int mult, String active, String deliverydays) {
        this.id = id;
        this.productId = productId;
        this.value = value;
        this.mult = mult;
        this.active = active;
        this.deliverydays = deliverydays;
    }

    {

    }
}