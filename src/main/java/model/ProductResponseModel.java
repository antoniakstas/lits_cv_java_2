package model;

import dto.Product;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@ApiModel
public class ProductResponseModel {

    @NotNull(message = "Please provide index")
    @Size(min=3, max=50)
    @ApiModelProperty(notes = "index of the product")
    private String index;

    @NotNull(message = "Please provide name of the product")
    @Size(min=3, max=50)
    @ApiModelProperty(notes = "name of the product")
    private String name;

    @NotNull(message = "Please provide manufacturer of the product")
    @Size(min=3, max=50)
    @ApiModelProperty(notes = "manufacturer of the product")
    private String manufacturer;

    public ProductResponseModel() {
    }

    public ProductResponseModel(String index, String name, String manufacturer) {
        this.index = index;
        this.name = name;
        this.manufacturer = manufacturer;
    }

    public ProductResponseModel(Product product) {
        this.index = product.getIndex();
        this.name = product.getName();
        this.manufacturer = product.getManufacturer();

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
}
