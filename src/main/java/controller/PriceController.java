package controller;

import model.PriceModel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/price")
public class PriceController {

    @GetMapping(path = "/list")
    public PriceModel findAll() {
        System.out.println("I'm in the GET method!");
        PriceModel priceModel = new PriceModel(1, 123, 43,2,"active", "4 days", "url");
        return priceModel;
    }

//
//    @GetMapping(path = "/listpage")
//    public ModelAndView findAllPage() {
//        System.out.println("I'm in the GET method!");
//        UserModel userModel = new UserModel(123, " user name", "url");
//        ModelAndView model = new ModelAndView("testPage");
//        model.addObject("msg", "some message from Controller");
//
//        return model;
//    }
}
