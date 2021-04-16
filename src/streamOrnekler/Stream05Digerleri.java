package streamOrnekler;

import java.util.stream.IntStream;

public class Stream05Digerleri {
    public static void main(String[] args) {

        System.out.println("TOPLAM:" + topla(4));
        topla1(4);
        System.out.println("==========");
        tekTopla(1,7);

    }
    //****************************************************************************************************
    // ÖRNEK25: 1'den belirtilen değere kadar olan tamsayıları toplayan ve sonucu döndüren metodu yazınız.
    //****************************************************************************************************
    public static int topla(int deger){
        return IntStream.range(1,  deger + 1).sum();
    }
    public static void topla1(int deger){
        IntStream.rangeClosed(1,deger).forEach(System.out::println);
    }
    public static void tekTopla(int alt, int ust){
        System.out.println(IntStream.rangeClosed(alt,ust).filter(Metotlar::tekMi).sum());
    }

}