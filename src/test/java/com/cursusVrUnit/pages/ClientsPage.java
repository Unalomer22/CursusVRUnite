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


}
