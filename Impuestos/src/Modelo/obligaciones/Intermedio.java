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
public class Intermedio extends General {
    public Intermedio(Periodo per) {
        super(Regimen.INTERMEDIO, per);
    }
}
