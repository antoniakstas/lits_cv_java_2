package launcher;

import dal.Order_to_productDalImp;
import org.junit.Assert;
import org.junit.Test;

public class Order_to_productLauncherTest {

	@Test
	public void testCountOfOrder_to_product(){
		Order_to_productDalImp order_to_productDal = new Order_to_productDalImp();

		Assert.assertEquals(order_to_productDal.readAllFromDB().size(), 10);
	}
}
