package com.cursusVrUnit.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserPage extends BasePage {

    @FindBy(xpath = "//li[@class='ui dropdown']")
    public WebElement kullaniciIconu;

    @FindBy(xpath = "//a[text()='Sign Out']")
    public WebElement signOutButton;

    @FindBy(id = "logo")
    public WebElement cursusImg;
}
