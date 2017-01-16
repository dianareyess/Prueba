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
public class BajaUsuarioDialog extends JDialog{
    private JButton btnAceptar;
    private JButton btnCancelar;
    private JLabel lblMatricula;
    private JTextField txtMatricula;
    private BajaUsuarioListener listener;
    
    public BajaUsuarioDialog(JFrame owner, String titulo){
        super(owner,titulo,true);
        super.setSize(300, 120);
        super.setLayout(new BorderLayout());
        super.add(pnlTrabajo(),BorderLayout.CENTER);
        super.add(pnlBotones(),BorderLayout.SOUTH);
        
        super.setVisible(false);
    }
    
    public JPanel pnlBotones(){
        JPanel panel=new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        btnAceptar=new JButton("Aceptar");
        btnCancelar=new JButton("Cancelar");
        
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                listener.aceptarClick(txtMatricula.getText());
            }
        });
        
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                listener.cancelarClick();
            }
        });
        
        panel.add(btnAceptar);
        panel.add(btnCancelar);
        
        return panel;
    }
    
    public JPanel pnlTrabajo(){
        JPanel panel=new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        lblMatricula=new JLabel("Matricula");
        txtMatricula=new JTextField(10);
        
        panel.add(lblMatricula);
        panel.add(txtMatricula);
        
        return panel;
    }
    
    public void setListener(BajaUsuarioListener listener){
        this.listener=listener;
    }
}