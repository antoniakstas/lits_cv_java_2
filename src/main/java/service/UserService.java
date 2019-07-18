package service;

import dto.User;
import model.UserRegistrationRequest;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface UserService extends UserDetailsService {


    public Optional<User> createUserInToDB(User user);

    List<User> findAllUser();

    public  Optional<User> updateUser(User user);

    public void deleteUser(Integer id);

    public boolean registerUser(UserRegistrationRequest requestData);
    public List<User> readAllFromDBById(Integer IdValue);


    // TODO: do this with security
    public boolean confirmUserRegistration(String username, String password, String email);

}
