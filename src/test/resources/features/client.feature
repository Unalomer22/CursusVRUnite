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
    And Search butonuna tiklanir
    Then Listelenen verilerin "Musteri10" yi icerdigi dogrulanir

  Scenario: Listede arama yapilabilir(BSN gore)
    And Clients tabindaki arama kutusuna "23131221331221123" musterisinin bilgisi yazilir
    And Search butonuna tiklanir
    Then Listelenen verilerin "23131221331221123" musterisinin BSNsini icerdigi dogrulanir

  Scenario: Listede arama yapilabilir(Telefon numarasina gore)
    And Clients tabindaki arama kutusuna "123123123123" musterisinin bilgisi yazilir
    And Search butonuna tiklanir
    Then Listelenen verilerin "123123123123" musterisinin telefon numarasini icerdigi dogrulanir

  Scenario: Listede arama yapilabilir(Ulkeye gore)
    And Clients tabindaki arama kutusuna "Almanya" musterisinin bilgisi yazilir
    And Search butonuna tiklanir
    Then Listelenen verilerin "Almanya" musterisinin ulkesini icerdigi dogrulanir

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

  Scenario: Mevcut kayit duzenlenebilir.(Isimde degisiklik)
    And Ilk kaydin duzenle butonuna tiklanir
    And "name" text boxindaki veri silinir, "Furkan ronaldo" yeni veri eklenir
    And Yeni kayit olusturma sayfasindaki Save Changes butonuna tiklanir
    And Ilk kaydin duzenle butonuna tiklanir
    Then "name" text boxindaki verinin "Furkan ronaldo" oldugu dogrulanir

  Scenario: Mevcut kayit duzenlenebilir.(BSN degisiklik)
    And Ilk kaydin duzenle butonuna tiklanir
    And "bsn" text boxindaki veri silinir, "684768758765875" yeni veri eklenir
    And Yeni kayit olusturma sayfasindaki Save Changes butonuna tiklanir
    And Ilk kaydin duzenle butonuna tiklanir
    Then "bsn" text boxindaki verinin "684768758765875" oldugu dogrulanir

  Scenario: Mevcut kayit duzenlenebilir.(Address degisiklik)
    And Ilk kaydin duzenle butonuna tiklanir
    And "address" text boxindaki veri silinir, "Schwerin" yeni veri eklenir
    And Yeni kayit olusturma sayfasindaki Save Changes butonuna tiklanir
    And Ilk kaydin duzenle butonuna tiklanir
    Then "address" text boxindaki verinin "Schwerin" oldugu dogrulanir

  Scenario: Mevcut kayit duzenlenebilir.(Post Code degisiklik)
    And Ilk kaydin duzenle butonuna tiklanir
    And "post code" text boxindaki veri silinir, "064289" yeni veri eklenir
    And Yeni kayit olusturma sayfasindaki Save Changes butonuna tiklanir
    And Ilk kaydin duzenle butonuna tiklanir
    Then "post code" text boxindaki verinin "064289" oldugu dogrulanir

  Scenario: Mevcut kayit duzenlenebilir.(Country degisiklik)
    And Ilk kaydin duzenle butonuna tiklanir
    And "country" text boxindaki veri silinir, "France" yeni veri eklenir
    And Yeni kayit olusturma sayfasindaki Save Changes butonuna tiklanir
    And Ilk kaydin duzenle butonuna tiklanir
    Then "country" text boxindaki verinin "France" oldugu dogrulanir

  Scenario: Mevcut kayit duzenlenebilir.(Personal Name degisiklik)
    And Ilk kaydin duzenle butonuna tiklanir
    And "personal name" text boxindaki veri silinir, "Ahmet Necdet SEZER" yeni veri eklenir
    And Yeni kayit olusturma sayfasindaki Save Changes butonuna tiklanir
    And Ilk kaydin duzenle butonuna tiklanir
    Then "personal name" text boxindaki verinin "Ahmet Necdet SEZER" oldugu dogrulanir

  Scenario: Mevcut kayit duzenlenebilir.(Phone Number degisiklik)
    And Ilk kaydin duzenle butonuna tiklanir
    And "phone number" text boxindaki veri silinir, "01784783948" yeni veri eklenir
    And Yeni kayit olusturma sayfasindaki Save Changes butonuna tiklanir
    And Ilk kaydin duzenle butonuna tiklanir
    Then "phone number" text boxindaki verinin "01784783948" oldugu dogrulanir

  Scenario: Mevcut kayit duzenlenebilir.(Email degisiklik)
    And Ilk kaydin duzenle butonuna tiklanir
    And "email" text boxindaki veri silinir, "ahmet@gmail.com" yeni veri eklenir
    And Yeni kayit olusturma sayfasindaki Save Changes butonuna tiklanir
    And Ilk kaydin duzenle butonuna tiklanir
    Then "email" text boxindaki verinin "ahmet@gmail.com" oldugu dogrulanir

  Scenario: Mevcut kayit duzenlenebilir.(Expire Date degisiklik)
    And Ilk kaydin duzenle butonuna tiklanir
    And "expire date" text boxindaki veri silinir, "2023-09-16" yeni veri eklenir
    And Yeni kayit olusturma sayfasindaki Save Changes butonuna tiklanir
    And Ilk kaydin duzenle butonuna tiklanir
    Then "expire date" text boxindaki verinin "2023-09-16" oldugu dogrulanir

  Scenario: Mevcut kayit silinebilir. Silmeden önce kullanicidan onay istenir.
    And 5.ci kaydin delete butonuna basilir
    And Yes, delete it! butonuna tiklanir
    Then Ilgili Kaydin listeden silindigi gozlemlenir

  Scenario: Mevcut kayit silinebilir. Silmeden önce kullanicidan onay istenir. Kullanici onay vermezse kayit silinme islemi gerceklesmez
    And 5.ci kaydin delete butonuna basilir
    And Cancel butonuna tiklanir
    Then Ilgili Kaydin listeden silinmedigi gozlemlenir