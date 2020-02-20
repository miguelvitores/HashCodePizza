package booksExample;

import java.util.ArrayList;
import java.util.List;

public class LibraryLife {
    public Library lib;
    public List<Integer> booksSentInOrder;

    public LibraryLife(){
        booksSentInOrder = new ArrayList<>();
    }

    public LibraryLife(List<Integer> booksSentInOrder) {
        this.booksSentInOrder = booksSentInOrder;
    }
}
