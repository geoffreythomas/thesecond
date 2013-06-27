package com.myinstitution.myapp.ft;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.myinstitution.myapp.view.AbstractPage;

public abstract class AbstractTest {
    AbstractPage page;
    WebDriver driver;

    public abstract AbstractPage obtainTestPage();

    @BeforeClass
    public void initTest() {
        driver = new FirefoxDriver();
        driver.get("http://localhost:8080/second-console");
        page = obtainTestPage();
        page.initSelenium(driver);
    }

    @AfterClass
    public void destroyTest() {
        driver.close();
    }
}
