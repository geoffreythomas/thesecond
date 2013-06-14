package com.myinstitution.myapp.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.myinstitution.myapp.identity.UserDTO;
import com.myinstitution.myapp.identity.client.UserBean;
import com.myinstitution.myapp.logger.LoggerFactory;

@Controller
@RequestMapping("/identities.do")
public class IdentityController extends AbstractController {

    private static Logger logger = LoggerFactory
            .getLogger(IdentityController.class);

    @RequestMapping(params = "action=listAllUsers")
    public ModelAndView listAllUsers() {
        logger.info("Entering");
        logger.debug("testing debug");
        logger.error("testing error");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("identities", listUsers());
        ModelAndView modelAndView = new ModelAndView("listIdentities", map);
        logger.info("Exiting");
        return modelAndView;
    }

    @RequestMapping(params = "action=prepareAddUser")
    public ModelAndView prepareAddUser() {
        logger.info("Entering");
        ModelAndView modelAndView = new ModelAndView("addIdentity");
        logger.info("Exiting");
        return modelAndView;
    }

    @RequestMapping(params = "action=addUser")
    public String addUser(@ModelAttribute("userDTO") UserDTO dto) {
        logger.info("Entering");
        UserBean userBean = getUserBean();
        userBean.addUser(dto);
        logger.info("Exiting");
        return "redirect:identities.do?action=listAllUsers";
    }

    public static String listUsers() {
        logger.info("Entering");
        UserBean userBean = getUserBean();
        String users = userBean.listUsers();
        logger.info("Users: " + users);
        logger.info("Exiting");
        return users;
    }

    @RequestMapping(params = "action=magic")
    public ModelAndView magic() {
        logger.info("Entering");
        ModelAndView modelAndView = new ModelAndView("magic");
        logger.info("Exiting");
        return modelAndView;
    }

    @RequestMapping(params = "action=home")
    public ModelAndView home() {
        logger.info("Entering");
        ModelAndView modelAndView = new ModelAndView("home");
        logger.info("Exiting");
        return modelAndView;
    }

    @RequestMapping(params = "action=test")
    public ModelAndView test() {
        logger.info("Entering");
        ModelAndView modelAndView = new ModelAndView("test");
        logger.info("Exiting");
        return modelAndView;
    }

    public static UserBean getUserBean() {
        logger.info("Entering");
        UserBean userBean;
        userBean = (UserBean) getBeanFactory().getBean(UserBean.BEAN_ID);
        logger.info("Exiting");
        return userBean;
    }
}
