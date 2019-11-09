/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure;

/**
 *
 * @author Kendrick
 */
public class Item {

    public final String name;
    public final String desc;
    public final String quantity;
    public final String weight;
    
    public Item(String name, String description, String quantity, String weight){
        this.name = name;
        this.desc = description;
        this.quantity = quantity;
        this.weight = weight;
    }
    
}
