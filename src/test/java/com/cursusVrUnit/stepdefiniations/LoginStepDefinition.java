package com.cursusVrUnit.stepdefiniations;

import com.cursusVrUnit.pages.BasePage;
import com.cursusVrUnit.pages.LoginPage;
import com.cursusVrUnit.utilities.ConfigurationReader;
import com.cursusVrUnit.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LoginStepDefinition {

    BasePage basePage = new BasePage();
    LoginPage loginPage = new LoginPage();

    @Given("Cursus Ana Sayfasina gidilir")
    public void cursusAnaSayfasinaGidilir() {
        Driver.getDriver().get(ConfigurationReader.getProperty("homePageUrl"));
    }

    @And("Ana sayfadaki login butonuna tiklanir")
    public void anaSayfadakiLoginButonunaTiklanir() {
        basePage.logInButton.click();
    }

    @And("{string} username girilir")
    public void usernameGirilir(String username) {
        loginPage.usernameTextbox.sendKeys(ConfigurationReader.getProperty(username));
    }

    @And("{string} sifre girilir")
    public void sifreGirilir(String password) {
        loginPage.passwordTextbox.sendKeys(ConfigurationReader.getProperty(password));
    }

    @And("Login sayfasindaki login butonuna tiklanir")
    public void loginSayfasindakiLoginButonunaTiklanir() {
        loginPage.loginButton.click();
    }

    @Then("Login sayfasinda sistemin hata verdigi {string} dogrulanir")
    public void loginSayfasindaSisteminHataVerdigiDogrulanir(String errorMessage) {
        Assert.assertEquals(ConfigurationReader.getProperty(errorMessage), loginPage.logInPageErrorMessage.getText());
    }
}
