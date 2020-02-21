package booksExample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LibraryPTReader {

    private String path;
    private String plainText="";
    public static int numBooks;
    public static int numLibs;
    public static int numDays;
    public static HashMap<Integer, Integer> scores;
    public static Library[] libraries;

    public LibraryPTReader(String path){
        if(path != null){
            this.path = path;
        }
    }

    public void read(){
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = br.readLine();
            plainText = plainText.concat(line+"\n");
            numBooks = Integer.parseInt(line.split(" ")[0]);
            numLibs = Integer.parseInt(line.split(" ")[1]);
            numDays = Integer.parseInt(line.split(" ")[2]);
            line = br.readLine();
            plainText = plainText.concat(line+"\n");
            String[] scoresString = line.split(" ");
            scores  = new HashMap<>();
            for(int i=0; i<scoresString.length; i++){
                scores.put(i,Integer.parseInt(scoresString[i]));
            }

            orderScores();

            libraries = new Library[numLibs];
            for(int i=0; i<numLibs;i++){
                line = br.readLine();
                plainText = plainText.concat(line+"\n");
                String[] libraryData = line.split(" ");
                libraries[i] = new Library(i,Integer.parseInt(libraryData[0]),
                        Integer.parseInt(libraryData[1]), Integer.parseInt(libraryData[2]));
                line = br.readLine();
                String[] booksLib = line.split(" ");
                plainText = plainText.concat(line+"\n");
                for(int j=0; j<libraries[i].getNumBooks(); j++){
                    int key = Integer.parseInt(booksLib[j]);
                    libraries[i].books.put(key, scores.get(key));
                }

            }

        } catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void orderScores(){
        scores = scores.entrySet().
                stream().
                sorted((Map.Entry.<Integer, Integer>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(e1, e2) -> e1, LinkedHashMap::new));
    }

    public String getPlainText() {
        return plainText;
    }

}
