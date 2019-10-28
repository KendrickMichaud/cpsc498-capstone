/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.HashMap;

/**
 *
 * @author Kendrick
 */
public class Bundle extends HashMap<String, Object>{
    public void putString(String key, String value){
        if(key != null && value != null)
            put(key, value);
    }
    
    public void putInteger(String key, int value){
        if(key != null)
            put(key, value);
    }
    
    public String getString(String key){
        Object potentialString = get(key);
        if(potentialString instanceof String)
            return (String) potentialString;
        else
           throw new IllegalArgumentException("Calling for a type that is not a String"); 
    }
    
    public Integer getInteger(String key){
        Object potentialInteger = get(key);
        if(potentialInteger instanceof Integer)
            return (Integer) potentialInteger;
        else
           throw new IllegalArgumentException("Calling for a type that is not a Integer"); 
    }

    public void putBoolean(String key, Boolean value) {
        if(key != null){
            put(key, value);
        }
    }

    public boolean getBoolean(String key) {
        Object potentialBoolean = get(key);
        if(potentialBoolean instanceof Boolean)
            return (Boolean) potentialBoolean;
        else
           throw new IllegalArgumentException("Calling for a type that is not a Boolean"); 
    }
    
    
}
