/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import app.FileManager;
import constants.KEY;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Kendrick
 */
public class XMLReader {
    private Bundle bundle;
    public Bundle readCharacter(File file){
        bundle = new Bundle();
        try {
            if(file == null){
                bundle.putBoolean(FileManager.IO_SUCCESS, Boolean.FALSE);
                return bundle;
            }
            
            DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
            DocumentBuilder build = fact.newDocumentBuilder();
            Document doc = build.parse(file);
            
            doc.getDocumentElement().normalize();
            Element character = doc.getDocumentElement();
            
            Element biography = extractElement(character, KEY.H_BIOGRAPHY);
            Element background = extractElement(character, KEY.H_BACKGROUND);
            Element armor = extractElement(character, KEY.H_ARMOR);
            Element weapons = extractElement(character, KEY.H_WEAPON);
            Element skills = extractElement(character, KEY.H_SKILLS);
            Element utility = extractElement(character, KEY.H_UTILITY);
            Element attributes = extractElement(character, KEY.H_ATTRIBUTES);
            Element feature = extractElement(character, KEY.H_FEATURE);
            Element inventory = extractElement(character, KEY.H_INVENTORY);
            Element spellbook = extractElement(character, KEY.H_SPELLBOOK);
            
            
            extractDataFromBackground(background);
            
            bundle.putBoolean(FileManager.IO_SUCCESS, Boolean.TRUE);
            return bundle;
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(XMLReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        bundle.putBoolean(FileManager.IO_SUCCESS, Boolean.FALSE);
        return bundle;
    }
    
    private Element extractElement(Element root, String tag){
        NodeList list = root.getElementsByTagName(tag);
        if(list != null && list.getLength() > 0){
            Node item = list.item(0);
            if(item instanceof Element){
                Element ele = (Element) item;
                return ele;
            }
        }
        return null;
    }
    
    private String extractString(Element root, String tag){
        Element element = extractElement(root, tag);
        if(element != null){
            String value = element.getTextContent();
            return value;
        }
        return "";
    }

    private void extractDataFromBackground(Element background) {
        String name, trait, bond, ideal, flaw;
        name = extractString(background, KEY.L_NAME);
        trait = extractString(background, KEY.L_TRAIT);
        bond = extractString(background, KEY.L_BOND);
        ideal = extractString(background, KEY.L_IDEAL);
        flaw = extractString(background, KEY.L_FLAW);
        bundle.putString(KEY.K_BACKGROUND_NAME, name);
        bundle.putString(KEY.K_BACKGROUND_TRAIT, trait);
        bundle.putString(KEY.K_BACKGROUND_BOND, bond);
        bundle.putString(KEY.K_BACKGROUND_IDEAL, ideal);
        bundle.putString(KEY.K_BACKGROUND_FLAW, flaw);
    }
}
