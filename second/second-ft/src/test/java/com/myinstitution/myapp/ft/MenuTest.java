package com.myinstitution.myapp.ft;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.myinstitution.myapp.view.AbstractPage;
import com.myinstitution.myapp.view.CommonPage;

public class MenuTest extends AbstractTest {
    @Test
    public void homePage_menu_Test() {
        String menuLabel = ((CommonPage) page).retrieveMainMenu_Level0_Home();
        Assert.assertEquals(menuLabel, "Home");
        menuLabel = ((CommonPage) page).retrieveMainMenu_Level0_ManageUsers();
        Assert.assertEquals(menuLabel, "Manage Users");
    }

    @Override
    public AbstractPage obtainTestPage() {
        AbstractPage page = new CommonPage();
        return page;
    }
}
