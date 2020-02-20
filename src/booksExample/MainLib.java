package booksExample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainLib {

    public static final String dir = "./Books/";

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Write the path: ");
        try {

            String path = br.readLine();
            LibraryPTReader libReader = new LibraryPTReader(dir+path);
            libReader.read();
            System.out.println(libReader.getPlainText());
            LibraryOrder libOrder = new LibraryOrder(libReader);
            libOrder.generateOrder();

            LibraryPTWriter libWriter = new LibraryPTWriter(dir+path, libOrder.getLibLife());
            libWriter.write();


        } catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
