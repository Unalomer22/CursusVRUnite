package com.cursusVrUnit.stepdefinitions;

import com.cursusVrUnit.pages.BasePage;
import com.cursusVrUnit.pages.UserPage;
import com.cursusVrUnit.utilities.BrowserUtils;
import com.cursusVrUnit.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LogOutStepDefinition {
    UserPage userPage = new UserPage();
    BasePage basePage = new BasePage();

    @And("{string} sayfasi acilir")
    public void sayfasiAcilir(String buttonName) {
        Driver.getDriver().findElement(By.xpath("//*[text()='" + buttonName + "']")).click();
        BrowserUtils.waitFor(3);
    }

    @And("Sag ustte bulunan kullanici ikonuna tiklanir")
    public void sagUstteBulunanKullaniciIkonunaTiklanir() {
        userPage.kullaniciIconu.click();
        BrowserUtils.waitFor(3);
    }

    @And("Sign Out butonuna tiklanir")
    public void signOutButonunaTiklanir() {
        userPage.signOutButton.click();
    }

    @And("Cursus goruntusune tiklanir")
    public void cursusGoruntusuneTiklanir() {
        userPage.cursusImg.click();
    }

    @Then("Sistemden cikis yapildigi dogrulanir")
    public void sistemdenCikisYapildigiDogrulanir() {
        Assert.assertTrue(basePage.logInButton.isDisplayed());
    }

}
