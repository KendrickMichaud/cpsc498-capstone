package core.test;

import core.Equipment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EquipmentTest {

    @Test
    public void EquipmentConstructorHasTwoConstructors(){
        String parseable = "parseable";
        String title = "title";
        String description = "Description";
        new Equipment(parseable);
        new Equipment(title, description);
        assert(true);
    }

    @Test
    public void EquipmentThrowsNullForNullInputs(){
        Equipment equipment = new Equipment("Title", "Description");
        Assertions.assertThrows(NullPointerException.class, () -> new Equipment(null));
        Assertions.assertThrows(NullPointerException.class, () -> new Equipment("Title", null));
        Assertions.assertThrows(NullPointerException.class, () -> new Equipment(null, "Description"));
        Assertions.assertThrows(NullPointerException.class, () -> equipment.setTitle(null));
        Assertions.assertThrows(NullPointerException.class, () -> equipment.setDesc(null));
        Assertions.assertThrows(NullPointerException.class, () -> equipment.setTitleAndDescription(null));
    }

    @Test
    public void EquipmentHasGettersAndSetters(){
        String expectedTitle = "Title";
        String expectedDescription = "Description";

        Equipment equipment = new Equipment(expectedTitle, expectedDescription);
        assertEquals(expectedTitle, equipment.getTitle());
        assertEquals(expectedDescription, equipment.getDesc());

        expectedDescription = "New Description";
        expectedTitle = "New Title";

        equipment.setTitle(expectedTitle);
        equipment.setDesc(expectedDescription);

        assertEquals(expectedTitle, equipment.getTitle());
        assertEquals(expectedDescription, equipment.getDesc());
    }

    @Test
    public void parseStringFunctionsAppropriately(){
        Equipment equipment;
        String parse = "Holy Longsword +2";
        equipment = new Equipment(parse);
        String secondParse = "Holy Longsword +2;A sophisticated weapon, for a more civilized age.";
        assertEquals(parse, equipment.getTitle());
        equipment = new Equipment(secondParse);
        String expectedTitle = "Holy Longsword +2";
        String expectedDesc = "A sophisticated weapon, for a more civilized age.";
        assertEquals(expectedTitle, equipment.getTitle());
        assertEquals(expectedDesc, equipment.getDesc());
    }




}