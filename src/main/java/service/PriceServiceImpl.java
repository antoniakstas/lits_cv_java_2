package service;

import dal.PriceDal;
import dal.ProductDal;
import dto.Price;
import dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PriceServiceImpl implements PriceService{
    @Autowired
    @Qualifier(value = "priceDal")
    private PriceDal priceDal;

    @Autowired
    @Qualifier(value = "productDal")
    private ProductDal productDal;


    @Override
    @Transactional
    public Optional<Price> createPriceInToDB(Price price) {
        int productIdFromPrice = price.getProductId();
        boolean productIdIsInDB = false;
        List<Product> productsList = productDal.readAllFromDB();
        for (Product productItem : productsList) {
            if (productIdFromPrice == productItem.getId()) {
                productIdIsInDB = true;
                break;
            }

        }

        if (productIdIsInDB) {

            return Optional.of(this.priceDal.createPriceInToDB(price));
        }
            return Optional.of(new Price());

    }


    @Override
    @Transactional
    public List<Price> findAllPrice() {
        List<Price> priceList = priceDal.readAllFromDB();
        return priceList;
    }

    @Override
    @Transactional
    public Optional<Price> updatePrice(Price price) {

            this.priceDal.updatePrice(price);
     return Optional.of(this.priceDal.updatePrice(price));
    }

    @Override
    @Transactional
    public void deleteLine(Long id) {
        priceDal.deleteLine(id);
    }


}



