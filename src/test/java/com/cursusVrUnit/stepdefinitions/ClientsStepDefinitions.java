package com.cursusVrUnit.stepdefinitions;

import com.cursusVrUnit.pages.ClientsPage;
import com.cursusVrUnit.utilities.BrowserUtils;
import com.cursusVrUnit.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en_old.Ac;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class ClientsStepDefinitions {
    ClientsPage clientsPage = new ClientsPage();
    static Faker faker = new Faker();
    List<String> expectedClientDatas = new ArrayList<>();
    Actions actions = new Actions(Driver.getDriver());
    int expectedSayfa = 1;
    int actualSayfaPrevious;

    String clientName;
    String clientBSNNumber;
    String clientAddress;
    String clientPostCode;
    String clientCountry;
    String clientPersonalName;
    String clientPhoneNumber;
    String clientEmail;
    String clientExpireDate;

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
        int actualSayfa = Integer.parseInt(actualUrl.substring(actualUrl.length() - 1));
        Assert.assertEquals(expectedSayfa + 1, actualSayfa);
    }


    @Then("Sayfanin bir mevcut sayfadan bir onceki sayfaya gectigi gozlemlenir")
    public void sayfaninBirMevcutSayfadanBirOncekiSayfayaGectigiGozlemlenir() {
        String actualUrl = Driver.getDriver().getCurrentUrl();
        int actualSayfa = Integer.parseInt(actualUrl.substring(actualUrl.length() - 2, actualUrl.length() - 1));

        Assert.assertEquals(actualSayfaPrevious - 1, actualSayfa);
    }

    @Then("Sayfanin {string}.ci sayfada oldugu dogrulanir")
    public void sayfaninCiSayfadaOlduguDogrulanir(String expectedPageNumber) {
        String actualPageNumber = Driver.getDriver().getCurrentUrl();
        actualPageNumber = actualPageNumber.charAt(actualPageNumber.length() - 1) + "";
        Assert.assertEquals(expectedPageNumber, actualPageNumber);
    }

    @And("Create New Client butonuna tiklanir")
    public void createNewClientButonunaTiklanir() {
        clientsPage.createNewClientButton.click();
    }

    @And("Gerekli valid Client bilgileri girilir")
    public void gerekliValidClientBilgileriGirilir() {
        clientName = faker.name().fullName();
        clientBSNNumber = faker.number().digits(23);
        clientAddress = faker.address().city();
        clientPostCode = faker.address().zipCode();
        clientCountry = faker.address().country();
        clientPersonalName = faker.name().fullName();
        clientPhoneNumber = faker.phoneNumber().cellPhone();
        clientEmail = faker.internet().emailAddress();
        clientExpireDate = "2023-08-05";

        expectedClientDatas.add(clientName);
        expectedClientDatas.add(clientBSNNumber);
        expectedClientDatas.add(clientPhoneNumber);
        expectedClientDatas.add(clientCountry);
        expectedClientDatas.add(clientExpireDate);


        actions.
                sendKeys(clientsPage.clientNameTextBox, clientName).
                sendKeys(Keys.TAB).
                sendKeys(clientBSNNumber).
                sendKeys(Keys.TAB).
                sendKeys(clientAddress).
                sendKeys(Keys.TAB).
                sendKeys(clientPostCode).
                sendKeys(Keys.TAB).
                sendKeys(clientCountry).
                sendKeys(Keys.TAB).
                sendKeys(clientPersonalName).
                sendKeys(Keys.TAB)
                .sendKeys(clientPhoneNumber).
                sendKeys(Keys.TAB).
                sendKeys(clientEmail).
                sendKeys(Keys.TAB).
                sendKeys(clientExpireDate).
                perform();
        BrowserUtils.waitFor(3);
        Driver.getDriver().findElement(By.xpath("//html")).click();
        BrowserUtils.waitFor(3);
    }

    public static void main(String[] args) {
        Faker faker = new Faker();
        System.out.println(faker.phoneNumber().cellPhone());
        System.out.println(faker.phoneNumber().phoneNumber());
    }

    @And("Client sayfasindaki Save Changes butonuna tiklanir")
    public void clientSayfasindakiSaveChangesButonunaTiklanir() {
        clientsPage.saveChangesButton.click();
    }

    @Then("Olusturulan clientin verileri listeden dogrulanir")
    public void olusturulanClientinVerileriListedenDogrulanir() {
        for (int i = 0; i < 5; i++){
            Assert.assertEquals(expectedClientDatas.get(i),clientsPage.firstClientsDatas.get(i).getText());
        }
    }
}

