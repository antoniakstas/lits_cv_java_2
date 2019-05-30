package service;

import dto.Price;

import java.util.List;

public interface PriceService {



    public boolean createPriceInToDB(Price price);

    List<Price> findAllPrice();
}
