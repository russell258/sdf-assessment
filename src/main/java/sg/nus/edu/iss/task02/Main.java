package sg.nus.edu.iss.task02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main( String[] args ) throws IOException
    {
        /*add directory texts inside task02
         - program has to run with argument so check arg length
         - check directory exists
         - FileReader >> bufferedReader >> readlines >> split and replace punctation, lowercase all
         - create hashmap of lists? or hashmap of hashmap
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
        
        HashMap<Integer,String> hashmap = new HashMap<Integer,String>();

        if (!newDirectory.isDirectory()){
            System.out.println("Directory does not exist. Please run Java program with argument for file directory again");
        }else{
            for (File directories: newDirectory.listFiles()){

                if (directories.isDirectory()){
                    for (File file: directories.listFiles()){
                        System.out.println(file);
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
                        wordListArray = wordListString.split(" ");

                        //create hashmap having integer key of String value
                        for (int i = 0; i<wordListArray.length; i++){
                            hashmap.put(i, wordListArray[i]);
                        }

                        br.close();
                    }
                }
            }
        }
    }
}
