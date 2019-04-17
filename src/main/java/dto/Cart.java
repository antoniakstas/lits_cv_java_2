package dto;

public class Cart {
    int id;
    int order_id;
    int product_count;
    int price_id;

    public Cart(Integer idValueFromDB,
                Integer order_idValueFromDB,
                Integer product_countValueFromDB,
                Integer price_idValueFromDB) {
        this.id = idValueFromDB;
        this.order_id = order_idValueFromDB;
        this.product_count = product_countValueFromDB;
        this.price_id = price_idValueFromDB;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getProduct_count() {
        return product_count;
    }

    public void setProduct_count(int product_count) {
        this.product_count = product_count;
    }

    public int getPrice_id() {
        return price_id;
    }

    public void setPrice_id(int price_id) {
        this.price_id = price_id;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", order_id='" + order_id + '\'' +
                ", product_count='" + product_count + '\'' +
                ", price_id='" + price_id + '\'' +
                '}';

    }
}



