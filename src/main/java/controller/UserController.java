package controller;


import dal.UserDalImp;
import dto.User;
import model.ResponseModel;
import model.UserModel;
import model.UserRegistrationRequest;
import model.UserRegistrationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping(path = "/list")
    public List<User> findAll() {
        System.out.println("I'm in the GET method!");
        UserModel userModel = new UserModel(123, " user name", "url");
        UserDalImp dal = new UserDalImp();
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

    @PostMapping("/registration")
    public UserRegistrationResponse registration(Locale locale, @Valid @RequestBody UserRegistrationRequest request, BindingResult bindingResult) {
        bindingResult.hasErrors();
        UserRegistrationResponse response = new UserRegistrationResponse();

        String errorMessage = messageSource.getMessage("autoparts.validation.messsage.example", new Object[]{"some value"}, locale);

        response.setErrorMessage(errorMessage);
        return response;
    }
}
