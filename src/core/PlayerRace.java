package core;

import util.KeyValueReader;

import java.util.ArrayList;
import java.util.List;

public class PlayerRace implements KeyValueReader<String, String> {

    List<RacialFeature> features;
    public PlayerRace(){
        features = new ArrayList<>();
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
