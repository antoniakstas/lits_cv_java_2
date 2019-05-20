package service;

import model.UserRegistrationRequest;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    static  {
        System.out.println("here");
    }

    @Override
    public boolean registerUser(UserRegistrationRequest requestData) {
//  TODO:
//   userDal.createUser()
//        if ok then send email
//                emailService.send


        return true;
    }

    @Override
    public boolean confirmUserRegistration(String username, String password, String email) {
        return false;
    }
}
