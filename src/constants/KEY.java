package constants;

public class KEY {

    //High keys and delimiters
    
    //Note: XML gets angry at me for asterisk and dash characters
    //But since they're fine with Russian letters looking like asterisks
    //.... might as well use it since localisation wouldn't affect this part.
    public static final String DELIM = "ж";
    public static final String I_DELIM = "ф";
    public static final String H_BIOGRAPHY = "biographicalData" + DELIM;
    public static final String H_BACKGROUND = "background" + DELIM;
    public static final String H_ATTRIBUTES = "attributes" + DELIM;
    public static final String H_INVENTORY = "inventory" + DELIM;
    public static final String H_SPELLBOOK = "spellbook" + DELIM;
    public static final String H_WEAPON = "equippedWeapon" + DELIM;
    public static final String H_ARMOR = "equippedArmor" + DELIM;
    public static final String H_FEATURE = "feature" + DELIM;
    public static final String H_SKILLS = "skills" + DELIM;
    public static final String H_UTILITY = "utility" + DELIM;
    public static final String H_IMAGE = "Image" + DELIM;
    public static final String H_PROFICIENCIES = "Proficiencies" + DELIM;
    public static final String H_DEFENSE = "Defense" + DELIM;
    
    //Special Keys 
    public static final String K_INVENTORY = "Inventory"; //Unique key doesn't need hkey or low key
    public static final String K_SPELLBOOK = "Spellbook";
    public static final String K_SKILLS = "Skills";
    public static final String L_SKILL_TYPE = "SkillType";
    public static final String L_SKILL_BONUS = "SkillBonus";
    
   
    //Generic Low Key
    public static final String L_NAME = "name";
    public static final String NULL = "NULL";

    //Biographical Data Low Keys
    public static final String L_CHARACTER_NAME = "characterName";
    public static final String L_DEITY = "deity";
    public static final String L_WEIGHT = "weight";
    public static final String L_ALIGNMENT = "alignment";
    public static final String L_SIZE = "size";
    public static final String L_HEIGHT = "height";
    public static final String L_CLASS = "playerClass";
    public static final String L_RACE = "playerRace";
    public static final String L_LEVEL = "playerLevel";

    //Biographical Data Keys
    public static final String K_CHARACTER_NAME = H_BIOGRAPHY + L_CHARACTER_NAME;
    public static final String K_DEITY = H_BIOGRAPHY + L_DEITY;
    public static final String K_ALIGNMENT = H_BIOGRAPHY + L_ALIGNMENT;
    public static final String K_SIZE = H_BIOGRAPHY + L_SIZE;
    public static final String K_HEIGHT = H_BIOGRAPHY + L_HEIGHT;
    public static final String K_WEIGHT = H_BIOGRAPHY + L_WEIGHT;
    public static final String K_CLASS = H_BIOGRAPHY + L_CLASS;
    public static final String K_RACE = H_BIOGRAPHY + L_RACE;
    public static final String K_LEVEL = H_BIOGRAPHY + L_LEVEL;

    //Background low_keys
    public static final String L_TRAIT = "trait";
    public static final String L_IDEAL = "ideal";
    public static final String L_BOND = "bond";
    public static final String L_FLAW = "flaw";

    //Background keys
    public static final String K_BACKGROUND_NAME = H_BACKGROUND + L_NAME;
    public static final String K_BACKGROUND_TRAIT = H_BACKGROUND + L_TRAIT;
    public static final String K_BACKGROUND_IDEAL = H_BACKGROUND + L_IDEAL;
    public static final String K_BACKGROUND_BOND = H_BACKGROUND + L_BOND;
    public static final String K_BACKGROUND_FLAW = H_BACKGROUND + L_FLAW;

    //Attribute Low Key
    public static final String L_STRENGTH = "Strength";
    public static final String L_DEXTERITY = "Dexterity";
    public static final String L_CONSTITUION = "Constitution";
    public static final String L_INTELLIGENCE = "Intelligence";
    public static final String L_WISDOM = "Wisdom";
    public static final String L_CHARISMA = "Charisma";
    
