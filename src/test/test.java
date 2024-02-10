package test;

import java.util.InputMismatchException;
import java.util.Scanner;

public class test extends admin {

    public static void main(String[] args) {
        System.out.println("--------Araç Kiralama Sistemine Hoş Geldiniz-------");
        islemSecme();
    }
    
    /// exception kullanıldı
    public static void islemSecme() {
        Scanner key = new Scanner(System.in);
        int islem;
        
        while (true) {
            try {
                System.out.println("Yapmak İstediğiniz İşlemi Seçiniz ");
                System.out.println("1 - Yönetici Girişi\n2 - Müşteri Girişi\n3 - Çıkış");
                islem = key.nextInt();
                
                switch (islem) {
                    case 1:
                        yoneticiGirisi();
                        break;
                    case 2:
                        MusteriGirisi();
                        break;
                    case 3:
                        System.out.println("Programdan çıkılıyor...");
                        System.exit(0);
                    default:
                        System.out.println("1 , 2 veya 3 girmelisiniz...");
                }
            } catch (InputMismatchException e) {
                System.out.println("Karakter veya metin girmemelisiniz !!!");
                System.out.println("Sadece rakam giriniz...");
                key.next(); // Hatalı girişi temizle
            }
        }
    }

    public static void yoneticiGirisi() {
        Scanner key = new Scanner(System.in);

        System.out.println("Kullanıcı adı ve parola bilgilerini giriniz");
        System.out.print("Kullanıcı adı :");
        String kullaniAdi = key.nextLine();
        System.out.print("Parola :");
        String parola = key.nextLine();
        
        test admin = new test();
        if (kullaniAdi.equals(admin.getKullaniciAdi()) && parola.equals(admin.getParola())) {
            System.out.println("Giriş Başarılı \n");
            Manager();
        } else {
            System.out.println("Kullanıcı adı veya parola hatalı");
        }
    }

    public static void MusteriGirisi() {
        CustomerPanel cstmr = new CustomerPanel();
    }

    public static void Manager() {
        Manager mngr = new Manager();

    }
}
