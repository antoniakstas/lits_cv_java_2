package dto;

import javax.persistence.*;

@Table
@Entity(name = "cart")
public class Cart {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private Integer id;
    int order_id;
    int product_count;
    int price_id;

    public Cart(Integer id,
                Integer order_id,//ValueFromDB,
                Integer product_count, //ValueFromDB,
                Integer price_id //ValueFromDB
    ) {
        this.id = id;
        this.order_id = order_id; //ValueFromDB;
        this.product_count = product_count; //ValueFromDB;
        this.price_id = price_id; //ValueFromDB;
    }

    public Cart() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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



