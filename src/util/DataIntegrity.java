/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import constants.KEY;

/**
 *
 * @author Kendrick
 */
public class DataIntegrity {

    public static final int DEFAULT_INTEGER = 10;

    /**
     * Returns an int if successfully converted
     *
     * @param text
     * @return integer parsed from text, 10 otherwise
     */
    public static int convertToInt(String text){
        try{
            int i = Integer.parseInt(text);
            return i;
        }
        catch (NumberFormatException e){
            return DEFAULT_INTEGER;
        }
    }

    public static boolean checkNumber(String value) {
        try{
            Integer.parseInt(value);
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }

    public static boolean validAttribute(String value) {
        int num = Integer.parseInt(value);
        return (num > 0) && (num <= 20);
    }

    public static String getDefault(String key) {
        if(KeyReader.getHighKey(key).equals(KEY.H_ATTRIBUTES)){
            return "10";
        }
        else
            return "0";
    }


}
