import java.util.Scanner;
import java.util.Stack;

public class Kuleler {

    Scanner scanner = new Scanner(System.in);
    static Stack<String> kule1 = new Stack<>(); //Kule1 için oluşturulan yığın yapısı
    static Stack<String> kule2 = new Stack<>(); //Kule2 için oluşturulan yığın yapısı
    static Stack<String> kule3 = new Stack<>(); //Kule3 için oluşturulan yığın yapısı

    private static int diskSayisi,adimSayisi=0;
    // diskSayisi kule üzerinde bulunan disk sayısını ve adimSayisi oyundaki adım sayısı tanımlanır


    public void KuleleriGoster() //Kuleleri ve üzerinde bulunan diskleri gösteren metot
    {
        System.out.println("\n");
        for (String direkGez: kule1) {     //Kule1 üzerinde gezinip kuleyi ve kulede bulunan diskleri gösterir
            System.out.println(direkGez);
        }
        System.out.println("----------");
        System.out.println("     1 \n\n");


        for (String direkGez: kule2) {     //Kule2 üzerinde gezinip kuleyi ve kulede bulunan diskleri gösterir
            System.out.println(direkGez);
        }
        System.out.println("----------");
        System.out.println("     2 \n\n");


        for (String direkGez: kule3) {     //Kule3 üzerinde gezinip kuleyi ve kulede bulunan diskleri gösterir
            System.out.println(direkGez);
        }
        System.out.println("----------");
        System.out.println("     3 \n\n");
    }

    public int getDiskSayisi() {  //Disk sayısını döndüren metot
        return diskSayisi;
    }

    public void setDiskSayisi(int diskSayisi) {  //Disk sayısını değiştiren metot
        this.diskSayisi = diskSayisi;
    }

    public static int getAdimSayisi() {  //Oyunda yapılanan hamlenin sayısını veren metot
        return adimSayisi;
    }

    public static void setAdimSayisi(int adimSayisi) {  //Oyunda adım yapıldıkça adım sayısını arttıran metot
        Kuleler.adimSayisi += adimSayisi;
    }
}
