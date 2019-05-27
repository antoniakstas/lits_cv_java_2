package dto;

import javax.persistence.*;

@Table
@Entity(name = "product")
public class Product{
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String index;
    private String name;
    private String manufacturer;
    private int count;


    public  Product(){

    }

    public Product(String name, String manufacturer, int count) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.count = count;
    }
    public Product(int id, String name, String manufacturer, int count) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.count = count;
    }

    public Product(int id, String index, String name, String manufacturer, int count) {
        this.id = id;
        this.index = index;
        this.name = name;
        this.manufacturer = manufacturer;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", index='" + index + '\'' +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", count=" + count +
                '}';
    }
}



