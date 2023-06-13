package com.cursusVrUnit.pages;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PasswordPage extends BasePage {

    @FindBy(id = "id_old_password")
    public WebElement oldPasswordTextBox;

    @FindBy(id = "id_new_password1")
    public WebElement newPasswordTextBox;

    @FindBy(id = "id_new_password2")
    public WebElement newPasswordConfirmationTextBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButton;
}
