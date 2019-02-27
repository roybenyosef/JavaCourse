package app.core.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PrintFile {
    public static void main(String[] args) {
//        try (FileReader in = new FileReader("C:/Program Files/Java/jdk1.8.0_201/COPYRIGHT")) {
//            //Reads one byte at a time - returns int. no good.
//        }

        try (BufferedReader in = new BufferedReader(new FileReader("C:/Program Files/Java/jdk1.8.0_201/COPYRIGHT"))) {
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch  (IOException ex) {
            ex.printStackTrace();
        }
    }
}
