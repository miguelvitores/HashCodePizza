package booksExample;

import java.util.*;
import java.util.stream.Collectors;

public class LibraryOrder {
    private List <LibraryLife> libraryLives;
    private int[] libIdsOrdered;
    private int numLibsSU;


    public LibraryOrder(){
        libIdsOrdered = new int[LibraryPTReader.libraries.length];
        libraryLives = new ArrayList<>();
    }

    public void generateOrder(){

        int currentDaysLeft = LibraryPTReader.numDays;
        boolean deadline = false;

        orderLibraries();

        for(int i = 0; i < libIdsOrdered.length && !deadline; i++){
            Library lib = LibraryPTReader.libraries[libIdsOrdered[i]];
            lib.orderBooksByScores();
            LibraryLife ll = new LibraryLife(lib);

            currentDaysLeft -= lib.getDaysSignUp();
            int booksToday = 0, llDaysLeft = currentDaysLeft;
            for (HashMap.Entry<Integer, Integer> b : lib.books.entrySet()) {
                booksToday++;

                if( ll.addBook(lib.id, b.getKey()) ){

                    if(booksToday == lib.getBooksPerDay()){
                        llDaysLeft--;
                        booksToday = 0;
                    }
                    if(llDaysLeft == 0){
                        deadline = true;
                        break;
                    }
                }
            }
            libraryLives.add(ll);
            numLibsSU++;
        }
    }


    private void orderLibraries(){
        HashMap<Integer, Double> librariesHeuristics = new HashMap<>();
        for(int i=0; i<libIdsOrdered.length; i++){
            Library l = LibraryPTReader.libraries[i];

            double timeHeur = (double)l.getDaysSignUp() / (double)LibraryPTReader.numDays;
            double booksHeur = (double)l.getNumBooks() / (double)LibraryPTReader.numBooks;

            double heur = (timeHeur + booksHeur) * l.getBooksPerDay();

            librariesHeuristics.put(i, heur);
        }
        librariesHeuristics = librariesHeuristics.entrySet().
                stream().
                sorted((Map.Entry.<Integer, Double>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(e1, e2) -> e1, LinkedHashMap::new));
        int index = 0;
        for (HashMap.Entry<Integer, Double> lh : librariesHeuristics.entrySet()) {
            libIdsOrdered[index] = lh.getKey();
            index++;
        }
    }

    public List<LibraryLife> getLibLife() {
        return libraryLives;
    }
}
