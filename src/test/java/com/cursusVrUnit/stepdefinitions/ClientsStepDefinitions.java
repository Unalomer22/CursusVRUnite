package com.cursusVrUnit.stepdefinitions;

import com.cursusVrUnit.pages.ClientsPage;
import com.cursusVrUnit.pages.HeadsetsPage;
import com.cursusVrUnit.pages.VideosPage;
import com.cursusVrUnit.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

import static com.cursusVrUnit.utilities.BrowserUtils.waitFor;

public class ClientsStepDefinitions {
    ClientsPage clientsPage = new ClientsPage();
    VideosPage videosPage = new VideosPage();
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

    @And("Search butonuna tiklanir")
    public void searchButonunaTiklanir() {
        waitFor(3);
        clientsPage.searchButton.click();
    }

    @Then("Listelenen verilerin {string} yi icerdigi dogrulanir")
    public void listelenenVerilerinMusterisiniIcerdigiDogrulanir(String expectedClientName) {
        waitFor(3);
        for (WebElement w : clientsPage.musteriIsimListesi) {
            Assert.assertEquals(expectedClientName, w.getText());
        }
    }

    @Then("Listelenen verilerin {string} musterisinin BSNsini icerdigi dogrulanir")
    public void listelenenVerilerinMusterisininBsnsiniIcerdigiDogrulanir(String expectedClientBSN) {
        waitFor(3);
        for (WebElement w : clientsPage.musteriIsimListesi) {
            Assert.assertEquals(expectedClientBSN, w.getText());
        }
    }

    @Then("Listelenen verilerin {string} musterisinin telefon numarasini icerdigi dogrulanir")
    public void listelenenVerilerinMusterisininTelefonNumarasiniIcerdigiDogrulanir(String expectedClienPhoneNumber) {
        waitFor(3);
        for (WebElement w : clientsPage.musteriIsimListesi) {
            Assert.assertEquals(expectedClienPhoneNumber, w.getText());
        }
    }

    @Then("Listelenen verilerin {string} musterisinin ulkesini icerdigi dogrulanir")
    public void listelenenVerilerinMusterisininUlkesiniIcerdigiDogrulanir(String expectedClientCountry) {
        waitFor(3);
        for (WebElement w : clientsPage.musteriIsimListesi) {
            Assert.assertEquals(expectedClientCountry, w.getText());
        }
    }

