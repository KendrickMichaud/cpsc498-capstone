/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package container;

import javax.swing.text.Document;
import util.Bundle;

/**
 *
 * @author Kendrick
 */
public interface CardDataHolder {
    
    public Document extractDocument(String key);

    public void putDocument(String key, String value);    

    public void getData(Bundle b);

    public void update(Bundle b);
}
