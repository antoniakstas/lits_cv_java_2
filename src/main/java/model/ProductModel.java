package model;

public class ProductModel {

    private Long id;
    private String index;
    private String name;
    private String manufacturer;
    private String url;
    private String url2;

    @Override
    public String toString() {
        return "ProductModel{" +
                "id=" + id +
                ", index='" + index + '\'' +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", url='" + url + '\'' +
                ", url2='" + url2 + '\'' +
                '}';
    }

    public ProductModel(Long id, String index, String name, String manufacturer, String url, String url2) {
        this.id = id;
        this.index = index;
        this.name = name;
        this.manufacturer = manufacturer;
        this.url = url;
        this.url2 = url2;
    }

    public String getUrl2() {
        return url2;
    }

    public void setUrl2(String url2) {
        this.url2 = url2;
    }

    public ProductModel(){

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


}



