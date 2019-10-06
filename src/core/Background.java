package core;

import util.KeyValueReader;

//Background class contains all details necessary for the character to function properly
//Everything is strings but the additionalFeatures class is a list that contains features such
//as Skill Proficiencies, Languages, Equipment, or other pertinent data that is not fluff.
public class Background implements KeyValueReader<String, String> {
    String title;
    String personalityTrait;
    String ideal;
    String bond;
    String flaw;

    @Override
    public String getValue(String key) {

        return key;
    }

    @Override
    public void updateValue(String key, String value) {

    }

    @Override
    public void clearContents() {

    }

    @Override
    public boolean hasContents() {
        return false;
    }
}