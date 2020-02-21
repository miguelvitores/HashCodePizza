package booksExample;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Library {
    public int id;
    private int numBooks;
    private int daysSignUp;
    private int booksPerDay;
    public HashMap<Integer, Integer> books;

    public Library(){
        books = new HashMap<>();
    }

    public Library(int id, int numBooks, int daysSignUp, int booksPerDay){
        this.id = id;
        books = new HashMap<>();
        this.numBooks = numBooks;
        this.daysSignUp = daysSignUp;
        this.booksPerDay = booksPerDay;
    }

    public void orderBooksByScores(){
        books = books.entrySet().
                stream().
                sorted((Map.Entry.<Integer, Integer>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(e1, e2) -> e1, LinkedHashMap::new));
    }

    public int getBooksPerDay() {
        return booksPerDay;
    }

    public int getDaysSignUp() {
        return daysSignUp;
    }

    public int getNumBooks() {
        return numBooks;
    }

    public void setNumBooks(int numBooks) {
        this.numBooks = numBooks;
    }

    public void setBooksPerDay(int booksPerDay) {
        this.booksPerDay = booksPerDay;
    }

    public void setDaysSignUp(int daysSignUp) {
        this.daysSignUp = daysSignUp;
    }
}
