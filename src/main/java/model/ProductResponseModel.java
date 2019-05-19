package model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@ApiModel
public class ProductResponseModel {

    @NotNull(message = "please provide index")
    @Size(min=3, max=50)
    @ApiModelProperty(notes = "index of the product")
    private String index;

    @ApiModelProperty(notes = "name of the product")
    private String name;

    @ApiModelProperty(notes = "manufacturer of the product")
    private String manufacturer;

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
