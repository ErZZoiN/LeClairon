/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leclaironraporteur;

import java.io.*;

/**
 *
 * @author mrpar
 */
public interface Identifiable extends Serializable {
    public int getId();
    public void setId(int i);
}
