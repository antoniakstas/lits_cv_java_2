package controller;

import dal.CartDal;
import dal.OrderDalImp;
import dto.*;
import model.AddToOrderModel;
import model.CartResponse;
import model.OrderModel;
import org.hibernate.engine.spi.IdentifierValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.*;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PriceService priceService;

    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;
    @GetMapping("/addToCart")
    public ModelAndView addToOrderModel(Model model){
        Integer orderId = 123;
        Integer numberOfProductsInCartfromDB = 5;
        AddToOrderModel addToOrderModel = new AddToOrderModel();
        model.addAttribute(addToOrderModel);
        ModelAndView mAV = new ModelAndView("productGoingToBeAdded",
                "numberOfProductsInCartfromDB",
                numberOfProductsInCartfromDB);
        return mAV;
    }

    @PostMapping("/addToCartSuccess")
    public ModelAndView addToOrderModelSuccess(@ModelAttribute AddToOrderModel addToOrderModel){
        Integer orderId = 123;
        Integer numberOfProductsInCartfromDB = 5;


        ModelAndView mAV = new ModelAndView("productWasAddedToCart",
                "numberOfProductsInCartfromDB",
                numberOfProductsInCartfromDB);
        return mAV;
    }
    @GetMapping(path = "/list")
    public List<Order> findAll() {


        List<Order> orderList = orderService.findAllOrder();

        return orderList;
    }

    @GetMapping(path = "/listById")
        public ModelAndView findItem(Integer orderId) {

        List<CartResponse> response = new ArrayList<>();

        Integer summary = 0;



        List<Cart> cartListList = cartService.readFromDBByOrderId(orderId);



        for (Cart cartItem : cartListList) {
            CartResponse cartResponse = new CartResponse();
            cartResponse.setCount(cartItem.getProduct_count());
            Long priceItemByCart = Long.valueOf(cartItem.getPrice_id());

            List<Price> allPriceByProductId =
                    priceService.readAllFromDBByPriceId(priceItemByCart);

            for (Price priceItem : allPriceByProductId) {
                cartResponse.setPrice((int) (priceItem.getValue() * priceItem.getMult()));
                cartResponse.setDeliverydays(priceItem.getDeliverydays());
                Long productItemByPrice = priceItem.getProductId();
                Product productByProductId =
                        productService.findById(productItemByPrice);
                cartResponse.setIndex(productByProductId.getIndex());
                cartResponse.setName(productByProductId.getName());
                cartResponse.setManufacturer(productByProductId.getManufacturer());
            }
            response.add(cartResponse);
            summary = (cartResponse.getCount()*cartResponse.getPrice())+summary;
        }
        ModelAndView modelAndView = new ModelAndView("orderById");

        modelAndView.addObject("response", response);
        modelAndView.addObject("response2", summary);

        String urlCloseOrder = "http://localhost:8880/application/order/listById?orderId=" + orderId;

        modelAndView.addObject("urlCloseOrder", urlCloseOrder);
        return modelAndView;
    }

    ModelAndView modelAndView = new ModelAndView("ordersPage");


    @GetMapping(path = "/ordersPage")
    public ModelAndView ordersPage() {

        List<Order> orderList = orderService.findAllOrder();

        ModelAndView modelAndView = new ModelAndView("orderPage");
        List<OrderModel> orderModels = new ArrayList<>();
        for (Order order: orderList ){
            OrderModel orderModel = new OrderModel();
            orderModel.setId(order.getId());
            orderModel.setStatus(order.getStatus());
            orderModel.setUser_m_id(order.getUserMId());
            orderModel.setUser_c_id(order.getUserCId());
            orderModel.setUrl("http://localhost:8880/application/order/listById?orderId=" + order.getId() );
            orderModels.add(orderModel);

        }
                modelAndView.addObject("ordersList",orderModels );

        return modelAndView;
    }

}