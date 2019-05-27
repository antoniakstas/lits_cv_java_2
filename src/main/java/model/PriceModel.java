package model;

public class PriceModel {
    private int id;
    private int product_id;
    private int value;
    private int mult;
    private String active;
    private String deliverydays;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public PriceModel(int id, int product_id, int value, int mult, String active, String deliverydays, String url) {
        this.id = id;
        this.product_id = product_id;
        this.value = value;
        this.mult = mult;
        this.active = active;
        this.deliverydays = deliverydays;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
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

    @java.lang.Override
    public java.lang.String toString() {
        return "Price{" +
                "id=" + id +
                ", product_id=" + product_id +
                ", value=" + value +
                ", mult=" + mult +
                ", active='" + active + '\'' +
                ", deliverydays='" + deliverydays + '\'' +
                '}';
    }

    {

    }
}
