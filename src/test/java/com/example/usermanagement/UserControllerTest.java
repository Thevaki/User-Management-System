package com.example.usermanagement;

import com.example.usermanagement.Controller.UserController;
import com.example.usermanagement.Model.UserModel;
import com.example.usermanagement.Service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserControllerTest {

    protected MockMvc mvc;

    @InjectMocks
    UserController userController;

    @Mock
    private UserService userService;

    @Autowired
    private WebApplicationContext wac;

    @Test
    void testCreateUser() {
        // Setup mock repository
        UserModel userModel = new UserModel();
        userModel.setUserId(1);
        userModel.setUsername("abc");
        userModel.setEmail("abc@gmail.com");
        userModel.setAddress("10, abc road");

        doReturn(userModel).when(userService).createUser(userModel);

        // Execute the service call
        UserModel returnedUser = userController.createUser(userModel);

        // Assert the response
        Assertions.assertTrue(returnedUser.getUserId().equals(userModel.getUserId()));
        Assertions.assertTrue(returnedUser.getUsername().equals(userModel.getUsername()));
        Assertions.assertTrue(returnedUser.getAddress().equals(userModel.getAddress()));
        Assertions.assertTrue(returnedUser.getEmail().equals(userModel.getEmail()));
    }

    @Test
    public void fetchAllUsers() throws Exception {
        UserModel userModel = new UserModel();
        userModel.setUserId(1);
        userModel.setUsername("abc");
        userModel.setEmail("abc@gmail.com");
        userModel.setAddress("10, abc road");

        UserModel userModel2 = new UserModel();
        userModel2.setUserId(2);
        userModel2.setUsername("xyz");
        userModel2.setEmail("xyz@gmail.com");
        userModel2.setAddress("10, xyz road");

        List<UserModel> users = Arrays.asList(userModel, userModel2);

        when(userService.fetchAllUsers()).thenReturn(users);

        List<UserModel> returnedUsers = userController.fetchAllUsers();

        Assertions.assertEquals(2, users.size());
        //Assertions.assertEquals(userModel.getUserId().equals(returnedUsers.get(0).getUserId()));
    }

    @Test
    void testFindById() {
        // Setup mock repository
        UserModel userModel = new UserModel();
        userModel.setUserId(1);
        userModel.setUsername("abc");
        userModel.setEmail("abc@gmail.com");
        userModel.setAddress("10, abc road");
        doReturn(userModel).when(userService).findById(1);

        // Execute the service call
        UserModel returnedUser = userController.findById(1);

        // Assert the response
        Assertions.assertTrue(returnedUser.getUserId().equals(userModel.getUserId()));
        Assertions.assertTrue(returnedUser.getUsername().equals(userModel.getUsername()));
        Assertions.assertTrue(returnedUser.getAddress().equals(userModel.getAddress()));
        Assertions.assertTrue(returnedUser.getEmail().equals(userModel.getEmail()));
    }

    @Test
    void testEditUser() {
        // Setup mock repository
        UserModel userModel = new UserModel();
        userModel.setUserId(1);
        userModel.setUsername("abc");
        userModel.setEmail("abc@gmail.com");
        userModel.setAddress("10, abc road");

        doReturn(userModel).when(userService).editUser(userModel);
        doReturn(userModel).when(userService).findById(1);

        // Execute the service call
        UserModel returnedUser = userController.editUser(1, userModel);

        // Assert the response
        Assertions.assertTrue(returnedUser.getUserId().equals(userModel.getUserId()));
        Assertions.assertTrue(returnedUser.getUsername().equals(userModel.getUsername()));
        Assertions.assertTrue(returnedUser.getAddress().equals(userModel.getAddress()));
        Assertions.assertTrue(returnedUser.getEmail().equals(userModel.getEmail()));
    }

    @Test
    public void deleteApplication() throws Exception {
        UserModel userModel  = new UserModel();
        userModel.setUserId(1);
        userModel.setUsername("abc");
        userModel.setEmail("abc@gmail.com");
        userModel.setAddress("10, abc road");

        Mockito.when(userService.deleteUser(1)).thenReturn(userModel);
        //verify(userRepository).findById(1);
    }


}







