package service;

import dal.PriceDal;
import dto.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
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
