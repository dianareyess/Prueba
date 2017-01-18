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
public class Incorporacion extends Impuestos {
    private Float ingresosBismestrales;
    
    public Incorporacion(Periodo per){
        super(Regimen.INCORPORACION, per);
    }
    
    @Override
    public Float totalPagar() {
        if (ingresosBismestrales < 10000){
            return (float)250;
        }else if (ingresosBismestrales < 20000){
            return (float)480;
        }else if (ingresosBismestrales < 30000){
            return (float)1000;
        }else if (ingresosBismestrales < 40000){
            return (float)1500;
        }else if (ingresosBismestrales < 50000){
            return (float)5000;
        }else{
            return (float)10000;
        }
    }

    public Float getIngresosBismestrales() {
        return ingresosBismestrales;
    }

    public void setIngresosBismestrales(Float ingresosBismestrales) {
        this.ingresosBismestrales = ingresosBismestrales;
    }
    
    
    
}
