package com.cursusVrUnit.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeadsetsPage extends BasePage {

    @FindBy(id = "id_serial_number")
    public WebElement serialNumber;

    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement isActiveCheckBox;

    @FindBy(xpath = "//tr[1]//td[1]")
    public WebElement firstHeadsetSerialNumber;

    @FindBy(id = "id_serial_number")
    public WebElement searchTextBox;

    @FindBy(xpath = "//tr//td[3]")
    public WebElement activeness;

    @FindBy(xpath = "//span[@style='color:red;']")
    public WebElement serialNumberErrorMessage;

}