    public static final String L_PROF = "Prof";
    public static final String L_STRPROF = L_STRENGTH+L_PROF;
    public static final String L_DEXPROF = L_DEXTERITY+L_PROF;
    public static final String L_CONPROF = L_CONSTITUION+L_PROF;
    public static final String L_INTPROF = L_INTELLIGENCE+L_PROF;
    public static final String L_WISPROF = L_WISDOM+L_PROF;
    public static final String L_CHAPROF = L_CHARISMA+L_PROF;
    
    

    //Attributes keys
    public static final String K_STRENGTH = H_ATTRIBUTES + L_STRENGTH;
    public static final String K_DEXTERITY = H_ATTRIBUTES + L_DEXTERITY;
    public static final String K_CONSTITUTION = H_ATTRIBUTES + L_CONSTITUION;
    public static final String K_INTELLIGENCE = H_ATTRIBUTES + L_INTELLIGENCE;
    public static final String K_WISDOM = H_ATTRIBUTES + L_WISDOM;
    public static final String K_CHARISMA = H_ATTRIBUTES + L_CHARISMA;
    
    public static final String K_STRENGTH_PROF = H_ATTRIBUTES + L_STRPROF;
    public static final String K_DEXTERITY_PROF = H_ATTRIBUTES + L_DEXPROF;
    public static final String K_CONSTITUTION_PROF = H_ATTRIBUTES + L_CONPROF;
    public static final String K_INTELLIGENCE_PROF = H_ATTRIBUTES + L_INTPROF;
    public static final String K_WISDOM_PROF = H_ATTRIBUTES + L_WISPROF;
    public static final String K_CHARISMA_PROF = H_ATTRIBUTES + L_CHAPROF;

    //Armor Low Keys
    public static final String L_DESCRIPTION = "desc";
    public static final String L_AC = "ac";
    public static final String L_DEX_CAP = "dexCap";
    public static final String L_DAMAGE_RESISTANCE = "DamageResistance";
    public static final String L_DEFENSE_BONUS = "DefenseBonus";
    public static final String L_AC_EXTRA = "ExtraAC";
    public static final String L_DEX_SAVE_BONUS = "DexSaveBonus";
    public static final String L_WIS_SAVE_BONUS = "WisSaveBonus";
    public static final String L_CHA_SAVE_BONUS = "ChaSaveBonus";
    
    //Armor Panel Keys
    
    public static final String K_ARMOR_NAME = H_ARMOR + L_NAME;
    public static final String K_ARMOR_DESCRIPTION = H_ARMOR + L_DESCRIPTION;
    public static final String K_ARMOR_AC = H_ARMOR + L_AC;
    public static final String K_ARMOR_DEX_CAP = H_ARMOR + L_DEX_CAP;
    public static final String K_DEFENSE_DR = H_DEFENSE + L_DAMAGE_RESISTANCE;
    public static final String K_DEFENSE_BONUSES = H_DEFENSE + L_DEFENSE_BONUS;
    public static final String K_DEFENSE_AC_EXTRA = H_DEFENSE + L_AC_EXTRA;

    //Weapon Low Keys
    public static final String L_ATTK_BONUS = "attkBonus";
    public static final String L_DMG_ROLL = "dmgRoll";
    public static final String L_DMG_BONUS = "dmgBonus";
    public static final String L_BASE = "Base64";
    public static String L_QUANTITY = "Quantity";
    
    public static String item(int i){
        return DELIM + "item" + I_DELIM + Integer.toString(i);
    }

    //Weapon Keys
    public static final String K_WEAPON_ATTK_BONUS = H_WEAPON + L_ATTK_BONUS;
    public static final String K_WEAPON_DMG_ROLL = H_WEAPON + L_DMG_ROLL;
    public static final String K_WEAPON_DMG_BONUS = H_WEAPON + L_DMG_BONUS;
    public static final String K_WEAPON_NAME = H_WEAPON + L_NAME;
    public static final String K_WEAPON_DESCRIPTION = H_WEAPON + L_DESCRIPTION;
   
