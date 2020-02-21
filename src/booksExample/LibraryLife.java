package booksExample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LibraryLife {
    public Library lib;
    public List<Integer> booksSentInOrder;
    public static HashMap<Integer, Integer> booksScanned;

    public LibraryLife(){
        booksSentInOrder = new ArrayList<>();
        booksScanned = new HashMap<>();
    }

    public LibraryLife(Library lib) {
        this.lib = lib;
        booksSentInOrder = new ArrayList<>();
        booksScanned = new HashMap<>();
    }

    public boolean addBook(int idLib, int idBook){
        boolean added = false;
        if( ! booksScanned.containsKey(idBook) ){
            booksScanned.put(idBook, idLib);
            booksSentInOrder.add(idBook);
            added = true;
        }
        return added;
    }
}
