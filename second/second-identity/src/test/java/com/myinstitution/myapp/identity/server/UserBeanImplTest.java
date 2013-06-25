package com.myinstitution.myapp.identity.server;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.myinstitution.myapp.identity.client.UserBean;

public class UserBeanImplTest {
    UserBean userBean;

    @BeforeClass
    public void setUp() {
        userBean = new UserBeanImpl();
    }

    @Test(groups = { "Test_P0" })
    public void listUsers_success_Test() {
        String listUsers = userBean.listUsers();
        assert listUsers.contains("Polgar, Judit");
        assert listUsers.contains("Kramnik, Vladamir");
    }
}
