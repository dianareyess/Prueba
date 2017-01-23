/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Excepciones.IntervalosFechaExcepcion;
import Excepciones.PersonaFisicaExcepcion;
import Excepciones.RFCExcepcion;
import Modelo.Persona;
import gui.componenetes.TEdit;
import gui.listeners.PersonaDialogListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author princessdiana
 */
public abstract class PersonaDialog extends JDialog {

    private JPanel pnlActions;
    private JButton btnCancelar;
    private JButton btnAceptar;

    private JPanel pnlEncabezado;
    private JLabel txtTitulo;

    private PersonaDialogListener listener;
    
    private JPanel pnlElementos;
    
    protected TEdit edtRFC;
    protected TEdit edtTelefono;

    public PersonaDialog(JFrame frame) {
        super(frame, true);
        super.setSize(600, 400);
        super.setLayout(new BorderLayout());

        txtTitulo = new JLabel("Inscripcion");

        pnlEncabezado = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlEncabezado.setBackground(Color.ORANGE);
        pnlEncabezado.add(txtTitulo);

        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Persona persona = crearObjeto();
                    listener.aceptarButtonClick(persona);
                    setVisible(false);
                } catch (IntervalosFechaExcepcion ex) {
                    JOptionPane.showMessageDialog(frame,
                            "La fecha de inscripcion debe ser menor al inicio de operaciones",
                            "Error en las Fechas",
                            JOptionPane.ERROR_MESSAGE);
                } catch (PersonaFisicaExcepcion ex) {
                    JOptionPane.showMessageDialog(frame,
                            "La persona debe ser mayor de edad para inscribirse",
                            "Estas chavo, chavo !",
                            JOptionPane.WARNING_MESSAGE);
                } catch (RFCExcepcion ex) {
                    JOptionPane.showMessageDialog(frame,
                            "RFC mal escrito",
                            "Pichon !",
                            JOptionPane.WARNING_MESSAGE);                    
                }

            }
        });

        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = JOptionPane.showConfirmDialog(
                        frame,
                        "De'veritas quieres cerrar?",
                        "Cancelar cambios",
                        JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION){
                    PersonaDialog.this.setVisible(false);
                }

            }
        });

        pnlActions = new JPanel();
        pnlActions.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pnlActions.setBackground(Color.CYAN);
        pnlActions.add(btnAceptar);
        pnlActions.add(btnCancelar);

        
        pnlElementos = new JPanel();
        pnlElementos.setBackground(Color.PINK);
        pnlElementos.setLayout(null);
                
        edtRFC = new TEdit("R.F.C.:", 6);
        edtRFC.setBounds(50, 50);
        
        edtTelefono = new TEdit("Telefono:", 10);
        edtTelefono.setBounds(50, 150);
   
        
        
        pnlElementos.add(edtRFC);
        pnlElementos.add(edtTelefono);
        
        
        super.add(pnlActions, BorderLayout.SOUTH);
        super.add(pnlEncabezado, BorderLayout.NORTH);
        super.add(pnlElementos, BorderLayout.CENTER);

    }

    public void setListener(PersonaDialogListener listener) {
        this.listener = listener;
    }

    protected abstract Persona crearObjeto() throws IntervalosFechaExcepcion, PersonaFisicaExcepcion, RFCExcepcion;

    protected JPanel getPnlElementos() {
        return pnlElementos;
    }

    protected void setPnlElementos(JPanel pnlElementos) {
        this.pnlElementos = pnlElementos;
    }

    
    
    
}