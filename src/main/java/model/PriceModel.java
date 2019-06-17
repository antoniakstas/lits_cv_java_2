package model;

public class PriceModel {

    private Long product_id;
    private Long value;
    private Long mult;
    private Long count;
    private String active;
    private String deliverydays;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public PriceModel(Long id, Long product_id, Long value, Long mult, Long count, String active, String deliverydays, String url) {

        this.product_id = product_id;
        this.value = value;
        this.mult = mult;
        this.count = count;
        this.active = active;
        this.deliverydays = deliverydays;

    }



    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
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
