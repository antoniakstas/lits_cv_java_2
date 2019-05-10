package controller;


import dal.UserDalImp;
import dto.User;
import model.UserModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping(path = "/list")
    public List<User> findAll() {
        System.out.println("I'm in the GET method!");
        UserModel userModel = new UserModel(123, " user name", "url");
        UserDalImp dal = new UserDalImp();
        dal.readAllFromDB();
        return dal.readAllFromDB();
    }


    @GetMapping(path = "/listpage")
    public ModelAndView findAllPage() {
        System.out.println("I'm in the GET method!");
        UserModel userModel = new UserModel(123, " user name", "url");
        ModelAndView model = new ModelAndView("testPage");
        model.addObject("msg", "some message from Controller");

        return model;
    }

    @GetMapping("/listpage/create")
    public ModelAndView greetingForm(Model model) {
        UserModel userModel = new UserModel();
        userModel.setName("predefined name");
        model.addAttribute("userModel", userModel);

        ModelAndView modelAndView = new ModelAndView("createUser", "userModel", userModel);

        return modelAndView;
    }

    @PostMapping("/listpage/result")
    public String greetingSubmit(@ModelAttribute UserModel userModel) {
        return "createUserResult";
    }
}
