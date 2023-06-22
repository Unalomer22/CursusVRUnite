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

    String clientName = faker.name().fullName();
    String clientBSNNumber = faker.number().digits(23);
    String clientAddress = faker.address().city();
    String clientPostCode = faker.address().zipCode();
    String clientCountry = faker.address().country();
    String clientPersonalName = faker.name().fullName();
    String clientPhoneNumber = faker.phoneNumber().cellPhone();
    String clientEmail = faker.internet().emailAddress();
    String clientExpireDate = "2023-08-05";

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

    @And("New Client Name girilir")
    public void newClientNameGirilir() {
        clientsPage.clientNameTextBox.sendKeys(clientName);
    }

    @And("New Client BSN numarasi girilir")
    public void newClientBSNNumarasiGirilir() {
        clientsPage.boxSerialNumber.sendKeys(clientBSNNumber);
    }

    @And("New client Adress girilir")
    public void newClientAdressGirilir() {
        clientsPage.addressTextBox.sendKeys(clientAddress);
    }

    @And("New Client Post Code girilir")
    public void newClientPostCodeGirilir() {
        clientsPage.postCodeTextBox.sendKeys(clientPostCode);
    }

    @And("New Client Country girilir")
    public void newClientCountryGirilir() {
        clientsPage.countryTextBox.sendKeys(clientCountry);
    }

    @And("New Client Personel Name girilir")
    public void newClientPersonelNameGirilir() {
        clientsPage.personalNameTextBox.sendKeys(clientPersonalName);
    }

    @And("New Client Phone Number girilir")
    public void newClientPhoneNumberGirilir() {
        clientsPage.phoneTextBox.sendKeys(clientPhoneNumber);
    }

    @And("New Client Email girilir")
    public void newClientEmailGirilir() {
        clientsPage.emailTextBox.sendKeys(clientEmail);
    }

    @And("New Client Expire Date girilir")
    public void newClientExpireDateGirilir() {
        clientsPage.expireDate.sendKeys(clientExpireDate);
        BrowserUtils.waitFor(1);
        Driver.getDriver().findElement(By.xpath("//html")).click();
        BrowserUtils.waitFor(1);
    }

    @Then("{string} Text boxinin altinda hata mesajinin gorundugu dogrulanir")
    public void textBoxininAltindaMesajininGorunduguDogrulanir(String textBox) {
        String expectedErrorMessage = "This field is required.";
        switch (textBox){
            case "name":
                Assert.assertEquals(expectedErrorMessage, clientsPage.nameErrorMessage.getText());
                break;
            case "bsn":
                Assert.assertEquals(expectedErrorMessage, clientsPage.bsnErrorMessage.getText());
                break;
            case "address":
                Assert.assertEquals(expectedErrorMessage, clientsPage.addressErrorMessage.getText());
                break;
            case "post code":
                Assert.assertEquals(expectedErrorMessage, clientsPage.postCodeErrorMessage.getText());
                break;
            case "country":
                Assert.assertEquals(expectedErrorMessage, clientsPage.countryErrorMessage.getText());
                break;
            case "personal name":
                Assert.assertEquals(expectedErrorMessage, clientsPage.personalNameErrorMessage.getText());
                break;
            case "phone number":
                Assert.assertEquals(expectedErrorMessage, clientsPage.phoneErrorMessage.getText());
                break;
            case "email":
                Assert.assertEquals(expectedErrorMessage, clientsPage.emailErrorMessage.getText());
                break;
            case "expire date":
                Assert.assertEquals(expectedErrorMessage, clientsPage.expireDateErrorMessage.getText());
                break;
            default:
                System.out.println("Yanlis girdi yapilmistir");
                break;
        }
    }
}

