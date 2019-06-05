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


    public  Product(){

    }

    public Product(String name, String manufacturer) {
        this.name = name;
        this.manufacturer = manufacturer;
    }
    public Product(int id, String name, String manufacturer) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
    }

    public Product(int id, String index, String name, String manufacturer) {
        this.id = id;
        this.index = index;
        this.name = name;
        this.manufacturer = manufacturer;
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

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", index='" + index + '\'' +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}



