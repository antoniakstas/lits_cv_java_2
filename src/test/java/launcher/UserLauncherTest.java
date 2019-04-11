package launcher;

import dal.UserDalImp;
import org.junit.Assert;
import org.junit.Test;

public class UserLauncherTest {

	@Test
	public void testCountOfUsers(){
		UserDalImp userDal = new UserDalImp();

		Assert.assertEquals(userDal.readAllFromDB().size(), 9);
	}
}
