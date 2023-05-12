package sg.nus.edu.iss.task02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main( String[] args ) throws IOException
    {
        /*add directory texts inside task02
         - program has to run with argument so check arg length
         - check directory exists
         - FileReader >> bufferedReader >> readlines >> split and replace punctation, lowercase all'
         - create hashmap of hashmap outside of the directory and file loops
         - inside the loop, .put inner hashmap 
           --> if outer hashmap key string[i] and inner hashmap key [i+1] does not exist yet, assign inner hashmap value counter 1
           --> if exists, get inner hashmap and add 1 to counter
           --> from hashmap, loop through and get inner hashmap value counts 
           --> for each outer hashmap key, add the values and divide by total to get probability. all probabilities add up ==1
        - 
         */

        String dirName = "";

        //check args exit
        if (args.length>0){
            dirName = args[0];
        }else{
           dirName = "texts";
           System.out.println("You have not passed in any argument so default directory: 'texts' will be used");
        }
        
        File newDirectory = new File(dirName);
        
        //hashmap of hashmap to store word, nextword, and count
        Map<String, Map<String, Integer>> wordNextWordCount = new HashMap<>();
        Map<String, Integer> NextWordCount = new HashMap<>();

        if (!newDirectory.isDirectory()){
            System.out.println("Directory does not exist. Please run Java program with argument for file directory again");
        }else{
            for (File directories: newDirectory.listFiles()){

                if (directories.isDirectory()){
                    for (File file: directories.listFiles()){
                        FileReader fr = new FileReader(file);
                        BufferedReader br = new BufferedReader(fr);

                        List<String> lineArray = new ArrayList<>();
                        List<String> wordList = new ArrayList<>();
                        String[] lineList;
                        String line = "";
                        String wordListString ="";
                        String[] wordListArray;
                        
                        // replace all punctuations and split
                        while (null!=(line=br.readLine())){
                            lineList = line.toLowerCase().trim().replaceAll("\\p{Punct}"," ").split(" ");
                            lineArray = Arrays.asList(lineList);
                            wordList.addAll(lineArray); 
                        }
                        
                        // convert back to string and remove punctuation
                        // wordList.replaceAll("\\p{Punct}", "");
                        wordListString = wordList.toString().replaceAll("\\p{Punct}", " ");
                        wordListArray = wordListString.trim().split(" ");

                        // create hashmap of a hashmap (of the next word and count)
                        for (int i = 0; i<wordListArray.length-1; i++){
                            int count =0;
                            if (!wordNextWordCount.containsKey(wordListArray[i])){
                                // if word doesn't exist yet, put.
                                NextWordCount.put(wordListArray[i+1],1);
                            }else{
                                // else add 1 to existing value of inner map
                                // count = NextWordCount.get(i+1);   commentting as returning null error
                                NextWordCount.put(wordListArray[i+1], count+1);
                            }
                            wordNextWordCount.put(wordListArray[i], NextWordCount);
                        }
                        
                        br.close();
                    }
                }
            }
        }
        // loop through hashmap

        // for(Map.Entry<String, HashMap<String,Integer>> t :wordNextWordCount.entrySet()){
        //     String key = t.getKey();
        //     for (Map.Entry<String,Integer> e : t.getValue().entrySet())
        //       System.out.println("OuterKey:" + key + " InnerKey: " + e.getKey()+ " VALUE:" +e.getValue());
        //   }


        // System.out.println(wordNextWordCount.toString());
    }
}
