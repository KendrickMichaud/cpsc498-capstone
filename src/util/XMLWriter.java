/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import app.FileManager;
import constants.KEY;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Kendrick
 * 
 * https://www.mkyong.com/java/how-to-create-xml-file-in-java-dom/
 * 
 * Basic guide on making xml files for java
 */
public class XMLWriter {
    
    private Document document;
    private boolean canWrite;
    
    public XMLWriter(){
        try {
            initializeDocument();
            canWrite = true;
        } catch (ParserConfigurationException ex) {
            canWrite = false;
            Logger.getLogger(XMLWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Bundle writeToFile(File file,Bundle bundle){
        if(canWrite && writeToDoc(bundle) && writeToFile(file)){
            bundle.putBoolean(FileManager.IO_SUCCESS, Boolean.TRUE);
        }
        else{
            bundle.putBoolean(FileManager.IO_SUCCESS, Boolean.FALSE);
        }
        
        return bundle;
    }

    private void initializeDocument() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        document = builder.newDocument();
    }

    private boolean writeToDoc(Bundle bundle) {
        System.out.println("Writing to doc");
        Element rootElement = document.createElement("Character");
        document.appendChild(rootElement);
        Element characterInfo = document.createElement("CharacterInfo");
        rootElement.appendChild(characterInfo);
        
        return true;
    }

    private boolean writeToFile(File file) {
        try {
            System.out.println("Writing to file");
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(file);
            transformer.transform(source, result);
            return true;
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(XMLWriter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(XMLWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
