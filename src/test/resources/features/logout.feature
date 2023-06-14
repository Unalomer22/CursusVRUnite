Feature: User Functionalities

  Background:Kullanicinin daha oncesinden sisteme giris yapmis olmasi
    Given Cursus Ana Sayfasina gidilir
    And Ana sayfadaki login butonuna tiklanir
    And "username01" username girilir
    And "password01" sifre girilir
    And Login sayfasindaki login butonuna tiklanir

  Scenario: Kullanici sistemden cikis yapabilir Cursus tabindan
    And Cursus goruntusune tiklanir
    And Sag ustte bulunan kullanici ikonuna tiklanir
    And Sign Out butonuna tiklanir

  Scenario: Kullanici sistemden cikis yapabilir Dashboard tabindan
    And "Dashboard" sayfasi acilir
    And Sag ustte bulunan kullanici ikonuna tiklanir
    And Sign Out butonuna tiklanir

  Scenario: Kullanici sistemden cikis yapabilir Clients tabindan
    And "Clients" sayfasi acilir
    And Sag ustte bulunan kullanici ikonuna tiklanir
    And Sign Out butonuna tiklanir

  Scenario: Kullanici sistemden cikis yapabilir Videos tabindan
    And "Videos" sayfasi acilir
    And Sag ustte bulunan kullanici ikonuna tiklanir
    And Sign Out butonuna tiklanir

  Scenario: Kullanici sistemden cikis yapabilir Headsets tabindan
    And "Headsets" sayfasi acilir
    And Sag ustte bulunan kullanici ikonuna tiklanir
    And Sign Out butonuna tiklanir

    @wip
  Scenario: Kullanici sifresini gecerli bir sifre ile degistirebilir
    And Sag ustte bulunan kullanici ikonuna tiklanir
    And "Change Password" sayfasi acilir
    And Old Password text boxina "password01" sifresi yazilir
    And New Password text boxina sifresi yazilir
    And New Password Confirmation text boxina sifresi yazilir
    And Save butonuna tiklanir

  Scenario: Kullanici sifresini gecersiz(Your password must contain at least 8 characters.) sifre ile degistiremez.
    And Sag ustte bulunan kullanici ikonuna tiklanir
    And "Change Password" sayfasi acilir
    And Old Password text boxina "password01" sifresi yazilir
    And New Password text boxina gecersiz sekiz karakterden az sifre yazilir
    And New Password Confirmation text boxina gecersiz sekiz karakterden az sifre yazilir
    And Save butonuna tiklanir




