package com.cursusVrUnit.stepdefinitions;

import com.cursusVrUnit.pages.VideosPage;
import com.cursusVrUnit.utilities.BrowserUtils;
import com.cursusVrUnit.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

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
        BrowserUtils.waitFor(3);
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
        WebElement element = Driver.getDriver().findElement(By.xpath("//div[text()='" + clientName + "']"));
        Actions actions = new Actions(Driver.getDriver());
        videosPage.clientsDropDown.click();
        BrowserUtils.waitFor(3);
        actions.scrollToElement(element).perform();
        Driver.getDriver().findElement(By.xpath("//div[text()='" + clientName + "']")).click();
        BrowserUtils.waitFor(3);
        Driver.getDriver().findElement(By.xpath("//i[@class='dropdown icon']")).click();
    }

    @And("Videos tabindaki save butonuna tiklanir")
    public void videosTabindakiSaveButonunaTiklanir() {
        videosPage.saveButton.click();
    }
}
