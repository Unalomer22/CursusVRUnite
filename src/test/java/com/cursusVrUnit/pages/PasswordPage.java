package com.cursusVrUnit.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PasswordPage extends BasePage {

    @FindBy(id = "id_old_password")
    public WebElement oldPasswordTextBox;

    @FindBy(id = "id_new_password1")
    public WebElement newPasswordTextBox;

    @FindBy(id = "id_new_password2")
    public WebElement newPasswordConfirmationTextBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButton;

    @FindBy(xpath = "//span[@class='text-danger']")
    public List<WebElement> sifreGuncellemeMesajiList;

    @FindBy(xpath = "//span[@class='text-danger']")
    public WebElement sifreGuncellemeMesaji;
}
