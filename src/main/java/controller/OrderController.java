package controller;

import model.AddToOrderModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/order")
public class OrderController {

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
}
