package core;

import constants.KEY;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerCharacterTest {

    PlayerCharacter character;

    @BeforeEach
    void setUpTest(){
        character = new PlayerCharacter();
    }

    @Test
    void getValue() {

    }

    @Test
    public void updateEquippedArmor(){

    }

    @Test
    public void updateEquippedWeapon(){
        String expectedName = "Shortsword";
        String expectedDescription = "A valiant guard's weapon of choice!";
        character.updateValue(KEY.EQUIPPED_WEAPON_NAME, expectedName);
        character.updateValue(KEY.EQUIPPED_WEAPON_DESC, expectedDescription);

        assertEquals(expectedName, character.getValue(KEY.EQUIPPED_WEAPON_NAME));
        assertEquals(expectedDescription, character.getValue(KEY.EQUIPPED_WEAPON_DESC));
    }

    @Test
    void updateSpellbook(){

    }

    @Test
    void updateInventoryItems(){
        String expectedItemName = "Ring of Protection +1";
        String expectedItemDesc = "Increases your AC by +1";
        String itemIndex = KEY.INVENTORY + "rowIndex(0)";
        character.updateValue((itemIndex+KEY.ITEM_NAME), expectedItemName);
        character.updateValue((itemIndex+KEY.ITEM_DESC), expectedItemDesc);

        assertEquals(expectedItemName, character.getValue(itemIndex+KEY.ITEM_NAME));
        assertEquals(expectedItemDesc, character.getValue(itemIndex+KEY.ITEM_DESC));
    }

    @Test
    void updateAttributes(){
        String expectedStrength = "7";
        String expectedDexterity = "15";
        String expectedConstitution = "14";
        String expectedWisdom = "13";
        String expectedIntelligence = "12";
        String expectedCharisma = "11";
        character.updateValue(KEY.STRENGTH, expectedStrength);
        character.updateValue(KEY.DEXTERITY, expectedDexterity);
        character.updateValue(KEY.CONSTITUTION, expectedConstitution);
        character.updateValue(KEY.WISDOM, expectedWisdom);
        character.updateValue(KEY.INTELLIGENCE, expectedIntelligence);
        character.updateValue(KEY.CHARISMA, expectedCharisma);
        assertEquals(expectedStrength, character.getValue(KEY.STRENGTH));
        assertEquals(expectedDexterity, character.getValue(KEY.DEXTERITY));
        assertEquals(expectedConstitution, character.getValue(KEY.CONSTITUTION));
        assertEquals(expectedIntelligence, character.getValue(KEY.INTELLIGENCE));
        assertEquals(expectedWisdom, character.getValue(KEY.WISDOM));
        assertEquals(expectedCharisma, character.getValue(KEY.CHARISMA));
    }

    @Test
    void updatePlayerRace(){
        String expectedRaceName = "Elf";
        String expectedFeatureName = "Darkvision";
        String expectedFeatureDescription = "See when its dark";

        character.updateValue(KEY.RACE_NAME, expectedRaceName);
        assertEquals(expectedRaceName, character.getValue(KEY.RACE_NAME));
        //TODO: Handle features
    }

    @Test
    void updatePlayerClass(){
        String expectedClassName = "Paladin";
        String expectedFeatureName = "Lay on Hands";
        String expectedFeatureDescription = "Heals when you touch";
        String expectedFeatureLevel = "1";

        character.updateValue(KEY.CLASS_NAME, expectedClassName);
        assertEquals(expectedClassName, character.getValue(KEY.CLASS_NAME));
        //TODO: Handle features
    }

    @Test
    void updateBackgroundData(){
        String expectedBackgroundTitle = "Criminal";
        String expectedPersonalityTrait = "Edgy trait with a description";
        String expectedPersonalityIdeal = "Honor among thieves";
        String expectedPersonalityBond = "Loves to steal";
        String expectedPersonalityFlaw = "Gets caught however";

        character.updateValue(KEY.BACKGROUND_TITLE, expectedBackgroundTitle);
        character.updateValue(KEY.PERSONALITY_TRAIT, expectedPersonalityTrait);
        character.updateValue(KEY.PERSONALITY_IDEAL, expectedPersonalityIdeal);
        character.updateValue(KEY.PERSONALITY_BOND, expectedPersonalityBond);
        character.updateValue(KEY.PERSONALITY_FLAW, expectedPersonalityFlaw);

        assertEquals(expectedBackgroundTitle, character.getValue(KEY.BACKGROUND_TITLE));
        assertEquals(expectedPersonalityBond, character.getValue(KEY.PERSONALITY_BOND));
        assertEquals(expectedPersonalityFlaw, character.getValue(KEY.PERSONALITY_FLAW));
        assertEquals(expectedPersonalityIdeal, character.getValue(KEY.PERSONALITY_IDEAL));
        assertEquals(expectedPersonalityTrait, character.getValue(KEY.PERSONALITY_TRAIT));
    }

    @Test
    void updateBiographicalData() {
        String expectedName, expetctedDeity,
                expectedAlignment, expectedSize,
                expectedHeight, expectedWeight;
        expectedName = "Kendrick";
        expectedAlignment = "Neutral Good";
        expectedHeight = "Tall";
        expectedWeight = "150lbs";
        expectedSize = "Medium";
        expetctedDeity = "Moradin";
        character.updateValue(KEY.CHARACTER_NAME, expectedName);
        character.updateValue(KEY.ALIGNMENT, expectedAlignment);
        character.updateValue(KEY.HEIGHT, expectedHeight);
        character.updateValue(KEY.WEIGHT, expectedWeight);
        character.updateValue(KEY.SIZE, expectedSize);
        character.updateValue(KEY.DEITY, expetctedDeity);
        assertEquals(expectedName, character.getValue(KEY.CHARACTER_NAME));
        assertEquals(expectedAlignment, character.getValue(KEY.ALIGNMENT));
        assertEquals(expectedHeight, character.getValue(KEY.HEIGHT));
        assertEquals(expectedWeight, character.getValue(KEY.WEIGHT));
        assertEquals(expectedSize, character.getValue(KEY.SIZE));
        assertEquals(expetctedDeity, character.getValue(KEY.DEITY));
    }

    @Test
    void clearContents() {
    }
}