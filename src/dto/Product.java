package dto;

public class Product {

    private String code;
    private String name;
    private String manufacturer;
    private int count;


    public  Product(){

    }
    public Product(String name , String manufacturer, String code, int count) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.code = code;
        this.count = count;
    }

    public Product(String name, String manufacturer, String code) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.code = code;
    }


    public String getNameautoparts() {
        return name;
    }

    public void setNameautoparts(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getQuantity() {
        return count;
    }

    public void setQuantity(int count) {
        this.count = count;
    }


    @Override
    public String toString() { return "|" + name + "| "+ manufacturer + "| "+ code + "| " + count + "|\n";}





}



