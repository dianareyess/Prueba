/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Excepciones.IntervalosFechaExcepcion;
import Excepciones.PersonaFisicaExcepcion;
import Modelo.Persona;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author princessdiana
 */
public class MoralDialog extends PersonaDialog{
    
    public MoralDialog(JFrame frame) {
        super(frame);
    }

    protected Persona crearObjeto() throws IntervalosFechaExcepcion, PersonaFisicaExcepcion {
        throw new IntervalosFechaExcepcion();
    }

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}