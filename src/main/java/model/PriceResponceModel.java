package model;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PriceResponceModel {

    @NotNull(message = "Please provide id")
    @Size(min=3, max=50)
    @ApiModelProperty(notes = "id of the price")

    private int id;

    @NotNull(message = "Please provide product_id")
    @Size(min=3, max=50)
    @ApiModelProperty(notes = "product_id of the price")

    private int product_id;

    @NotNull(message = "Please provide value")
    @Size(min=3, max=50)
    @ApiModelProperty(notes = "value of the price")

    private int value;

    @NotNull(message = "Please provide mult")
    @Size(min=2, max=12)
    @ApiModelProperty(notes = "mult of the price")

    private int mult;

    @NotNull(message = "Please provide active")
    @Size(min=3, max=10)
    @ApiModelProperty(notes = "active of the price")

    private String active;

    @NotNull(message = "Please provide deliverydays")
    @Size(min=2, max=7)
    @ApiModelProperty(notes = "deliverydays of the price")

    private String deliverydays;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getMult() {
        return mult;
    }

    public void setMult(int mult) {
        this.mult = mult;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getDeliverydays() {
        return deliverydays;
    }

    public void setDeliverydays(String deliverydays) {
        this.deliverydays = deliverydays;
    }
}
