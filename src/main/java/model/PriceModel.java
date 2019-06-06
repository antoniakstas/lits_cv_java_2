package model;

public class PriceModel {

    private int product_id;
    private int value;
    private int mult;
    private int count;
    private String active;
    private String deliverydays;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public PriceModel(int id, int product_id, int value, int mult, int count, String active, String deliverydays, String url) {

        this.product_id = product_id;
        this.value = value;
        this.mult = mult;
        this.count = count;
        this.active = active;
        this.deliverydays = deliverydays;

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

    @Override
    public String toString() {
        return "PriceModel{" +
                "product_id=" + product_id +
                ", value=" + value +
                ", mult=" + mult +
                ", count=" + count +
                ", active='" + active + '\'' +
                ", deliverydays='" + deliverydays + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    {

    }
}
