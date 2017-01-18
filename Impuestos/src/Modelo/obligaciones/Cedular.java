/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.obligaciones;

import objetos.Fecha;
import objetos.Periodo;
import objetos.Regimen;

/**
 *
 * @author princessdiana
 */
public class Cedular extends Impuestos {
    
    private Float totalCasaHabitacion;
    private Float totalLocalComercial;

    public Cedular(Periodo per){
        super(Regimen.CEDULAR, per);
    }    


    @Override
    public Float calculaRecargos() {
        return (float)2.0;
    }

    
    @Override
    public Float calculoImpuesto() {
        return null;
        
    }
    
    
   
    @Override
    public Float totalPagar() {
        Float total = totalCasaHabitacion * (float)0.10 + totalLocalComercial * (float)0.25;
        Float iva = (totalCasaHabitacion + totalLocalComercial) * (float)0.16;
        return total + iva;
    }



    
}
