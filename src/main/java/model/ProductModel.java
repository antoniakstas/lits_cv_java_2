package model;

public class ProductModel {

    private Long id;
    private String index;
    private String name;
    private String manufacturer;
    private String url;


    public ProductModel(){

    }
    public ProductModel(Long id, String index, String name, String manufacturer, String url) {
        this.id = id;
        this.index = index;
        this.name = name;
        this.manufacturer = manufacturer;
        this.url = url;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ProductModel{" +
                "id=" + id +
                ", index='" + index + '\'' +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}



