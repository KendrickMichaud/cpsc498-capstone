/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file_io;

import app.Bundle;
import app.DataIntegrity;
import templates.RacePower;
import templates.PowerRating;
import templates.Power;
import file_io.FileManager;
import gui.util.KEY;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
import data_structure.Inventory;
import data_structure.Item;
import data_structure.Skill;
import data_structure.Skills;
import data_structure.Spell;
import data_structure.Spellbook;
import java.io.InputStream;
import templates.BackgroundTemplates;
import templates.BackgroundTemplates.PlayerBackground;
import templates.ClassTemplates;
import templates.Feature;
import templates.PlayerClass;
import templates.PlayerClassBuilder;
import templates.PlayerRace;
import templates.RaceTemplates;
import templates.Templates;

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
            Element defense = extractElement(character, KEY.H_DEFENSE);
            
            
            extractDataFromBiography(biography);
            extractDataFromAttributes(attributes);
            extractDataFromBackground(background);
            extractDataFromImage(image);
            extractDataFromArmor(armor);
            extractDataFromDefense(defense);
            extractDataFromUtility(utility);
            extractWeapons(weapons);
            extractDataFromInventory(inventory);
            extractDataFromSpellbook(spellbook);
            extractDataFromFeatures(feature);
            extractDataFromSkills(skills);
            bundle.putBoolean(FileManager.IO_SUCCESS, Boolean.TRUE);
            return bundle;
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(XMLReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        bundle.putBoolean(FileManager.IO_SUCCESS, Boolean.FALSE);
        return bundle;
    }
    
    private Element extractElement(Element root, String tag){
        if(root == null || tag == null){
            return null;
        }
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
                
                if(!DataIntegrity.isNumeric(attkBonus))
                    attkBonus = "0";
                if(!DataIntegrity.isNumeric(dmgBonus))
                    dmgBonus = "0";
                                
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
        con = extractString(attributes, KEY.L_CONSTITUTION);
        intel = extractString(attributes, KEY.L_INTELLIGENCE);
        wis = extractString(attributes, KEY.L_WISDOM);
        cha = extractString(attributes, KEY.L_CHARISMA);
        
        bundle.putString(KEY.K_STRENGTH, str);
        bundle.putString(KEY.K_DEXTERITY, dex);
        bundle.putString(KEY.K_CONSTITUTION, con);
        bundle.putString(KEY.K_INTELLIGENCE, intel);
        bundle.putString(KEY.K_WISDOM, wis);
        bundle.putString(KEY.K_CHARISMA, cha);
        
        
        pStr = extractString(attributes, KEY.L_STRPROF);
        pDex = extractString(attributes, KEY.L_DEXPROF);
        pCon = extractString(attributes, KEY.L_CONPROF);
        pIntel = extractString(attributes, KEY.L_INTPROF);
        pWis = extractString(attributes, KEY.L_WISPROF);
        pCha = extractString(attributes, KEY.L_CHAPROF);
                
        bundle.putString(KEY.K_STRENGTH_PROF, pStr);
        bundle.putString(KEY.K_DEXTERITY_PROF, pDex);
        bundle.putString(KEY.K_CONSTITUTION_PROF, pCon);
        bundle.putString(KEY.K_INTELLIGENCE_PROF, pIntel);
        bundle.putString(KEY.K_WISDOM_PROF, pWis);
        bundle.putString(KEY.K_CHARISMA_PROF, pCha);
    }

    private void extractDataFromArmor(Element armor) {
        String ac, desc, dexC, name;
        ac = extractString(armor, KEY.L_AC);
        desc = extractString(armor, KEY.L_DESCRIPTION);
        dexC = extractString(armor, KEY.L_DEX_CAP);
        name = extractString(armor, KEY.L_NAME);
        
        bundle.putString(KEY.K_ARMOR_AC, ac);
        bundle.putString(KEY.K_ARMOR_DESCRIPTION, desc);
        bundle.putString(KEY.K_ARMOR_DEX_CAP, dexC);
        bundle.putString(KEY.K_ARMOR_NAME, name);
    }

    private void extractDataFromDefense(Element defense) {
        String dr, bon, acExtra;
        dr = extractString(defense, KEY.L_DAMAGE_RESISTANCE);
        bon = extractString(defense, KEY.L_DEFENSE_BONUS);
        acExtra = extractString(defense, KEY.L_AC_EXTRA);
        
        bundle.putString(KEY.K_DEFENSE_DR, dr);
        bundle.putString(KEY.K_DEFENSE_BONUSES, bon);
        bundle.putString(KEY.K_DEFENSE_AC_EXTRA, acExtra);
    }

    private void extractDataFromUtility(Element utility) {
        String speed, init, health, hitDie;
        speed = extractString(utility, KEY.L_SPEED_BONUS);
        init = extractString(utility, KEY.L_INIT_BONUS);
        health = extractString(utility, KEY.L_HEALTH_POINTS);
        hitDie = extractString(utility, KEY.L_HIT_DIE);
        
        bundle.putString(KEY.K_SPEED_BONUS, speed);
        bundle.putString(KEY.K_INIT_BONUS, init);
        bundle.putString(KEY.K_HEALTH_POINTS, health);
        bundle.putString(KEY.K_HIT_DIE, hitDie);
    }

    private void extractDataFromInventory(Element inventory) {
        NodeList list = inventory.getChildNodes();
        Inventory inv = new Inventory();
        for(int i = 0; i < list.getLength(); i++){
            Node node = list.item(i);
            if(node instanceof Element){                      
                Element ele = (Element) node;
                String name, desc, weight, quantity;
                name = extractString(ele, KEY.L_NAME);
                desc = extractString(ele, KEY.L_DESCRIPTION);
                weight = extractString(ele, KEY.L_WEIGHT);
                quantity = extractString(ele, KEY.L_QUANTITY);
                Item item = new Item(name, desc, quantity, weight);
                inv.store(item);
            }
        }
        bundle.putInventory(inv);
    }

    private void extractDataFromSpellbook(Element spellbook) {
        String caster = extractString(spellbook, "caster");
        int cast = 0;
        if(DataIntegrity.isNumeric(caster)){
            cast = Integer.parseInt(caster);
            if(cast > 2 || cast < 0){
                cast = 0;
            }
        }
        Spellbook book = new Spellbook(cast);
        NodeList pages = spellbook.getElementsByTagName("page");
        for(int pageNum = 0; pageNum < pages.getLength(); pageNum++){
            Element page = (Element) pages.item(pageNum);
            NodeList spells = page.getElementsByTagName("spell");
            ArrayList<Spell> list = new ArrayList<>();
            for(int curr = 0; curr < spells.getLength(); curr++){
                Element spell = (Element) spells.item(curr);
                String name = extractString(spell, KEY.L_NAME);
                String desc = extractString(spell, KEY.L_DESCRIPTION);
                
                Spell sp = new Spell(name, desc);
                list.add(sp);
            }
            book.addSpellsCollection(list);
        }
        bundle.putSpellbook(book);
    }

    private void extractDataFromSkills(Element skills) {
        Skills skillList = new Skills();
        NodeList list = skills.getElementsByTagName("skill");
        for(int i = 0; i < list.getLength(); i++){
            Element skill = (Element) list.item(i);
            try{
                int type = Integer.parseInt(extractString(skill, KEY.L_SKILL_TYPE));
                int bonus = Integer.parseInt(extractString(skill, KEY.L_SKILL_BONUS));
                String name = extractString(skill, KEY.L_NAME);
                Skill sk = new Skill(type, bonus, name);
                skillList.addSkill(sk);
            }
            catch (NumberFormatException e){
                Logger.getLogger(XMLReader.class.getName()).log(Level.SEVERE, "Improper format of data for skill");
            }

        }
        String str = extractString(skills, KEY.L_EQUIPMENT_PROFICIENCES);
        if(str != null){
            bundle.putString(KEY.K_EQUIPMENT_LANG_PROFICIENCIES, str);
        }
        
        bundle.putSkills(skillList);
    }

    private void extractDataFromFeatures(Element feature) {
        String str = extractString(feature, KEY.L_FEATURES_DESCRIPTION);
        if(str != null){
            bundle.putString(KEY.K_FEATURES_DESCRIPTION, str);
        }
    }

    public Bundle readBackgrounds(File file) {
        bundle = new Bundle();
        try{
            if(file == null){
                bundle.putBoolean(FileManager.IO_SUCCESS, Boolean.FALSE);
                return bundle;
            }
            
            InputStream is = getClass().getResourceAsStream("/templates/backgrounds.xml");
            DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
            DocumentBuilder build = fact.newDocumentBuilder();
            Document doc = build.parse(is);
            
            doc.getDocumentElement().normalize();
            Element root = doc.getDocumentElement();
            NodeList backgrounds = root.getElementsByTagName("background");
            if(backgrounds != null && backgrounds.getLength() > 0){
                BackgroundTemplates templates;
                templates = new BackgroundTemplates();
                for(int index = 0; index < backgrounds.getLength(); index++){
                    BackgroundTemplates.PlayerBackground background = new PlayerBackground();
                    Element iBackground = (Element) backgrounds.item(index);
                    Element name,trait,ideal,bond,flaw;
                    Element proficiencies, features;
                    
                    name = extractElement(iBackground, "name");
                    trait = extractElement(iBackground, "trait");
                    ideal = extractElement(iBackground, "ideal");
                    bond = extractElement(iBackground, "bond");
                    flaw = extractElement(iBackground, "flaw");
                    
                                        
                    String strName = name.getTextContent();
                    ArrayList<String> traits, ideals, bonds, flaws;
                    String arrayTagName = "option";
                    traits = extractStrings(trait, arrayTagName);
                    ideals = extractStrings(ideal, arrayTagName);
                    bonds = extractStrings(bond, arrayTagName);
                    flaws = extractStrings(flaw, arrayTagName);
                    background.setName(strName);
                    String strDesc = extractString(iBackground, "description");
                    background.addStrings(traits, PlayerBackground.STORY.TRAIT);
                    background.addStrings(ideals, PlayerBackground.STORY.IDEAL);
                    background.addStrings(bonds, PlayerBackground.STORY.BOND);
                    background.addStrings(flaws, PlayerBackground.STORY.FLAW);
                    if(strDesc != null){
                        background.addDescription(strDesc);
                    }
                    
                    proficiencies = extractElement(iBackground, "proficiencies");
                    if(proficiencies != null){
                        Element skills = extractElement(proficiencies, "skills");
                        if(skills != null){
                            ArrayList<String> skillProficincies;
                            skillProficincies = extractStrings(skills, "skill");
                            background.addSkills(skillProficincies);
                        }
                    }
                    features = extractElement(iBackground, "features");
                    if(features != null){
                        ArrayList<Feature> featuresList;
                        featuresList = extractFeatures(features);
                        background.addFeatures(featuresList);
                    }
                   
                        
                    
                    templates.add(background);
                }
                
                bundle.putTemplate(Templates.TYPE.T_BACKGROUND, templates);
            }
            bundle.putBoolean(FileManager.IO_SUCCESS, Boolean.TRUE);
        } catch (SAXException | IOException | ParserConfigurationException ex) {
            Logger.getLogger(XMLReader.class.getName()).log(Level.SEVERE, null, ex);
            bundle.putBoolean(FileManager.IO_SUCCESS, Boolean.FALSE);
        }
        return bundle;
        
    }

    public Bundle readClasses(File file) {
        bundle = new Bundle();
        try{
            if(file == null){
                bundle.putBoolean(FileManager.IO_SUCCESS, Boolean.FALSE);
                return bundle;
            }
            
            InputStream is = getClass().getResourceAsStream("/templates/classes.xml");
            DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
            DocumentBuilder build = fact.newDocumentBuilder();
            Document doc = build.parse(is);
            
            doc.getDocumentElement().normalize();
            Element root = doc.getDocumentElement();
            NodeList classes = root.getElementsByTagName("class");
            if(classes != null && classes.getLength() > 0){
                ClassTemplates templates;
                templates = new ClassTemplates();
                for(int index = 0; index < classes.getLength(); index++){

                    PlayerClassBuilder builder = new PlayerClassBuilder();
                    Element pClass = (Element) classes.item(index);
                    Element health = extractElement(pClass, "health");
                    Element profs = extractElement(pClass, "proficiencies");
                    Element skills = extractElement(profs, "skills");
                    Element saves = extractElement(profs, "savingThrows");
                    Element equip = extractElement(profs, "equipment");
                    Element feature = extractElement(pClass, "features");
                    Power power = extractPower(pClass);
                    
                    ArrayList<String> equipmentProfs = new ArrayList<>();
                    equipmentProfs.add(extractString(equip, "weapon"));
                    equipmentProfs.add(extractString(equip, "armor"));
                    equipmentProfs.add(extractString(equip, "tool"));
                    
                    builder.setName(extractString(pClass, "name"))
                            .setFlavorText(extractString(pClass, "flavorText"))
                            .setCasterType(extractString(pClass, "casterType"))
                            .setHitDie(extractString(health, "hitDie"))
                            .setHitDieAttribute(extractString(health, "attribute"))
                            .setSkillsProfs(extractStrings(skills, "option"))
                            .setSavingThrows(extractStrings(saves, "attribute"))
                            .setEquipmentProfs(equipmentProfs)
                            .setFeatures(extractFeatures(feature));
                        
                    if(builder.validClass()){
                        PlayerClass ca = builder.createPlayerClass();
                        if(power != null){
                            power.setCasterType(ca.casterType);
                            ca.setPowerLevel(power);
                        }
                        templates.add(ca);
                    }
                }
                
                bundle.putTemplate(Templates.TYPE.T_CLASS, templates);
            }
            bundle.putBoolean(FileManager.IO_SUCCESS, Boolean.TRUE);
        } catch (SAXException | IOException | ParserConfigurationException ex) {
            Logger.getLogger(XMLReader.class.getName()).log(Level.SEVERE, null, ex);
            bundle.putBoolean(FileManager.IO_SUCCESS, Boolean.FALSE);
        }
        return bundle;
    }

    public Bundle readRaces(File file) {
        bundle = new Bundle();
        try{
            if(file == null){
                bundle.putBoolean(FileManager.IO_SUCCESS, Boolean.FALSE);
                return bundle;
            }
            InputStream is = getClass().getResourceAsStream("/templates/races.xml");
            
            DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
            DocumentBuilder build = fact.newDocumentBuilder();
            Document doc = build.parse(is);
            
            doc.getDocumentElement().normalize();
            Element root = doc.getDocumentElement();
            NodeList races = root.getElementsByTagName("race");
            if(races != null && races.getLength() > 0){
                RaceTemplates templates;
                templates = new RaceTemplates();
                for(int index = 0; index < races.getLength(); index++){
                    Element race = (Element) races.item(index);
                    if(race != null){
                        String name, size, flavorText, image;
                        ArrayList<String> lang;
                        Bundle languages = new Bundle();
                        Bundle attributes = new Bundle();
                        ArrayList<Feature> features = new ArrayList<>();
                        name = extractString(race, KEY.L_NAME);
                        size = extractString(race, KEY.L_SIZE);
                        image = extractString(race, KEY.L_RACE_IMAGE);
                        flavorText = extractString(race, "flavorText");
                        Element feature = extractElement(race, "features");
                        if(feature != null){
                            features.addAll(extractFeatures(feature));
                        }
                        lang = new ArrayList<>();
                        Element langs = extractElement(race, "languages");
                        if(langs != null){
                            lang.addAll(extractStrings(langs, "item"));
                            String wild = extractString(langs, "wildcard");
                            int wAmount = 0;
                            if(wild != null && DataIntegrity.isNumeric(wild)){
                                wAmount = Integer.parseInt(wild);
                                if(wAmount < 0)
                                    wAmount = 0;
                            }
                            
                            languages.putInteger("wildcard", wAmount);
                            languages.putInteger(KEY.L_SIZE, lang.size());
                            for(int i = 0; i < lang.size(); i++){
                                languages.putString(Integer.toString(i), lang.get(i));
                            }
                        }
                        
                        Element attr = extractElement(race, "attributes");
                        if(attr != null){
                            String str, dex, con, intel, wis, cha;
                            Element wild;
                            str = extractString(attr, KEY.L_STRENGTH);
                            dex = extractString(attr, KEY.L_DEXTERITY);
                            con = extractString(attr, KEY.L_CONSTITUTION);
                            intel = extractString(attr, KEY.L_INTELLIGENCE);
                            wis = extractString(attr, KEY.L_WISDOM);
                            cha = extractString(attr, KEY.L_CHARISMA);
                            wild = extractElement(attr, "wildcard");
                           
                            if(str != null && DataIntegrity.isNumeric(str)){
                                attributes.putInteger(KEY.L_STRENGTH, Integer.parseInt(str));
                            }
                            if(dex != null && DataIntegrity.isNumeric(dex)){
                                attributes.putInteger(KEY.L_DEXTERITY, Integer.parseInt(dex));
                            }
                            if(con != null && DataIntegrity.isNumeric(con)){
                                attributes.putInteger(KEY.L_CONSTITUTION, Integer.parseInt(con));
                            }
                            if(intel != null && DataIntegrity.isNumeric(intel)){
                                attributes.putInteger(KEY.L_INTELLIGENCE, Integer.parseInt(intel));
                            }
                            if(wis != null && DataIntegrity.isNumeric(wis)){
                                attributes.putInteger(KEY.L_WISDOM, Integer.parseInt(wis));
                            }
                            if(cha != null && DataIntegrity.isNumeric(cha)){
                                attributes.putInteger(KEY.L_CHARISMA, Integer.parseInt(cha));
                            }
                            if(wild != null){
                                String amt = wild.getAttribute("amt");
                                String bonus = wild.getTextContent();
                                if(amt != null && bonus != null && DataIntegrity.isNumeric(amt) && DataIntegrity.isNumeric(bonus)){
                                    int amount = Integer.parseInt(amt);
                                    int bon = Integer.parseInt(bonus);
                                    
                                    attributes.putInteger("wildcard", bon);
                                    attributes.putInteger("wildcardAmount", amount);
                                }
                            }
                        }
                        PlayerRace r = new PlayerRace(
                        name,attributes,size,languages,features,flavorText
                        );
                        
                        if(image != null)
                            r.initImagePath(image);
                        
                        RacePower rp = extractRacePower(race, attributes);
                        if(rp != null){
                            r.setPower(rp);
                        }                        templates.add(r);
                    }
                    
                    
                }
                
                bundle.putTemplate(Templates.TYPE.T_RACE, templates);
            }
            bundle.putBoolean(FileManager.IO_SUCCESS, Boolean.TRUE);
        } catch (SAXException | IOException | ParserConfigurationException ex) {
            Logger.getLogger(XMLReader.class.getName()).log(Level.SEVERE, null, ex);
            bundle.putBoolean(FileManager.IO_SUCCESS, Boolean.FALSE);
        }
        return bundle;
    }

    private ArrayList<String> extractStrings(Element root, String tagName) {
        NodeList nodes = root.getElementsByTagName(tagName);
        if(nodes != null && nodes.getLength() > 0){
            ArrayList<String> strings = new ArrayList<>();
            for(int i = 0; i < nodes.getLength(); i++){
                String item = ((Element) nodes.item(i)).getTextContent();
                if(item != null){
                    strings.add(item);
                }
            }
            return strings;
        }
        return new ArrayList<>();
    }

    private ArrayList<Feature> extractFeatures(Element root) {
        if(root == null)
            return null;
        ArrayList<Feature> features = new ArrayList<>();
        NodeList nodes = root.getElementsByTagName("feature");
        if(nodes != null){
            for(int i = 0; i < nodes.getLength(); i++){
                Element item = (Element) nodes.item(i);
                if(item != null){
                    String name, desc;
                    name = extractString(item, "title");
                    desc = extractString(item, "body");
                    if(name != null && desc != null){
                        features.add(new Feature(name, desc));
                    }
                }
            }
        }
        return features;
    }
    
    private RacePower extractRacePower(Element pRace, Bundle attributes){
        Power p = extractPower(pRace);
        RacePower rp = new RacePower(p, attributes);
        return rp;
    }

    private Power extractPower(Element pClass) {
        Element powerRating = extractElement(pClass, "powerRating");
        Element magic, martial, position;
        magic = extractElement(powerRating, "magic");
        martial = extractElement(powerRating, "martial");
        position = extractElement(powerRating, "position");
        
        int moff, mdeff, mutil;
        int martoff, martdeff, martutil;
        int ranged, melee;
        
        moff = extractInteger(magic, PowerRating.OFFENSIVE);
        mdeff = extractInteger(magic, PowerRating.DEFENSIVE);
        mutil = extractInteger(magic, PowerRating.UTILITY);
        
        martoff = extractInteger(martial, PowerRating.OFFENSIVE);
        martdeff = extractInteger(martial, PowerRating.DEFENSIVE);
        martutil = extractInteger(martial, PowerRating.UTILITY);
        
        ranged = extractInteger(position, PowerRating.RANGED);
        melee = extractInteger(position, PowerRating.MELEE);
        
        Power p = new Power();
        p.setMagic(moff, mdeff, mutil);
        p.setMartial(martoff, martdeff, martutil);
        p.setPlaystyle(melee, ranged);
        return p;
    }

    private int extractInteger(Element root, String tag) {
        if(root == null){
            return 0;
        }
        String s = extractString(root, tag);
        if(DataIntegrity.isNumeric(s)){
            return Integer.parseInt(s);
        }
        return 0;
    }
}
