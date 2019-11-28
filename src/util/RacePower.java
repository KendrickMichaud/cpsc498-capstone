/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Kendrick
 */
public class RacePower extends Power{

    private Bundle attributes;

    RacePower(Power p, Bundle attributes) {
        magic = p.getMagic();
        martial = p.getMartial();
        playstyle = p.getPlaystyle();
        this.attributes = attributes;
    }
    
    @Override
    String getCaster() {
        return "";
    }

    @Override
    void setCasterType(String casterType) {
        super.setCasterType(""); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Bundle attributes(){
        return attributes;
    }
    
}
