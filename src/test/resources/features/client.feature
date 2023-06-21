Feature: Client Functionality

  Background: Clients tabi acilir
    Given Cursus Ana Sayfasina gidilir
    And Ana sayfadaki login butonuna tiklanir
    And "username01" username girilir
    And "password01" sifre girilir
    And Login sayfasindaki login butonuna tiklanir
    And "Clients" sayfasi acilir

  Scenario: Listede arama yapilabilir(Isme gore)
    And Clients tabindaki arama kutusuna "Musteri10" musterisinin bilgisi yazilir
    And Clients tabindaki Search butonuna tiklanir
    Then Listelenen verilerin "Musteri10" musterisinin ismini icerdigi dogrulanir

  Scenario: Listede arama yapilabilir(BSN gore)
    And Clients tabindaki arama kutusuna "23131221331221123" musterisinin bilgisi yazilir
    And Clients tabindaki Search butonuna tiklanir
    Then Listelenen verilerin "23131221331221123" musterisinin BSNsini icerdigi dogrulanir

  Scenario: Listede arama yapilabilir(Telefon numarasina gore)
    And Clients tabindaki arama kutusuna "123123123123" musterisinin bilgisi yazilir
    And Clients tabindaki Search butonuna tiklanir
    Then Listelenen verilerin "123123123123" musterisinin telefon numarasini icerdigi dogrulanir

  Scenario: Listede arama yapilabilir(Ulkeye gore)
    And Clients tabindaki arama kutusuna "Almanya" musterisinin bilgisi yazilir
    And Clients tabindaki Search butonuna tiklanir
    Then Listelenen verilerin "Almanya" musterisinin ulkesini icerdigi dogrulanir

  Scenario: Listede arama yapilabilir(Isme göre ve mevcut olmayan bir isim)
    And Clients tabindaki arama kutusuna "Ahmet" musterisinin bilgisi yazilir
    And Clients tabindaki Search butonuna tiklanir
    Then Listelenen verilerin "Ahmet" musterisinin ismini icermedigi dogrulanir

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

    Scenario: Yeni kayit olusturulabilir(Client)
      And Create New Client butonuna tiklanir
      And Gerekli valid Client bilgileri girilir
      And Client sayfasindaki Save Changes butonuna tiklanir
      Then Olusturulan clientin verileri listeden dogrulanir
