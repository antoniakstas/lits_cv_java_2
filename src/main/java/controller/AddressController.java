package controller;

import model.AddressListResponseModel;
import model.AddressResponseModel;
import model.UserModel;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/address")
class AddressController {

    @GetMapping(path = "/list")
    public AddressListResponseModel findAll() {
        AddressListResponseModel responseModel = new AddressListResponseModel();

        AddressResponseModel element1 = new AddressResponseModel();
        AddressResponseModel element2 = new AddressResponseModel();
        List<AddressResponseModel> addressResponseModels = new ArrayList<>();

        addressResponseModels.add(element1);
        addressResponseModels.add(element2);

        responseModel.setAddressResponseModels(addressResponseModels);

        return responseModel;
    }


    @PostMapping(path = "/create")
    @ResponseBody
    public UserModel createUser(
            @RequestBody UserModel userModel) {
        System.out.println("I'm in the POST method!");

        return new UserModel(123, "anotherName", "urlFromPost");
    }


    @GetMapping(path = "/item")
    public AddressResponseModel findItem(Integer id) {
        AddressResponseModel responseModel = new AddressResponseModel();


        return responseModel;
    }

    @PostMapping(path = "/item")
    public AddressResponseModel createItem(@Valid @RequestBody AddressResponseModel model, BindingResult bindingResult) {
        bindingResult.hasErrors();
        AddressResponseModel responseModel = new AddressResponseModel();


        return responseModel;
    }


}