package launcher;

import dal.RoleDalImp;
import dto.Role;
import org.junit.Assert;
import org.junit.Test;

public class RoleLauncherTest {

	@Test
	public void testToTestApplicationTest(){
		Assert.assertTrue(true);
	}

	@Test
	public void testCountsOfRoles(){
		RoleDalImp roleDalImp = new RoleDalImp();
		Assert.assertEquals(roleDalImp.readAllFromDB().size(),2);
	}

//	@Test
//	public void testReadFromDBById(){
//		RoleDalImp roleDalImp = new RoleDalImp();
//		roleDalImp.readFromDBById(2).isPresent();
//	}

}
