/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file_io;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Bundle;

/**
 *
 * @author Kendrick
 */
class FileOutput {

    FileOutput(File file, FileManager.FILE_TYPE fileType, Bundle output) {

    }

    /**
     * Writes the the data stored in the Bundle and should return the
     * bundle containing a status on IO_SUCCESS. True if successful
     * False if exceptions or other issues occurred.
     * @return 
     */
    Bundle writeBundle() {
        for(int i = 0; i < 10; i++){
            try {
                Thread.sleep(1000);
                System.out.println(i);
            } catch (InterruptedException ex) {
                Logger.getLogger(FileOutput.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("All done, now I will return the bundle");
        return new Bundle();
    }
    
}
