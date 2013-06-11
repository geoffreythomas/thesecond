package com.geoffrey.second.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.geoffrey.second.identity.UserDTO;
import com.geoffrey.second.identity.client.UserBean;
import com.myinstitution.myapp.logger.LoggerFactory;

@Controller
@RequestMapping("/identities.do")
public class IdentityController {

    private static Logger logger = LoggerFactory
            .getLogger(IdentityController.class);

    @RequestMapping(params = "action=listAllUsers")
    public ModelAndView listAllUsers() {
        logger.info("Entering listAllUsers");
        logger.debug("testing");
        logger.error("testing error");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("identities", listUsers());
        ModelAndView modelAndView = new ModelAndView("listIdentities", map);
        logger.info("Exiting listAllUsers");
        return modelAndView;
    }

    @RequestMapping(params = "action=prepareAddUser")
    public ModelAndView prepareAddUser() {
        logger.info("Entering prepareAddUser");
        ModelAndView modelAndView = new ModelAndView("addIdentity");
        logger.info("Exiting prepareAddUser");
        return modelAndView;
    }

    @RequestMapping(params = "action=addUser")
    public String addUser(@ModelAttribute("userDTO") UserDTO dto) {
        logger.info("Entering addUser");
        UserBean userBean = getUserBean();
        userBean.addUser(dto);
        logger.info("Exiting addUser");
        return "redirect:identities.do?action=listAllUsers";
    }

    public static String listUsers() {
        logger.info("Entering listUsers");
        UserBean userBean = getUserBean();
        String users = userBean.listUsers();
        logger.info("Users: " + users);
        logger.info("Exiting listUsers");
        return users;
    }

    public static UserBean getUserBean() {
        UserBean userBean;
        userBean = (UserBean) getBeanFactory().getBean(UserBean.BEAN_ID);
        return userBean;
    }

    public static BeanFactory getBeanFactory() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "spring-identity.xml" });

        // an ApplicationContext is also a BeanFactory (via inheritance)
        BeanFactory factory = context;
        return factory;
    }
}
