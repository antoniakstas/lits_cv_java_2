package dal;

import dto.Price;
import dto.User;

import java.util.List;
import java.util.Optional;

public interface PriceDal {
    List<Price> readAllFromDB();

    Optional<Price> readFromDBById(int id);

    boolean createPriceInToDB(User user);

    boolean updatePrice(int id, User user);

    boolean deletePrice(int id);

    public interface UserDal {

        List<Price> readAllFromDB();

        Optional<Price> readFromDBById(int id);

        boolean createPriceInToDB(Price user);

        boolean updatePrice(int id, Price user);

        boolean deletePrice(int id);
    }

}
