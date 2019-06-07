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
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private UserService userService;




    @GetMapping(path = "/list")
    public List<User> findAll() {
        List<User> userList = userService.findAllUser();
        return userList;
    }

    @PostMapping(value= "/add")
    public User createUserInToDB(@ModelAttribute("user") User user){



        Optional<User> userWasCreated = this.userService.createUserInToDB(user);


        if(userWasCreated.isPresent()){
            return userWasCreated.get();

        }

        return null;
    }

    @PostMapping(path = "/update")
    public User updateUserInToDB(@ModelAttribute("user") User user){


        Optional<User> userWasUpdated = this.userService.updateUser(user);


        if(userWasUpdated.isPresent()){
            return userWasUpdated.get();

        }

        return null;
    }

    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public String deleteUserLine(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return "User was deleted";

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
    public UserRegistrationResponse registration(HttpServletRequest httpRequest,
                                                 HttpServletResponse httpResponse,
                                                 Locale locale, @Valid @RequestBody UserRegistrationRequest request, BindingResult bindingResult) {

        UserRegistrationResponse response = new UserRegistrationResponse();

        if (bindingResult.hasErrors()) {
            ObjectError error = bindingResult.getAllErrors().get(0);
            String messageKey = error.getDefaultMessage().substring(1,
                    error.getDefaultMessage().indexOf("}"));

            String errorMessage = messageSource.getMessage(messageKey, new Object[]{request.getPassword()}, locale);

            response.setErrorMessage(errorMessage);

        } else {
            userService.registerUser(request);
            String successMessage = messageSource.getMessage("autoparts.validation.message.step1.done",
                    new Object[]{request.getEmail()}, locale);
            response.setSuccessMessage(successMessage);
        }

        return response;
    }
}
