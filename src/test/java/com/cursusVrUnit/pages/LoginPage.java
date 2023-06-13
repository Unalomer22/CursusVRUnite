package com.cursusVrUnit.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id = "id_username")
    public WebElement usernameTextbox;

    @FindBy(id = "id_password")
    public WebElement passwordTextbox;

    @FindBy(xpath = "//button[@class='login-btn']")
    public WebElement loginButton;

    @FindBy(xpath = "//a[text()='Forgot Password']")
    public WebElement forgotPassword;

    @FindBy(xpath = "//span[@class='text-danger']")
    public WebElement logInPageErrorMessage;
}
