package FileHandling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileDemo {

    public static void main(String[] args) {
        File target = new File("/home/santosh/temp/test1.txt");
        try {
            FileWriter writer = new FileWriter(target);
            for (int num = 1; num < 11; num++) {
                writer.write("This is line " + num +  System.getProperty( "line.separator"));
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
