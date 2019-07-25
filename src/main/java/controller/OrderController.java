package controller;

import dal.OrderDalImp;
import dto.Order;
import model.AddToOrderModel;
import model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

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
    public List<Order> findOrderById(Integer id) {


        List<Order> orderList = orderService.findOrderById(id);

        return orderList;
    }

    @GetMapping(path = "/ordersPage")
    public ModelAndView ordersPage() {

        List<Order> orderList = orderService.findAllOrder();

        ModelAndView modelAndView = new ModelAndView("orderPage");

        modelAndView.addObject("ordersList", orderList);

        return modelAndView;
    }

}