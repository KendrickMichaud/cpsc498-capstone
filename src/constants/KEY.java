package constants;

//TODO: Need to refactor HighKeys to have a H_ infront of name.
//TODO: Need to add Low Keys
//TODO: Need to combine High and Low keys in terms of refactor
public class KEY {

    //High_Keys for PlayerCharacter to Handle
    public static final String H_BIOGRAPHICAL_DATA = "biographicalData*";
    public static final String H_BACKGROUND = "background*";
    public static final String H_PLAYER_CLASS = "playerClass*";
    public static final String H_PLAYER_RACE = "playerRace*";
    public static final String H_ATTRIBUTES = "attributes*";
    public static final String H_INVENTORY = "inventory*";
    public static final String H_SPELLBOOK = "spellbook*";
    public static final String H_WEAPON = "equippedWeapon*";
    public static final String H_ARMOR = "equippedArmor*";

    //Low Keys
    public static final String L_CHARACTER_NAME = "characterName";
    public static final String L_DEITY = "deity";
    public static final String L_WEIGHT = "weight";
    public static final String L_ALIGNMENT = "alignment";
    public static final String L_SIZE = "size";
    public static final String L_HEIGHT = "height";

    //Biographical Data Keys
    public static final String K_CHARACTER_NAME = H_BIOGRAPHICAL_DATA + L_CHARACTER_NAME;
    public static final String K_DEITY = H_BIOGRAPHICAL_DATA + L_DEITY;
    public static final String K_ALIGNMENT = H_BIOGRAPHICAL_DATA + L_ALIGNMENT;
    public static final String K_SIZE = H_BIOGRAPHICAL_DATA + L_SIZE;
    public static final String K_HEIGHT = H_BIOGRAPHICAL_DATA + L_HEIGHT;
    public static final String K_WEIGHT = H_BIOGRAPHICAL_DATA + L_WEIGHT;

    public static final String L_TITLE = "title";
    public static final String L_TRAIT = "trait";
    public static final String L_IDEAL = "ideal";
    public static final String L_BOND = "bond";
    public static final String L_FLAW = "flaw";

    //Background low_keys
    public static final String K_BACKGROUND_TITLE = H_BACKGROUND + L_TITLE;
    public static final String K_BACKGROUND_TRAIT = H_BACKGROUND + L_TRAIT;
    public static final String K_BACKGROUND_IDEAL = H_BACKGROUND + L_IDEAL;
    public static final String K_BACKGROUND_BOND = H_BACKGROUND + L_BOND;
    public static final String K_BACKGROUND_FLAW = H_BACKGROUND + L_FLAW;
    public static final String NULL = "IsNull";

    public static final String L_NAME = "name";
    //PlayerRace low_keys
    public static final String K_RACE_NAME = H_PLAYER_RACE + L_NAME;

    //PlayerClass low_keys
    public static final String K_CLASS_NAME = H_PLAYER_CLASS + L_NAME;

    public static final String L_STRENGTH = "Strength";
    public static final String L_DEXTERITY = "Dexterity";
    public static final String L_CONSTITUION = "Constitution";
    public static final String L_INTELLIGENCE = "Intelligence";
    public static final String L_WISDOM = "Wisdom";
    public static final String L_CHARISMA = "Charisma";

    //Attributes low_keys
    public static final String K_STRENGTH = H_ATTRIBUTES + L_STRENGTH;
    public static final String K_DEXTERITY = H_ATTRIBUTES + L_DEXTERITY;
    public static final String K_CONSTITUTION = H_ATTRIBUTES + L_CONSTITUION;
    public static final String K_INTELLIGENCE = H_ATTRIBUTES + L_INTELLIGENCE;
    public static final String K_WISDOM = H_ATTRIBUTES + L_WISDOM;
    public static final String K_CHARISMA = H_ATTRIBUTES + L_CHARISMA;

    public static final String EQUIPPED = "is_equipped";
    public static final String NOT_EQUIPPED = "not_equipped";
    public static final String SET_TO_UNEQUIP = "setToUnequip";
    public static final String UNEQUIPPED = "unequipped";
    public static final String SET_TO_EQUIPPED = "setToEquip";

    public static final String L_DESCRIPTION = "desc";
    public static final String L_AC = "ac";
    public static final String L_DEX_BONUS = "dexBonus";
    public static final String L_EQUIP_STATE = "isEquipped?";

    public static final String K_ARMOR_NAME = H_ARMOR + L_NAME;
    public static final String K_ARMOR_DESCRIPTION = H_ARMOR + L_DESCRIPTION;
    public static final String K_ARMOR_AC = H_ARMOR + L_AC;
    public static final String K_ARMOR_DEX_BONUS = H_ARMOR + L_DEX_BONUS;
    public static final String K_ARMOR_EQUIP_STATE = H_ARMOR + L_EQUIP_STATE;

    public static final String L_ATTK_BONUS = "attkBonus";
    public static final String L_DMG_ROLL = "dmgRoll";
    public static final String L_DMG_BONUS = "dmgBonus";

    public static final String K_WEAPON_ATTK_BONUS = H_WEAPON + L_ATTK_BONUS;
    public static final String K_WEAPON_DMG_ROLL = H_WEAPON + L_DMG_ROLL;
    public static final String K_WEAPON_DMG_BONUS = H_WEAPON + L_DMG_BONUS;
    public static final String K_WEAPON_EQUIP_STATE = H_WEAPON + L_EQUIP_STATE;
    public static final String K_WEAPON_NAME = H_WEAPON + L_NAME;
    public static final String K_WEAPON_DESCRIPTION = H_WEAPON + L_DESCRIPTION;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Inventory low_keys
    //Inventory is a different way of handling keys because items have an index
    //This requires the usage of the [-optional_key] to derive extra information
    //Updating the description in row 3 of an item would then be
    //Key: "inventory*rowInde x(3)*item_desc"
    public static final String ITEM_NAME = "*item_name";
    public static final String ITEM_DESC = "*item_desc";

    public static int invRow = 0;
    /**
     *  Returns a high_key H_INVENTORY with a low_key that represents the element
     *  add an optional_key (see above) to describe what specific changes have
     *  to be made.
     */
    public static String generateInventoryRow(){
        invRow++;
        return H_INVENTORY +"rowIndex("+0+")";
    }

    //Inventory low_keys
    //Inventory is a different way of handling keys because items have an index
    //This requires the usage of the [-optional_key] to derive extra information
    //Updating the description in row 3 of an item would then be
    //Key: "inventory*rowInde x(3)*item_desc"
    public static final String SPELL_NAME = "*spell_name";
    public static final String SPELL_DESC = "*spell_desc";
    public static final String SPELL_LEVEL = "*spell_level";


    //Features are very much different from all the other ones as there are several Feature types.


}
