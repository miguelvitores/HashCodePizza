package booksExample;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainLib {

    public static final String dirIn = "./Books/DataInput/";
    public static final String dirOut = "./Books/DataOutput/";

    public static void main(String[] args) {

        File[] inFiles = new File(dirIn).listFiles();
        assert inFiles != null;
        for(File f : inFiles){
            long tms0 = System.currentTimeMillis();
            String path = f.getName();
            LibraryPTReader libReader = new LibraryPTReader(dirIn+path);
            libReader.read();
            LibraryOrder libOrder = new LibraryOrder();
            libOrder.generateOrder();
            LibraryPTWriter libWriter = new LibraryPTWriter(dirOut, path, libOrder.getLibLife());
            libWriter.write();
            long ttms = System.currentTimeMillis() - tms0;
//                System.out.println(path+" output");
//                System.out.println(libWriter.getPlainText());
            System.out.println(path+" time spent: "+ttms + " ms");
        }

//        try {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            System.out.print("Write the path: ");
//            String path = br.readLine();
//            LibraryPTReader libReader = new LibraryPTReader(dirIn+path);
//            libReader.read();
//            System.out.println(libReader.getPlainText());
//            LibraryOrder libOrder = new LibraryOrder(libReader);
//            libOrder.generateOrder();
//
//            LibraryPTWriter libWriter = new LibraryPTWriter(dirOut, path, libOrder.getLibLife());
//            libWriter.write();
//            System.out.println(libWriter.getPlainText());
//
//        } catch(IOException ex){
//            System.out.println(ex.getMessage());
//        }
    }
}
