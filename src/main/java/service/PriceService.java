package service;

import dto.Price;

import java.util.List;
import java.util.Optional;

public interface PriceService {



    public Optional<Price> createPriceInToDB(Price price);

    List<Price> findAllPrice();

    public  Optional<Price> updatePrice(Price price);

    public void deleteLine(Long id);

    public List<Price> readAllFromDBByProductId(Long productIdValue);



    }
