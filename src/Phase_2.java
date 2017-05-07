import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


public class Phase_2 {  
    
    //Assumptions:
    /*
     * The "words" are separated using regex \W which in Java means
     * words are made up of: a-z, A-Z, 0-9, _
     * so remaining characters are treated as delimiters.
     * ex. High-five = High, five
     * 
     * Things to fix: apostrophes, numbers shouldn't be words.
     * 
     */
    
    static Map<String, Integer> occurences = new HashMap<String, Integer>();
    static Iterator<String> iterator = null; 
    
    public static void main(String[] args) {
        phase1(occurences, iterator);
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Prefix to get the count or type QUIT:");
        String inp = scanner.nextLine();
        while (!(inp.toUpperCase()).equals("QUIT")){
            System.out.println("Prefix:" + inp + " has a count of:" + searchPrefix(inp));
            inp = scanner.nextLine();
        }
    }
    
    public static void phase1(Map occurences, Iterator iterator){
        
        try {
            //Importing File
            @SuppressWarnings("resource")
            Scanner inFile = new Scanner(new FileReader("techInterview.txt"));
            
            //Delimiter to separate words
            while(inFile.hasNextLine()){
                String str = inFile.nextLine();
                String[] words = str.split("\\W+");
            
                //For each word in the line, 
                //this will add it to the map
                for (String st : words){
                    if (occurences.containsKey(st)){
                        int x = (int) occurences.get(st);
                        x++;
                        occurences.put(st, x);
                    }
                    else{
                        if (st.equals("") || st.equals(null)){
                            continue;
                        }
                        else{
                            occurences.put(st, 1);
                        }
                    }
                }
            }
                
            //Printing Map
            iterator = occurences.keySet().iterator();
            
            while (iterator.hasNext()) {
               String key = iterator.next().toString();
               String value = occurences.get(key).toString();
              
               System.out.println(key + "," + value);
            }   
        }       
            
        catch (FileNotFoundException e) {
            System.out.println("File not Found");
            e.printStackTrace();
        }
        
        
    }
    
    public static int searchPrefix(String str){
        
        iterator = occurences.keySet().iterator();
        int prefixCount = 0;
        while (iterator.hasNext()) {
           String key = iterator.next().toString();
           int value = (int) occurences.get(key);
           if (key.startsWith(str)){
               prefixCount = prefixCount + value;
           }
        }   
        return prefixCount;
        
    }
    
    
//test
}