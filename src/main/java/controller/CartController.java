package controller;


import crunchify.com.tutorials.CrunchifyEmailAPI;
import dto.*;
import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
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

//    @GetMapping(value = "/delete")
//    public void deleteLine(Long id) {
//
//        Optional<Cart> optionalCart = this.cartService.deleteLine(id);
//    }

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

        ModelAndView modelAndView = new ModelAndView("thanksForRegistration");
        modelAndView.addObject("currentUserName", username);
        modelAndView.addObject("orderListToHtml", orderList);
        modelAndView.addObject("orderListWithCartItemsToHtml", orderListExtended);
        return modelAndView;
    }

    @GetMapping(path = "/emptyCart")
    public ModelAndView emptyCartPage() {
        List<CartResponse> response = new ArrayList<>();

        Integer summary = 0;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        Integer idUserName = userService.readUserIdByName(username);
        String status = "not worked out";
        List<Order> orderList = orderService.findOrderByUserCId(idUserName, status);

        if (orderList.isEmpty()) {
            ModelAndView modelAndViewempty = new ModelAndView("cartIsEmpty");
            return modelAndViewempty;
        } else {
            Integer orderid = orderList.get(0).getId();

            List<Cart> cartListList = cartService.readFromDBByOrderId(orderid);
            for (Cart cartItem : cartListList) {
                CartResponse cartResponse = new CartResponse();
                cartResponse.setCount(cartItem.getProduct_count());
                Long priceItemByCart = Long.valueOf(cartItem.getPrice_id());
                String urlDelete = "http://localhost:8880/application/cart/emptyCart/deleteCart?cartId=" + cartItem.getId();
                String urlUpdate = "http://localhost:8880/application/cart/emptyCart/updateCart?cartId=" + cartItem.getId();

                cartResponse.setDeleteUrl(urlDelete);
                cartResponse.setUpdateUrl(urlUpdate);

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
                summary = (cartResponse.getCount() * cartResponse.getPrice()) + summary;
            }

            String urlSubmitCart = "http://localhost:8880/application/cart/emptyCart/submitCart?orderId=" + orderid;

            ModelAndView modelAndView = new ModelAndView("cartByUserName");
            modelAndView.addObject("response", response);
            modelAndView.addObject("response2", summary);
            modelAndView.addObject("urLSubmit", urlSubmitCart);

            return modelAndView;
        }


    }

    @GetMapping(path = "/addToCart")
    public ModelAndView addProductToCart(Integer priceId) {
        ModelAndView modelAndView = new ModelAndView("cart");

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        Integer userId = userService.readUserIdByName(username);

        String status = "not worked out";

        List<Order> orderList = orderService.findOrderByUserCId(userId, status);

        if (orderList.isEmpty()) {
            Order order = new Order(1, status, 1, userId);
            orderService.createOrderInToDB(order);
            Cart cart1 = new Cart(null, order.getId(), 1, priceId);
            cartService.createCart(cart1);
        } else {
            Order curentOrder = orderList.get(0);
            Integer orderId = curentOrder.getId();

            Cart cartItem = cartService.readByOrderIdAndPriceId(orderId, priceId);
            if (cartItem == null) {
                Cart cart = new Cart(null, curentOrder.getId(), 1, priceId);
                cartService.createCart(cart);
            } else {
                Integer newProductCount = cartItem.getProduct_count() + 1;
                cartItem.setProduct_count(newProductCount);
                cartService.updateCart(cartItem);
            }

        }

        return new ModelAndView("redirect:/cart/emptyCart");

    }

    @GetMapping(path = "/emptyCart/submitCart")
    public ModelAndView SubmitCart(Integer orderId) {

        String urlSubmitCart = "http://localhost:8880/application/cart/emptyCart/submitCart?orderId=" + orderId;


        orderService.updateOrderStatus(orderId);

        String congratulations = "Congratulations! Order with number " + orderId + " was confirm.";
        ModelAndView modelAndView = new ModelAndView("orderConfirm");
        modelAndView.addObject("text", congratulations);

        String crunchifyConfFile = "email-bean.xml";
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(crunchifyConfFile);
        CrunchifyEmailAPI crunchifyEmailAPI = (CrunchifyEmailAPI) context.getBean("crunchifyEmail");

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        List<User> userList = userService.readAllFromDBByName(username);
        String toAddr = userList.get(0).getEmail();
        String fromAddr = "ilia97ap76@gmail.com";
        String subject = "AutoParts Order";
        String body = "Thank you. Order number " + orderId + " was confirmed. ";
        crunchifyEmailAPI.crunchifyReadyToSendEmail(toAddr, fromAddr, subject, body);

        String bodyForManager = "New Order! Order number " + orderId + " was confirmed by " + userList.get(0).getName() +
                " , " + userList.get(0).getEmail();
        crunchifyEmailAPI.crunchifyReadyToSendEmail(fromAddr, fromAddr, subject, bodyForManager);

        return modelAndView;

    }

    @GetMapping(path = "/emptyCart/deleteCart")
    public ModelAndView DeleteCart(Integer cartId) {

        cartService.deleteLine(cartId);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Integer idUserName = userService.readUserIdByName(username);
        String status = "not worked out";
        List<Order> orderList = orderService.findOrderByUserCId(idUserName, status);
        Integer orderid = orderList.get(0).getId();
        List<Cart> cartListList = cartService.readFromDBByOrderId(orderid);
        if (cartListList.isEmpty()) {
            orderService.deleteLine(orderid);
            ModelAndView modelAndViewempty = new ModelAndView("cartIsEmpty");
            return modelAndViewempty;
        } else {

            return new ModelAndView("redirect:/cart/emptyCart");

        }
    }

    @GetMapping(path = "/emptyCart/updateCart")
    public ModelAndView updateCart(Integer cartId) {

//        CartModel cartModel = new CartModel();
        CartModelCount cartModelCount = new CartModelCount();

        String urlSubmitCartItem = "http://localhost:8880/application/cart/emptyCart/submitCart?oardId=" + cartId;

        ModelAndView modelAndView = new ModelAndView("updateCartItem");
        modelAndView.addObject("cartModel", cartModelCount);
//        modelAndView.addObject("submit", urlSubmitCartItem);
        return modelAndView;

        }

    @PostMapping(path ="/updateCartItem")
    public ModelAndView Submit(Integer cartModelCount) {
//        ModelAndView modelAndView = new ModelAndView();

//        model.getProduct_count();
//        Cart cart = new Cart(1, model.getOrder_id(), model.getOrder_id(), model.getPrice_id());
//        productService.createProductInToDB(product);
//        String fileName =
//                fileStorageService.storeFileFromProducts(file, product.getId());
        return new ModelAndView("redirect:/cart/emptyCart");
    }




}