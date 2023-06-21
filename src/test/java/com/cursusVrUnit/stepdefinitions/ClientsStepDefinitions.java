package com.cursusVrUnit.stepdefinitions;

import com.cursusVrUnit.pages.ClientsPage;
import com.cursusVrUnit.utilities.BrowserUtils;
import com.cursusVrUnit.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ClientsStepDefinitions {
    ClientsPage clientsPage = new ClientsPage();

    int expectedSayfa = 1;
    int actualSayfaPrevious;

    @And("Clients tabindaki arama kutusuna {string} musterisinin bilgisi yazilir")
    public void clientsTabindakiAramaKutusunaMusterisininIsmiYazilir(String arananMusteriBilgisi) {
        clientsPage.searchTextBox.sendKeys(arananMusteriBilgisi);
    }

    @And("Clients tabindaki Search butonuna tiklanir")
    public void clientsTabindakiSearchButonunaTiklanir() {
        BrowserUtils.waitFor(3);
        clientsPage.searchButton.click();
    }

    @Then("Listelenen verilerin {string} musterisinin ismini icerdigi dogrulanir")
    public void listelenenVerilerinMusterisiniIcerdigiDogrulanir(String expectedClientName) {
        BrowserUtils.waitFor(3);
        for (WebElement w : clientsPage.musteriIsimListesi) {
            Assert.assertEquals(expectedClientName, w.getText());
        }
    }

    @Then("Listelenen verilerin {string} musterisinin BSNsini icerdigi dogrulanir")
    public void listelenenVerilerinMusterisininBsnsiniIcerdigiDogrulanir(String expectedClientBSN) {
        BrowserUtils.waitFor(3);
        for (WebElement w : clientsPage.musteriIsimListesi) {
            Assert.assertEquals(expectedClientBSN, w.getText());
        }
    }

    @Then("Listelenen verilerin {string} musterisinin telefon numarasini icerdigi dogrulanir")
    public void listelenenVerilerinMusterisininTelefonNumarasiniIcerdigiDogrulanir(String expectedClienPhoneNumber) {
        BrowserUtils.waitFor(3);
        for (WebElement w : clientsPage.musteriIsimListesi) {
            Assert.assertEquals(expectedClienPhoneNumber, w.getText());
        }
    }

    @Then("Listelenen verilerin {string} musterisinin ulkesini icerdigi dogrulanir")
    public void listelenenVerilerinMusterisininUlkesiniIcerdigiDogrulanir(String expectedClientCountry) {
        BrowserUtils.waitFor(3);
        for (WebElement w : clientsPage.musteriIsimListesi) {
            Assert.assertEquals(expectedClientCountry, w.getText());
        }
    }

    @Then("Listelenen verilerin {string} musterisinin ismini icermedigi dogrulanir")
    public void listelenenVerilerinMusterisininIsminiIcermedigiDogrulanir(String expectedClientName) {
        BrowserUtils.waitFor(3);
        for (WebElement w : clientsPage.musteriIsimListesi) {
            Assert.assertFalse(w.getText().contains(expectedClientName));
        }
    }

    @Then("Sayfada {int} kayit oldugu dogrulanir")
    public void sayfadaKayitOlduguDogrulanir(int expectedListSize) {
        Assert.assertEquals(expectedListSize, clientsPage.musteriIsimListesi.size());
    }

    @Then("Sayfanin altinda bulunan {string} butonuna tiklanir")
    public void sayfaninAltindaBulunanButonunaTiklanir(String nextOrPreviousButton) {
        if (nextOrPreviousButton.equals("Previous")) {
            String actualUrl = Driver.getDriver().getCurrentUrl();
            actualSayfaPrevious = Integer.parseInt(actualUrl.substring(actualUrl.length() - 1));
        }
        Driver.getDriver().findElement(By.xpath("//*[text()='" + nextOrPreviousButton + "']")).click();
    }

    @Then("Sayfanin bir mevcut sayfadan bir sonraki sayfaya gectigi gozlemlenir")
    public void sayfaninBirOncekiSayfadanBirSonrakiSayfayaGectigiGozlemlenir() {
        String actualUrl = Driver.getDriver().getCurrentUrl();
        int actualSayfa = Integer.parseInt(actualUrl.substring(actualUrl.length()-1));
        Assert.assertEquals(expectedSayfa + 1, actualSayfa);
    }


    @Then("Sayfanin bir mevcut sayfadan bir onceki sayfaya gectigi gozlemlenir")
    public void sayfaninBirMevcutSayfadanBirOncekiSayfayaGectigiGozlemlenir() {
        String actualUrl = Driver.getDriver().getCurrentUrl();
        int actualSayfa = Integer.parseInt(actualUrl.substring(actualUrl.length() - 2, actualUrl.length() - 1));

        Assert.assertEquals(actualSayfaPrevious - 1, actualSayfa);
    }

    public static void main(String[] args) {
        String actualUrl = "http://peteksoft.com:9000/clients?page=2";
        System.out.println(actualUrl.lastIndexOf(actualUrl.length() - 1));
        System.out.println();
    }
}

