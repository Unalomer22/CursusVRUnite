package com.cursusVrUnit.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VideosPage extends BasePage {

    @FindBy(id = "id_title")
    public WebElement searchTextBox;

    @FindBy(xpath = "//button[@class='more_items_14']")
    public WebElement searchButton;

    @FindBy(xpath = "//button[@class='create_btn_dash']")
    public WebElement createNewClientButton;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButton;

    @FindBy(id = "id_title")
    public WebElement videoTitleTextBox;

    @FindBy(id = "id_file")
    public WebElement videoUpload;

    @FindBy(xpath = "//i[@class='dropdown icon']")
    public WebElement clientsDropDown;

    @FindBy(xpath = "//div[@class='help-block']")
    public WebElement errorMessage;

    @FindBy(xpath = "//i[@class='delete icon']")
    public WebElement clientDeleteIcon;

    @FindBy(xpath = "//div[@class='prompt srch_explore ui dropdown cntry152 selection multiple']//a")
    public WebElement videonunClienti;
}
