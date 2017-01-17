/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

/**
 *
 * @author princessdiana
 */
public enum Regimen {
    
    INCORPORACION(1),
    INTERMEDIO(1),
    CEDULAR(2),
    HOSPEDAJE(3),
    IEPS(4);
    
    private Regimen(int parametro){
        numerito = parametro;
    }
    
    private int numerito;

    public int getNumerito() {
        return numerito;
    }
    
    

    
}
