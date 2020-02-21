package booksExample;

import pizzaExample.PizzaOrder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class LibraryPTWriter {
    private String plainText="";
    private String path;
    private List<LibraryLife> libraryLives;

    public LibraryPTWriter(String dir, String path, List<LibraryLife> libraryLives){
        if(path != null){
            this.path = dir+"out-"+path;
            this.libraryLives = libraryLives;
            File dirFile = new File(dir);
            if( ! dirFile.exists()) dirFile.mkdir();
        }
    }

    public void write(){
        try {

            FileWriter fw = new FileWriter(path, false);

            fw.write(libraryLives.size()+"\n");
            plainText += libraryLives.size()+"\n";
            for(LibraryLife ll : libraryLives){
                fw.write(ll.lib.id+" "+ll.booksSentInOrder.size()+"\n");
                plainText += ll.lib.id+" "+ll.booksSentInOrder.size()+"\n";
                for(int book : ll.booksSentInOrder){
                    fw.write(book+" ");
                    plainText += book+" ";
                }
                fw.write("\n");
                plainText += "\n";
            }

            fw.close();

        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public String getPlainText() {
        return plainText;
    }
}
