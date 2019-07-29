package service;

import dal.UserDal;
import dto.User;
import model.UserRegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
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
    @Transactional
    public List<User> readAllFromDBById(Integer IdValue) {
        List<User> userList = userDal.readAllFromDBById(IdValue);
        return userList;
    }

    @Override
    @Transactional
    public List<User> readAllFromDBByName(String userName){
        List<User> userList= userDal.readAllFromDBByName(userName);
        return userList;
    }





    @Override
    public boolean confirmUserRegistration(String username, String password, String email) {
        return false;
    }

    @Override
    public Integer readUserIdByName(String userName) {

    return userDal.readUserIdByName(userName);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<User> userList= userDal.readAllFromDBByName(s);
        List<GrantedAuthority> authorities = new ArrayList<>();
        SimpleGrantedAuthority  authority = new SimpleGrantedAuthority(userList.get(0).getRole());

        authorities.add(authority);
        org.springframework.security.core.userdetails.User springUser =
                new org.springframework.security.core.userdetails.User(userList.get(0).getName(),userList.get(0).getPassword(),authorities);
        return springUser;
    }
}
