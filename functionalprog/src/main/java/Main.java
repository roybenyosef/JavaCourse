import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Example 1
        (new Thread(()-> System.out.println("yo yo ma"))).start();
        MyRunnable r = new MyRunnable();
        (new Thread(r::doit)).start();

        //Example 2
        List<String> data = Arrays.asList("bla", "bli", "blu", "yoyoma");
        Collections.sort(data, (s1, s2)->s1.length() - s2.length());
        System.out.println(data);

        //Example 3
        List<String> data2 = Arrays.asList("a", "d", "z", "b");
        Collections.sort(data2, Person::checkNames);
        System.out.println(data2);
    }
}
