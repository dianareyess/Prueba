/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import Objetos.Regimen;
import java.util.HashSet;

/**
 *
 * @author Diana Reyes Luis
 */
public class Prueba {

    public static void main(String[] args) {
        
        HashSet<Regimen> regimenes = new HashSet<>();
        regimenes.add(Regimen.IEPS);
        regimenes.add(Regimen.CEDULAR);
        regimenes.add(Regimen.INCORPORACION);
        regimenes.add(Regimen.INTERMEDIO);
        
        for (Regimen regimene : regimenes) {
            System.out.println(regimene);
        }
        
        
        

    }
}
