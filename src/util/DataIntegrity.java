/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

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
        text = removePlusesAndMinuses(text);
        try{
            int i = Integer.parseInt(text);
            return i;
        }
        catch (NumberFormatException e){
            return DEFAULT_INTEGER;
        }
    }
    

    private static String removePlusesAndMinuses(String text) {
        return ""; //TODO;
    }


}
