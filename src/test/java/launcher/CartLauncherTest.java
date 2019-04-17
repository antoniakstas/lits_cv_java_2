package launcher;

import dal.CartDalImp;
import org.junit.Assert;
import org.junit.Test;

public class CartLauncherTest {

    @Test
    public void testCountOfCart() {
        CartDalImp cartDal = new CartDalImp();

        Assert.assertEquals(cartDal.readAllFromDB().size(), 10);
    }
}
