package service;

import dal.PriceDal;
import dto.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public class PriceServiceImpl implements PriceService{
    @Autowired
    @Qualifier(value = "priceDal")
    private PriceDal priceDal;


    @Override
    public List<Price> findAllPrice() {
        List<Price> priceList = priceDal.readAllFromDB();
        return priceList;
    }
}
