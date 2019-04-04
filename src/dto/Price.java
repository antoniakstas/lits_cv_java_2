package dto;

public class Price {
    private int id;
    private int produkt_id;
    private int value;
    private int mult;
    private String active;
    private String deliverydays;



    public Price(int id, int produkt_id, int value, int mult, String active, String deliverydays) {
        this.id = id;
        this.produkt_id = produkt_id;
        this.value = value;
        this.mult = mult;
        this.active = active;
        this.deliverydays = deliverydays;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProdukt_id() {
        return produkt_id;
    }

    public void setProdukt_id(int produkt_id) {
        this.produkt_id = produkt_id;
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
                ", produkt_id=" + produkt_id +
                ", value=" + value +
                ", mult=" + mult +
                ", active='" + active + '\'' +
                ", deliverydays='" + deliverydays + '\'' +
                '}';
    }

    {

    }
}