package test;

import java.util.LinkedList;
import java.util.Scanner;

public class Customer implements IText{

    public String Ad;
    public String Soyad;
    public int Yas;
    public int telNo;
    public boolean ehliyetVarMi;
    public String Adres = "Belirtilmedi";
    public LinkedList<Customer> musteriList = new LinkedList<>();
    public Scanner key = new Scanner(System.in);

    public Customer(String Ad, String Soyad, int Yas, int telNo, boolean ehliyetVarMi) {
        this.Ad = Ad;
        this.Soyad = Soyad;
        this.Yas = Yas;
        this.telNo = telNo;
        this.ehliyetVarMi = ehliyetVarMi;
    }

    public Customer(String Ad, String Soyad, int Yas, int telNo, boolean ehliyetVarMi,String Adres) {
        this.Ad = Ad;
        this.Soyad = Soyad;
        this.Yas = Yas;
        this.telNo = telNo;
        this.ehliyetVarMi = ehliyetVarMi;
        this.Adres = Adres;
    }

    public Customer() {

    }

        @Override
    public void ListeYazdirma() {
         for (int i = 0; i < musteriList.size(); i++) {
            System.out.println((i + 1) + "." + musteriList.get(i));
        }
    }
    @Override
    public String toString() {

        return "Müşteri Bilgisi \n" + "Ad :" + Ad + "\nSoyad :" + Soyad + "\nYas :" + Yas + "\ntelNo :" + telNo + "\nehliyetVarMi :" + ehliyetVarMi + "\nAdres : " + Adres+ "\n";
    }
/*
    public void musteriListYazdirma() {
        for (int i = 0; i < musteriList.size(); i++) {
            System.out.println((i + 1) + "." + musteriList.get(i));
        }
    }
*/

    public void varOlanMusteriListesiGoruntuleme() {
        musteriList.addFirst(new Customer("Resul", "Demir", 19, 741852963, false));
        musteriList.addFirst(new Customer("Bedirhan", "Çakar", 23, 74198663, true, "Tatvan/Bitlis"));
        musteriList.addFirst(new Customer("Yusuf", "Bakırlı", 20, 7485154, true,"Bandırma/Balıkesir"));
    }

    // Overloading örneği: İlk metot sadece adı alır
    public void musteriEklemeListesi(String ad) {
        Customer yeniMusteri = new Customer();
        yeniMusteri.Ad = ad;

        musteriList.addLast(yeniMusteri);
        System.out.println("Yeni Müşteri Başarıyla Eklendi");
        System.out.println(yeniMusteri);

        System.out.println("Güncel Müşteri Listesi");
        varOlanMusteriListesiGoruntuleme();
    }

    // İkinci metot adı, yaşını, telefon numarasını ve ehliyet durumunu alır
    public void musteriEklemeListesi(String ad, int yas, int telNo, boolean ehliyetVarMi) {
        Customer yeniMusteri = new Customer(ad, "", yas, telNo, ehliyetVarMi);

        musteriList.addLast(yeniMusteri);
        System.out.println("Yeni Müşteri Başarıyla Eklendi");
        System.out.println(yeniMusteri);

        System.out.println("Güncel Müşteri Listesi");
        varOlanMusteriListesiGoruntuleme();
    }

    public void musteriEklemeListesi() {
        System.out.println("****Müşteri Bilgilerini Giriniz*****");
        System.out.print("Ad : ");
        this.Ad = key.nextLine();
        System.out.print("Soyad : ");
        this.Soyad = key.nextLine();
        System.out.print("Yaş :");
        this.Yas = key.nextInt();
        System.out.print("Telefon numarası :");
        this.telNo = key.nextInt();
        System.out.print("Ehliyet Durumu :");
        this.ehliyetVarMi = key.nextBoolean();

        Customer yeniMusteri = new Customer(this.Ad, this.Soyad, this.Yas, this.telNo, this.ehliyetVarMi);
        musteriList.addLast(yeniMusteri);
        System.out.println("Yeni Müşteri Başarıyla Eklendi");
        System.out.println(yeniMusteri);

        System.out.println("Güncel Müşteri Listesi");
        ListeYazdirma();
    }

    public void musteriSilmeListesi() {

        ListeYazdirma();
        if (musteriList.isEmpty()) {
            System.out.println("Liste zaten boş. Silme işlemi yapılamaz.");
            return;
        }

        System.out.println("Kaçıncı Müşteriyi Silmek İstiyorsunuz?");
        int sil = key.nextInt();

        if (sil >= 1 && sil <= musteriList.size()) {
            musteriList.remove(sil - 1);
            System.out.println("Müşteri başarıyla silindi.");
            ListeYazdirma();
        } else {
            System.out.println("Geçersiz indeks girişi.");
        }
    }



}
