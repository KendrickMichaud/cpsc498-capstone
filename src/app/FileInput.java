/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.io.File;
import util.Bundle;
import util.XMLReader;

/**
 *
 * @author Kendrick
 */
public class FileInput {
    private FileManager.FILE fileType;
    private static final String INPUT_TYPE = "inType";
    private final File file;

    FileInput(File file, FileManager.FILE fileType) {
        this.file = file;
        this.fileType = fileType;
    }

    Bundle getBundle() throws InterruptedException {
        Bundle b = new Bundle();
        XMLReader reader = new XMLReader();
        b = reader.readCharacter(file);
        return b;
    }
    
}
