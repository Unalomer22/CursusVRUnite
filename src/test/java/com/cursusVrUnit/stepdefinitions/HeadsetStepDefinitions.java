package com.cursusVrUnit.stepdefinitions;

import com.cursusVrUnit.pages.HeadsetsPage;
import com.cursusVrUnit.utilities.BrowserUtils;
import com.cursusVrUnit.utilities.ConfigurationReader;
import com.cursusVrUnit.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static com.cursusVrUnit.utilities.BrowserUtils.waitFor;

public class HeadsetStepDefinitions {
    HeadsetsPage headsetsPage = new HeadsetsPage();
    String serialNumber = new Faker().number().digits(40);
    String oldActiveness;

    @And("Yeni Headsetin Serial Numberi girilir")
    public void olusturulacakHeadsetinSerialNumberiGirilir() {
        headsetsPage.serialNumber.sendKeys(serialNumber);
        ConfigurationReader.set("newSerialNumber", serialNumber);
    }

    @Then("Olusturulan Headsetin verileri listeden dogrulanir")
    public void olusturulanHeadsetinVerileriListedenDogrulanir() {
        Assert.assertEquals(serialNumber, headsetsPage.firstHeadsetSerialNumber.getText());
    }

    @And("Headsets tabindaki arama kutusuna {string} headset seri numarasi yazilir")
    public void headsetsTabindakiAramaKutusunaHeadsetSeriNumarasiYazilir(String arananHeadsetSerialNumarasi) {
        headsetsPage.searchTextBox.sendKeys(arananHeadsetSerialNumarasi);
    }

    @And("Is Active check box'ina tiklanir")
    public void isActiveCheckBoxInaTiklanir() {
        waitFor(3);
        Actions act = new Actions(Driver.getDriver());
        act.moveToElement(headsetsPage.isActiveCheckBox).click().perform();
    }

    @And("Mevcut serial number silinir")
    public void mevcutSerialNumberSilinir() {
        headsetsPage.serialNumber.clear();
    }

    @Then("Ilgili headsetin serial numarasinin {string} oldugu dogrulanir")
    public void ilgiliHeadsetinSerialNumarasininOlduguDogrulanir(String expectedSerialNumber) {
        Assert.assertEquals(ConfigurationReader.getProperty(expectedSerialNumber), headsetsPage.serialNumber.getAttribute("value"));
    }

    @And("{int}.ci headsetin aktiflik durumuna bakilir")
    public void ciKaydinAktiflikDurumunaBakilir(int arg0) {
        oldActiveness = Driver.getDriver().findElement(By.xpath("(//tr//td[3])[" + arg0 + "]")).getText();
    }

    @And("{int}. headsetin duzenle butonuna tiklanir")
    public void headsetinDuzenleButonunaTiklanir(int arg0) {
        Driver.getDriver().findElement(By.xpath("(//a[@title='Edit'])[" + arg0 + "]")).click();
    }

    @Then("{int}. headsetin aktiflik durumununun guncellendigi gozlemlenir")
    public void headsetinAktiflikDurumunununGuncellendigiGozlemlenir(int arg0) {
        String actualActiveness = Driver.getDriver().findElement(By.xpath("(//tr//td[3])[" + arg0 + "]")).getText();
        if (oldActiveness.equals("False")) {
            Assert.assertEquals("True", actualActiveness);
        } else {
            Assert.assertEquals("False", actualActiveness);
        }
    }
}
