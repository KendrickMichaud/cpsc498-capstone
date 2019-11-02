/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.io.File;
import util.Bundle;

/**
 *
 * @author Kendrick
 */
public class FileInput {

    FileInput(File file, FileManager.FILE fileType) {

    }

    Bundle getBundle() throws InterruptedException {
        Bundle b = new Bundle();
        b.putBoolean(FileManager.IO_SUCCESS, Boolean.TRUE);
        System.err.println("Waiting for 5 seconds");
        Thread.sleep(5000);
        System.err.println("Returning thing");
        return b;
    }
    
}
