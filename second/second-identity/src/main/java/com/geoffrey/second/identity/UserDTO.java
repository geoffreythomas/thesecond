package com.geoffrey.second.identity;

import java.io.Serializable;

public class UserDTO implements Serializable {

    private static final long serialVersionUID = -6408145602004754026L;

    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
