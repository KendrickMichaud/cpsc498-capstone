/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package templates;

import java.util.ArrayList;
import templates.BackgroundTemplates.Background;

/**
 *
 * @author Kendrick-Laptop
 */
public class BackgroundTemplates extends Templates<Background>{

    public static class Background {
        
        public ArrayList<String> getSkills(){
            return skillProfs;
        }
        
        public ArrayList<Feature> getFeatures(){
            return features;
        }

        public void setName(String strName) {
            this.name = strName;
        }

        public ArrayList<String> getStrings(STORY story) {
            switch(story){
                case BOND:return bonds;
                case FLAW:return flaws;
                case IDEAL:return ideals;
                case TRAIT:return traits;
            }
            throw new IllegalArgumentException();
        }

        public String getName() {
            return name;
        }
        
        public enum STORY{TRAIT, IDEAL, BOND, FLAW};
        private ArrayList<String> traits, ideals, bonds, flaws;
        private ArrayList<String> skillProfs;
        private ArrayList<Feature> features; 
        private String name;
        public Background() {
            
        }

        public void addFeatures(ArrayList<Feature> featuresList) {
            features = featuresList;
        }

        public void addSkills(ArrayList<String> skillProficincies) {
            skillProfs = skillProficincies;
        }

        public void addStrings(ArrayList<String> list, STORY story) {
            switch(story){
                case BOND:bonds=list;break;
                case FLAW:flaws=list;break;
                case IDEAL:ideals=list;break;
                case TRAIT:traits=list;break;
            }
        }
    }
}
