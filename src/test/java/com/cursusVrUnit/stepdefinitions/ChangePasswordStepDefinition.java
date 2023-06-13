package com.cursusVrUnit.stepdefinitions;

import com.cursusVrUnit.pages.PasswordPage;
import com.cursusVrUnit.utilities.BrowserUtils;
import com.cursusVrUnit.utilities.ConfigurationReader;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;

public class ChangePasswordStepDefinition {

    Faker faker = new Faker();

    String password = faker.internet().password(8, 15, true, false, true);

    PasswordPage passwordPage = new PasswordPage();

    @And("Old Password text boxina {string} sifresi yazilir")
    public void oldPasswordTextBoxinaSifresiYazilir(String oldPassword) {
        BrowserUtils.waitFor(3);
        passwordPage.oldPasswordTextBox.sendKeys(ConfigurationReader.getProperty(oldPassword));
    }

    @And("New Password text boxina sifresi yazilir")
    public void newPasswordTextBoxinaSifresiYazilir() {
        BrowserUtils.waitFor(3);
        System.out.println(password);
        passwordPage.newPasswordTextBox.sendKeys(password);
    }

    @And("New Password Confirmation text boxina sifresi yazilir")
    public void newPasswordConfirmationtextBoxinaSifresiYazilir() {
        BrowserUtils.waitFor(3);
        passwordPage.newPasswordConfirmationTextBox.sendKeys(password);
        ConfigurationReader.set("password01", password);
    }

    @And("Save butonuna tiklanir")
    public void saveButonunaTiklanir() {
        BrowserUtils.waitFor(3);
        passwordPage.saveButton.click();
        BrowserUtils.waitFor(3);
    }
}
