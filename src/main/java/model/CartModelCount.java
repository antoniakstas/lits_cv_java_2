package model;

public class CartModelCount {

    private Integer productCount;

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public CartModelCount() {
    }

    @Override
    public String toString() {
        return "CartModelCount{" +
                "productCount=" + productCount +
                '}';
    }
}
