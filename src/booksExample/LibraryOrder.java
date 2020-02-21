package booksExample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LibraryOrder {
    private LibraryPTReader libReader;
    private List <LibraryLife> libraryLives;
    private int numLibsSU;


    public LibraryOrder(LibraryPTReader libReader){
        this.libReader = libReader;
        libraryLives = new ArrayList<>();
    }

    public void generateOrder(){

        int currentDaysLeft = libReader.numDays;
        boolean deadline = false;

        for(int i = 0; i < LibraryPTReader.libraries.length && !deadline; i++){
            Library lib = LibraryPTReader.libraries[i];
            LibraryLife ll = new LibraryLife(lib);

            HashMap<Integer, Integer> books = lib.books;
            currentDaysLeft -= lib.getDaysSignUp();
            int booksToday = 0, llDaysLeft = currentDaysLeft;
            for (HashMap.Entry<Integer, Integer> b : books.entrySet()) {
                booksToday++;
                ll.booksSentInOrder.add(b.getKey());
                if(booksToday == lib.getBooksPerDay()){
                    llDaysLeft--;
                    booksToday = 0;
                }
                if(llDaysLeft == 0){
                    deadline = true;
                    break;
                }
            }
            libraryLives.add(ll);
            numLibsSU++;
        }

    }

    public List<LibraryLife> getLibLife() {
        return libraryLives;
    }
}
