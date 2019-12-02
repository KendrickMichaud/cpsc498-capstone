/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import gui.util.KEY;
import gui.util.KeyReader;

/**
 *
 * @author Kendrick
 */
public class DataIntegrity {

    public static final int DEFAULT_TEN = 10;
    public static String DEFAULT_ZERO_STR = "0";

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
            return DEFAULT_TEN;
        }
    }

    public static boolean isNumeric(String value) {
        try{
            if(value.equals("")){
                return false;
            }
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
            return Integer.toString(DEFAULT_TEN);
        }
        else
            return "0";
    }


}
