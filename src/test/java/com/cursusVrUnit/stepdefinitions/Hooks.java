package com.cursusVrUnit.stepdefinitions;


import com.cursusVrUnit.utilities.BrowserUtils;
import com.cursusVrUnit.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.BeforeStep;
import org.openqa.selenium.remote.Browser;

public class Hooks {

    @BeforeStep
    public void setUp(){
        BrowserUtils.waitFor(2);
    }

    @After
    public void tearDown(){
        Driver.closeDriver();
    }


}
