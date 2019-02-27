package app.core.io;

import java.io.*;

public class PrimitiesIn {
    public static void main(String[] args) {
        try(DataInputStream in = new DataInputStream (
                new BufferedInputStream(
                        new FileInputStream("c:/temp/aaa.dat")))) {

            System.out.println(in.readInt());
            System.out.println(in.readBoolean());
            System.out.println(in.readUTF());
            System.out.println(in.readFloat());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
