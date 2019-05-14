public class Person {

    public String first;
    public String last;

    public Person(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public static int checkNames(String first, String last) {
        return first.compareTo(last);
    }
}
