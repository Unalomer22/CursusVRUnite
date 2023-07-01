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
    Then Sistemden cikis yapildigi dogrulanir

  Scenario Outline: Kullanici sistemden cikis yapabilir Dashboard, Clients, Videos ve Headsets tabindan
    And "<tabs>" sayfasi acilir
    And Sag ustte bulunan kullanici ikonuna tiklanir
    And Sign Out butonuna tiklanir
    Then Sistemden cikis yapildigi dogrulanir
    Examples: Tablar
      | tabs      |
      | Dashboard |
      | Clients   |
      | Videos    |
      | Headsets  |

  Scenario: Kullanici sifresini gecerli bir sifre ile degistirebilir
    And Sag ustte bulunan kullanici ikonuna tiklanir
    And "Change Password" sayfasi acilir
    And Old Password text boxina "password01" sifresi yazilir
    And New Password text boxina sifresi yazilir
    And New Password Confirmation text boxina sifresi yazilir
    And Save butonuna tiklanir
    And Ana sayfadaki login butonuna tiklanir
    And "username01" username girilir
    And "password01" sifre girilir
    And Login sayfasindaki login butonuna tiklanir
    Then Sisteme login yapildigi dogrulanir
    Then Sistemin sifre degistirildigine dair mesaji dogrulanir

  Scenario Outline: Kullanici sifresini gecersiz(Your password must contain at least 8 characters. & Your password can’t be entirely numeric.) sifre ile degistiremez.
    And Sag ustte bulunan kullanici ikonuna tiklanir
    And "Change Password" sayfasi acilir
    And Old Password text boxina "password01" sifresi yazilir
    And New Password text boxina gecersiz "<invalidPassword>" sifre yazilir
    And New Password Confirmation text boxina gecersiz sifre yazilir
    And Save butonuna tiklanir
    Then Eski sifrenin yeni sifre ile degistirilmedigi dogrulanir
    Examples: Invalid Cridentials
      | invalidPassword |
      | sekizKarakterAz |
      | digitsOnly      |