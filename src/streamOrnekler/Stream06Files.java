package streamOrnekler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Stream;

public class Stream06Files {

    public static void main(String[] args) throws IOException {

        String path = "src/streamOrnekler/mars.txt";

      Stream<String> satirlar= Files.
              lines(Path.of(path));
      satirlar.forEach(System.out::println);
      System.out.println("==============================================");
      Files.lines(Path.of(path)).
              map(String::toUpperCase).forEach(System.out::println);

      System.out.println("==============================================");

      Files.lines(Path.of(path)).
              limit(1).
                map(String::toUpperCase).
                    forEach(System.out::println);

      Files.lines(Path.of(path)).
              skip(2).limit(2).
              map(String::toUpperCase).
              forEach(System.out::println);

      System.out.println(Files.lines(Path.of(path)).
              map(String::toUpperCase).
              filter(t->t.contains("O")).count());


      Files.lines(Path.of(path)).
      map(t->t.toLowerCase().split(" ")).
              flatMap(Arrays::stream).
              distinct().
              forEach(System.out::println);

     long mSayisi= Files.lines(Path.of(path)).
              map(t->t.toLowerCase().
                      split("")).flatMap(Arrays::stream).
              filter(t->t.equals("m")).count();

        System.out.println(mSayisi);

        System.out.println(Files.lines(Path.of(path)).
                map(t->t.replace("_","").
                        replaceAll("\\W","").
                        split("")).
                flatMap(Arrays::stream).
                count());






    }


}
