package test;

import java.util.Scanner;
import java.util.Timer;

public class CustomerPanel extends Car {

    public Scanner key = new Scanner(System.in);

    public Car car = new Car();

    public CustomerPanel() {
        AracGoruntuleme(); // ÖNCE ARAÇ LİSTESİNİ DOLDURALIM
        System.out.println("-----------Müşteri Giriş Ekranına Hoş Geldiniz---------");
        islemler();
    }

    public void islemler() {

        while (true) {
            System.out.println("Yapmak İstediğini İşlemi Seçiniz");
            System.out.println("1 - Araç Seçeneklerini görünütüleme\n"
                    + "2- Araç Seçme\n"
                    + "3-Sürücü Bilgilerini girme");

            int islem = key.nextInt();
            
            if (islem == 1) {
                AracSecenekleriniGoruntuleme();
                break;
            } else if (islem == 2) {
                AracSecme();
                break;
            } else if (islem == 3) {
                surucuBilgileriniGirme();
                break;
            } else {
                System.out.println("Geçersiz işlem! Lütfen 1,2 veya 3 giriniz.");
            }
        }
    }

    public void AracSecenekleriniGoruntuleme() {
        car.AracGoruntuleme();
        car.ListeYazdirma();
    }

    public void AracSecme() {
        System.out.println("******* ARAÇ SEÇME EKRANI ******");
        AracSecenekleriniGoruntuleme();

        while (true) {
            System.out.print("Kaç numaralı  Aracı Seçmek İstiyorsunuz ? ");
            int secim = key.nextInt();

            if (secim > 0 && secim <= aracList.size()) {
                System.out.println("******  Seçtiğiniz Araç ***** \n " + aracList.get(secim - 1));
                break;
            } else if (secim <= 0) {
                System.out.println("Lütfen doğru bir değer giriniz !!!");
            } else if (secim > aracList.size()) {
                System.out.println("Lütfen doğru bir değer giriniz !!!");
            }
        }
    }

    public void surucuBilgileriniGirme() {
        System.out.println("****Müşteri Bilgilerini Giriniz*****");
        key.nextLine();
        
        System.out.print("Ad : ");
        String ad = key.nextLine();
//
        System.out.print("Soyad : ");
        String soyad = key.nextLine();
        System.out.print("Yaş :");
        int yas = key.nextInt();
        System.out.print("Telefon numarası :");
        int telNo = key.nextInt();
        System.out.print("Ehliyet Durumu :");
        boolean ehliyetVarMi = key.nextBoolean();

        Customer newCustomer = new Customer(ad, soyad, yas, telNo, ehliyetVarMi);
        System.out.println("\nKayıt işlemi Başarılı");
        System.out.println(newCustomer);
    }
}
