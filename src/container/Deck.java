/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package container;

import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Kendrick
 */
public class Deck {
    private ArrayList<String> deck;
    private JPanel holder;
    private int current_item;
    
    public Deck(JPanel holder){
        if(holder == null)
            throw new NullPointerException();
        if(!holder.getLayout().getClass().equals(CardLayout.class)){
            throw new IllegalArgumentException("JPanel holder must use a CardLayout");
        }
        this.holder = holder;
        deck = new ArrayList<>();
        current_item = 0;
    }
    
    public boolean add(JPanel card, String key){
        if(card == null || key == null)
            return false;
        deck.add(key);
        holder.add(card,key);
        return true;
    }
    
    public void nextCard(){
        current_item++;
        if(current_item >= deck.size()){
            current_item = 0;
        }
        revealCard();
    }
    
    public void previousCard(){
        current_item--;
        if(current_item < 0){
            if(deck.isEmpty())
                current_item = 0;
            else
                current_item = deck.size()-1;
        }
        revealCard();
    }

    private void revealCard() {
        CardLayout layout = (CardLayout) holder.getLayout();
        String name = deck.get(current_item);
        layout.show(holder, name);
    }

    void display() {
        if(deck.size() > 0){
            revealCard();
        }
    }

    String getCardName() {
        if(deck.size() > 0){
            return deck.get(current_item);
        }
        else{
            throw new IndexOutOfBoundsException("Deck does not have items");
        }
    }
}
