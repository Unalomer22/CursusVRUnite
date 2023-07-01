package com.cursusVrUnit.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ClientsPage extends BasePage {

    @FindBy(id = "id_name")
    public WebElement searchTextBox;

    @FindBy(xpath = "//button[@class='more_items_14']")
    public WebElement searchButton;

    @FindBy(xpath = "//tbody//tr/td[1]")
    public List<WebElement> musteriIsimListesi;

    @FindBy(xpath = "//button[@class='create_btn_dash']")
    public WebElement createNewClientButton;

    @FindBy(id = "id_name")
    public WebElement clientNameTextBox;

    @FindBy(xpath = "//button[@class='save_btn']")
    public WebElement saveChangesButton;

    @FindBy(xpath = "//tbody/tr[1]/td")
    public List<WebElement> firstClientsDatas;

    @FindBy(id = "id_box_serial_number")
    public WebElement boxSerialNumber;

    @FindBy(id = "id_address")
    public WebElement addressTextBox;

    @FindBy(id = "id_post_code")
    public WebElement postCodeTextBox;

    @FindBy(id = "id_country")
    public WebElement countryTextBox;

    @FindBy(id = "id_personal_name")
    public WebElement personalNameTextBox;

    @FindBy(id = "id_phone")
    public WebElement phoneTextBox;

    @FindBy(id = "id_email")
    public WebElement emailTextBox;

    @FindBy(id = "id_expire_date")
    public WebElement expireDate;

    @FindBy(xpath = "((//div[@class='ui search focus mt-30 lbel25'])[1]//div)[4]")
    public WebElement nameErrorMessage;

    @FindBy(xpath = "((//div[@class='ui search focus mt-30 lbel25'])[2]//div)[4]")
    public WebElement bsnErrorMessage;

    @FindBy(xpath = "((//div[@class='ui search focus lbel25 mt-30'])[1]//div)[5]")
    public WebElement addressErrorMessage;

    @FindBy(xpath = "((//div[@class='ui search focus mt-30 lbel25'])[3]//div)[4]")
    public WebElement postCodeErrorMessage;

    @FindBy(xpath = "((//div[@class='ui search focus mt-30 lbel25'])[4]//div)[4]")
    public WebElement countryErrorMessage;

    @FindBy(xpath = "((//div[@class='ui search focus mt-30 lbel25'])[5]//div)[4]")
    public WebElement personalNameErrorMessage;

    @FindBy(xpath = "((//div[@class='ui search focus mt-30 lbel25'])[6]//div)[4]")
    public WebElement phoneErrorMessage;

    @FindBy(xpath = "((//div[@class='ui search focus mt-30 lbel25'])[7]//div)[3]")
    public WebElement emailErrorMessage;

    @FindBy(xpath = "((//div[@class='ui search focus mt-30 lbel25'])[8]//div)[2]")
    public WebElement expireDateErrorMessage;

    @FindBy(xpath = "(//i[@class='uil uil-edit-alt'])[1]")
    public WebElement firstClientsEditButton;

    @FindBy(xpath = "//button[@class='swal2-confirm swal2-styled swal2-default-outline']")
    public WebElement yesDeleteItButton;

    @FindBy(xpath = "//button[@class='swal2-cancel swal2-styled swal2-default-outline']")
    public WebElement cancelButton;

    public void a() {
    }

}
