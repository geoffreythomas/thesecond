package com.myinstitution.myapp.identity.server;

import java.util.GregorianCalendar;

import org.slf4j.Logger;

import com.myinstitution.myapp.identity.UserDTO;
import com.myinstitution.myapp.identity.client.UserBean;
import com.myinstitution.myapp.logger.LoggerFactory;

public class UserBeanImpl implements UserBean {

    private static final long serialVersionUID = -5469068509021751946L;

    private static Logger logger = LoggerFactory.getLogger(UserBeanImpl.class);

    public String listUsers() {
        return "[Polgar, Judit -" + GregorianCalendar.getInstance().getTime()
                + "]," + "[Kramnik, Vladamir -"
                + GregorianCalendar.getInstance().getTime() + "].";
    }

    public void addUser(UserDTO userDTO) {
        logger.info("Entering addUser");
        logger.info(userDTO.getFirstName());
        logger.info(userDTO.getLastName());
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
