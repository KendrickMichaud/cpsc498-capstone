/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package templates;

import java.util.ArrayList;

/**
 *
 * @author Kendrick-Laptop
 * @param <T>
 */
public abstract class Templates<T> extends ArrayList<T>{
    public enum TYPE{T_BACKGROUND, T_CLASS, T_RACE}
    
    public static final String FILE_RACE = "/templates/races.xml";
    public static final String FILE_CLASS = "/templates/classes.xml";
    public static final String FILE_BACKGROUND = "/templates/backgrounds.xml";
    
}
