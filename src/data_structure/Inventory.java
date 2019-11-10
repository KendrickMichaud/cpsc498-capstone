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
public class Inventory {

    private final ArrayList<Item> list;
    
    public Inventory(){
        list = new ArrayList();
    }
    
    public boolean store(Item item){
        return list.add(item);
    }
    
    public Item get(int index){
        return list.get(index);
    }

    public int size() {
        return list.size();
    }
    
}
