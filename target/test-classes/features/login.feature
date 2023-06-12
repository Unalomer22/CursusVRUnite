Feature: Login

  Scenario: Login with valid username and password
    Given Cursus Ana Sayfasina gidilir
    And Ana sayfadaki login butonuna tiklanir
    And "username01" username girilir
    And "password01" sifre girilir
    And Login sayfasindaki login butonuna tiklanir