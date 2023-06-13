package com.cursusVrUnit.stepdefiniations;


import com.cursusVrUnit.utilities.Driver;
import io.cucumber.java.After;

public class Hooks {



    @After
    public void tearDown(){
        Driver.closeDriver();
    }


}
