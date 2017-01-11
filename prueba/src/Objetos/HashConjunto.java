/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import excepciones.RegimenIncompatibleException;
import java.util.HashSet;

/**
 *
 * @author Diana Reyes Luis
 */
public class HashConjunto extends HashSet<Regimen> {
     @Override
     public boolean add(Regimen rgm) {
         
         if((rgm == Regimen.INCORPORACION) && super.contains(Regimen.INTERMEDIO)) {
             return false;
         }
         
         switch (rgm) {
             case INCORPORACION:
                 if (super.contains(Regimen.INTERMEDIO)){
                     return false;
                 }
                 super.add(rgm);
                 break;
             case INTERMEDIO: 
                 if (super.contains(Regimen.INCORPORACION)){
                     return false;
                 }
             super.add(rgm);
                 break;
             default:
                 super.add(rgm);
                 throw new AssertionError();
         }
         Regimen e = null;
         
         return super.add(e);
     }
}