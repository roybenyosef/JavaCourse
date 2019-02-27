package app.core.io;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class PrimitiesOut {
    public static void main(String[] args) {
        //BufferedOutputStream is used to flush data and not abuse for example the writing to disk.
        try(DataOutputStream out = new DataOutputStream (
                    new BufferedOutputStream(
                    new FileOutputStream("c:/temp/aaa.dat")))) {

            out.writeInt(20);
            out.writeBoolean(true);
            out.writeUTF("moshe moshe");
            out.writeFloat(5.5f);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
