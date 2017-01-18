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
public class Ieps extends Impuestos {
    private Float litrosMagna;
    private Float litrosPremium;
    private Float litrosDisel;

    public Ieps(Periodo per) {
        super(Regimen.IEPS, per);
    }

    @Override
    public Float totalPagar() {
        Float magna = litrosMagna * (float)15.99 * (float)0.20;
        Float premuin = litrosPremium * (float)17.79 * (float)0.20;
        Float disel = litrosDisel * (float)17.05 * (float)0.20;
        return magna + premuin + disel;
    }

    public Float getLitrosMagna() {
        return litrosMagna;
    }

    public void setLitrosMagna(Float litrosMagna) {
        this.litrosMagna = litrosMagna;
    }

    public Float getLitrosPremium() {
        return litrosPremium;
    }

    public void setLitrosPremium(Float litrosPremium) {
        this.litrosPremium = litrosPremium;
    }

    public Float getLitrosDisel() {
        return litrosDisel;
    }

    public void setLitrosDisel(Float litrosDisel) {
        this.litrosDisel = litrosDisel;
    }

    @Override
    public Float calculaRecargos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
