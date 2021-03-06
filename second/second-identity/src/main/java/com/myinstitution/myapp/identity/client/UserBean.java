package com.myinstitution.myapp.identity.client;

import java.io.Serializable;

import com.myinstitution.myapp.identity.UserDTO;

public interface UserBean extends Serializable {
    public static final String BEAN_ID = "UserBean";

    public void addUser(UserDTO userDTO);

    public void addUsers();

    public void updateUser();

    public void deleteUser();

    public void deleteUsers();

    public void getUserByID();

    public String listUsers();
}
