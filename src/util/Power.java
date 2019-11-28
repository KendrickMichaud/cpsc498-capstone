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
public class Power {

    protected PowerRating.Magic magic;
    protected PowerRating.Martial martial;
    protected PowerRating.Playstyle playstyle;
    private String casterType;

    void setMagic(int moff, int mdeff, int mutil) {
        magic = new PowerRating.Magic();
        magic.offensive.set(moff);
        magic.defensive.set(mdeff);
        magic.utility.set(mutil);
    }

    void setMartial(int martoff, int martdeff, int martutil) {
        martial = new PowerRating.Martial();
        martial.offensive.set(martoff);
        martial.defensive.set(martdeff);
        martial.utility.set(martutil);
    }

    void setPlaystyle(int melee, int ranged) {
        playstyle = new PowerRating.Playstyle();
        playstyle.melee.set(melee);
        playstyle.ranged.set(ranged);
    }

    PowerRating.Magic getMagic() {
        return magic;
    }

    PowerRating.Martial getMartial() {
        return martial;
    }

    PowerRating.Playstyle getPlaystyle() {
        return playstyle;
    }

    void setCasterType(String casterType) {
        this.casterType = casterType;
    }

    String getCaster() {
        return casterType;
    }
    
}
