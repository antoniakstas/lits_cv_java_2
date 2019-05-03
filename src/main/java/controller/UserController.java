package controller;


import model.UserModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping(path = "/list")
    public UserModel findAll() {
        System.out.println("I'm in the GET method!");
        UserModel userModel = new UserModel(123, " user name", "url");
        return userModel;
    }
}
