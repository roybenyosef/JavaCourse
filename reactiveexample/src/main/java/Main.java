import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        System.out.println();
        //we moved the file. this need hobbit.txt in the main project, but it's better to read it from resources
        try (BufferedReader in = new BufferedReader(new FileReader("Hobbit.txt"))){
            String line = in.readLine();
            while(line != null) {
                words.addAll(Arrays.asList(line.split(" ")));
                line = in.readLine();
            }
        }
        catch (Exception e) { e.printStackTrace(); }


        try {
            //another way to read the stream:
            Stream<String> lines =  Files.lines(Paths.get(Main.class.getResource("Hobbit.txt").toURI()));
            lines.flatMap(line -> Stream.of(line.split(" ")))
                    .forEach(System.out::println);
        }
        catch (Exception e) { e.printStackTrace(); }


        //print book
        words.stream().forEach(System.out::println);  //or write a lambda s -> System.out.println(s)

        //how many 4 letter words
        System.out.println(words.stream().filter(x -> x.length() == 4).count());

        //average word letter of words > 4
        System.out.println(words.stream().filter(x -> x.length() > 4)
                                         .mapToInt(str -> str.length())
                                         .average());


        //using collector. we want to get a collection of all one letter words
        Map<Object, Object> singleLetterWords = words.stream()
                .filter(x -> x.length() == 1)
                .distinct()                         //prevent duplicates
                .collect(Collectors.toMap(s -> s, s -> s.hashCode()));   //key is the word, value is the hash code

        System.out.println(singleLetterWords);

        //print words count
        Map<String, Long> wordCount = words.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        System.out.println(wordCount);

        //parallel print words count
        //it uses fork-join
        Map<String, Long> wordCount2 = words.parallelStream().collect(Collectors.groupingByConcurrent(s -> s, Collectors.counting()));
        System.out.println(wordCount2);


    }
}
