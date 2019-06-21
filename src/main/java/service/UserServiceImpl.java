package service;

import dal.UserDal;
import dto.User;
import model.UserRegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier(value = "userDal")
    private UserDal userDal;

    @Override
    @Transactional
    public Optional<User> createUserInToDB(User user) {
        return Optional.of(this.userDal.createUserInToDB(user));
    }

    @Override
    @Transactional
    public List<User> findAllUser() {
        List<User> userList = userDal.readAllFromDB();

        return userList;
    }

    @Override
    @Transactional
    public Optional<User> updateUser(User user) {

        return Optional.of(this.userDal.updateUser(user));
    }

    @Override
    @Transactional
    public void deleteUser(Integer id) {
        userDal.deleteUser(id);

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

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
