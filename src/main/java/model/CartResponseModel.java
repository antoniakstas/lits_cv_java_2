package model;
//TODO: rename fields
public class CartResponseModel {

        Integer order_id;
        Integer product_count;
        Integer  price_id;

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
    }

