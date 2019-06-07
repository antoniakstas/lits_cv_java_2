package service;

import dto.User;
import model.UserRegistrationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface UserService {


    public Optional<User> createUserInToDB(User user);

    List<User> findAllUser();

    public  Optional<User> updateUser(User user);

    public void deleteUser(Integer id);

    public boolean registerUser(UserRegistrationRequest requestData);


    // TODO: do this with security
    public boolean confirmUserRegistration(String username, String password, String email);

}
