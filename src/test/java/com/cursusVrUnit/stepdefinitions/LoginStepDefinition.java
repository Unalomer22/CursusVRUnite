package com.cursusVrUnit.stepdefinitions;

import com.cursusVrUnit.pages.BasePage;
import com.cursusVrUnit.pages.LoginPage;
import com.cursusVrUnit.pages.UserPage;
import com.cursusVrUnit.utilities.ConfigurationReader;
import com.cursusVrUnit.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import static com.cursusVrUnit.utilities.BrowserUtils.waitFor;

public class LoginStepDefinition {

    BasePage basePage = new BasePage();
    LoginPage loginPage = new LoginPage();

    UserPage userPage = new UserPage();

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

    public void logIn(){
        cursusAnaSayfasinaGidilir();
        anaSayfadakiLoginButonunaTiklanir();
        usernameGirilir("username01");
        sifreGirilir("password01");
        loginSayfasindakiLoginButonunaTiklanir();
        sistemeLoginYapildigiDogrulanir();
    }

    @Then("Sisteme login yapildigi dogrulanir")
    public void sistemeLoginYapildigiDogrulanir() {
        Assert.assertTrue(userPage.kullaniciIconu.isDisplayed());
    }


}
