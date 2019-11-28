/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package templates;

import java.util.ArrayList;
import util.Bundle;
import util.RacePower;

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
    private RacePower racePower;
    
    public PlayerRace(String name, Bundle a, String size, Bundle l, ArrayList<Feature> features, String flavorText){
        this.name = name;
        this.attributes = a;
        this.size = size;
        this.languages = l;
        this.features = features;
        this.flavorText = flavorText;
    }

    public void setPower(RacePower rp) {
        racePower = rp;
    }

    public RacePower powerLevel() {
        return racePower;
    }
}
