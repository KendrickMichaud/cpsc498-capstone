/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package templates;

import java.util.ArrayList;
import util.Bundle;

/**
 *
 * @author Kendrick-Laptop
 */
public class PlayerRace {
    public final String name;
    public final Bundle attributes;
    public final String size;
    public final Bundle languages;
    public final ArrayList<Feature> features;
    public final String flavorText;
    private String imagePath;
    
    public PlayerRace(String name, Bundle a, String size, Bundle l, ArrayList<Feature> features, String flavorText){
        this.name = name;
        this.attributes = a;
        this.size = size;
        this.languages = l;
        this.features = features;
        this.flavorText = flavorText;
    }

    public void initImagePath(String image) {
        if(image != null && imagePath == null)
            imagePath = image;
    }
    
    public String imagePath(){
        return imagePath;
    }
    
    public boolean hasImagePath(){
        return (imagePath != null);
    }
}
