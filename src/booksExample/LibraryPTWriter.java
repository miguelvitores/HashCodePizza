package booksExample;

import pizzaExample.PizzaOrder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class LibraryPTWriter {
    private String path;
    private List<LibraryLife> libraryLives;

    public LibraryPTWriter(String path, List<LibraryLife> libraryLives){
        if(path != null){
            this.path = path+"-out.txt";
        }
    }

    public void write(){
        try {

            FileWriter fw = new FileWriter(path, false);

            for(LibraryLife ll : libraryLives){
                fw.write(libraryLives.size()+"\n");
                fw.write(ll.lib.id+" "+ll.lib);
            }

            fw.close();

        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

}
