package dto;

import model.ProductResponseModel;

import javax.persistence.*;

@Table
@Entity(name = "product")
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "index_code")
    private String index;
    @Column(name = "name")
    private String name;
    @Column(name = "manufacturer")
    private String manufacturer;


    public Product() {

    }



    public Product(Long id, String index, String name, String manufacturer) {
        this.id = id;
        this.index = index;
        this.name = name;
        this.manufacturer = manufacturer;
    }
    public Product(ProductResponseModel productResponseModel) {
        this.index = productResponseModel.getIndex();
        this.name = productResponseModel.getName();
        this.manufacturer = productResponseModel.getManufacturer();
    }

    public Product(String name, String manufacturer) {
        this.name = name;
        this.manufacturer = manufacturer;
    }

    public Product(Long id, String name, String manufacturer) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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



