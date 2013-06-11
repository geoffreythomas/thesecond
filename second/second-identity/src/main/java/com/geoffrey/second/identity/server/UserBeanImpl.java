package com.geoffrey.second.identity.server;

import java.util.GregorianCalendar;

import org.apache.log4j.Logger;

import com.geoffrey.second.identity.UserDTO;
import com.geoffrey.second.identity.client.UserBean;

public class UserBeanImpl implements UserBean {

    private static final long serialVersionUID = -5469068509021751946L;

    private static Logger logger = Logger.getLogger(UserBeanImpl.class);

    public String listUsers() {
        return "[Polgar, Judit -" + GregorianCalendar.getInstance().getTime()
                + "]," + "[Kramnik, Vladamir -"
                + GregorianCalendar.getInstance().getTime() + "].";
    }

    public void addUser(UserDTO userDTO) {
        logger.info("Entering addUser");
        logger.info(userDTO.getFirstName());
        logger.info("Exiting addUser");
    }

    public void addUsers() {

    }

    public void updateUser() {

    }

    public void deleteUser() {

    }

    public void deleteUsers() {

    }

    public void getUserByID() {

    }

}
