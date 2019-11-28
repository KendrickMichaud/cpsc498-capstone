/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import templates.PlayerClass;
import templates.PlayerRace;

/**
 *
 * @author Kendrick
 */
public class PowerRating {
    
    private Martial martialScores;
    private Magic magicScores;
    private Playstyle playstyleScores;
    private final boolean initialized;
    public static final String OFFENSIVE = "offense";
    public static final String DEFENSIVE = "defense";
    public static final String UTILITY = "utility";
    public static final String MELEE = "melee";
    public static final String RANGED = "ranged";
    
    private PowerRating(){
        martialScores = new Martial();
        magicScores = new Magic();
        playstyleScores = new Playstyle();
        initialized = false;
    }
    
    private PowerRating(Power cp, RacePower rp){
        martialScores = new Martial();
        magicScores = new Magic();
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
        Magic cMagic = cp.getMagic();
        Magic rMagic = rp.getMagic();
        String casterType = cp.getCaster();
        int casterBonus = 0;
        if(rp.attributes().getInteger(casterType) > 0){
            casterBonus = Score.MAX_SCORE/10;
        }
        
        int off, def, util;
        off = cMagic.offensive.get() + rMagic.offensive.get() + casterBonus;
        def = cMagic.defensive.get() + rMagic.defensive.get() + casterBonus;
        util = cMagic.utility.get() + rMagic.utility.get() + casterBonus;
        
        magicScores = new Magic();
        magicScores.set(off,def,util);
        return true;
    }

    private boolean calculateMartial(Power cp, RacePower rp) {
        Martial mart = cp.getMartial();
        return true;
    }

    private boolean calculatePlaystyle(Power cp, RacePower rp) {
        Playstyle p = cp.getPlaystyle();
        return true;
    }

    public Magic magic() {
        return magicScores;
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
    
    public static class Martial{
        Score offensive;
        Score defensive;
        Score utility;
        
        public Martial(){
            offensive = new Score();
            defensive = new Score();
            utility = new Score();
        }
    }
    
    public static class Magic{
        Score offensive;
        Score defensive;
        Score utility;
        
        public Magic(){
            offensive = new Score();
            defensive = new Score();
            utility = new Score();
        }

        private void set(int off, int def, int util) {
            offensive.set(off);
            defensive.set(def);
            utility.set(util);
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
    }
    
    public static class Playstyle{
        Score ranged;
        Score melee;
        
        public Playstyle(){
            ranged = new Score();
            melee = new Score();
        }
    }
    
}
