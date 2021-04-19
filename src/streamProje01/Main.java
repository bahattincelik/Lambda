package streamProje01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Main {

    private static List<Ogrenci>ogrListesi = new ArrayList<>();

    public static void main(String[] args) {

        testOgrenciOlustur();

        System.out.println("======= Isme Gore Sirala =======");
        ismeGoreListele("Ahmet");

        System.out.println("======= Soy Isme Gore Sirala =======");
        soyIsmeGoreListele("Can");

        System.out.println("======= Cinsiyete Gore Sirala =======");
        cinsiyeteGoreListele("erkek");

        System.out.println("======= Nota Gore Sirala =======");
        notaGoreSirala(90.0);

        System.out.println("======= Yasa Gore Sirala =======");
        yasaGoreSirala(30);

        System.out.println("======= Yasi 20 olan Erkekleri Sirala =======");
        yasaVeCinsiyeteGoreSirala(20, "erkek");

        System.out.println("======= Yasi 30 olan KAdinlari Sirala =======");
        yasaVeCinsiyeteGoreSirala(30, "kadın");

        System.out.println("======= Sinif Ortalamasi =======");
        System.out.println(sinifOrtalamasiHesapla(ogrListesi));




    }

    private static void yasaVeCinsiyeteGoreSirala(int yas, String cinsiyet) {

        ogrListesi.stream().filter(t->t.getYas()<yas && t.getCinsiyet().equalsIgnoreCase(cinsiyet))
                .sorted(Comparator.comparing(Ogrenci::getAd)).forEach(System.out::println);


    }

    private static double sinifOrtalamasiHesapla(List<Ogrenci> ogrListesi) {

      Double toplam = ogrListesi.stream().map(Ogrenci::getDiplomaNotu).reduce(0.0,(x,y)->(x+y));
        return toplam/ogrListesi.size();


    }


    private static void yasaGoreSirala(int yas){
        ogrListesi.stream().filter(t->t.getYas()<yas).forEach(System.out::println);
    }

    private static void notaGoreSirala(Double not){
        ogrListesi.stream().filter(t-> t.getDiplomaNotu()>not).forEach(System.out::println);
    }

    private static void cinsiyeteGoreListele(String cinsiyet){
        ogrListesi.stream().filter(t-> t.getCinsiyet().equalsIgnoreCase(cinsiyet)).forEach(System.out::println);
    }

    private static void soyIsmeGoreListele(String soyIsim){
        ogrListesi.stream().filter(t->t.getSoyad().equalsIgnoreCase(soyIsim)).forEach(System.out::println);
    }

    private static void ismeGoreListele(String isim){
        ogrListesi.stream().filter(t->t.getAd().equalsIgnoreCase(isim)).forEach(System.out::println);

    }

    private static void testOgrenciOlustur(){
        ogrListesi.add(new Ogrenci("Ahmet", "Can", 30, 95.5, "erkek"));
        ogrListesi.add(new Ogrenci("Ahmet", "Baki", 18, 90.1, "erkek"));
        ogrListesi.add(new Ogrenci("Ayşe", "Can", 21, 82.3, "kadın"));
        ogrListesi.add(new Ogrenci("Mustafa", "Can", 15, 75.4, "erkek"));
        ogrListesi.add(new Ogrenci("Ayşe", "Yılmaz", 40, 45, "kadın"));
        ogrListesi.add(new Ogrenci("Ali", "Veli", 80, 35.5, "erkek"));
        ogrListesi.add(new Ogrenci("Veli", "Öztürk", 20, 95.5, "erkek"));
    }

}
