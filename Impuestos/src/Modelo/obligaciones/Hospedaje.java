/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.obligaciones;

import objetos.Periodo;
import objetos.Regimen;
/**
 *
 * @author princessdiana
 */
public class Hospedaje extends Impuestos {
    
    public Hospedaje(Periodo per) {
        super(Regimen.HOSPEDAJE, per);
    }

    @Override
    public Float totalPagar() {
        Float impuesto = getIngresos() * (float)0.02;
        return super.totalPagar() + impuesto;
    }

    @Override
    public Float calculaRecargos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private float getIngresos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