    //Utility Low Keys
    public static final String L_SPEED_BONUS = "SpeedBonus";
    public static final String L_INIT_BONUS = "InitiativeBonus";
    public static final String L_HEALTH_POINTS = "HP";
    public static final String L_HIT_DIE = "HitDie";
    
    //Utility Keys
    public static final String K_HEALTH_POINTS = H_UTILITY + L_HEALTH_POINTS;
    public static final String K_HIT_DIE = H_UTILITY + L_HIT_DIE;
    public static final String K_INIT_BONUS = H_UTILITY + L_INIT_BONUS;
    public static final String K_SPEED_BONUS = H_UTILITY + L_SPEED_BONUS;
    
    //Skills and Proficiencies Low Keys
    public static final String L_ATHLETICS_PROF = "Athletics";
    public static final String L_ATHLETICS_BONUS = "AthleticsBonus";
    public static final String L_ACROBATICS_PROF = "Acrobatics";
    public static final String L_ACROBATICS_BONUS = "AcrobaticsBonus";
    public static final String L_SLEIGHT_PROF = "Sleight of Hand";
    public static final String L_SLEIGHT_BONUS = "SleightBonus";
    public static final String L_STEALTH_PROF = "Stealth";
    public static final String L_STEALTH_BONUS = "StealthBonus";
    public static final String L_ARCANA_PROF = "Arcana";
    public static final String L_ARCANA_BONUS = "ArcanaBonus";
    public static final String L_HISTORY_PROF = "History";
    public static final String L_HISTORY_BONUS = "HistoryBonus";
    public static final String L_INVESTIGATION_PROF = "Investigation";
    public static final String L_INVESTIGATION_BONUS = "InvestigationBonus";
    public static final String L_NATURE_PROF = "Nature";
    public static final String L_NATURE_BONUS = "NatureBonus";
    public static final String L_RELIGION_PROF = "Religion";
    public static final String L_RELIGION_BONUS = "ReligionBonus";
    public static final String L_ANIMAL_PROF = "Animal Handling";
    public static final String L_ANIMAL_BONUS = "AnimalHandlingBonus";
    public static final String L_INSIGHT_PROF = "Insight";
    public static final String L_INSIGHT_BONUS = "InsightBonus";
    public static final String L_MEDICINE_PROF = "Medicine";
    public static final String L_MEDICINE_BONUS = "MedicineBonus";
    public static final String L_PERCEPTION_PROF = "Perception";
    public static final String L_PERCEPTION_BONUS = "PerceptionBonus";
    public static final String L_SURVIVAL_PROF = "Survival";
    public static final String L_SURVIVAL_BONUS = "SurvivalBonus";
    public static final String L_DECEPTION_PROF = "Deception";
    public static final String L_DECEPTION_BONUS = "DeceptionBonus";
    public static final String L_INTIMIDATION_PROF = "Intimidation";
    public static final String L_INTIMIDATION_BONUS = "IntimidationBonus";
    public static final String L_PERFORMANCE_PROF = "Performance";
    public static final String L_PERFORMANCE_BONUS = "PerformanceBonus";
    public static final String L_PERSUASION_PROF = "Persuasion";
    public static final String L_PERSUASION_BONUS = "PersuasionBonus";
    public static final String L_EQUIPMENT_PROFICIENCES = "EquipmentProfs";

