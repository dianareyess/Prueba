/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Excepciones.IntervalosFechaExcepcion;
import Excepciones.PersonaFisicaExcepcion;
import Excepciones.RFCExcepcion;
import Modelo.Fisica;
import Modelo.Persona;
import gui.componenetes.TEdit;
import javax.swing.JFrame;
import objetos.Fecha;
import objetos.RFC;
import objetos.TipoPersona;

/**
 *
 * @author princessdiana
 */
public class FisicaDialog extends PersonaDialog {
    
    private TEdit edtNombre;
    private TEdit edtPaterno;
    private TEdit edtMaterno;
    
    public FisicaDialog(JFrame frame) {
        super(frame);
        
        edtNombre = new TEdit("Nombre:", 7);
        edtNombre.setBounds(50, 100);
        edtPaterno = new TEdit("Paterno", 6);
        edtPaterno.setBounds(230, 100);
        edtMaterno = new TEdit("Materno", 6);
        edtMaterno.setBounds(400, 100);
        
        super.getPnlElementos().add(edtNombre);
        super.getPnlElementos().add(edtPaterno);
        super.getPnlElementos().add(edtMaterno);

    }

    @Override
    protected Persona crearObjeto() throws IntervalosFechaExcepcion, PersonaFisicaExcepcion, RFCExcepcion {
        Fisica fisica = new Fisica(new RFC(super.edtRFC.getText(), TipoPersona.FISICA), 
                edtNombre.getText(), 
                edtPaterno.getText(), 
                edtMaterno.getText(), 
                new Fecha(4,9,1981), 
                super.edtTelefono.getText(), 
                new Fecha(), 
                new Fecha());
        return fisica;
    }
    
}