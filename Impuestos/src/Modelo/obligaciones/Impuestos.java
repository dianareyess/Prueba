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

public abstract class Impuestos implements Obligacion {
    
    Regimen regimen;
    private Periodo periodo;
    private Boolean obligacionCumplida;
    
    public Impuestos(Regimen rgm, Periodo per){
        this.regimen = rgm;
        this.periodo = per;
        obligacionCumplida = false;
    }
    
    @Override
    public Float calculoImpuesto(){
        return totalPagar() + calculaRecargos();
    }
    
    @Override
    public Float calculaRecargos() {
        if (getPeriodo().getFechaLimitePago().compareTo(new Fecha()) <= 0){
            return (float)0.0;
        }else{
            return totalPagar()*(float)0.03;
        }
    }    
    
    
    public String toString(){
        return getRegimen().toString()+" "+getPeriodo().toString();
    }

    public Regimen getRegimen() {
        return regimen;
    }

    public void setRegimen(Regimen regimen) {
        this.regimen = regimen;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public Boolean getObligacionCumplida() {
        return obligacionCumplida;
    }

    public void setObligacionCumplida(Boolean obligacionCumplida) {
        this.obligacionCumplida = obligacionCumplida;
    }

    
}
