package booksExample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        for(Library lib : libReader.libraries){
            LibraryLife ll = new LibraryLife();

            HashMap<Integer, Integer> books = lib.getBooks();
            currentDaysLeft -= lib.getDaysSignUp() - 1;
            int count = 0;
            for (HashMap.Entry<Integer, Integer> b : books.entrySet()) {
                count++;
                if(count == lib.getBooksPerDay()){
                    currentDaysLeft--;
                    ll.booksSentInOrder.add(b.getKey());
                }
                if(currentDaysLeft == -1){
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
