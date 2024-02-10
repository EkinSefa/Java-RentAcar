package test;

import java.util.LinkedList;
import java.util.Scanner;

public class Car implements IText {

    private String marka;
    private int model;
    private double kiralamaFiyati;
    private String renk;
    private String yakitTuru;
    private int kapasite;
    public LinkedList<Car> aracList = new LinkedList<>();
    public Scanner key = new Scanner(System.in);

    public Car(String marka, int model, double kiralamaFiyati, String renk, String yakitTuru) {
        this.marka = marka;
        this.model = model;
        this.kiralamaFiyati = kiralamaFiyati;
        this.renk = renk;
        this.yakitTuru = yakitTuru;
    }

    public Car(String marka, int model, double kiralamaFiyati, String renk, String yakitTuru, int kapasite) {
        this.marka = marka;
        this.model = model;
        this.kiralamaFiyati = kiralamaFiyati;
        this.renk = renk;
        this.yakitTuru = yakitTuru;
        this.kapasite = kapasite;
    }

    public Car() {

    }
    @Override
    public void ListeYazdirma() {
        for (int i = 0; i < aracList.size(); i++) {
            System.out.println((i + 1) + "." + aracList.get(i));
        }
    }
    
    @Override
    public String toString() {
        return "Araç Bilgisi\n" + " Marka : " + marka + "\n Model : " + model + "\n Kiralama Fiyatı :" + kiralamaFiyati + " TL" + "\n Renk : " + renk + "\n Yakıt Türü : " + yakitTuru + "\n Kapasite : " + kapasite + "\n";
    }

    /*
    public void AracListesiYazdirma() {
        for (int i = 0; i < aracList.size(); i++) {
            System.out.println((i + 1) + "." + aracList.get(i));
        }
    }*/
    public void AracGoruntuleme() {

        aracList.addFirst(new Car("Mercedes", 2023, 1200, "Beyaz", "Dizel", 4));
        aracList.addFirst(new Car("BMW", 2024, 1500, "Mavi", "Benzin"));
        aracList.addFirst(new Car("Audi", 2023, 1600, "Siyah", "Benzin", 5));

    }

    public void AracSilme() {
        if (aracList.isEmpty()) {
            System.out.println("Liste zaten boş. Silme işlemi yapılamaz.");
            return;
        }

        System.out.println("Kaçıncı sıradaki Arabayı silmek istiyorsunuz?");
        int sil = key.nextInt();

        if (sil >= 1 && sil <= aracList.size()) {
            aracList.remove(sil - 1);
            System.out.println("Araç başarıyla silindi.");
            ListeYazdirma();
        } else {
            System.out.println("Geçersiz indeks girişi.");
        }

    }

    public void AracEkleme() {
        System.out.println("Yeni Araç Ekleme İşlemi");

        System.out.print("Marka : ");
        this.marka = key.nextLine();

        System.out.print("Model : ");
        this.model = key.nextInt();

        System.out.print("Kiralama Fiyatı : ");
        this.kiralamaFiyati = key.nextDouble();

        System.out.print("Renk :");
        key.nextLine();
        this.renk = key.nextLine();

        System.out.print("Yakıt Türü :");
        this.yakitTuru = key.nextLine();

        // yeni arac objesi oluşturma ;
        Car yeniArac = new Car(marka, model, kiralamaFiyati, renk, yakitTuru);

        // yeni arac objesini listeye ekleyelim
        aracList.addLast(yeniArac);
        System.out.println("Yeni araç eklendi :" + yeniArac);

        // araç listesinin güncel halini yazdıralım
        ListeYazdirma();

        test.islemSecme();
    }

    public void AracGuncelleme() {
        System.out.println("Araç Güncelleme işlemi");

        System.out.print("Kaçıncı sıradaki arabanın bilgilerini güncellemek istiyorsunuz ? ");
        int sira = key.nextInt();

        if (sira >= 1 && sira <= aracList.size()) {
            // seçilen aracın eski bilgilerini gösterme
            System.out.println("Eski bilgiler : ");
            System.out.println(aracList.get(sira - 1));

            // yeni bilgileri girmek
            System.out.print("Marka : ");
            key.nextLine();
            String yeniMarka = key.nextLine();

            System.out.print("Model : ");
            int yeniModel = key.nextInt();

            System.out.print("Kiralama Fiyatı : ");
            double yeniKiralamaFiyati = key.nextDouble();

            System.out.print("Renk : ");
            key.nextLine();
            String yeniRenk = key.nextLine();

            System.out.print("Yakıt Türü : ");
            String yeniYakitTuru = key.nextLine();

            // yeni bilgilerle aracı güncelle
            Car guncelArac = aracList.get(sira - 1);

            guncelArac.marka = yeniMarka;
            guncelArac.model = yeniModel;
            guncelArac.kiralamaFiyati = yeniKiralamaFiyati;
            guncelArac.renk = yeniRenk;
            guncelArac.yakitTuru = yeniYakitTuru;

            // Güncellenmiş aracı liste içinde gösterme
            System.out.println("Güncellenmiş Bilgiler :");
            System.out.println(guncelArac);

            // Araç listesinin güncel halini yazdırma
            ListeYazdirma();

        } else {
            System.out.println("Geçersiz index girişi");
        }
    }



}
