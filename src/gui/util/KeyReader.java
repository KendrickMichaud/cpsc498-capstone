package gui.util;

import gui.util.KEY;

public class KeyReader {
    
    //High keys are the highest keys in the hiearchy. In UML speak,
    //these would be considered "objects"
    public static String getHighKey(String key){
        if(key == null)
            return KEY.NULL;

        int index = key.indexOf(KEY.DELIM);
        if(index == -1)
            return KEY.NULL;
        return key.substring(0, index+1);
    }

    //Low keys (not loki :| ...) are attributes of the high key. In UML
    //it's the same thing. 
    public static String getLowKey(String key) {
        if(key == null)
            return KEY.NULL;

        int index = key.indexOf(KEY.DELIM);
        if(index == -1)
            return KEY.NULL;
        String low_key = key.substring(index+1,key.length());
        index = low_key.indexOf(KEY.DELIM);
        if(index == -1){
            return low_key;
        }
        else{
            return low_key.substring(0, index);
        }
    }
    
    /**
     * Returns the index of the key if it is part of a group of items.
     * @param key Must have proper delimiter 'ф' for the number.
     * @return Number (0,1,2,3,4,5...n) of the index if it has one. -1 otherwise
     */
    public static int getIndex(String key){
        int delimLoc = key.indexOf(KEY.I_DELIM);
        if(delimLoc > 0){
            String substr = key.substring(delimLoc + 1);
            int num;
            try{
                num = Integer.parseInt(substr);
            }
            catch (NumberFormatException e){
                num = -1;
            }
            return num;
        }
        return -1;
    }
}
