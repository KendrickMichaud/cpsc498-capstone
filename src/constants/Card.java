/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constants;

/**
 *
 * @author Kendrick
 */
public class Card {

    public static void initCurrentSkillsProfsCard() {
        currentSkillsCard = new SkillsProfsCard(DEFAULT);
    }

    private static abstract class GenericCard {
        protected int num;
        protected String name;
        
        public GenericCard(int num){
            this.num = num;
            determineName();
        }
        
        public void increment(){
            if(++num > 2)
                num = 0;
            determineName();
        }
        
        public void decrement(){
            if(--num < 0)
                num = 0;
            determineName();
        }
                
        @Override
        public String toString(){
            return name;
        }
           
        public abstract void determineName();
    }
    private static class DefenseCard extends GenericCard{
        public DefenseCard(int num) {
            super(num);
        }
        
        @Override
        public void determineName(){
            switch(num){
                case 0:name = DEFENSE;break;
                case 1:name = ARMOR;break;
                case 2:name = RESISTANCE;break;
            }
        }
    }
    private static class SkillsProfsCard extends GenericCard{
        public SkillsProfsCard(int num){
            super(num);
        }
        
        @Override
        public void decrement(){
            if(--num < 0){
                num = 1;
            }
        }
        
        @Override
        public void increment(){
            if(++num > 1)
                num = 0;
        }

        @Override
        public void determineName() {
            switch(num){
                case 0:name=PROFICIENCIES;break;
                case 1:name=SKILLS;break;
            }
        }
        
    }
    
    public static final String DEFENSE = "Defense";
    public static final String ARMOR = "Armor";
    public static final String RESISTANCE = "Resistances";
    public static final String SKILLS = "Skills";
    public static final String PROFICIENCIES = "Proficiencies";
    
    
    private static DefenseCard currentDefenseCard;
    private static SkillsProfsCard currentSkillsCard;

    
    public static void initCurrentDefenseCard(){
        currentDefenseCard = new DefenseCard(DEFAULT);
    }
    
    public static final int INCREMENT = 1;
    public static final int DEFAULT = 0;
    public static final int DECREMENT = -1;
    
    public static void changeDefenseCard(int changeType){
        switch(changeType){
            case INCREMENT:currentDefenseCard.increment();break;
            case DECREMENT:currentDefenseCard.decrement();break;
        }
    }
    
    public static void changeSkillsCard(int changeType){
        switch(changeType){
            case INCREMENT:currentSkillsCard.increment();break;
            case DECREMENT:currentSkillsCard.decrement();break;
        }
    }
    
    public static String getCurrentDefenseCard(){
        return currentDefenseCard.toString();
    }
    
    public static String getCurrentSkillsCard(){
        return currentSkillsCard.toString();
    }
    
}
