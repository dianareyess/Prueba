/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impuestos;

import Excepciones.DireccionExcepcion;
import Modelo.obligaciones.Cedular;

/**
 *
 * @author princessdiana
 */
public class Impuestos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws DireccionExcepcion  {
        // TODO code application logic here
        
        /*Obligacion ob = new Cedular();
        
        arreglo.add(ob);
        arreglo.add(new Ieps());
        arreglo.add(new Incorporacion());
        arreglo.add(new Cedular());
        
        for (int i = 0; i < arreglo.size(); i++) {
            
            
            arreglo.get(i).metodoPrueba();
        }*/
        
        Cedular cedular = new Cedular();
        
        Float f = cedular.calculoImpuesto();
        
        System.out.println(f);
        
        
       
    }

    
    
    
}
