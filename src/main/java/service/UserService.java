package service;

import model.UserRegistrationRequest;
import org.springframework.stereotype.Service;


public interface UserService {

    public boolean registerUser(UserRegistrationRequest requestData);


    // TODO: do this with security
    public boolean confirmUserRegistration(String username, String password, String email);

}
