package core;

import util.KeyValueReader;

public class PlayerClass implements KeyValueReader<String, String> {
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
