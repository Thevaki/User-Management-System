package com.example.usermanagement;

import com.example.usermanagement.Model.UserModel;
import com.example.usermanagement.Repository.UserRepository;
import com.example.usermanagement.Service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    void testCreateUser() {
        // Setup mock repository
        UserModel userModel  = new UserModel();
        userModel.setUserId(1);
        userModel.setUsername("abc");
        userModel.setEmail("abc@gmail.com");
        userModel.setAddress("10, abc road");

        doReturn(userModel).when(userRepository).save(userModel);

        // Execute the service call
        UserModel returnedUser = userService.createUser(userModel);

        // Assert the response
        Assertions.assertTrue(returnedUser.getUserId().equals(userModel.getUserId()));
        Assertions.assertTrue(returnedUser.getUsername().equals(userModel.getUsername()));
        Assertions.assertTrue(returnedUser.getAddress().equals(userModel.getAddress()));
        Assertions.assertTrue(returnedUser.getEmail().equals(userModel.getEmail()));
    }

    @Test
    void testFindById() {
        // Setup mock repository
        UserModel userModel  = new UserModel();
        userModel.setUserId(1);
        userModel.setUsername("abc");
        userModel.setEmail("abc@gmail.com");
        userModel.setAddress("10, abc road");
        doReturn(Optional.of(userModel)).when(userRepository).findById(1);

        // Execute the service call
        UserModel returnedUser = userService.findById(1);

        // Assert the response
        Assertions.assertTrue(returnedUser.getUserId().equals(userModel.getUserId()));
        Assertions.assertTrue(returnedUser.getUsername().equals(userModel.getUsername()));
        Assertions.assertTrue(returnedUser.getAddress().equals(userModel.getAddress()));
        Assertions.assertTrue(returnedUser.getEmail().equals(userModel.getEmail()));
    }

    void testFetchAll() {
        // Setup mock repository
        UserModel userModel  = new UserModel();
        userModel.setUserId(1);
        userModel.setUsername("abc");
        userModel.setEmail("abc@gmail.com");
        userModel.setAddress("10, abc road");

        UserModel userModel2  = new UserModel();
        userModel2.setUserId(2);
        userModel2.setUsername("xyz");
        userModel2.setEmail("xyz@gmail.com");
        userModel2.setAddress("10, xyz road");

        doReturn(Arrays.asList(userModel, userModel2)).when(userRepository).findAll();

        // Execute the service call
        List<UserModel> users = userService.fetchAllUsers();

        // Assert the response
        Assertions.assertEquals(2, users.size());
    }

    @Test
    void testEditUser() {
        // Setup mock repository
        UserModel userModel  = new UserModel();
        userModel.setUserId(1);
        userModel.setUsername("abc");
        userModel.setEmail("abc@gmail.com");
        userModel.setAddress("10, abc road");

        doReturn(userModel).when(userRepository).save(userModel);

        // Execute the service call
        UserModel returnedUser = userService.editUser(userModel);

        // Assert the response
        Assertions.assertTrue(returnedUser.getUserId().equals(userModel.getUserId()));
        Assertions.assertTrue(returnedUser.getUsername().equals(userModel.getUsername()));
        Assertions.assertTrue(returnedUser.getAddress().equals(userModel.getAddress()));
        Assertions.assertTrue(returnedUser.getEmail().equals(userModel.getEmail()));
    }

//    @Test
//    public void deleteApplication() throws Exception {
//        UserModel userModel  = new UserModel();
//        userModel.setUserId(1);
//        userModel.setUsername("abc");
//        userModel.setEmail("abc@gmail.com");
//        userModel.setAddress("10, abc road");
//
//        Mockito.when(userService.deleteUser(1)).thenReturn(userModel);
//        verify(userRepository).findById(1);
//    }

}
