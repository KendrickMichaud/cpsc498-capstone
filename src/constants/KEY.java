package constants;

public class KEY {

    //High_Keys for PlayerCharacter to Handle
    public static final String BIOGRAPHICAL_DATA = "biographicalData*";
    public static final String BACKGROUND = "background*";
    public static final String PLAYER_CLASS = "playerClass*";
    public static final String PLAYER_RACE = "playerRace*";
    public static final String ATTRIBUTES = "attributes*";
    public static final String INVENTORY = "inventory*";
    public static final String SPELLBOOK = "spellbook*";
    public static final String EQUIPPED_WEAPON = "equippedWeapon*";
    public static final String EQUIPPED_ARMOR = "equippedArmor*";


    //Biographical Data low_keys
    public static final String CHARACTER_NAME = BIOGRAPHICAL_DATA + "characterName";
    public static final String DEITY = BIOGRAPHICAL_DATA + "deity";
    public static final String ALIGNMENT = BIOGRAPHICAL_DATA +"alignment";
    public static final String SIZE = BIOGRAPHICAL_DATA +"size";
    public static final String HEIGHT = BIOGRAPHICAL_DATA +"height";
    public static final String WEIGHT = BIOGRAPHICAL_DATA +"weight";

    //Background low_keys
    public static final String BACKGROUND_TITLE = BACKGROUND + "title";
    public static final String PERSONALITY_TRAIT = BACKGROUND + "trait";
    public static final String PERSONALITY_IDEAL = BACKGROUND + "ideal";
    public static final String PERSONALITY_BOND = BACKGROUND + "bond";
    public static final String PERSONALITY_FLAW = BACKGROUND + "flaw";
    public static final String NULL = "IsNull";

    //PlayerRace low_keys
    public static final String RACE_NAME = PLAYER_RACE + "name";

    //PlayerClass low_keys
    public static final String CLASS_NAME = PLAYER_CLASS + "name";

    //Attributes low_keys
    public static final String STRENGTH = ATTRIBUTES + "Strength";
    public static final String DEXTERITY = ATTRIBUTES + "Dexterity";
    public static final String CONSTITUTION = ATTRIBUTES + "Constitution";
    public static final String INTELLIGENCE = ATTRIBUTES + "Intelligence";
    public static final String WISDOM = ATTRIBUTES + "Wisdom";
    public static final String CHARISMA = ATTRIBUTES + "Charisma";

    //Inventory low_keys
    //Inventory is a different way of handling keys because items have an index
    //This requires the usage of the [-optional_key] to derive extra information
    //Updating the description in row 3 of an item would then be
    //Key: "inventory*rowInde x(3)*item_desc"
    public static final String ITEM_NAME = "*item_name";
    public static final String ITEM_DESC = "*item_desc";
    public static final String EQUIPPED = "*equipped";
    public static int invRow = 0;
    /**
     *  Returns a high_key INVENTORY with a low_key that represents the element
     *  add an optional_key (see above) to describe what specific changes have
     *  to be made.
     */
    public static String generateInventoryRow(){
        invRow++;
        return INVENTORY+"rowIndex("+0+")";
    }

    //Inventory low_keys
    //Inventory is a different way of handling keys because items have an index
    //This requires the usage of the [-optional_key] to derive extra information
    //Updating the description in row 3 of an item would then be
    //Key: "inventory*rowInde x(3)*item_desc"
    public static final String SPELL_NAME = "*spell_name";
    public static final String SPELL_DESC = "*spell_desc";
    public static final String SPELL_LEVEL = "*spell_level";
    public static int spellbookRow = 0;
    /**
     *  Returns an autoIncremented id to place for a inventory item.
     */
    public static String generateSpellbookRow(){
        invRow++;
        return INVENTORY+"rowIndex("+0+")";
    }


    public static final String EQUIPPED_WEAPON_NAME = EQUIPPED_WEAPON + "name";
    public static final String EQUIPPED_WEAPON_DESC = EQUIPPED_WEAPON + "desc";




}
