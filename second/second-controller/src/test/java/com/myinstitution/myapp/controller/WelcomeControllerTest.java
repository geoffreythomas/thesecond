package com.myinstitution.myapp.controller;

import org.springframework.web.servlet.ModelAndView;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WelcomeControllerTest {

    // private MockHttpServletRequest request;
    // private MockHttpServletResponse response;
    private WelcomeController controller;

    @BeforeClass
    public void setUp() {
        controller = new WelcomeController();
    }

    @Test(groups = { "Test_P0" })
    public void magic_success_Test() {
        ModelAndView modelAndView = controller.magic();
        assert "magic".equals(modelAndView.getViewName());
    }
}
