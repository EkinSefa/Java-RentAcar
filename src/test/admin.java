package test;

public class admin {
    // kullanıcı adı ve parola final anahtar kelimesi ile  değiştirilemez olarak tanımlanır...

    private final String kullaniciAdi;
    private final String parola;

    public admin() {
        this.kullaniciAdi = "admin";
        this.parola = "admin";
    }

    // getter metotları
    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public String getParola() {
        return parola;
    }
}
