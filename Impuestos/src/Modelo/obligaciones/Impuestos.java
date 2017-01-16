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
    
    private Periodo periodo;
    private Regimen regimen;
    
    @Override
    public Float calculoImpuestos() {
        return totalPagar() + calcularRecargos();
    }
    
}