    @Then("Listelenen verilerin {string} musterisinin ismini icermedigi dogrulanir")
    public void listelenenVerilerinMusterisininIsminiIcermedigiDogrulanir(String expectedClientName) {
        waitFor(3);
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

    @And("Create New Client butonuna tiklanir {string}")
    public void createNewClientButonunaTiklanir(String a) {
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
        waitFor(3);
        Driver.getDriver().findElement(By.xpath("//html")).click();
        waitFor(3);
    }

    public static void main(String[] args) {
        Faker faker = new Faker();
        System.out.println(faker.phoneNumber().cellPhone());
        System.out.println(faker.phoneNumber().phoneNumber());
    }

    @And("Yeni kayit olusturma sayfasindaki Save Changes butonuna tiklanir")
    public void yeniKayitOlusturSayfasindakiSaveChangesButonunaTiklanir() {
        waitFor(3);
        clientsPage.saveChangesButton.click();
    }

    @Then("Olusturulan clientin verileri listeden dogrulanir")
    public void olusturulanClientinVerileriListedenDogrulanir() {
        for (int i = 0; i < 5; i++) {
            Assert.assertEquals(expectedClientDatas.get(i), clientsPage.firstClientsDatas.get(i).getText());
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
        waitFor(1);
        Driver.getDriver().findElement(By.xpath("//html")).click();
        waitFor(1);
    }

    @Then("{string} Text boxinin altinda hata mesajinin gorundugu dogrulanir")
    public void textBoxininAltindaMesajininGorunduguDogrulanir(String textBox) {
        String expectedErrorMessage = "This field is required.";
        switch (textBox) {
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
            case "serial number":
                Assert.assertEquals(expectedErrorMessage, new HeadsetsPage().serialNumberErrorMessage.getText());
            default:
                System.out.println("Yanlis girdi yapilmistir");
                break;
        }
    }

    @And("{string} text boxindaki veri silinir, {string} yeni veri eklenir")
    public void textBoxindakiVeriSilinirYeniVeriEklenir(String textBox, String newData) {
        switch (textBox) {
            case "name":
                clientsPage.clientNameTextBox.clear();
                clientsPage.clientNameTextBox.sendKeys(newData);
                break;
            case "bsn":
                clientsPage.boxSerialNumber.clear();
                clientsPage.boxSerialNumber.sendKeys(newData);
                break;
            case "address":
                clientsPage.addressTextBox.clear();
                clientsPage.addressTextBox.sendKeys(newData);
                break;
            case "post code":
                clientsPage.postCodeTextBox.clear();
                clientsPage.postCodeTextBox.sendKeys(newData);
                break;
            case "country":
                clientsPage.countryTextBox.clear();
                clientsPage.countryTextBox.sendKeys(newData);
                break;
            case "personal name":
                clientsPage.personalNameTextBox.clear();
                clientsPage.personalNameTextBox.sendKeys(newData);
                break;
            case "phone number":
                clientsPage.phoneTextBox.clear();
                clientsPage.phoneTextBox.sendKeys(newData);
                break;
            case "email":
                clientsPage.emailTextBox.clear();
                clientsPage.emailTextBox.sendKeys(newData);
                break;
            case "expire date":
                clientsPage.expireDate.clear();
                clientsPage.expireDate.sendKeys(newData);
                Driver.getDriver().findElement(By.xpath("//html")).click();
                break;
            default:
                System.out.println("Yanlis girdi yapilmistir");
                break;
        }
    }

    @Then("{string} text boxindaki verinin {string} oldugu dogrulanir")
    public void textBoxindakiVerininOlduguDogrulanir(String textBox, String expectedData) {
        System.out.println("------------------------------------");
        System.out.println(clientsPage.clientNameTextBox.getText());
        System.out.println(clientsPage.clientNameTextBox.getAttribute("value"));
        switch (textBox) {
            case "name":
                Assert.assertEquals(expectedData, clientsPage.clientNameTextBox.getAttribute("value"));
                break;
            case "bsn":
                Assert.assertEquals(expectedData, clientsPage.boxSerialNumber.getAttribute("value"));
                break;
            case "address":
                Assert.assertEquals(expectedData, clientsPage.addressTextBox.getAttribute("value"));
                break;
            case "post code":
                Assert.assertEquals(expectedData, clientsPage.postCodeTextBox.getAttribute("value"));
                break;
            case "country":
                Assert.assertEquals(expectedData, clientsPage.countryTextBox.getAttribute("value"));
                break;
            case "personal name":
                Assert.assertEquals(expectedData, clientsPage.personalNameTextBox.getAttribute("value"));
                break;
            case "phone number":
                Assert.assertEquals(expectedData, clientsPage.phoneTextBox.getAttribute("value"));
                break;
            case "email":
                Assert.assertEquals(expectedData, clientsPage.emailTextBox.getAttribute("value"));
                break;
            case "expire date":
                Assert.assertEquals(expectedData, clientsPage.expireDate.getAttribute("value"));
                break;
            case "Title":
                Assert.assertEquals(expectedData, videosPage.videoTitleTextBox.getAttribute("value"));
                break;
            default:
                System.out.println("Yanlis girdi yapilmistir");
                break;
        }
    }

    @And("Ilk kaydin duzenle butonuna tiklanir")
    public void ilkKaydinDuzenleButonunaTiklanir() {
        clientsPage.firstClientsEditButton.click();
    }

    String expectedClientDeletedName;

    @And("{int}.ci kaydin delete butonuna basilir")
    public void ciKaydinDeleteButonunaBasilir(int clientNumber) {
        expectedClientDeletedName = Driver.getDriver().findElement(By.xpath("(//tr//td[1])[" + clientNumber + "]")).getText();
        Driver.getDriver().findElement(By.xpath("(//a[@title='Delete'])[" + clientNumber + "]")).click();
    }

    @And("Yes, delete it! butonuna tiklanir")
    public void yesDeleteItButonunaTiklanir() {
        clientsPage.yesDeleteItButton.click();
    }

    @Then("Ilgili Kaydin listeden silindigi gozlemlenir")
    public void ilgiliKaydinListedenSilindigiGozlemlenir() {
        try {
            Assert.assertFalse(Driver.getDriver().findElement(By.xpath("//*[text()='" + expectedClientDeletedName + "']")).isDisplayed());
        } catch (Exception e) {
            Assert.assertTrue(true);
        }
    }

    @And("Cancel butonuna tiklanir")
    public void cancelButonunaTiklanir() {
        clientsPage.cancelButton.click();
    }

    @Then("Ilgili Kaydin listeden silinmedigi gozlemlenir")
    public void ilgiliKaydinListedenSilinmedigiGozlemlenir() {
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//*[text()='" + expectedClientDeletedName + "']")).isDisplayed());
    }

    @And("Create New {string} butonuna tiklanir")
    public void createNewButonunaTiklanir(String arg0) {
        Driver.getDriver().findElement(By.xpath("//button[contains(text(),'" + arg0 +"')]")).click();
    }
}

