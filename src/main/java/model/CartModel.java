package model;

public class CartModel {

	private Integer id;
	private Integer order_id;
	private Integer product_count;
	private Integer price_id;

	public CartModel(Integer id,
                     Integer order_id,
                     Integer product_count,
                     Integer price_id) {
		this.id = id;
		this.order_id = order_id;
		this.product_count = product_count;
		this.price_id = price_id;
	}

	public CartModel(int id, int order_id, int product_count, int price_id) {
	}

	public CartModel(int id, int order_id, int product_count, int price_id, String url) {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public Integer getProduct_count() {
		return product_count;
	}

	public void setProduct_count(Integer product_count) {
		this.product_count = product_count;
	}

	public Integer getPrice_id() {
		return price_id;
	}

	public void setPrice_id(Integer price_id) {
		this.price_id = price_id;
	}

	@Override
	public String toString() {
		return "Cart{" +
				"id=" + id +
				", order_id='" + order_id + '\'' +
				", product_count='" + product_count + '\'' +
				", price_id='" + price_id + '\'' +
				'}';
	}
}
