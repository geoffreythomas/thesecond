package com.myinstitution.myapp.view;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {
    public void initSelenium(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
