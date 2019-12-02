/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package templates;

import gui.character_builder.DESCRIPTION;
import templates.PlayerClass;
import templates.PlayerRace;

/**
 *
 * @author Kendrick
 */
public class PowerRating {
    
    private PowerStat martialScores;
    private PowerStat magicScores;
    private Playstyle playstyleScores;
    private final boolean initialized;
    public static final String OFFENSIVE = "offense";
    public static final String DEFENSIVE = "defense";
    public static final String UTILITY = "utility";
    public static final String MELEE = "melee";
    public static final String RANGED = "ranged";
    
    private PowerRating(){
        martialScores = new PowerStat();
        magicScores = new PowerStat();
        playstyleScores = new Playstyle();
        initialized = false;
    }
    
    private PowerRating(Power cp, RacePower rp){
        martialScores = new PowerStat();
        magicScores = new PowerStat();
        playstyleScores = new Playstyle();
        initialized = calculate(cp, rp);
    }

    public static PowerRating analyze(Power cp, RacePower rp) {
        if(cp == null || rp == null){
            return new PowerRating();
        }
        else{
            return new PowerRating(cp, rp);
        }
        
    }

    private boolean calculate(Power cp, RacePower rp) {
        boolean condition = true;
        condition = condition && calculateMagic(cp, rp);
        condition = condition && calculateMartial(cp, rp);
        condition = condition && calculatePlaystyle(cp, rp);
        return condition;
    }

    private boolean calculateMagic(Power cp, RacePower rp) {
        PowerStat cMagic = cp.getMagic();
        PowerStat rMagic = rp.getMagic();
        String casterType = cp.getCaster();
        int casterBonus = 0;
        if(rp.attributes().getInteger(casterType) > 0){
            casterBonus = Score.MAX_SCORE/10;
        }
        
        int off, def, util;
        off = cMagic.offensive.get() + rMagic.offensive.get() + casterBonus;
        def = cMagic.defensive.get() + rMagic.defensive.get() + casterBonus;
        util = cMagic.utility.get() + rMagic.utility.get() + casterBonus;
        
        magicScores = new PowerStat();
        magicScores.set(off,def,util);
        return true;
    }

    private boolean calculateMartial(Power cp, RacePower rp) {
        PowerStat classMartial = cp.martial;
        PowerStat raceMartial = rp.martial;
        int off, def, util;
        off = classMartial.offensive.get() + raceMartial.offensive.get();
        def = classMartial.defensive.get() + raceMartial.defensive.get();
        util = classMartial.utility.get() + raceMartial.utility.get();
        martialScores = new PowerStat();
        martialScores.set(off, def, util);
        return true;
    }

    private boolean calculatePlaystyle(Power cp, RacePower rp) {
        Playstyle classPlaystyle = cp.playstyle;
        Playstyle racePlaystyle = rp.playstyle;
        
        int melee, ranged;
        melee = classPlaystyle.melee() + racePlaystyle.melee();
        ranged = classPlaystyle.ranged() + racePlaystyle.ranged();
        playstyleScores = new Playstyle();
        playstyleScores.set(melee, ranged);
        return true;
    }

    public PowerStat magic() {
        return magicScores;
    }
    
    public PowerStat martial(){
        return martialScores;
    }
    
    public Playstyle playstyle(){
        return playstyleScores;
    }
    
    public static class Score{
        public static final int MAX_SCORE = 10;
        public static final int MIN_SCORE = 0;
        
        private int score;

        private Score() {
        }
        public Score calculateScore(int value){
            return new Score(value);
        }
        
        private Score(int value){
            this.score = value;
        }

        void set(int value) {
            this.score = value;
        }
        
        int get(){
            return score;
        }
    }
    
    public static class PowerStat{
        Score offensive;
        Score defensive;
        Score utility;
        
        public PowerStat(){
            offensive = new Score();
            defensive = new Score();
            utility = new Score();
        }
        public int offensive() {
            return offensive.get();
        }

        public int defensive() {
            return defensive.get();
        }

        public int utility() {
            return utility.get();
        }
        
        public void set(int off, int def, int util){
            offensive.set(off);
            defensive.set(def);
            utility.set(util);
        }
    }
    
    public static class Playstyle{
        Score ranged;
        Score melee;
        
        public Playstyle(){
            ranged = new Score();
            melee = new Score();
        }

        public int ranged() {
            return ranged.get();
        }

        public int melee() {
            return melee.get();
        }

        private void set(int mel, int ran) {
            melee.set(mel);
            ranged.set(ran);
        }
    }
    
    public String getDescription(){
        StringBuilder output = new StringBuilder();
        if(playstyleScores != null){
            int melee = playstyleScores.melee();
            int ranged = playstyleScores.ranged();
            
            if(melee > ranged){
                output.append(DESCRIPTION.MELEE);
            }
            else if(melee < ranged){
                output.append(DESCRIPTION.RANGED);
            }
            else{
                output.append(DESCRIPTION.PLAYSTYLE_BOTH);
            }
        }
        if(martialScores != null && magicScores != null){
            int martTotal = martialScores.offensive() + martialScores.defensive() + martialScores.utility();
            int magiTotal = magicScores.offensive() + magicScores.defensive() + magicScores.utility();
            
            String ap = martTotal>magiTotal?DESCRIPTION.MARTIAL:DESCRIPTION.MAGIC;
            output.append(ap);
            
            int martOff = martialScores.offensive();
            int magiOff = magicScores.offensive();
            
            if(martOff + magiOff > 7){
                output.append(DESCRIPTION.OFFENSIVE);
            }
            else{
                output.append(DESCRIPTION.NON_OFFENSIVE);
            }
            
            if(martialScores.defensive() + magicScores.defensive() > 7){
                output.append(DESCRIPTION.DEFENSIVE);
            }
            else{
                output.append(DESCRIPTION.NON_DEFENSIVE);
            }
            
            if(martialScores.utility() + magicScores.utility() > 7){
                output.append(DESCRIPTION.UTILITY);
            }
            else{
                output.append(DESCRIPTION.NON_UTILITY);
            }
        }
        
        return output.toString();
    }
    
}
