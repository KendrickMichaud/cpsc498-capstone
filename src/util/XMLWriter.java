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
    private Bundle bundle;
    
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

    private boolean writeToDoc(Bundle b) {
        bundle = b;
        if(b == null)
            return false;
        System.out.println("Writing to doc");
        Element character = document.createElement("Character");
        document.appendChild(character);
        Element biography = document.createElement(KEY.H_BIOGRAPHY);
        Element background = document.createElement(KEY.H_BACKGROUND);
        Element skills = document.createElement(KEY.H_SKILLS);
        Element attributes = document.createElement(KEY.H_ATTRIBUTES);
        Element inventory = document.createElement(KEY.H_INVENTORY);
        Element weapons = document.createElement(KEY.H_WEAPON);
        Element defense = document.createElement(KEY.H_ARMOR);
        Element spellbook = document.createElement(KEY.H_SPELLBOOK);
        Element utility = document.createElement(KEY.H_UTILITY);
        Element features = document.createElement(KEY.H_FEATURE);
        Element image = document.createElement(KEY.H_IMAGE);
        addChildrenToImage(image);
        addChildrenToElement(biography);
        addChildrenToElement(background);
        addChildrenToElement(weapons);
        
        character.appendChild(biography);
        character.appendChild(background);
        character.appendChild(skills);
        character.appendChild(attributes);
        character.appendChild(inventory);
        character.appendChild(weapons);
        character.appendChild(defense);
        character.appendChild(spellbook);
        character.appendChild(utility);
        character.appendChild(features);
        character.appendChild(image);
        
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

    private void addChildrenToElement(Element ele) {
        if(ele != null){
            switch(ele.getTagName()){
                case KEY.H_BACKGROUND:
                    addChild(KEY.K_BACKGROUND_NAME, ele);
                    addChild(KEY.K_BACKGROUND_BOND, ele);
                    addChild(KEY.K_BACKGROUND_IDEAL, ele);
                    addChild(KEY.K_BACKGROUND_FLAW, ele);
                    addChild(KEY.K_BACKGROUND_TRAIT, ele);
                    break;
                case KEY.H_BIOGRAPHY:break;
                case KEY.H_ARMOR:break;
                case KEY.H_FEATURE:break;
                case KEY.H_WEAPON:
                    for(int i = 0; i < 3; i++){
                        addWeapon(i, ele);
                    }
                    break;
                    
                
            }
        }
    }
    
    private void addChild(String key, Element root){
        System.out.println("Pulling for root: " + key);
        String value = bundle.getString(key);
        if(value != null){
            Element child = document.createElement(KeyReader.getLowKey(key));
            child.setTextContent(value);
            root.appendChild(child);
        }
    }

    private void addChildrenToImage(Element image) {
        addChild(KEY.K_IMAGE, image);
    }
    
    private void addWeapon(int curr, Element weapons) {
        Element item = document.createElement("item");
        item.setAttribute("id", Integer.toString(curr));
        addChild(KEY.K_WEAPON_NAME + KEY.item(curr), item);
        addChild(KEY.K_WEAPON_ATTK_BONUS + KEY.item(curr), item);
        addChild(KEY.K_WEAPON_DESCRIPTION + KEY.item(curr), item);
        addChild(KEY.K_WEAPON_DMG_ROLL + KEY.item(curr), item);
        addChild(KEY.K_WEAPON_DMG_BONUS + KEY.item(curr), item);
        weapons.appendChild(item);
    }
    
}
