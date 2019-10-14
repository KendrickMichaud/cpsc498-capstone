package util;

import constants.KEY;

public class KeyReader {
    public static String getHighKey(String key){
        if(key == null)
            return KEY.NULL;

        int index = key.indexOf("*");
        if(index == -1)
            return KEY.NULL;
        return key.substring(0, index+1);
    }

    public static String getOptionalKey(String key) {
        return "";
    }

    public static int getRowIndex(String key) {
        return 0;
    }

    public static String getLowKey(String key) {
        if(key == null)
            return KEY.NULL;

        int index = key.indexOf("*");
        if(index == -1)
            return KEY.NULL;
        String low_key = key.substring(0, index);
        index = low_key.indexOf("*");
        if(index == -1){
            return low_key;
        }
        else{
            return low_key.substring(0, index);
        }
    }
    
    public static boolean validKey(String key){
        return true;
    }
}
