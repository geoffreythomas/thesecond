package com.myinstitution.myapp.ft;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.myinstitution.myapp.view.AbstractPage;
import com.myinstitution.myapp.view.HomePage;

public class HomePageTest extends AbstractTest {
    @Test
    public void homePage_Test() {
        String test = ((HomePage) page).retrieveMainMenu_Level0_Home();
        Assert.assertEquals(test, "Home");
    }

    @Override
    public AbstractPage obtainTestPage() {
        AbstractPage page = new HomePage();
        return page;
    }
}
