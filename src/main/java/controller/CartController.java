package controller;


import com.sun.xml.bind.v2.TODO;
import dto.*;
import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
class CartController {


    @Autowired
    private CartService cartService;


    @Autowired
    private OrderService orderService;
    @Autowired
    private PriceService priceService;
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    @GetMapping(path = "/read")
    public CartListResponseModel findItem(Long order_id) {
        CartListResponseModel responseModel = new CartListResponseModel();

        List<CartResponseModel> allCartByOrderId = cartService.findAllCartByOrderId(order_id);
        responseModel.setCartResponseModel(allCartByOrderId);


        return responseModel;
    }


    @GetMapping(path = "/list")
    public List<Cart> findAll() {
        List<Cart> allCarts = cartService.findAllCarts();
        return allCarts;

    }

    @PostMapping(value = "/add")
    public Cart createCart(@ModelAttribute("cart") Cart cart) {

        Optional<Cart> cartWasCreated = this.cartService.createCart(cart);


        if (cartWasCreated.isPresent()) {
            return cartWasCreated.get();

        }

        return null;
    }

    @PostMapping(value = "/update")
    public Cart updateCart(@ModelAttribute("cart") Cart cart) {

        Optional<Cart> cartWasUpdated = this.cartService.updateCart(cart);

        if (cartWasUpdated.isPresent()) {
            return cartWasUpdated.get();
        }

        return null;
    }

    @GetMapping(value = "/delete")
    public void deleteLine(Long id) {

        Optional<Cart> optionalCart = this.cartService.deleteLine(id);

    }

    @GetMapping(path = "/listToCart")
    public ModelAndView findAll1() {


        List<Order> orderList = orderService.findAllOrder();
        List<Cart> allCarts = cartService.findAllCarts();

        List<OrderModelWithCartItems> orderListExtended = new ArrayList<>();
        for (Order orderItem : orderList) {
            OrderModelWithCartItems item = new OrderModelWithCartItems();
            List<CartModel> cartsForOrder = new ArrayList<>();
            for (Cart cartItem : allCarts) {
                CartModel cmodel = new CartModel(cartItem.getId().intValue(), cartItem.getOrder_id(), cartItem.getProduct_count(), cartItem.getPrice_id());
                if (cartItem.getOrder_id() == orderItem.getId()) {
                    cartsForOrder.add(cmodel);
                }
            }
            item.setCartList(cartsForOrder);
            orderListExtended.add(item);
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();


//        System.out.println("I'm in the GET method!");
//        OrderModel orderModel = new OrderModel(123, " user name", 1, 2,"e");
//        OrderDalImp dal = new OrderDalImp();
//        dal.readAllFromDB();

        ModelAndView modelAndView = new ModelAndView("thanksForRegistration");
        modelAndView.addObject("currentUserName", username);
        modelAndView.addObject("orderListToHtml", orderList);
        modelAndView.addObject("orderListWithCartItemsToHtml", orderListExtended);


        return modelAndView;
    }

    @GetMapping(path = "/emptyCart")
    public ModelAndView emptyCartPage() {
        List<CartResponse> response = new ArrayList<>();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();


        List<User> allUserListByName = userService.readAllFromDBByName(username);
//        Integer getUserIdByName = allUserListByName.get(0).getId();
        //TODO: classcastex Integer
//        for (User userItem : allUserListByName) {
//            userItem.getId();
//        }

        Integer idUserName = 2;
        List<Order> orderList = orderService.findOrderById(idUserName);
        Integer orderid = orderList.get(0).getId();

        List<Cart> cartListList = cartService.readFromDBById(orderid);
        Long priceIdFromCart = Long.valueOf(cartListList.get(0).getPrice_id());

        for (Cart cartItem: cartListList){
            cartItem.getProduct_count();
        }
        List<Price> priceList = priceService.readAllFromDBByPriceId(priceIdFromCart);

//        Integer idUserName = SELECT id FROM lits_cv_java_2.user where name = 'username';

        ModelAndView modelAndView = new ModelAndView("cartIsEmpty");

        return modelAndView;
    }

    @GetMapping(path = "/addToCart")
    public ModelAndView addToCart() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        if (username == "user") {

        }

        ModelAndView modelAndView = new ModelAndView("cartIsEmpty");

        return modelAndView;


    }


}
