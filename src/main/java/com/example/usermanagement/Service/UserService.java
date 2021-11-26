package com.example.usermanagement.Service;

import com.example.usermanagement.Model.UserModel;

import java.util.List;

public interface UserService {
    UserModel createUser(UserModel user);

    UserModel editUser(UserModel user);

    UserModel deleteUser(Integer id);

    UserModel findById(Integer id);

    List<UserModel> fetchAllUsers();
}
