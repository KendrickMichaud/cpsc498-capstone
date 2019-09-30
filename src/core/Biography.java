package core;

import java.util.HashMap;
import java.util.List;

/**
 * Biography class is all data involving fluff but also includes the Background class
 * Background is something like Acolyte which has additional features that can affect the game.
 */
public class Biography {

    private HashMap<String, String> data;
    String characterName;
    String deity;
    String alignment;
    String hairColor;
    String eyeColor;
    String height;
    String weight;

    public Biography(){
        data = new HashMap<>();
        initData();
    }

    private void initData() {
    }

    public String get(String key){
        return data.get(key);
    }

    public void update(String key, String value) {
        data.remove(key);
        data.put(key, value);
    }
}
