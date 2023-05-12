package sg.nus.edu.iss.task02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MainStream {
    public static void main( String[] args ) throws IOException
    {
        String dirName = "";

        //check args exit
        if (args.length>0){
            dirName = args[0];
        }else{
        dirName = "texts";
        System.out.println("You have not passed in any argument so default directory: 'texts' will be used");
        }
        
        File newDirectory = new File(dirName);

        if (!newDirectory.isDirectory()){
            System.out.println("Directory does not exist. Please run Java program with argument for file directory again");
        }else{
            for (File directories: newDirectory.listFiles()){

                if (directories.isDirectory()){
                    for (File file: directories.listFiles()){
                        Map<String, Integer> wordCount = new HashMap<>();
                        FileReader fr = new FileReader(file);
                        BufferedReader br = new BufferedReader(fr);
                        br.lines()
                        .map(line -> line.trim().toLowerCase().replaceAll("\\p{Punct}",""))
                        // String -> String[]
                        // convert the String[] into a stream of strings with flatmap
                        .map(line -> line.split("\\s+"))
                        .flatMap(words -> Arrays.asList(words).stream())
                        .filter(word -> (word.trim().length() > 0))
                        .forEach(word -> {
                            int c = wordCount.computeIfAbsent(word, w -> 0);
                            wordCount.put(word , c +1);
                        });


                        br.close();
                        for (String k:wordCount.keySet()){
                            System.out.printf("word: %s, count %d\n",k, wordCount.get(k));
                        }
            
                        long single = wordCount.keySet().stream()
                            .filter((String word) -> wordCount.get(word)==1)
                            .count();
            
                        System.out.printf(">>> single words: %d\n", single);
                        System.out.println(wordCount.keySet());
                    }
                }
            }
        }
    }
}
