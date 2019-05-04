package controller;

import model.UserModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
class AddressController {

    @GetMapping(path = "/list")
    public UserModel findAll() {
        System.out.println("I'm in the GET method!");
        UserModel userModel = new UserModel(123, " user name", "url");
        return userModel;
    }

    @PostMapping(path = "/create")
    @ResponseBody
    public UserModel createUser(
            @RequestBody UserModel userModel) {
        System.out.println("I'm in the POST method!");

        return new UserModel(123, "anotherName", "urlFromPost");
    }

}