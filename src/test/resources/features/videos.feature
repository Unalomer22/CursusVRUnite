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
    And Search butonuna tiklanir
    Then Listelenen verilerin "Video13" yi icerdigi dogrulanir

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
    And Create New "Video" butonuna tiklanir
    And New Video Titlei girilir
    And Bilgisayardan video secilir
    And Clients drop downundan "Omer UNAL" clienti secilir
    And Yeni kayit olusturma sayfasindaki Save Changes butonuna tiklanir
    Then Faker ile uretilen title ile yeni bir videonun eklendigi dogrulanir

  Scenario: Eksik girdilerle yeni video yuklenmesi yapilamamalidir(Title eksik)
    And Create New "Video" butonuna tiklanir
    And Bilgisayardan video secilir
    And Clients drop downundan "Omer UNAL" clienti secilir
    And Yeni kayit olusturma sayfasindaki Save Changes butonuna tiklanir
    Then Videos tabinda sistemin hata verdigi gozlemlenir

  Scenario: Eksik girdilerle yeni video yuklenmesi yapilamamalidir(Video eksik)
    And Create New "Video" butonuna tiklanir
    And New Video Titlei girilir
    And Clients drop downundan "Omer UNAL" clienti secilir
    And Yeni kayit olusturma sayfasindaki Save Changes butonuna tiklanir
    Then Videos tabinda sistemin hata verdigi gozlemlenir

  Scenario: Eksik girdilerle yeni video yuklenmesi yapilamamalidir(Client eksik)
    And Create New "Video" butonuna tiklanir
    And New Video Titlei girilir
    And Bilgisayardan video secilir
    And Yeni kayit olusturma sayfasindaki Save Changes butonuna tiklanir
    Then Videos tabinda sistemin hata verdigi gozlemlenir

  Scenario Outline: Birden fazla musteri icin kayit olusturulabilir.
    And Create New "Video" butonuna tiklanir
    And New Video Titlei girilir
    And Bilgisayardan video secilir
    And Clients drop downundan "<musteri01>" clienti secilir
    And Clients drop downundan "<musteri02>" clienti secilir
    And Yeni kayit olusturma sayfasindaki Save Changes butonuna tiklanir
    Then Faker ile uretilen title ile yeni bir videonun eklendigi dogrulanir
    Examples: Musteriler
      | musteri01 | musteri02 |
      | Omer UNAL | Musteri04 |
      | Musteri07 | Musteri09 |

  Scenario: Mevcut video duzenlenebilir.(Titleda degisiklik)
    And Ilk kaydin duzenle butonuna tiklanir
    And "Title" text boxindaki veri silinir, "Yeni Title" yeni veri eklenir
    And Yeni kayit olusturma sayfasindaki Save Changes butonuna tiklanir
    And Ilk kaydin duzenle butonuna tiklanir
    Then "Title" text boxindaki verinin "Yeni Title" oldugu dogrulanir

#UNAUTOMATED
#  Scenario: Mevcut video duzenlenebilir.(Video degisiklik)
#    And Ilk kaydin duzenle butonuna tiklanir
#    And "Title" text boxindaki veri silinir, "Yeni Title" yeni veri eklenir
#    And Videos tabindaki save butonuna tiklanir
#    And Ilk kaydin duzenle butonuna tiklanir
#    Then "Title" text boxindaki verinin "Yeni Title" oldugu dogrulanir

  Scenario: Mevcut video duzenlenebilir.(Clientte degisiklik)
    And Ilk kaydin duzenle butonuna tiklanir
    And Clients drop downundaki mevcut client silinir
    And Clients drop downundan "Musteri09" clienti secilir
    And Yeni kayit olusturma sayfasindaki Save Changes butonuna tiklanir
    And "Videos" sayfasi acilir
    And Ilk kaydin duzenle butonuna tiklanir
    Then Ilgili kaydin clientinin "Musteri09" oldugu dogrulanir

  Scenario: Mevcut kayit silinebilir. Silmeden önce kullanicidan onay istenir.(Videos)
    And 2.ci videonun delete butonuna basilir
    And Yes, delete it! butonuna tiklanir
    Then Ilgili kaydin listeden silindigi gozlemlenir

  Scenario: Mevcut kayit silinebilir. Silmeden önce kullanicidan onay istenir. Kullanici onay vermezse kayit silinme islemi gerceklesmez(Videos)
    And 4.ci videonun delete butonuna basilir
    And Cancel butonuna tiklanir
    Then Ilgili kaydin listeden silinmedigi gozlemlenir