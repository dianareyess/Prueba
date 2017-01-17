/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.util.HashSet;

/**
 *
 * @author princessdiana
 */
public class HashConjunto extends HashSet<Regimen> {

    @Override
    public boolean add(Regimen rgm) {
        if ((rgm == Regimen.INCORPORACION)&&super.contains(Regimen.INTERMEDIO)){
            return false;
        }else if ((rgm == Regimen.INTERMEDIO)&&super.contains(Regimen.INCORPORACION)){
            return false;
        }else{
            return super.add(rgm);
        }
    }
    
    
    
}
