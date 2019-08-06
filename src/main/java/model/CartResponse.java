package model;

public class CartResponse {
    private String index;
    private String name;
    private String manufacturer;
    private Integer price;
    private String deliverydays;
    private Integer count;
    private String deleteUrl;
    private String updateUrl;
    private String confirmUrl;

    public CartResponse(){

    }
    public CartResponse(String index, String name, String manufacturer, Integer price, String deliverydays, Integer count, String deleteUrl, String updateUrl, String confirmUrl) {
        this.index = index;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.deliverydays = deliverydays;
        this.count = count;
        this.deleteUrl = deleteUrl;
        this.updateUrl = updateUrl;
        this.confirmUrl = confirmUrl;
    }

    public String getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Integer getPrice() {
        return price;
    }

    public String getDeliverydays() {
        return deliverydays;
    }

    public Integer getCount() {
        return count;
    }

    public String getDeleteUrl() {
        return deleteUrl;
    }

    public String getUpdateUrl() {
        return updateUrl;
    }

    public String getConfirmUrl() {
        return confirmUrl;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setDeliverydays(String deliverydays) {
        this.deliverydays = deliverydays;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setDeleteUrl(String deleteUrl) {
        this.deleteUrl = deleteUrl;
    }

    public void setUpdateUrl(String updateUrl) {
        this.updateUrl = updateUrl;
    }

    public void setConfirmUrl(String confirmUrl) {
        this.confirmUrl = confirmUrl;
    }

    @Override
    public String toString() {
        return "CartResponse{" +
                "index='" + index + '\'' +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", deliverydays='" + deliverydays + '\'' +
                ", count=" + count +
                ", deleteUrl='" + deleteUrl + '\'' +
                ", updateUrl='" + updateUrl + '\'' +
                ", confirmUrl='" + confirmUrl + '\'' +
                '}';
    }
}
