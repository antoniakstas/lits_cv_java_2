package model;

import dto.Product;

import java.util.List;

public class ProductListResponseModel {
    private List<ProductResponseModel> productResponseModelList;

    public List<ProductResponseModel> getProductResponseModelList() {
        return productResponseModelList;
    }

    public void setProductResponseModelList(List<ProductResponseModel> productResponseModelList) {
        this.productResponseModelList = productResponseModelList;
    }
}
