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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Carrera;

/**
 *
 * @author Usuario
 */
public class AltaUsuarioDialog extends JDialog{
    private JButton btnAgregar;
    private JButton btnCancelar;
    private JLabel lblMatricula;
    private JTextField txtMatricula;
    private JLabel lblNombre;
    private JTextField txtNombre;
    private JLabel lblPaterno;
    private JTextField txtPaterno;
    private JLabel lblMaterno;
    private JTextField txtMaterno;
    private JComboBox cmbCarrera;
    private JCheckBox chkProfesor;
    private AltaUsuarioListener listener;
    
    public AltaUsuarioDialog(JFrame owner, String titulo){
        super(owner,titulo,true);
        super.setSize(700, 150);
        super.setLayout(new BorderLayout());
        super.add(pnlTrabajo(),BorderLayout.CENTER);
        super.add(pnlBotones(),BorderLayout.SOUTH);
        
        super.setVisible(false);
    }
    
    private JPanel pnlBotones(){
        JPanel panel=new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        btnAgregar=new JButton("Agregar");
        btnCancelar=new JButton("Cancelar");
        
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(chkProfesor.isSelected()){
                    listener.agregarDocenteClick(txtNombre.getText(), txtPaterno.getText(), txtMaterno.getText(),txtMatricula.getText());
                }
                else{
                    listener.agregarClick(txtNombre.getText(), txtPaterno.getText(), txtMaterno.getText(),txtMatricula.getText(),(Carrera)cmbCarrera.getSelectedItem());
                }
                System.out.println("Aceptar");
            }
        });
        
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                listener.cancelarClick();
                txtMatricula.setText("");
                txtNombre.setText("");
                txtPaterno.setText("");
                txtMaterno.setText("");
                System.out.println("Cancelar");
            }
        });
        
        panel.add(btnAgregar);
        panel.add(btnCancelar);
        
        return panel;
    }
    
    private JPanel pnlTrabajo(){
        JPanel panel=new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        lblMatricula=new JLabel("Matricula");
        txtMatricula=new JTextField(10);
        lblNombre=new JLabel("Nombre");
        txtNombre=new JTextField(10);
        lblPaterno=new JLabel("Apellido paterno");
        txtPaterno=new JTextField(10);
        lblMaterno=new JLabel("Apellido materno");
        txtMaterno=new JTextField(10);
        cmbCarrera=new JComboBox(Carrera.values());
        chkProfesor=new JCheckBox("Profesor?");
        chkProfesor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(cmbCarrera.isEnabled())
                    cmbCarrera.setEnabled(false);
                else
                    cmbCarrera.setEnabled(true);
            }
        });
        panel.add(lblMatricula);
        panel.add(txtMatricula);
        panel.add(chkProfesor);
        panel.add(lblNombre);
        panel.add(txtNombre);
        panel.add(lblPaterno);
        panel.add(txtPaterno);
        panel.add(lblMaterno);
        panel.add(txtMaterno);
        panel.add(cmbCarrera);
        return panel;
    }

    public void setListener(AltaUsuarioListener listener) {
        this.listener = listener;
    }
}
