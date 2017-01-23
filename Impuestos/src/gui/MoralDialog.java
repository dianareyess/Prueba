/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Excepciones.IntervalosFechaExcepcion;
import Excepciones.PersonaFisicaExcepcion;
import Excepciones.RFCExcepcion;
import Excepciones.RFCException;
import Modelo.Moral;
import Modelo.Persona;
import gui.componenetes.TEdit;
import javax.swing.JDialog;
import javax.swing.JFrame;
import objetos.Fecha;
import objetos.RFC;
import objetos.TipoPersona;

/**
 *
 * @author princessdiana
 */
public class MoralDialog extends PersonaDialog{
    
    private TEdit edtRazonSocial;
    private TEdit edtTipoSociedad;
    
    public MoralDialog(JFrame frame) {
        super(frame);
        
        edtRazonSocial = new TEdit("RazonSocial:", 7);
        edtRazonSocial.setBounds(50, 100);
        edtTipoSociedad = new TEdit("Tipo", 6);
        edtTipoSociedad.setBounds(230, 100);
        
        super.getPnlElementos().add(edtRazonSocial);
        super.getPnlElementos().add(edtTipoSociedad);
        
    }

    @Override
    protected Persona crearObjeto() throws IntervalosFechaExcepcion, PersonaFisicaExcepcion, RFCExcepcion {
        Moral moral = new Moral (new RFC(super.edtRFC.getText(), TipoPersona.MORAL), 
                edtRazonSocial.getText(), 
                edtTipoSociedad.getText(), 
                null, 
                super.edtTelefono.getText(), 
                new Fecha(), 
                new Fecha(),
                new Fecha());    
        return moral;
    }
    
}