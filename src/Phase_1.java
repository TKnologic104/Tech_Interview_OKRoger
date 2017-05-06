import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


public class Phase_1 {	
	//Assumptions:
	/*
	 * The "words" are seperated using regex \W which in Java means
	 * words are made up of: a-z, A-Z, 0-9, _
	 * so remaining characters are treated as delimiters.
	 * ex. High-five = High, five
	 */
	public static void main(String[] args) {
		//Creating Map
		Map<String, Integer> occurences = new HashMap<String, Integer>();
		Iterator<String> iterator = null; 
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
	
	

}

//testing

//Printing out
//int value = (int) occurences.get("Joe");
//System.out.println("Joe" + "," + value);
//
//System.out.println("---------------");

////System.out.println(Arrays.toString(words));