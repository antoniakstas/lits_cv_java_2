package dal;

import dto.Price;

import java.util.List;
import java.util.Optional;

public interface PriceDal {
    List<Price> readAllFromDB();

    Optional<Price> readFromDBById(int id);

    public Price createPriceInToDB(Price price);

    boolean updatePrice1(int id, Price price);

    boolean deletePrice(int id);

    public Price updatePrice(Price price);

    public void deleteLine(Long id);


}
