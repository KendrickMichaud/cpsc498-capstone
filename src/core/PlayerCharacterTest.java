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
        character.updateValue(KEY.K_WEAPON_NAME, expectedName);
        character.updateValue(KEY.K_WEAPON_DESCRIPTION, expectedDescription);

        assertEquals(expectedName, character.getValue(KEY.K_WEAPON_NAME));
        assertEquals(expectedDescription, character.getValue(KEY.K_WEAPON_DESCRIPTION));
    }

    @Test
    void updateSpellbook(){

    }

    @Test
    void updateInventoryItems(){
        String expectedItemName = "Ring of Protection +1";
        String expectedItemDesc = "Increases your AC by +1";
        String itemIndex = KEY.H_INVENTORY + "rowIndex(0)";
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
        character.updateValue(KEY.K_STRENGTH, expectedStrength);
        character.updateValue(KEY.K_DEXTERITY, expectedDexterity);
        character.updateValue(KEY.K_CONSTITUTION, expectedConstitution);
        character.updateValue(KEY.K_WISDOM, expectedWisdom);
        character.updateValue(KEY.K_INTELLIGENCE, expectedIntelligence);
        character.updateValue(KEY.K_CHARISMA, expectedCharisma);
        assertEquals(expectedStrength, character.getValue(KEY.K_STRENGTH));
        assertEquals(expectedDexterity, character.getValue(KEY.K_DEXTERITY));
        assertEquals(expectedConstitution, character.getValue(KEY.K_CONSTITUTION));
        assertEquals(expectedIntelligence, character.getValue(KEY.K_INTELLIGENCE));
        assertEquals(expectedWisdom, character.getValue(KEY.K_WISDOM));
        assertEquals(expectedCharisma, character.getValue(KEY.K_CHARISMA));
    }

    @Test
    void updatePlayerRace(){
        String expectedRaceName = "Elf";
        String expectedFeatureName = "Darkvision";
        String expectedFeatureDescription = "See when its dark";

        character.updateValue(KEY.K_RACE_NAME, expectedRaceName);
        assertEquals(expectedRaceName, character.getValue(KEY.K_RACE_NAME));
        //TODO: Handle features
    }

    @Test
    void updatePlayerClass(){
        String expectedClassName = "Paladin";
        String expectedFeatureName = "Lay on Hands";
        String expectedFeatureDescription = "Heals when you touch";
        String expectedFeatureLevel = "1";

        character.updateValue(KEY.K_CLASS_NAME, expectedClassName);
        assertEquals(expectedClassName, character.getValue(KEY.K_CLASS_NAME));
        //TODO: Handle features
    }

    @Test
    void updateBackgroundData(){
        String expectedBackgroundTitle = "Criminal";
        String expectedPersonalityTrait = "Edgy trait with a description";
        String expectedPersonalityIdeal = "Honor among thieves";
        String expectedPersonalityBond = "Loves to steal";
        String expectedPersonalityFlaw = "Gets caught however";

        character.updateValue(KEY.K_BACKGROUND_TITLE, expectedBackgroundTitle);
        character.updateValue(KEY.K_BACKGROUND_TRAIT, expectedPersonalityTrait);
        character.updateValue(KEY.K_BACKGROUND_IDEAL, expectedPersonalityIdeal);
        character.updateValue(KEY.K_BACKGROUND_BOND, expectedPersonalityBond);
        character.updateValue(KEY.K_BACKGROUND_FLAW, expectedPersonalityFlaw);

        assertEquals(expectedBackgroundTitle, character.getValue(KEY.K_BACKGROUND_TITLE));
        assertEquals(expectedPersonalityBond, character.getValue(KEY.K_BACKGROUND_BOND));
        assertEquals(expectedPersonalityFlaw, character.getValue(KEY.K_BACKGROUND_FLAW));
        assertEquals(expectedPersonalityIdeal, character.getValue(KEY.K_BACKGROUND_IDEAL));
        assertEquals(expectedPersonalityTrait, character.getValue(KEY.K_BACKGROUND_TRAIT));
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
        character.updateValue(KEY.K_CHARACTER_NAME, expectedName);
        character.updateValue(KEY.K_ALIGNMENT, expectedAlignment);
        character.updateValue(KEY.K_HEIGHT, expectedHeight);
        character.updateValue(KEY.K_WEIGHT, expectedWeight);
        character.updateValue(KEY.K_SIZE, expectedSize);
        character.updateValue(KEY.K_DEITY, expetctedDeity);
        assertEquals(expectedName, character.getValue(KEY.K_CHARACTER_NAME));
        assertEquals(expectedAlignment, character.getValue(KEY.K_ALIGNMENT));
        assertEquals(expectedHeight, character.getValue(KEY.K_HEIGHT));
        assertEquals(expectedWeight, character.getValue(KEY.K_WEIGHT));
        assertEquals(expectedSize, character.getValue(KEY.K_SIZE));
        assertEquals(expetctedDeity, character.getValue(KEY.K_DEITY));
    }

    @Test
    void clearContents() {
    }
}