package sg.nus.edu.iss.task02;

import java.io.File;

public class FileExtractor {
    public static void directoryCheck(File directory){
        if (directory.isDirectory()){
            for (File file: directory.listFiles()){
                directoryCheck(file);
            }
        }

    }
}
