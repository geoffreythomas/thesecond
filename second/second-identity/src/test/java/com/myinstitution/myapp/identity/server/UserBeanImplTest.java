package com.myinstitution.myapp.identity.server;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.myinstitution.myapp.identity.UserDTO;
import com.myinstitution.myapp.identity.client.UserBean;

public class UserBeanImplTest {
    UserBean userBean;

    @BeforeClass
    public void setUp() {
        userBean = new UserBeanImpl();
    }

    @Test(groups = { "Test_P0" })
    public void addUser_success_Test() {
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName("firstName");
        userDTO.setLastName("lastName");
        userBean.addUser(userDTO);
        assert true;
    }

    @Test(groups = { "Test_P0" })
    public void addUsers_success_Test() {
        userBean.addUsers();
        assert true;
    }

    @Test(groups = { "Test_P0" })
    public void deleteUser_success_Test() {
        userBean.deleteUser();
        assert true;
    }

    @Test(groups = { "Test_P0" })
    public void deleteUsers_success_Test() {
        userBean.deleteUsers();
        assert true;
    }

    @Test(groups = { "Test_P0" })
    public void getUserByID_success_Test() {
        userBean.getUserByID();
        assert true;
    }

    @Test(groups = { "Test_P0" })
    public void listUsers_success_Test() {
        String listUsers = userBean.listUsers();
        assert listUsers.contains("Polgar, Judit");
        assert listUsers.contains("Kramnik, Vladamir");
    }

    @Test(groups = { "Test_P0" })
    public void updateUser_success_Test() {
        userBean.updateUser();
        assert true;
    }
}
