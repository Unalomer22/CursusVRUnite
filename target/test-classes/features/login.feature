Feature: Login

  Scenario: Login with valid username and password
    Given Cursus Ana Sayfasina gidilir
    And Ana sayfadaki login butonuna tiklanir
    And "username01" username girilir
    And "password01" sifre girilir
    And Login sayfasindaki login butonuna tiklanir
#    And Driver kapatilir


  Scenario: Login with invalid username and valid password
    Given Cursus Ana Sayfasina gidilir
    And Ana sayfadaki login butonuna tiklanir
    And "usernameInvalid" username girilir
    And "password01" sifre girilir
    And Login sayfasindaki login butonuna tiklanir
    Then Login sayfasinda sistemin hata verdigi "logInPageErrorMessage" dogrulanir

  Scenario: Login with valid username and invalid password
    Given Cursus Ana Sayfasina gidilir
    And Ana sayfadaki login butonuna tiklanir
    And "username01" username girilir
    And "passwordInvalid" sifre girilir
    And Login sayfasindaki login butonuna tiklanir
    Then Login sayfasinda sistemin hata verdigi "logInPageErrorMessage" dogrulanir

  Scenario: Login with invalid username and invalid password
    Given Cursus Ana Sayfasina gidilir
    And Ana sayfadaki login butonuna tiklanir
    And "usernameInvalid" username girilir
    And "passwordInvalid" sifre girilir
    And Login sayfasindaki login butonuna tiklanir
    Then Login sayfasinda sistemin hata verdigi "logInPageErrorMessage" dogrulanir