/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Excepciones.IntervalosFechaExcepcion;
import Excepciones.PersonaFisicaExcepcion;
import Modelo.Persona;
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
                Persona persona = null;
                try {
                    persona = crearObjeto();
                } catch (IntervalosFechaExcepcion ex) {
                    Logger.getLogger(PersonaDialog.class.getName()).log(Level.SEVERE, null, ex);
                } catch (PersonaFisicaExcepcion ex) {
                    Logger.getLogger(PersonaDialog.class.getName()).log(Level.SEVERE, null, ex);
                }
                listener.aceptarButtonClick(persona);
                setVisible(false);

            }
        });

        btnCancelar = new JButton("Cancelar");
        //btnCancelar.addActionListener(l);

        pnlActions = new JPanel();
        pnlActions.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pnlActions.setBackground(Color.CYAN);
        pnlActions.add(btnAceptar);
        pnlActions.add(btnCancelar);

        super.add(pnlActions, BorderLayout.SOUTH);
        super.add(pnlEncabezado, BorderLayout.NORTH);

    }

    public void setListener(PersonaDialogListener listener) {
        this.listener = listener;
    }

    protected abstract Persona crearObjeto() throws IntervalosFechaExcepcion, PersonaFisicaExcepcion;

}
