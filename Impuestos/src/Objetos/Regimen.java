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
    
    INCORPORACION(Periodicidad.BIMESTRAL),
    INTERMEDIO(Periodicidad.MENSUAL),
    CEDULAR(Periodicidad.BIMESTRAL),
    HOSPEDAJE(Periodicidad.TRIMESTRAL),
    IEPS(Periodicidad.MENSUAL);
    
    private Regimen(Periodicidad periodicidad){
        this.periodicidad = periodicidad;
    }
    
    private final Periodicidad periodicidad;

    public Periodicidad getPeriodicidad() {
        return periodicidad;
    }
     
}