package dal;

import dto.Price;

import java.util.List;
import java.util.Optional;

public interface PriceDal {
    List<Price> readAllFromDB();

    Optional<Price> readFromDBById(int id);
    public void createPriceInToDB(Price price);

    boolean updatePrice(int id, Price price);

    boolean deletePrice(int id);


}