    //Skils and Proficiences Keys
    public static final String K_ATHLETICS_PROF = H_SKILLS + L_ATHLETICS_PROF;
    public static final String K_ATHLETICS_BONUS = H_SKILLS + L_ATHLETICS_BONUS;
    public static final String K_ACROBATICS_PROF = H_SKILLS + L_ACROBATICS_PROF;
    public static final String K_ACROBATICS_BONUS = H_SKILLS + L_ACROBATICS_BONUS;
    public static final String K_SLEIGHT_PROF = H_SKILLS + L_SLEIGHT_PROF;
    public static final String K_SLEIGHT_BONUS = H_SKILLS + L_SLEIGHT_BONUS;
    public static final String K_STEALTH_PROF = H_SKILLS + L_STEALTH_PROF;
    public static final String K_STEALTH_BONUS = H_SKILLS + L_STEALTH_BONUS;
    public static final String K_ARCANA_PROF = H_SKILLS + L_ARCANA_PROF;
    public static final String K_ARCANA_BONUS = H_SKILLS + L_ARCANA_BONUS;
    public static final String K_HISTORY_PROF = H_SKILLS + L_HISTORY_PROF;
    public static final String K_HISTORY_BONUS = H_SKILLS + L_HISTORY_BONUS;
    public static final String K_INVESTIGATION_PROF = H_SKILLS + L_INVESTIGATION_PROF;
    public static final String K_INVESTIGATION_BONUS = H_SKILLS + L_INVESTIGATION_BONUS;
    public static final String K_NATURE_PROF = H_SKILLS + L_NATURE_PROF;
    public static final String K_NATURE_BONUS = H_SKILLS + L_NATURE_BONUS;
    public static final String K_RELIGION_PROF = H_SKILLS + L_RELIGION_PROF;
    public static final String K_RELIGION_BONUS = H_SKILLS + L_RELIGION_BONUS;
    public static final String K_ANIMAL_PROF = H_SKILLS + L_ANIMAL_PROF;
    public static final String K_ANIMAL_BONUS = H_SKILLS + L_ANIMAL_BONUS;
    public static final String K_INSIGHT_PROF = H_SKILLS + L_INSIGHT_PROF;
    public static final String K_INSIGHT_BONUS = H_SKILLS + L_INSIGHT_BONUS;
    public static final String K_MEDICINE_PROF = H_SKILLS + L_MEDICINE_PROF;
    public static final String K_MEDICINE_BONUS = H_SKILLS + L_MEDICINE_BONUS;
    public static final String K_PERCEPTION_PROF = H_SKILLS + L_PERCEPTION_PROF;
    public static final String K_PERCEPTION_BONUS = H_SKILLS + L_PERCEPTION_BONUS;
    public static final String K_SURVIVAL_PROF = H_SKILLS + L_SURVIVAL_PROF;
    public static final String K_SURVIVAL_BONUS = H_SKILLS + L_SURVIVAL_BONUS;
    public static final String K_DECEPTION_PROF = H_SKILLS + L_DECEPTION_PROF;
    public static final String K_DECEPTION_BONUS = H_SKILLS + L_DECEPTION_BONUS;
    public static final String K_INTIMIDATION_PROF = H_SKILLS + L_INTIMIDATION_PROF;
    public static final String K_INTIMIDATION_BONUS = H_SKILLS + L_INTIMIDATION_BONUS;
    public static final String K_PERFORMANCE_PROF = H_SKILLS + L_PERFORMANCE_PROF;
    public static final String K_PERFORMANCE_BONUS = H_SKILLS + L_PERFORMANCE_BONUS;
    public static final String K_PERSUASION_PROF = H_SKILLS + L_PERSUASION_PROF;
    public static final String K_PERSUASION_BONUS = H_SKILLS + L_PERSUASION_BONUS;
    public static final String K_EQUIPMENT_PROFICIENCES = H_SKILLS + L_EQUIPMENT_PROFICIENCES;
    public static final String K_IMAGE = H_IMAGE + L_BASE;

    
    //Feats Low Keys
    public static final String L_FEATURES_DESCRIPTION = "FeaturesDescription";
    
    //Feats Keys
    public static final String K_FEATURES_DESCRIPTION = H_FEATURE + L_FEATURES_DESCRIPTION;
    private static String L_PROFICIENCY_BONUS = "proficiencyBonus";
    public static String K_PROFICIENCY_BONUS = H_SKILLS + L_PROFICIENCY_BONUS;

    
    //Inventory Keys
    public static String generateCoordinates(int row, int col){
        return "(".concat(Integer.toString(row)).concat(",")
                .concat(Integer.toString(col)).concat(")");
    }
    
    public static String generateInventoryKey(int row, int col){
        return H_INVENTORY + generateCoordinates(row, col);
    }
    
    public static String generateSpellbookKey(int row, int col){
        return H_SPELLBOOK + generateCoordinates(row, col);
    }
    
    
    

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
