Feature: Login

  Background: Login Page'e giris
    Given Cursus Ana Sayfasina gidilir
    And Ana sayfadaki login butonuna tiklanir
@wip
  Scenario: Login with valid username and password
    And "username01" username girilir
    And "password01" sifre girilir
    And Login sayfasindaki login butonuna tiklanir
    Then Sisteme login yapildigi dogrulanir

  Scenario Outline: Login with invalid cridentials
    And "<usernames>" username girilir
    And "<passwords>" sifre girilir
    And Login sayfasindaki login butonuna tiklanir
    Then Login sayfasinda sistemin hata verdigi "logInPageErrorMessage" dogrulanir
    Examples: Kullanici Adi ve Sifreler
      | usernames       | passwords       |
      | usernameInvalid | password01      |
      | username01      | passwordInvalid |
      | usernameInvalid | passwordInvalid |