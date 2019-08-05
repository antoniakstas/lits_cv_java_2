package model;

import java.util.List;

public class ProductWithPricesResponse extends ProductModel{
    List<PriceModel> priceModels;

    public ProductWithPricesResponse(){

    }
    public ProductWithPricesResponse(Long id, String index, String name, String manufacturer, String url, String url2, List<PriceModel> priceModels) {
        super(id, index, name, manufacturer, url,url2);
        this.priceModels = priceModels;
    }

    public List<PriceModel> getPriceModels() {
        return priceModels;
    }

    public void setPriceModels(List<PriceModel> priceModels) {
        this.priceModels = priceModels;
    }
}
