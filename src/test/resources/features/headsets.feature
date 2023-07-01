Feature: Headset Functionality

  Background: Headsets tabi acilir
    Given Cursus Ana Sayfasina gidilir
    And Ana sayfadaki login butonuna tiklanir
    And "username01" username girilir
    And "password01" sifre girilir
    And Login sayfasindaki login butonuna tiklanir
    And "Headsets" sayfasi acilir

  Scenario: Listede arama yapilabilir(Isme gore)
    And Headsets tabindaki arama kutusuna "yu567567675756756567567567576756675" headset seri numarasi yazilir
    And Search butonuna tiklanir
    Then Listelenen verilerin "Musteri10" yi icerdigi dogrulanir

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

  Scenario: Yeni kayit olusturulabilir(Headset & Aktif)
    And Create New "Headset" butonuna tiklanir
    And Yeni Headsetin Serial Numberi girilir
    And Clients drop downundan "Omer UNAL" clienti secilir
    And Yeni kayit olusturma sayfasindaki Save Changes butonuna tiklanir
    Then Olusturulan Headsetin verileri listeden dogrulanir

  Scenario: Yeni kayit olusturulabilir(Headset & Deaktif)
    And Create New "Headset" butonuna tiklanir
    And Yeni Headsetin Serial Numberi girilir
    And Clients drop downundan "Omer UNAL" clienti secilir
    And Is Active check box'ina tiklanir
    And Yeni kayit olusturma sayfasindaki Save Changes butonuna tiklanir
    Then Olusturulan Headsetin verileri listeden dogrulanir

  Scenario: Eksik girdilerle yeni headset yuklenmesi yapilamamalidir(Serial Number eksik)
    And Create New "Headset" butonuna tiklanir
    And Clients drop downundan "Omer UNAL" clienti secilir
    And Yeni kayit olusturma sayfasindaki Save Changes butonuna tiklanir
    Then "serial number" Text boxinin altinda hata mesajinin gorundugu dogrulanir


#    Email gonderme servisine email verisi gitmedigi icin, servis hata veriyor. Paneli kullanan kisi bu hata ile karsilasiyor.
#   Bunun yerine Diger fieldlarda oldugu gibi "This field is required." hatasi tarzinda hatalar daha uygun olur.
#  Scenario: Eksik girdilerle yeni headset yuklenmesi yapilamamalidir(Musteri eksik)
#    And Create New "Headset" butonuna tiklanir
#    And Yeni Headsetin Serial Numberi girilir
#    And Is Active check box'ina tiklanir
#    And Yeni kayit olusturma sayfasindaki Save Changes butonuna tiklanir

  Scenario: Mevcut headset duzenlenebilir.(Serial Numberda degisiklik)
    And Ilk kaydin duzenle butonuna tiklanir
    And Mevcut serial number silinir
    And Yeni Headsetin Serial Numberi girilir
    And Yeni kayit olusturma sayfasindaki Save Changes butonuna tiklanir
    And Ilk kaydin duzenle butonuna tiklanir
    Then Ilgili headsetin serial numarasinin "newSerialNumber" oldugu dogrulanir

  Scenario: Mevcut headset duzenlenebilir.(Clientte degisiklik)
    And Ilk kaydin duzenle butonuna tiklanir
    And Clients drop downundaki mevcut client silinir
    And Clients drop downundan "Musteri09" clienti secilir
    And Yeni kayit olusturma sayfasindaki Save Changes butonuna tiklanir
    And Ilk kaydin duzenle butonuna tiklanir
    Then Ilgili kaydin clientinin "Musteri09" oldugu dogrulanir

  Scenario: Mevcut headset duzenlenebilir.(Aktiflikte degisiklik)
    And 3.ci headsetin aktiflik durumuna bakilir
    And 3. headsetin duzenle butonuna tiklanir
    And Is Active check box'ina tiklanir
    And Yeni kayit olusturma sayfasindaki Save Changes butonuna tiklanir
    Then 3. headsetin aktiflik durumununun guncellendigi gozlemlenir

  Scenario: Mevcut kayit silinebilir. Silmeden önce kullanicidan onay istenir.(Headset)
    And 3.ci kaydin delete butonuna basilir
    And Yes, delete it! butonuna tiklanir
    Then Ilgili kaydin listeden silindigi gozlemlenir

  Scenario: Mevcut kayit silinebilir. Silmeden önce kullanicidan onay istenir. Kullanici onay vermezse kayit silinme islemi gerceklesmez(Headset)
    And 3.ci kaydin delete butonuna basilir
    And Cancel butonuna tiklanir
    Then Ilgili kaydin listeden silinmedigi gozlemlenir