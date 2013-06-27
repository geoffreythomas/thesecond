package com.myinstitution.myapp.view;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends AbstractPage {

    @FindBy(how = How.ID_OR_NAME, using = "mainMenu_Level0_Home-btnInnerEl")
    WebElement mainMenu_Level0_Home;

    public String retrieveMainMenu_Level0_Home() {
        return mainMenu_Level0_Home.getText();
    }
}