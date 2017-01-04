/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impuestos;

import Objetos.Fecha;

/**
 *
 * @author Diana Reyes Luis
 */
public class Impuestos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Fecha f = new Fecha(28,04,2017);
        System.out.println(f);
        System.out.println(f.fechaValidar());
    }
    
}
