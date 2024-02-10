package test;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Manager extends Customer {

    public Car car = new Car();
    public Scanner key = new Scanner(System.in);

    public Manager() {
        System.out.println("Yönetici Sınıfı");
        car.AracGoruntuleme();
        varOlanMusteriListesiGoruntuleme();
        islemSecme();
    }

    // iç içe class tanımlandı
    public class AracIslemleri {

        public void araclarıGoruntuleme() {
            car.ListeYazdirma();
        }

        public void aracEkleme() {
            car.AracEkleme();
        }

        public void aracSil() {
            car.ListeYazdirma();
            car.AracSilme();
        }

        public void aracGuncelleme() {
            car.ListeYazdirma();
            car.AracGuncelleme();
        }
    }

    // iç içe class tanımlandı
    public class MusteriIslemleri {

        public void musteriGoruntuleme() {
            ListeYazdirma();

        }

        public void musteriEkle() {
            musteriEklemeListesi();
        }

        public void musteriSil() {
            musteriSilmeListesi();
        }
    }

    // exception kullanıldı
    public void islemSecme() {
        while (true) {
            try {
                System.out.println("Yapmak İstediğiniz İşlemi seçiniz");
                System.out.println("****İşlemler*****\n"
                        + "1-Araç İşlemleri\n "
                        + "2-Müşterileri İşlemleri\n"
                        + "3-Çıkış");

                int islem = key.nextInt();
                if (islem == 1) {
                    aracIslemleri();
                    break;
                } else if (islem == 2) {
                    musteriIslemleri();
                    break;
                } else {
                    System.out.println("Geçersiz işlem! Lütfen 1  2  veya 3 giriniz.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Karakter veya metin girmemelisiniz");
                key.next(); // Hatalı girişi temizle
            }
        }
    }

    public void aracIslemleri() {
        AracIslemleri aracIslemleri = new AracIslemleri();
        System.out.println("Bir İşlem Seçiniz");

        while (true) {
            System.out.println("****** Araç İşlemleri ******\n"
                    + "1-Araç Görüntüleme\n"
                    + "2- Araç Ekleme\n"
                    + "3-Araç Silme\n"
                    + "4-Araç Güncelleme\n"
                    + "5-Çıkış");
            int islem = key.nextInt();

            switch (islem) {
                case 1:
                    aracIslemleri.araclarıGoruntuleme();
                    break;
                case 2:
                    aracIslemleri.aracEkleme();
                    break;
                case 3:
                    aracIslemleri.aracSil();
                    break;
                case 4:
                    aracIslemleri.aracGuncelleme();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Lütfen Geçerli Bir İşlem Seçiniz");
            }
        }
    }

    public void musteriIslemleri() {
        MusteriIslemleri musteriIslemleri = new MusteriIslemleri();
        System.out.println("Bir İşlem Seçiniz");

        while (true) {
            System.out.println("*******Müşteri İşlemleri********\n"
                    + "1-Müşterileri Görüntüleme \n"
                    + "2- Müşteri Silme\n"
                    + "3-Müşteri Ekleme\n"
                    + "4-Çıkış");
            int islem = key.nextInt();

            switch (islem) {
                case 1:
                    musteriIslemleri.musteriGoruntuleme();
                    break;
                case 2:
                    musteriIslemleri.musteriSil();
                    break;
                case 3:
                    musteriIslemleri.musteriEkle();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Lütfen Geçerli Bir İşlem Seçiniz");
            }
        }
    }
}
