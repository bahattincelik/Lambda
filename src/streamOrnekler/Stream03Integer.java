package streamOrnekler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Stream03Integer {
    public static void main(String[] args) {
        List<Integer> liste = new ArrayList<>();
        liste.add(12);
        liste.add(9);
        liste.add(13);
        liste.add(4);
        liste.add(9);
        liste.add(2);
        liste.add(4);
        liste.add(-1);
        liste.add(12);
        liste.add(15);
        liste.add(500);
        liste.add(-15);

        System.out.println("En Buyuk Deger : " +buyukBul(liste));
        System.out.println("En Buyuk Deger : " +buyukBul1(liste));
        System.out.println("En Buyuk Deger : " +buyukBul2(liste));
        System.out.println("En Kucuk Deger : " +kucukBul(liste));
        System.out.println("Carpim Sonuc : " +carpimBul(liste));
        System.out.println("9 Sayisi : " +dokuzSay(liste));
        System.out.println("Negatif Liste : " +negatifSayiListesi(liste));
    }
    public static int buyukBul(List<Integer> liste){
        return liste.stream().reduce(0,(x,y)-> x>y?x:y);
    }
    public static int buyukBul1(List<Integer> liste){
        return liste.stream().reduce(0,Math::max);
    }

    public static int buyukBul2(List<Integer> liste){
        return liste.stream().sorted().reduce(0,(x,y)->y);
    }
    public static int kucukBul(List<Integer> liste){
        return liste.stream().reduce(0,(x,y)-> x<y?x:y);
    }
    public static int carpimBul(List<Integer> liste){
        return liste.stream().reduce(1,(x,y)-> x*y);
    }
    public static int dokuzSay(List<Integer> liste){
        return (int) liste.stream().filter(x -> x==9).count();
    }

    //negatif sayilari ayri bir liste olarak donduren method' u yazalim.
    public static List<Integer> negatifSayiListesi(List<Integer> liste){
        return liste.stream().filter(x-> x<0).collect(Collectors.toList());
    }
}
