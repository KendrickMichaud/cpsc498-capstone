/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package container;

import constants.KEY;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.text.Document;
import util.Bundle;
import util.KeyReader;

/**
 *
 * @author Kendrick
 */
public class Deck {
    private ArrayList<String> deck;
    protected ArrayList<CardDataHolder> panels;
    private JPanel holder;
    protected int current_item;
    
    public Deck(JPanel holder){
        if(holder == null)
            throw new NullPointerException();
        if(!holder.getLayout().getClass().equals(CardLayout.class)){
            throw new IllegalArgumentException("JPanel holder must use a CardLayout");
        }
        this.holder = holder;
        panels = new ArrayList<>();
        deck = new ArrayList<>();
        current_item = 0;
    }
    
    public boolean add(CardDataHolder card, String key){
        if(card == null || key == null)
            return false;
        deck.add(key);
        panels.add(card);
        holder.add((JPanel)card,key);
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

    protected void revealCard() {
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

    Document getDocument(String key, int i) {
        CardDataHolder panel = panels.get(i);
        return panel.extractDocument(key);
    }

    void putDocument(String key, String value) {
        int index = KeyReader.getIndex(key);
        if(index >= 0){
            CardDataHolder panel = panels.get(index);
            panel.putDocument(key, value);
        }
    }

    void collect(Bundle b) {
        for(int i = 0; i < panels.size(); i++){
            CardDataHolder h = panels.get(i);
            h.getData(b);
        }
    }
    
    void update(Bundle b){
        for(int i = 0; i < panels.size(); i++){
            CardDataHolder h = panels.get(i);
            h.update(b);
        }
    }
}
