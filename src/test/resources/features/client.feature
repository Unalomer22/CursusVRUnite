Feature: Client Functionality

  Background: Clients tabi acilir
    Given Cursus Ana Sayfasina gidilir
    And Ana sayfadaki login butonuna tiklanir
    And "username01" username girilir
    And "password01" sifre girilir
    And Login sayfasindaki login butonuna tiklanir
    And "Clients" sayfasi acilir

  Scenario Outline: Listede arama yapilabilir(Isme gore, BSN gore, Telefon numarasina gore, Ulkeye gore)
    And Clients tabindaki arama kutusuna "<arananVeri>" musterisinin bilgisi yazilir
    And Search butonuna tiklanir
    Then Listelenen verilerin "<arananVeri>" yi icerdigi dogrulanir
    Examples: Sutuna gore sirasiyla arama yapilacak veriler
      | arananVeri        |
      | Musteri10         |
      | 23131221331221123 |
      | 123123123123      |
      | Almanya           |

  Scenario: Listede arama yapilabilir(Isme göre ve mevcut olmayan bir isim)
    And Clients tabindaki arama kutusuna "Ahmet" musterisinin bilgisi yazilir
    And Search butonuna tiklanir
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
    And Create New "Client" butonuna tiklanir
    And Gerekli valid Client bilgileri girilir
    And Yeni kayit olusturma sayfasindaki Save Changes butonuna tiklanir
    Then Olusturulan clientin verileri listeden dogrulanir

  Scenario: Eksik girdi ile yeni kayit olusturulamamalidir.(Isim eksik)
    And Create New "Client" butonuna tiklanir
    And New Client BSN numarasi girilir
    And New client Adress girilir
    And New Client Post Code girilir
    And New Client Country girilir
    And New Client Personel Name girilir
    And New Client Phone Number girilir
    And New Client Email girilir
    And New Client Expire Date girilir
    And Yeni kayit olusturma sayfasindaki Save Changes butonuna tiklanir
    Then "name" Text boxinin altinda hata mesajinin gorundugu dogrulanir

  Scenario: Eksik girdi ile yeni kayit olusturulamamalidir.(BSN  eksik)
    And Create New "Client" butonuna tiklanir
    And New Client Name girilir
    And New client Adress girilir
    And New Client Post Code girilir
    And New Client Country girilir
    And New Client Personel Name girilir
    And New Client Phone Number girilir
    And New Client Email girilir
    And New Client Expire Date girilir
    And Yeni kayit olusturma sayfasindaki Save Changes butonuna tiklanir
    Then "bsn" Text boxinin altinda hata mesajinin gorundugu dogrulanir

  Scenario: Eksik girdi ile yeni kayit olusturulamamalidir.(Adress eksik)
    And Create New "Client" butonuna tiklanir
    And New Client Name girilir
    And New Client BSN numarasi girilir
    And New Client Post Code girilir
    And New Client Country girilir
    And New Client Personel Name girilir
    And New Client Phone Number girilir
    And New Client Email girilir
    And New Client Expire Date girilir
    And Yeni kayit olusturma sayfasindaki Save Changes butonuna tiklanir
    Then "address" Text boxinin altinda hata mesajinin gorundugu dogrulanir

  Scenario: Eksik girdi ile yeni kayit olusturulamamalidir.(Post Code eksik)
    And Create New "Client" butonuna tiklanir
    And New Client Name girilir
    And New Client BSN numarasi girilir
    And New client Adress girilir
    And New Client Country girilir
    And New Client Personel Name girilir
    And New Client Phone Number girilir
    And New Client Email girilir
    And New Client Expire Date girilir
    And Yeni kayit olusturma sayfasindaki Save Changes butonuna tiklanir
    Then "post code" Text boxinin altinda hata mesajinin gorundugu dogrulanir

  Scenario: Eksik girdi ile yeni kayit olusturulamamalidir.(Country eksik)
    And Create New "Client" butonuna tiklanir
    And New Client Name girilir
    And New Client BSN numarasi girilir
    And New client Adress girilir
    And New Client Post Code girilir
    And New Client Personel Name girilir
    And New Client Phone Number girilir
    And New Client Email girilir
    And New Client Expire Date girilir
    And Yeni kayit olusturma sayfasindaki Save Changes butonuna tiklanir
    Then "country" Text boxinin altinda hata mesajinin gorundugu dogrulanir

  Scenario: Eksik girdi ile yeni kayit olusturulamamalidir.(Personel Name eksik)
    And Create New "Client" butonuna tiklanir
    And New Client Name girilir
    And New Client BSN numarasi girilir
    And New client Adress girilir
    And New Client Post Code girilir
    And New Client Country girilir
    And New Client Phone Number girilir
    And New Client Email girilir
    And New Client Expire Date girilir
    And Yeni kayit olusturma sayfasindaki Save Changes butonuna tiklanir
    Then "personal name" Text boxinin altinda hata mesajinin gorundugu dogrulanir

  Scenario: Eksik girdi ile yeni kayit olusturulamamalidir.(Phone Number eksik)
    And Create New "Client" butonuna tiklanir
    And New Client Name girilir
    And New Client BSN numarasi girilir
    And New client Adress girilir
    And New Client Post Code girilir
    And New Client Country girilir
    And New Client Personel Name girilir
    And New Client Email girilir
    And New Client Expire Date girilir
    And Yeni kayit olusturma sayfasindaki Save Changes butonuna tiklanir
    Then "phone number" Text boxinin altinda hata mesajinin gorundugu dogrulanir

  Scenario: Eksik girdi ile yeni kayit olusturulamamalidir.(Email eksik)
    And Create New "Client" butonuna tiklanir
    And New Client Name girilir
    And New Client BSN numarasi girilir
    And New client Adress girilir
    And New Client Post Code girilir
    And New Client Country girilir
    And New Client Personel Name girilir
    And New Client Phone Number girilir
    And New Client Expire Date girilir
    And Yeni kayit olusturma sayfasindaki Save Changes butonuna tiklanir
    Then "email" Text boxinin altinda hata mesajinin gorundugu dogrulanir

  Scenario: Eksik girdi ile yeni kayit olusturulamamalidir.(Expire Date eksik)
    And Create New "Client" butonuna tiklanir
    And New Client Name girilir
    And New Client BSN numarasi girilir
    And New client Adress girilir
    And New Client Post Code girilir
    And New Client Country girilir
    And New Client Personel Name girilir
    And New Client Phone Number girilir
    And New Client Email girilir
    And Yeni kayit olusturma sayfasindaki Save Changes butonuna tiklanir
    Then "expire date" Text boxinin altinda hata mesajinin gorundugu dogrulanir

  Scenario Outline: Mevcut kayit duzenlenebilir.(Isimde degisiklik)
    And Ilk kaydin duzenle butonuna tiklanir
    And "<degisiklikYapilacakAlan>" text boxindaki veri silinir, "<yeniVeri>" yeni veri eklenir
    And Yeni kayit olusturma sayfasindaki Save Changes butonuna tiklanir
    And Ilk kaydin duzenle butonuna tiklanir
    Then "<degisiklikYapilacakAlan>" text boxindaki verinin "<yeniVeri>" oldugu dogrulanir
    Examples:
      | degisiklikYapilacakAlan | yeniVeri           |
      | name                    | Furkan ronaldo     |
      | bsn                     | 684768758765875    |
      | address                 | Schwerin           |
      | post code               | 064289             |
      | country                 | France             |
      | personal name           | Ahmet Necdet SEZER |
      | phone number            | 01784783948        |
      | email                   | ahmet@gmail.com    |
      | expire date             | 2023-09-16         |

  Scenario: Mevcut kayit silinebilir. Silmeden önce kullanicidan onay istenir.
    And 5.ci kaydin delete butonuna basilir
    And Yes, delete it! butonuna tiklanir
    Then Ilgili Kaydin listeden silindigi gozlemlenir

  Scenario: Mevcut kayit silinebilir. Silmeden önce kullanicidan onay istenir. Kullanici onay vermezse kayit silinme islemi gerceklesmez
    And 5.ci kaydin delete butonuna basilir
    And Cancel butonuna tiklanir
    Then Ilgili Kaydin listeden silinmedigi gozlemlenir