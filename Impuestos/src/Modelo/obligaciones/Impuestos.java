/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.obligaciones;

import objetos.Periodo;



/**
 *
 * @author princessdiana
 */

public abstract class Impuestos implements Obligacion {
    
    private Regimen regimen;
    private Periodo periodo;
    
    @Override
    public Float calculoImpuesto(){
        return totalPagar() + calculaRecargos();
    }

    
}
