import java.util.Scanner;

public class Oyun {
    Scanner scanner = new Scanner(System.in);


    public static void Baslat()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("            HANOİ KULESİ ");
        System.out.println("-------------------------------------\n");

        Kuleler kuleler = new Kuleler();
        System.out.print("Kac adet disk bulunsun ? : "); //Disk sayısı alınır
        int  N = scanner.nextInt() ; //Disk sayısını alır  N:Disk sayısı
        kuleler.setDiskSayisi(N);    //Alınan disk sayısı Kuleler classında bulunan setDiskSayisi() metoduna atanır.


        //Static olarak alınan disk sayısına bağlı olarak ilk elemandan başlanarak eleman sayıları artarak (N-1)'e
        // kadar olan indexlere yerleştirilir
        for (int i = 0; i < N; i++)  // (N) adet eleman için işlem tekrarlanır
        {
            String eleman="";  // Her index için değer içi boşaltılır
            for (int j = 0; j <= i; j++)
            {
                eleman += "X";
            }
            Kuleler.kule1.add(eleman); // Oyun başlangıcında diskler kule1 içerisine yerleştirilir
        }


        kuleler.KuleleriGoster(); // Kuleler oyun başlangıcında gösterilir
        Oyun oyun = new Oyun();
        oyun.KuledenDiskAl();
        // Oyun classı içerisinde bulunan KuledenDiskAl() metodu oyun referansı ile çağırılarak oyun başlatılır


    }

    public void KuledenDiskAl()
    {
        Kuleler kuleler = new Kuleler(); //Kuleler classından kuleler referansı oluşturulur

        int kuleSec; // Kulelerde bulunan diskleri almak için oluşturulan kuleSec değişkeni
        System.out.print("Hangi kuledeki diski almak istersiniz ? : ");
        kuleSec = scanner.nextInt();

        while (kuleSec <= 0 || kuleSec >3) //Belirlenen kuleler secilmezse tekrar deger alınır
        {
            System.out.println("Hatali kule secimi! Tanimlanan kulelerden birini seciniz :  ");
            kuleSec = scanner.nextInt();

        }


        switch (kuleSec) //Seçilen kule için işlem yapar
        {

            case 1:
                if(Kuleler.kule1.isEmpty()) //Kule boş ise
                {
                    System.out.println("Kulede disk bulunmamakta ! Lutfen disk bulunan bir kule sec ");
                    KuledenDiskAl(); //Tekrar kule secimine yonlendirir
                }
                else // Kule doluysa
                {
                    KuleyeDiskBirak(Kuleler.kule1.firstElement(),1);
                    //Seçilen kuledeki ilk eleman KuleyeDiskBirak() metoduna yönlendirilir ve hangi kuleden geldiyse
                    // o kulenin numarası gönderilir
                }
                break;

            case 2:
                if(Kuleler.kule2.isEmpty()) //Kule boş ise
                {
                    System.out.println("Kulede disk bulunmamakta ! Lutfen disk bulunan bir kule sec ");
                    KuledenDiskAl(); //Tekrar kule secimine yonlendirir
                }
                else
                {
                    KuleyeDiskBirak(Kuleler.kule2.firstElement(),2);
                    //Seçilen kuledeki ilk eleman KuleyeDiskBirak() metoduna yönlendirilir ve hangi kuleden geldiyse
                    // o kulenin numarası gönderilir

                }
                break;

            case 3:
                if(Kuleler.kule3.isEmpty()) //Kule boş ise
                {
                    System.out.println("Kulede disk bulunmamakta ! Lutfen disk bulunan bir kule sec ");
                    KuledenDiskAl(); //Tekrar kule secimine yonlendirir
                }
                else
                {
                    KuleyeDiskBirak(Kuleler.kule3.firstElement(),3);
                    //Seçilen kuledeki ilk eleman KuleyeDiskBirak() metoduna yönlendirilir ve hangi kuleden geldiyse
                    // o kulenin numarası gönderilir
                }
                break;
        }

    }


    public void KuleyeDiskBirak(String kuledenAlinanDisk,int hangiKule)
    //Seçilen kuledeki ilk eleman kuledenAlinanDisktir ve hangi kuleden geldigi belirtilir
    {
        Kuleler kuleler = new Kuleler(); // Kuleler classından kuleler referansı olustulur

        int kuleSec; //Disk birakılacak kule için tanımlanır
        int adim=0; //Oyun adım sayısını tutmak icin tanımlanır

        System.out.print("Hangi kuleye diski bırakmak istersiniz ? : ");
        kuleSec = scanner.nextInt();

        while (kuleSec <= 0 || kuleSec >3) //Belirlenen kuleler secilmezse tekrar deger alınır
        {
            System.out.println("Hatali kule secimi! Tanimlanan kulelerden birini seciniz :  ");
            kuleSec = scanner.nextInt();

        }


        switch (kuleSec) //Secilen kulenin numarasına bağlı olarak girer
        {
            case 1:
                if(!Kuleler.kule1.isEmpty()) //Eğer kule boş değilse
                {
                    if(kuledenAlinanDisk.length() > Kuleler.kule1.firstElement().length())  //Eğer kuleden alınan disk boyutu
                    {                                                                       //eklenen kulenin ilk eleman boyutundan
                        System.out.println("Kucuk diskin üzerine buyuk disk konulamaz!");   //buyukse disk konulamaz!
                    }
                    else {
                        Kuleler.kule1.add(0,kuledenAlinanDisk);
                        // Konulacak disk tum sartları sagladıgı icin secilen kuleye 0.index olarak disk eklenir


                        //Disk yeni kuleye eklendigi icin eski bulundugu kuleden degeri  silinir
                        //KuleyeDiskBirak() metodunda bulunan hangiKule parametresi sayesinde kuleden degeri silinir
                        switch (hangiKule)
                        {
                            case 1:
                                Kuleler.kule1.remove(Kuleler.kule1.firstElement()); //Kule1 icin ilk eleman silinir
                                break;
                            case 2:
                                Kuleler.kule2.remove(Kuleler.kule2.firstElement()); //Kule2 icin ilk eleman silinir
                                break;
                            case 3:
                                Kuleler.kule3.remove(Kuleler.kule3.firstElement()); //Kule3 icin ilk eleman silinir
                                break;
                        }
                        adim++; // Tum kosullar saglandıgı icin oyun hamle sayısı bir deger artar
                        Kuleler.setAdimSayisi(adim); //Kuleler classında bulunan setAdimSayisi metotu guncellenir
                        System.out.println("Toplam Adim Sayisi : " + Kuleler.getAdimSayisi());

                    }
                }
                else { //Eger secilen kule bos ise disk direk olarak kuleye yerlestirilir
                    Kuleler.kule1.add(0,kuledenAlinanDisk);
                    // Konulacak disk tum sartları sagladıgı icin secilen kuleye 0.index olarak disk eklenir


                    //Disk yeni kuleye eklendigi icin eski bulundugu kuleden degeri  silinir
                    //KuleyeDiskBirak() metodunda bulunan hangiKule parametresi sayesinde kuleden degeri silinir
                    switch (hangiKule)
                    {
                        case 1:
                            Kuleler.kule1.remove(Kuleler.kule1.firstElement()); //Kule1 icin ilk eleman silinir
                            break;
                        case 2:
                            Kuleler.kule2.remove(Kuleler.kule2.firstElement()); //Kule2 icin ilk eleman silinir
                            break;
                        case 3:
                            Kuleler.kule3.remove(Kuleler.kule3.firstElement()); //Kule3 icin ilk eleman silinir
                            break;
                    }

                    adim++; //Tum kosullar saglandıgı icin oyun hamle sayısı bir deger artar
                    Kuleler.setAdimSayisi(adim); //Kuleler classında bulunan setAdimSayisi metotu guncellenir
                    System.out.println("Toplam Adim Sayisi : " + Kuleler.getAdimSayisi());
                }

                kuleler.KuleleriGoster(); //Yapılan islemler sonucunda kuleler tekrar gosterilir
                KuledenDiskAl(); //Yeniden kulelerden disk almak icin KuledenDiskAl() metodu cagrılır
                break;

            case 2:

                if(!Kuleler.kule2.isEmpty()) //Eğer kule boş değilse
                {

                    if(kuledenAlinanDisk.length() > Kuleler.kule2.firstElement().length()) //Eğer kuleden alınan disk boyutu
                    {                                                                      //eklenen kulenin ilk eleman boyutundan
                        System.out.println("Kucuk diskin üzerine buyuk disk konulamaz!");  //buyukse disk konulamaz!
                    }
                    else {
                        Kuleler.kule2.add(0,kuledenAlinanDisk);
                        // Konulacak disk tum sartları sagladıgı icin secilen kuleye 0.index olarak disk eklenir


                        //Disk yeni kuleye eklendigi icin eski bulundugu kuleden degeri  silinir
                        //KuleyeDiskBirak() metodunda bulunan hangiKule parametresi sayesinde kuleden degeri silinir
                        switch (hangiKule)
                        {
                            case 1:
                                Kuleler.kule1.remove(Kuleler.kule1.firstElement()); //Kule1 icin ilk eleman silinir
                                break;
                            case 2:
                                Kuleler.kule2.remove(Kuleler.kule2.firstElement()); //Kule2 icin ilk eleman silinir
                                break;
                            case 3:
                                Kuleler.kule3.remove(Kuleler.kule3.firstElement()); //Kule3 icin ilk eleman silinir
                                break;
                        }

                        adim++; // Tum kosullar saglandıgı icin oyun hamle sayısı bir deger artar
                        Kuleler.setAdimSayisi(adim); //Kuleler classında bulunan setAdimSayisi metotu guncellenir
                        System.out.println("Toplam Adim Sayisi : " + Kuleler.getAdimSayisi());
                    }
                }
                else {  //Eger secilen kule bos ise disk direk olarak kuleye yerlestirilir
                    Kuleler.kule2.add(0,kuledenAlinanDisk);
                    // Konulacak disk tum sartları sagladıgı icin secilen kuleye 0.index olarak disk eklenir


                    //Disk yeni kuleye eklendigi icin eski bulundugu kuleden degeri  silinir
                    //KuleyeDiskBirak() metodunda bulunan hangiKule parametresi sayesinde kuleden degeri silinir
                    switch (hangiKule)
                    {
                        case 1:
                            Kuleler.kule1.remove(Kuleler.kule1.firstElement()); //Kule1 icin ilk eleman silinir
                            break;
                        case 2:
                            Kuleler.kule2.remove(Kuleler.kule2.firstElement()); //Kule2 icin ilk eleman silinir
                            break;
                        case 3:
                            Kuleler.kule3.remove(Kuleler.kule3.firstElement()); //Kule3 icin ilk eleman silinir
                            break;
                    }
                    adim++; //Tum kosullar saglandıgı icin oyun hamle sayısı bir deger artar
                    Kuleler.setAdimSayisi(adim); //Kuleler classında bulunan setAdimSayisi metotu guncellenir
                    System.out.println("Toplam Adim Sayisi : " + Kuleler.getAdimSayisi());

                }
                kuleler.KuleleriGoster(); //Yapılan islemler sonucunda kuleler tekrar gosterilir
                KuledenDiskAl(); //Yeniden kulelerden disk almak icin KuledenDiskAl() metodu cagrılır
                break;

            case 3:
                if(!Kuleler.kule3.isEmpty()) //Eğer kule boş değilse
                {
                    if(kuledenAlinanDisk.length() > Kuleler.kule3.firstElement().length()) //Eğer kuleden alınan disk boyutu
                    {                                                                      //eklenen kulenin ilk eleman boyutundan
                        System.out.println("Kucuk diskin üzerine buyuk disk konulamaz!");  //buyukse disk konulamaz!
                    }
                    else {
                        Kuleler.kule3.add(0,kuledenAlinanDisk);
                        // Konulacak disk tum sartları sagladıgı icin secilen kuleye 0.index olarak disk eklenir


                        //Disk yeni kuleye eklendigi icin eski bulundugu kuleden degeri  silinir
                        //KuleyeDiskBirak() metodunda bulunan hangiKule parametresi sayesinde kuleden degeri silinir
                        switch (hangiKule)
                        {
                            case 1:
                                Kuleler.kule1.remove(Kuleler.kule1.firstElement()); //Kule1 icin ilk eleman silinir
                                break;
                            case 2:
                                Kuleler.kule2.remove(Kuleler.kule2.firstElement()); //Kule2 icin ilk eleman silinir
                                break;
                            case 3:
                                Kuleler.kule3.remove(Kuleler.kule3.firstElement()); //Kule3 icin ilk eleman silinir
                                break;
                        }
                        adim++; //Tum kosullar saglandıgı icin oyun hamle sayısı bir deger artar
                        Kuleler.setAdimSayisi(adim); //Kuleler classında bulunan setAdimSayisi metotu guncellenir
                        System.out.println("Toplam Adim Sayisi : " + Kuleler.getAdimSayisi());

                    }
                }
                else {  //Eger secilen kule bos ise disk direk olarak kuleye yerlestirilir
                    Kuleler.kule3.add(0,kuledenAlinanDisk);
                    // Konulacak disk tum sartları sagladıgı icin secilen kuleye 0.index olarak disk eklenir


                    //Disk yeni kuleye eklendigi icin eski bulundugu kuleden degeri  silinir
                    //KuleyeDiskBirak() metodunda bulunan hangiKule parametresi sayesinde kuleden degeri silinir
                    switch (hangiKule)
                    {
                        case 1:
                            Kuleler.kule1.remove(Kuleler.kule1.firstElement()); //Kule1 icin ilk eleman silinir
                            break;
                        case 2:
                            Kuleler.kule2.remove(Kuleler.kule2.firstElement()); //Kule2 icin ilk eleman silinir
                            break;
                        case 3:
                            Kuleler.kule3.remove(Kuleler.kule3.firstElement()); //Kule3 icin ilk eleman silinir
                            break;
                    }
                    adim++; //Tum kosullar saglandıgı icin oyun hamle sayısı bir deger artar
                    Kuleler.setAdimSayisi(adim); //Kuleler classında bulunan setAdimSayisi metotu guncellenir
                    System.out.println("Toplam Adim Sayisi : " + Kuleler.getAdimSayisi());

                }
                kuleler.KuleleriGoster(); //Yapılan islemler sonucunda kuleler tekrar gosterilir


                //Eğer kulede bütün diskler bulunursa oyun kazanılmış olur ve biter.
                if(Kuleler.kule3.size() == kuleler.getDiskSayisi())
                {
                    System.out.println("TEBRİKLER OYUNU KAZANDINIZ!");
                }
                else //Kulede eksik disk varsa oyuna KuledenDiskAl() metoduyla devam edilir.
                {
                    KuledenDiskAl();
                }
                break;
        }



    }

}
