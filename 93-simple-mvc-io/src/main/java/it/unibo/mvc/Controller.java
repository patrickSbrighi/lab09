package it.unibo.mvc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private static final String DEFAULT_FILE_NAME = "output.txt";
    private static final String PATH = System.getProperty("user.home") + System.getProperty("file.separator");
    private File file = new File(PATH + DEFAULT_FILE_NAME);

    public void setFile(final String filePath){
        this.file = new File(filePath);
    }

    public File getFile(){
        return this.file;
    }

    public String getFilePath(){
        return file.getPath();
    }

    public void saveString(final String toSave) throws IOException{
        try(final BufferedWriter bw = new BufferedWriter(new FileWriter(this.file));){
            bw.write(toSave);
            bw.newLine();
        }
    }
}
