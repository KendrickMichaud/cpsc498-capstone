/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_structure;

/**
 *
 * @author Kendrick
 */
public class Skill {
    public static final String PROFICIENT = "proficient";
    public static final String HALF_PROFICIENT = "halfProficient";
    public static final String NO_PROFICIENCY = "noProficiency";
    public final int type;
    public final int bonusAmount;
    

    public Skill(int type, int bonusAmount) {
        this.type = type;
        this.bonusAmount = bonusAmount;
    }
    
    
    
}
