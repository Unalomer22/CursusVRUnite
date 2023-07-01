package com.cursusVrUnit.stepdefinitions;

import com.cursusVrUnit.pages.VideosPage;
import com.cursusVrUnit.utilities.BrowserUtils;
import com.cursusVrUnit.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static com.cursusVrUnit.utilities.BrowserUtils.waitFor;

public class VideosStepDefinitions {
    VideosPage videosPage = new VideosPage();
    Faker faker = new Faker();

    String videoTitle = faker.funnyName().name();

    @And("Videos tabindaki arama kutusuna {string} musterisinin bilgisi yazilir")
    public void videosTabindakiAramaKutusunaMusterisininBilgisiYazilir(String arananVideoTitlei) {
        videosPage.searchTextBox.sendKeys(arananVideoTitlei);
    }

    @And("Videos tabindaki Search butonuna tiklanir")
    public void videosTabindakiSearchButonunaTiklanir() {
        waitFor(3);
        videosPage.searchButton.click();
    }

    @And("Create New Video butonuna tiklanir")
    public void createNewVideoButonunaTiklanir() {
        videosPage.createNewClientButton.click();
    }

    @And("New Video Titlei girilir")
    public void newVideoTitleiGirilir() {
        videosPage.videoTitleTextBox.sendKeys(videoTitle);
    }


    @And("Bilgisayardan video secilir")
    public void bilgisayardanVideoSecilir() {
        videosPage.videoUpload.sendKeys("C:\\Users\\Administrator\\Desktop\\videoplayback.mp4");
    }

    @And("Clients drop downundan {string} clienti secilir")
    public void clientsDropDownundanClientiSecilir(String clientName) {
        waitFor(3);
        WebElement element = Driver.getDriver().findElement(By.xpath("//div[text()='" + clientName + "']"));
        Actions actions = new Actions(Driver.getDriver());
        videosPage.clientsDropDown.click();
        waitFor(3);
        actions.scrollToElement(element).perform();
        Driver.getDriver().findElement(By.xpath("//div[text()='" + clientName + "']")).click();
        waitFor(3);
        Driver.getDriver().findElement(By.xpath("//h2")).click();
    }


    @Then("Faker ile uretilen title ile yeni bir videonun eklendigi dogrulanir")
    public void titleindaYeniBirVideonunEklendigiDogrulanir() {
        waitFor(2);
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//*[text()='" + videoTitle + "']")).isDisplayed());
    }

    @Then("Videos tabinda sistemin hata verdigi gozlemlenir")
    public void videosTabindaTextBoxininAltindaSisteminHataVerdigiGozlemlenir() {
        waitFor(3);
        String expectedErrorMessage = "This field is required.";
        try {
            Assert.assertEquals(expectedErrorMessage, videosPage.errorMessage.getText());
        } catch (Exception e) {
            Assert.fail("Assertion Fail olmustur");
        }
    }

    @And("Clients drop downundaki mevcut client silinir")
    public void clientsDropDownundakiMevcutClientSilinir() {
        waitFor(3);
        BrowserUtils.waitForClickablility(videosPage.clientDeleteIcon, 10);
        videosPage.clientDeleteIcon.click();
    }

    @Then("Ilgili kaydin clientinin {string} oldugu dogrulanir")
    public void ilgiliVideonunClientininOlduguDogrulanir(String expectedMewVideosClient) {
        waitFor(3);
        Assert.assertEquals(expectedMewVideosClient, videosPage.videonunClienti.getText());
    }

    String expectedVideoDeletedTitle;

    @And("{int}.ci videonun delete butonuna basilir")
    public void ciVideonunDeleteButonunaBasilir(int clientNumber) {
        expectedVideoDeletedTitle = Driver.getDriver().findElement(By.xpath("(//tr//td[1])[" + clientNumber + "]")).getText();
        Driver.getDriver().findElement(By.xpath("(//a[@title='Delete'])[" + clientNumber + "]")).click();
    }

    @Then("Ilgili kaydin listeden silindigi gozlemlenir")
    public void ilgiliVideonunListedenSilindigiGozlemlenir() {
        try {
            Assert.assertFalse(Driver.getDriver().findElement(By.xpath("//*[text()='" + expectedVideoDeletedTitle + "']")).isDisplayed());
        } catch (Exception e) {
            Assert.assertTrue(true);
        }
    }

    @Then("Ilgili kaydin listeden silinmedigi gozlemlenir")
    public void ilgiliVideonunListedenSilinmedigiGozlemlenir() {
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//*[text()='" + expectedVideoDeletedTitle + "']")).isDisplayed());
    }
}
