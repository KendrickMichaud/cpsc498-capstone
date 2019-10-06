package util;

import constants.KEY;

public class KeyReader {
    public static String getHighKey(String key){
        if(key == null)
            return KEY.NULL;
        return "";
    }

    public static String getOptionalKey(String key) {
        return "";
    }

    public static int getRowIndex(String key) {
        return 0;
    }

    public static String getLowKey(String key) {
        return "";
    }
}
