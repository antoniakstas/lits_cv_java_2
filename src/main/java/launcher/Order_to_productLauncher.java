package launcher;

import dal.Order_to_productDalImp;
import dto.Order_to_product;

import java.util.List;

public class Order_to_productLauncher {

	public static void main(String[] args) {

		Order_to_productDalImp order_to_productDalImp = new Order_to_productDalImp();

		List<Order_to_product> order_to_productList = order_to_productDalImp.readAllFromDB();

		order_to_productList.stream().forEach(x -> System.out.println(x));

	}
}
