public class Boom7 {

    static {

    }

    public static void main(String[] args) {

        System.out.println("Hello World!");
        outer: for (int i =1; i <= 1000; ++i){
            if (i % 7 == 0) {
                System.out.print("Boom, ");
                continue;
            }
            int numberToFindDigits = i;
            while (numberToFindDigits > 0)
            {
                int remainder = numberToFindDigits % 10;
                if (remainder == 7) {
                    System.out.print("Boom, ");
                    continue outer;
                }
                numberToFindDigits /= 10;
            }

            System.out.print(i + ", ");
        }
    }
}
