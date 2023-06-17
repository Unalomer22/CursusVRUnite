package com.cursusVrUnit.stepdefinitions;

import com.cursusVrUnit.pages.LoginPage;
import com.cursusVrUnit.pages.PasswordPage;
import com.cursusVrUnit.utilities.BrowserUtils;
import com.cursusVrUnit.utilities.ConfigurationReader;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class ChangePasswordStepDefinition {

    Faker faker = new Faker();

    String password = faker.internet().password(8, 15, true, false, true);
    String invalidPassword;
    PasswordPage passwordPage = new PasswordPage();
    LoginPage loginPage = new LoginPage();

    boolean sifreGuncellemeMesaji;

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
        sifreGuncellemeMesaji = passwordPage.sifreGuncellemeMesajiList.isEmpty();
    }

    @Then("Eski sifrenin yeni sifre ile degistirilmedigi dogrulanir")
    public void eskiSifreninYeniSifreIleDegistirilmedigiDogrulanir() {
        Assert.assertFalse(sifreGuncellemeMesaji);
    }

    @Then("Sistemin sifre degistirildigine dair mesaji dogrulanir")
    public void sisteminSifreDegistirildigineDairMesajiDogrulanir() {
        Assert.assertFalse(sifreGuncellemeMesaji);
    }

    @And("New Password text boxina gecersiz {string} sifre yazilir")
    public void newPasswordTextBoxinaGecersizSadeceRakamlardanOlusanSifreYazilir(String invalidPassword) {
        switch (invalidPassword){
            case "digitsOnly":
                invalidPassword = faker.number().digits(10);
                break;
            case "sekizKarakterAz":
                invalidPassword = faker.internet().password(2,7, true, false, true);
                break;

        }
        BrowserUtils.waitFor(3);
        passwordPage.newPasswordTextBox.sendKeys(invalidPassword);
        ConfigurationReader.set("passwordInvalid", invalidPassword);
    }

    @And("New Password Confirmation text boxina gecersiz sifre yazilir")
    public void newPasswordConfirmationTextBoxinaGecersizSadeceRakamlardanOlusanSifreYazilir() {
        BrowserUtils.waitFor(3);
        passwordPage.newPasswordConfirmationTextBox.sendKeys(invalidPassword);
    }
}
