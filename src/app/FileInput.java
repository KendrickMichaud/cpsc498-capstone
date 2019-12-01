/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import static app.FileManager.FILE_TYPE.CXML;
import static app.FileManager.FILE_TYPE.T_BACKGROUND;
import java.io.File;
import util.Bundle;
import util.XMLReader;

/**
 *
 * @author Kendrick
 */
public class FileInput {
    private FileManager.FILE_TYPE fileType;
    private final File file;

    FileInput(File file, FileManager.FILE_TYPE fileType) {
        this.file = file;
        this.fileType = fileType;
    }

    Bundle getBundle() throws InterruptedException {
        Bundle b = new Bundle();
        XMLReader reader = new XMLReader();
        if(fileType == CXML){
            b = reader.readCharacter(file);
        }
        else{
            switch(fileType){
                case T_BACKGROUND:b = reader.readBackgrounds(file);break;
                case T_CLASS:b = reader.readClasses(file);break;
                case T_RACE:b = reader.readRaces(file);break;
            }
        }
        return b;
    }
    
}
