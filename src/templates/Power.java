/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package templates;

/**
 *
 * @author Kendrick
 */
public class Power {

    protected PowerRating.PowerStat magic;
    protected PowerRating.PowerStat martial;
    protected PowerRating.Playstyle playstyle;
    private String casterType;

    public void setMagic(int moff, int mdeff, int mutil) {
        magic = new PowerRating.PowerStat();
        magic.offensive.set(moff);
        magic.defensive.set(mdeff);
        magic.utility.set(mutil);
    }

    public void setMartial(int martoff, int martdeff, int martutil) {
        martial = new PowerRating.PowerStat();
        martial.offensive.set(martoff);
        martial.defensive.set(martdeff);
        martial.utility.set(martutil);
    }

    public void setPlaystyle(int melee, int ranged) {
        playstyle = new PowerRating.Playstyle();
        playstyle.melee.set(melee);
        playstyle.ranged.set(ranged);
    }

    public PowerRating.PowerStat getMagic() {
        return magic;
    }

    public PowerRating.PowerStat getMartial() {
        return martial;
    }

    public PowerRating.Playstyle getPlaystyle() {
        return playstyle;
    }

    public void setCasterType(String casterType) {
        this.casterType = casterType;
    }

    public String getCaster() {
        return casterType;
    }
    
}
