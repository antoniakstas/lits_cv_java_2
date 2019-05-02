package model;

public class ProductModel {

    private int id;
    private String index;
    private String name;
    private String manufacturer;
    private int count;
    private  String url;


    public ProductModel(int id, String index, String name, String manufacturer, int count, String url) {
        this.id = id;
        this.index = index;
        this.name = name;
        this.manufacturer = manufacturer;
        this.count = count;
        this.url = url;
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
                ", count=" + count +
                ", url='" + url + '\'' +
                '}';
    }
}



