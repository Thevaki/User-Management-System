package com.example.usermanagement.Service;


import com.example.usermanagement.Model.UserModel;
import com.example.usermanagement.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    //create a new user with the provided user details
    public UserModel createUser(UserModel user) {
        return userRepository.save(user);
    }

    //edit user details based on the given user id
    public UserModel editUser(UserModel user) {
        return userRepository.save(user);
    }

    //delete a user based on the given user id
    public UserModel deleteUser(Integer id) {
        Optional<UserModel> user = userRepository.findById(id);

        if (user.isPresent()) {
            userRepository.deleteById(id);
            return user.get();
        }
        return null;
    }

    //find a user based on the given user id
    public UserModel findById(Integer id) {
        Optional<UserModel> user = userRepository.findById(id);

        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }

    //find all the existing users
    public List<UserModel> fetchAllUsers() {
        List<UserModel> users = userRepository.findAll();

        if (users.isEmpty()) {
            return null;
        }
        return users;
    }
}
