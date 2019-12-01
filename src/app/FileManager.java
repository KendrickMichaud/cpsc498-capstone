/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;
import util.Bundle;
import util.XMLWriter;

/**
 *
 * @author Kendrick
 */
public class FileManager {

    private final File file;
    private final IO_TYPE type;
    private FILE_TYPE fileType;
    public enum IO_TYPE{READ,WRITE};
    public enum FILE_TYPE{CXML,T_BACKGROUND, T_CLASS, T_RACE,SETTINGS};
    
    public FileManager(File file, IO_TYPE ioType, FILE_TYPE fileType){
        if(file == null){
            throw new NullPointerException("File cannot be null");
        }
        this.file = file;
        this.type = ioType;
        this.fileType = fileType;
    }
    
    public static final String IO_SUCCESS = "IoStatus";
    
    public Bundle getData(){
        try {
            IOWorker worker = new IOWorker(file, type, fileType, null);
            worker.execute();
            return worker.get(); //In this case wait for the result because we need data to load it in.
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        Bundle b = new Bundle();
        b.putBoolean(IO_SUCCESS, Boolean.FALSE);
        return b;
    }
    
    public void sendData(Bundle bundle){
        IOWorker worker = new IOWorker(file, type, fileType, bundle);
        worker.execute();
    }
    
    private static class IOWorker extends SwingWorker<Bundle, Integer>{

        private final File file;
        private final IO_TYPE type;
        private final FILE_TYPE fileType;
        private final Bundle output;
        
        public IOWorker(File file, IO_TYPE type, FILE_TYPE fileType, Bundle input){
            this.file = file;
            this.type = type;
            this.fileType = fileType;
            this.output = input;
        }

        @Override
        protected Bundle doInBackground() throws Exception {
            Bundle b = null;
            switch(type){
                case READ:
                    b = readFile();
                    break;
                case WRITE:
                    b = writeFile();
                    break;
            }
            if(b != null){
                return b;
            }
            else{
                b = new Bundle();
                b.putBoolean(IO_SUCCESS, false);
                return b;
            }
        }

        private Bundle readFile() throws InterruptedException {
            FileInput reader = new FileInput(file, fileType);
            return reader.getBundle();
        }

        private Bundle writeFile() {
            XMLWriter writer = new XMLWriter();
            return writer.writeToFile(file, output);
        }
        
    }
}
