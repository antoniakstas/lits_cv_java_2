package model;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


//TODO: rename fields
public class CartResponseModel {

    @NotNull(message = "Please provide id")
    @Size(min=1, max=30)
    @ApiModelProperty(notes = "id of the cart")
    Integer id;

    @NotNull(message = "Please provide order_id")
    @Size(min=1, max=30)
    @ApiModelProperty(notes = "order_id of the cart")
    Integer order_id;

    @NotNull(message = "Please provide product_count")
    @Size(min=1, max=30)
    @ApiModelProperty(notes = "product_count of the cart")
    Integer product_count;

    @NotNull(message = "Please provide price_id")
    @Size(min=1, max=30)
    @ApiModelProperty(notes = "price_id of the cart")
    Integer  price_id;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getProduct_count() {
        return product_count;
    }

    public void setProduct_count(Integer product_count) {
        this.product_count = product_count;
    }

    public Integer getPrice_id() {
        return price_id;
    }

    public void setPrice_id(Integer price_id) {
        this.price_id = price_id;
    }
}

