package com.myinstitution.myapp.controller;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.myinstitution.myapp.logger.LoggerFactory;

@Controller
@RequestMapping("/welcome.do")
public class WelcomeController extends AbstractController {

    private static Logger logger = LoggerFactory
            .getLogger(WelcomeController.class);

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
}
