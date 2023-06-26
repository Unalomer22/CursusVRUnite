Feature: Videos Functionality

  Background: Videos tabi acilir
    Given Cursus Ana Sayfasina gidilir
    And Ana sayfadaki login butonuna tiklanir
    And "username01" username girilir
    And "password01" sifre girilir
    And Login sayfasindaki login butonuna tiklanir
    And "Videos" sayfasi acilir

  Scenario: Listede arama yapilabilir(Isme gore)
    And Videos tabindaki arama kutusuna "Video13" musterisinin bilgisi yazilir
    And Videos tabindaki Search butonuna tiklanir
    Then Listelenen verilerin "Video13" musterisinin ismini icerdigi dogrulanir

  Scenario: Liste 10’ar kayitlik sayfalar halinde sayfalandirilir. Sayfalarda ileri-geri yada secilen ozel bir sayfaya gidilebilir.
    Then Sayfada 10 kayit oldugu dogrulanir

  Scenario: Liste 10’ar kayitlik sayfalar halinde sayfalandirilir. Sayfalarda ileri-geri yada secilen ozel bir sayfaya gidilebilir.(Next Button)
    And Sayfanin altinda bulunan "Next" butonuna tiklanir
    Then Sayfanin bir mevcut sayfadan bir sonraki sayfaya gectigi gozlemlenir

  Scenario: Liste 10’ar kayitlik sayfalar halinde sayfalandirilir. Sayfalarda ileri-geri yada secilen ozel bir sayfaya gidilebilir.(Previous Button)
    And Sayfanin altinda bulunan "Next" butonuna tiklanir
    And Sayfanin altinda bulunan "Previous" butonuna tiklanir
    Then Sayfanin bir mevcut sayfadan bir onceki sayfaya gectigi gozlemlenir

  Scenario: Liste 10’ar kayitlik sayfalar halinde sayfalandirilir. Sayfalarda ileri-geri yada secilen ozel bir sayfaya gidilebilir.(Ozel Sayfa Button)
    And Sayfanin altinda bulunan "2" butonuna tiklanir
    Then Sayfanin "2".ci sayfada oldugu dogrulanir

    Scenario: Yeni video yuklenebilir
      And Create New Video butonuna tiklanir
      And New Video Titlei girilir
      And Bilgisayardan video secilir
      And Clients drop downundan "Omer UNAL" clienti secilir
      And Videos tabindaki save butonuna tiklanir
