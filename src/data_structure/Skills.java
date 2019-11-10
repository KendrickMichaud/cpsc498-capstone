/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_structure;

import java.util.ArrayList;

/**
 *
 * @author Kendrick
 */
public class Skills {
    
    private final ArrayList<Skill> skills;
    
    public Skills(){
        skills = new ArrayList<>();
    }

    public void addSkill(Skill skill) {
        skills.add(skill);
    }
    
    public Skill getSkill(int i){
        return skills.get(i);
    }
    
    public int size(){
        return skills.size();
    }
    
}
