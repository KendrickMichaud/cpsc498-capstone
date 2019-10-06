package core;

import util.KeyValueReader;

/**
 * Biography class is all data involving fluff but also includes the Background class
 * Background is something like Acolyte which has additional features that can affect the game.
 */
public class Biography implements KeyValueReader<String, String> {

    public Biography(){

    }

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
