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
        // TODO Auto-generated method stub

    }

    public void updateUser() {
        // TODO Auto-generated method stub

    }

    public void deleteUser() {
        // TODO Auto-generated method stub

    }

    public void deleteUsers() {
        // TODO Auto-generated method stub

    }

    public void getUserByID() {
        // TODO Auto-generated method stub

    }

}
