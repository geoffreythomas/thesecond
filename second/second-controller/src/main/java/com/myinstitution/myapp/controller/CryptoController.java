package com.myinstitution.myapp.controller;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.myinstitution.myapp.logger.LoggerFactory;

@Controller
@RequestMapping("/crypto.do")
public class CryptoController extends AbstractController {

    private static Logger logger = LoggerFactory
            .getLogger(CryptoController.class);

    @RequestMapping(params = "action=prepareCryptoHome")
    public ModelAndView prepareCryptoHome() {
        logger.info("Entering");
        ModelAndView modelAndView = new ModelAndView("cryptoHome");
        logger.info("Exiting");
        return modelAndView;
    }
}
