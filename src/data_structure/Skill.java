/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_structure;

import gui.util.KEY;

/**
 *
 * @author Kendrick
 */
public class Skill {
    public static final int FULL_PROF = 1;
    public static final int HALF_PROF = 2;
    public static final int NO_PROF = 0;
    public static final String STR_FULL_PROF = "proficient";
    public static final String STR_HALF_PROF = "halfProficient";
    public static final String STR_NO_PROF = "noProficiency";
    public static String NONE = "N/A";

    public final int type;
    public final int bonusAmount;
    

    public Skill(int type, int bonusAmount) {
        this.type = type;
        this.bonusAmount = bonusAmount;
    }
    
    
    
}
