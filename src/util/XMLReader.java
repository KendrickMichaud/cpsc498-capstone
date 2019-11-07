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
            Element image = extractElement(character, KEY.H_IMAGE);
            
            
            extractDataFromBiography(biography);
            extractDataFromAttributes(attributes);
            extractDataFromBackground(background);
            extractDataFromImage(image);
            extractWeapons(weapons);
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

    private void extractDataFromImage(Element image) {
        String base64 = extractString(image, KEY.L_BASE);
        if(base64 != null){
            bundle.putString(KEY.K_IMAGE, base64);
        }
    }
    
    private void extractWeapons(Element weapons) {
        NodeList items = weapons.getElementsByTagName("item");
        for(int curr = 0; curr < 3; curr++){
            Element item = items!=null?(Element) items.item(curr):null;
            if(item != null){
                String name, attkBonus, desc, dmgRoll, dmgBonus;
                name = extractString(item, KEY.L_NAME);
                attkBonus = extractString(item, KEY.L_ATTK_BONUS);
                desc = extractString(item, KEY.L_DESCRIPTION);
                dmgRoll = extractString(item, KEY.L_DMG_ROLL);
                dmgBonus = extractString(item, KEY.L_DMG_BONUS);
                
                if(!DataIntegrity.checkNumber(attkBonus))
                    attkBonus = "0";
                if(!DataIntegrity.checkNumber(dmgBonus))
                    dmgBonus = "0";
                
                System.out.println(name + " " + attkBonus + " " + desc + " " + dmgBonus + " " + dmgRoll);
                
                bundle.putString(KEY.K_WEAPON_NAME + KEY.item(curr), name);
                bundle.putString(KEY.K_WEAPON_DMG_ROLL + KEY.item(curr), dmgRoll);
                bundle.putString(KEY.K_WEAPON_DMG_BONUS + KEY.item(curr), dmgBonus);
                bundle.putString(KEY.K_WEAPON_DESCRIPTION + KEY.item(curr), desc);
                bundle.putString(KEY.K_WEAPON_ATTK_BONUS + KEY.item(curr), attkBonus);
            }
        }
    }

    private void extractDataFromBiography(Element biography) {
        String name, pClass, pRace, size, weight, height, align, deity, level;
        name = extractString(biography, KEY.L_CHARACTER_NAME);
        pClass = extractString(biography, KEY.L_CLASS);
        pRace = extractString(biography, KEY.L_RACE);
        size = extractString(biography, KEY.L_SIZE);
        weight = extractString(biography, KEY.L_WEIGHT);
        height = extractString(biography, KEY.L_HEIGHT);
        align = extractString(biography, KEY.L_ALIGNMENT);
        deity = extractString(biography, KEY.L_DEITY);
        level = extractString(biography, KEY.L_LEVEL);
        
        bundle.putString(KEY.K_CHARACTER_NAME, name);
        bundle.putString(KEY.K_CLASS, pClass);
        bundle.putString(KEY.K_RACE, pRace);
        bundle.putString(KEY.K_SIZE, size);
        bundle.putString(KEY.K_WEIGHT, weight);
        bundle.putString(KEY.K_HEIGHT, height);
        bundle.putString(KEY.K_ALIGNMENT, align);
        bundle.putString(KEY.K_DEITY, deity);
        bundle.putString(KEY.K_LEVEL, level);
    }

    private void extractDataFromAttributes(Element attributes) {
        String str, dex, con, intel, wis, cha;
        String pStr, pDex, pCon, pIntel, pWis, pCha;
        
        str = extractString(attributes, KEY.L_STRENGTH);
        dex = extractString(attributes, KEY.L_DEXTERITY);
        con = extractString(attributes, KEY.L_CONSTITUION);
        intel = extractString(attributes, KEY.L_INTELLIGENCE);
        wis = extractString(attributes, KEY.L_WISDOM);
        cha = extractString(attributes, KEY.L_CHARISMA);
        
        bundle.putString(KEY.K_STRENGTH, str);
        bundle.putString(KEY.K_DEXTERITY, dex);
        bundle.putString(KEY.K_CONSTITUTION, con);
        bundle.putString(KEY.K_INTELLIGENCE, intel);
        bundle.putString(KEY.K_WISDOM, wis);
        bundle.putString(KEY.K_CHARISMA, cha);
        
        /*
        pStr = extractString(attributes, KEY.L_STRPROF);
        pDex = extractString(attributes, KEY.L_DEXPROF);
        pCon = extractString(attributes, KEY.L_CONPROF);
        pIntel = extractString(attributes, KEY.L_INTPROF);
        pWis = extractString(attributes, KEY.L_WISPROF);
        pCha = extractString(attributes, KEY.L_CHAPROF);
        */
    }
}
