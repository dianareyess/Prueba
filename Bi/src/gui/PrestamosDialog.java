/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class PrestamosDialog extends JDialog{
    private JButton btnAceptar;
    private JButton btnCancelar;
    private JLabel lblMatricula;
    private JTextField txtMatricula;
    private JLabel lblISBN;
    private JTextField txtISBN;
    private JLabel lblEjemplar;
    private JTextField txtEjemplar;
    private PrestamoListener listener;
    
    public PrestamosDialog(JFrame owner, String titulo){
        super(owner,titulo,true);
        super.setSize(500, 130);
        super.setLayout(new BorderLayout());
        super.add(pnlTrabajo(),BorderLayout.CENTER);
        super.add(pnlBotones(),BorderLayout.SOUTH);
        
        super.setVisible(false);
    }
    
    private JPanel pnlBotones(){
        JPanel panel=new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        btnAceptar=new JButton("Aceptar");
        btnCancelar=new JButton("Cancelar");
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                listener.aceptarClick(txtMatricula.getText(), txtISBN.getText(), Integer.valueOf(txtEjemplar.getText()));
                System.out.println("Aceptar");
            }
        });
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                listener.cancelarClick();
                System.out.println("Cancelar");
            }
        });
        panel.add(btnAceptar);
        panel.add(btnCancelar);
        return panel;
    }
    
    private JPanel pnlTrabajo(){
        JPanel panel=new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        lblMatricula=new JLabel("Matricula");
        txtMatricula=new JTextField(10);
        lblISBN=new JLabel("ISBN");
        txtISBN=new JTextField(10);
        lblEjemplar=new JLabel("Ejemplar");
        txtEjemplar=new JTextField(5);
        panel.add(lblMatricula);
        panel.add(txtMatricula);
        panel.add(lblISBN);
        panel.add(txtISBN);
        panel.add(lblEjemplar);
        panel.add(txtEjemplar);
        return panel;
    }

    public void setListener(PrestamoListener listener) {
        this.listener = listener;
    }
    
}
