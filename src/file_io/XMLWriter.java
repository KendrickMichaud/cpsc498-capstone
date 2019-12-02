/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file_io;

import app.Bundle;
import gui.util.KeyReader;
import file_io.FileManager;
import gui.util.KEY;
import java.io.File;
import java.util.ArrayList;
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
import data_structure.Inventory;
import data_structure.Item;
import data_structure.Skill;
import data_structure.Skills;
import data_structure.Spell;
import data_structure.Spellbook;
import java.io.OutputStream;
import javax.swing.JOptionPane;

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
        Element character = document.createElement("Character");
        document.appendChild(character);
        Element biography = document.createElement(KEY.H_BIOGRAPHY);
        Element background = document.createElement(KEY.H_BACKGROUND);
        Element skills = document.createElement(KEY.H_SKILLS);
        Element attributes = document.createElement(KEY.H_ATTRIBUTES);
        Element inventory = document.createElement(KEY.H_INVENTORY);
        Element weapons = document.createElement(KEY.H_WEAPON);
        Element armor = document.createElement(KEY.H_ARMOR);
        Element defense = document.createElement(KEY.H_DEFENSE);
        Element spellbook = document.createElement(KEY.H_SPELLBOOK);
        Element utility = document.createElement(KEY.H_UTILITY);
        Element features = document.createElement(KEY.H_FEATURE);
        Element image = document.createElement(KEY.H_IMAGE);
        addChildrenToImage(image);
        addChildrenToElement(biography);
        addChildrenToElement(background);
        addChildrenToElement(weapons);
        addChildrenToElement(attributes);
        addChildrenToElement(armor);
        addChildrenToElement(defense);
        addChildrenToElement(utility);
        addChildrenToElement(inventory);
        addChildrenToElement(spellbook);
        addChildrenToElement(skills);
        addChildrenToElement(features);
        
        character.appendChild(biography);
        character.appendChild(background);
        character.appendChild(skills);
        character.appendChild(attributes);
        character.appendChild(inventory);
        character.appendChild(weapons);
        character.appendChild(armor);
        character.appendChild(defense);
        character.appendChild(spellbook);
        character.appendChild(utility);
        character.appendChild(features);
        character.appendChild(image);
        
        return true;
    }

    private boolean writeToFile(File file) {
        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(file.getAbsolutePath());
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
                case KEY.H_BIOGRAPHY:
                    addChild(KEY.K_CHARACTER_NAME,ele);
                    addChild(KEY.K_CLASS, ele);
                    addChild(KEY.K_RACE, ele);
                    addChild(KEY.K_SIZE, ele);
                    addChild(KEY.K_WEIGHT, ele);
                    addChild(KEY.K_HEIGHT, ele);
                    addChild(KEY.K_DEITY, ele);
                    addChild(KEY.K_ALIGNMENT, ele);
                    addChild(KEY.K_LEVEL, ele);
                    break;
                case KEY.H_ARMOR:
                    addChild(KEY.K_ARMOR_AC, ele);
                    addChild(KEY.K_ARMOR_DESCRIPTION, ele);
                    addChild(KEY.K_ARMOR_DEX_CAP, ele);
                    addChild(KEY.K_ARMOR_NAME, ele);
                    break;
                case KEY.H_DEFENSE:
                    addChild(KEY.K_DEFENSE_DR, ele);
                    addChild(KEY.K_DEFENSE_BONUSES, ele);
                    addChild(KEY.K_DEFENSE_AC_EXTRA, ele);
                    break;
                case KEY.H_WEAPON:
                    for(int i = 0; i < 3; i++){
                        addWeapon(i, ele);
                    }
                    break;
                case KEY.H_ATTRIBUTES:
                    addChild(KEY.K_STRENGTH, ele);
                    addChild(KEY.K_DEXTERITY, ele);
                    addChild(KEY.K_CONSTITUTION, ele);
                    addChild(KEY.K_INTELLIGENCE, ele);
                    addChild(KEY.K_WISDOM, ele);
                    addChild(KEY.K_CHARISMA, ele);
                    addChild(KEY.K_STRENGTH_PROF, ele);
                    addChild(KEY.K_DEXTERITY_PROF, ele);
                    addChild(KEY.K_CONSTITUTION_PROF, ele);
                    addChild(KEY.K_INTELLIGENCE_PROF, ele);
                    addChild(KEY.K_WISDOM_PROF, ele);
                    addChild(KEY.K_CHARISMA_PROF, ele);
                    break;
                case KEY.H_UTILITY:
                    addChild(KEY.K_SPEED_BONUS,ele);
                    addChild(KEY.K_INIT_BONUS, ele);
                    addChild(KEY.K_HEALTH_POINTS, ele);
                    addChild(KEY.K_HIT_DIE,ele);
                    break;
                case KEY.H_INVENTORY:
                    Inventory inv = bundle.getInventory();
                    if(inv != null){
                        for(int i = 0; i < inv.size(); i++){
                            Item item = inv.get(i);
                            addItem(item, ele);
                        }
                    }
                    break;
                case KEY.H_SPELLBOOK:
                    Spellbook book = bundle.getSpellbook();
                    if(book != null){
                        ele.appendChild(createElement("caster", Integer.toString(book.getCasterType())));
                        for(int i = 0; i < book.length(); i++){
                            addSpells(book.getCollection(i), ele, i);
                        }
                    }
                    break;
                case KEY.H_SKILLS:
                    Skills skills = bundle.getSkills();
                    if(skills != null){
                        for(int i = 0; i < skills.size(); i++){
                            addSkill(skills.getSkill(i), ele);
                        }
                    }
                    addChild(KEY.K_EQUIPMENT_LANG_PROFICIENCIES, ele);
                    break;
                case KEY.H_FEATURE:
                    addChild(KEY.K_FEATURES_DESCRIPTION, ele);
                    break;
            }
        }
    }
    
    private void addChild(String key, Element root){
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

    private void addItem(Item item, Element inventory) {
        Element itemRow = document.createElement("item");
        itemRow.appendChild(createElement(KEY.L_NAME, item.name));
        itemRow.appendChild(createElement(KEY.L_DESCRIPTION, item.desc));
        itemRow.appendChild(createElement(KEY.L_QUANTITY, item.quantity));
        itemRow.appendChild(createElement(KEY.L_WEIGHT, item.weight));
        inventory.appendChild(itemRow);
    }
    
    private Element createElement(String tag, String value){
        Element ele = document.createElement(tag);
        if(value != null){
            ele.setTextContent(value);
        }
        return ele;
    }
    
    private void addSpells(ArrayList<Spell> spells, Element spellbook, int pageNum){
        Element page = document.createElement("page");
        page.setAttribute("num", Integer.toString(pageNum));
        for(Spell spell : spells){
            Element eleSpell = document.createElement("spell");
            eleSpell.appendChild(createElement(KEY.L_NAME, spell.name));
            eleSpell.appendChild(createElement(KEY.L_DESCRIPTION, spell.description));
            page.appendChild(eleSpell);
        }
        spellbook.appendChild(page);
    }

    private void addSkill(Skill skill, Element skills) {
        Element eleSkill = document.createElement("skill");
        eleSkill.appendChild(createElement(KEY.L_NAME, skill.name));
        eleSkill.appendChild(createElement(KEY.L_SKILL_TYPE, Integer.toString(skill.type)));
        eleSkill.appendChild(createElement(KEY.L_SKILL_BONUS, Integer.toString(skill.bonusAmount)));
        skills.appendChild(eleSkill);
    }
    
}
