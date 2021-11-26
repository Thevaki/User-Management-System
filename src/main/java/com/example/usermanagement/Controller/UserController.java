package com.example.usermanagement.Controller;

import com.example.usermanagement.Model.UserModel;
import com.example.usermanagement.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

/* Controller class to perform CRUD operations*/
@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    UserService userService;

    //create a new user
    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public UserModel createUser(@RequestBody UserModel user) {
        if (user == null) {
            throw new NoSuchElementException();
        }
        return userService.createUser(user);
    }

    //edit user details (except id) of an existing user
    @RequestMapping(value = "/editUserDetails/{id}", method = RequestMethod.PUT)
    public UserModel editUser(@PathVariable("id") Integer id, @RequestBody UserModel user) {
        if (id == null) {
            throw new IllegalArgumentException();
        }

        UserModel existingUser = userService.findById(id);

        if (existingUser == null) {
            throw new NoSuchElementException();
        }
        existingUser.setUsername(user.getUsername());
        existingUser.setAddress(user.getAddress());
        existingUser.setEmail(user.getEmail());
        return userService.editUser(existingUser);
    }

    //delete an existing user based on the given user id
    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
    public UserModel deleteUser(@PathVariable("id") Integer id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }

        return userService.deleteUser(id);
    }

    //find an existing user based on the given user id
    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public UserModel findById(@PathVariable("id") Integer id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }

        return userService.findById(id);
    }

    //find all the users in the database
    @RequestMapping(value = "/fetchAllUsers", method = RequestMethod.GET)
    public List<UserModel> fetchAllUsers() {
        return userService.fetchAllUsers();
    }

}
