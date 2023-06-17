package com.cursusVrUnit.stepdefinitions;

import com.cursusVrUnit.pages.PasswordPage;
import com.cursusVrUnit.utilities.BrowserUtils;
import com.cursusVrUnit.utilities.ConfigurationReader;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;

public class ChangePasswordStepDefinition {

    Faker faker = new Faker();

    String password = faker.internet().password(8, 15, true, false, true);

    String invalidPassword = faker.internet().password(2,7, true, false, true);

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

    @And("New Password text boxina gecersiz sekiz karakterden az sifre yazilir")
    public void newPasswordTextBoxinaGecersizKarakterdenAzSifreYazilir() {
        BrowserUtils.waitFor(3);
        passwordPage.newPasswordTextBox.sendKeys(invalidPassword);
    }

    @And("New Password Confirmation text boxina gecersiz sekiz karakterden az sifre yazilir")
    public void newPasswordConfirmationTextBoxinaGecersizKarakterdenAzSifreYazilir() {
        BrowserUtils.waitFor(3);
        passwordPage.newPasswordConfirmationTextBox.sendKeys(invalidPassword);
    }
}
