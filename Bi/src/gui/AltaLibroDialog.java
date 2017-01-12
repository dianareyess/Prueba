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
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Editorial;

/**
 *
 * @author Usuario
 */
public class AltaLibroDialog extends JDialog{
    private JButton btnAgregar;
    private JButton btnCancelar;
    private JLabel lblISBN;
    private JTextField txtISBN;
    private JLabel lblTitulo;
    private JTextField txtTitulo;
    private JLabel lblAutor;
    private JTextField txtAutor;
    private JLabel lblEjemplar;
    private JTextField txtEjemplar;
    private JComboBox cmbEditorial;
    private AltaLibroListener listener;
    
    public AltaLibroDialog(JFrame owner, String titulo){
        super(owner,titulo,true);
        super.setSize(700, 150);
        super.setLayout(new BorderLayout());
        super.add(pnlTrabajo(),BorderLayout.CENTER);
        super.add(pnlBotones(),BorderLayout.SOUTH);
        
        super.setVisible(false);
    }
    
    private JPanel pnlBotones(){
        JPanel panel=new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        btnAgregar=new JButton("Agregar");
        btnCancelar=new JButton("Cancelar");
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                listener.agregarClick(txtTitulo.getText(), txtAutor.getText(), (Editorial)cmbEditorial.getSelectedItem(), txtISBN.getText(), Integer.valueOf(txtEjemplar.getText()));
            }
        });
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                listener.cancelarClick();
                txtISBN.setText("");
                txtAutor.setText("");
                txtEjemplar.setText("");
            }
        });
        panel.add(btnAgregar);
        panel.add(btnCancelar);
        return panel;
    }
    
    private JPanel pnlTrabajo(){
        JPanel panel=new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        lblISBN=new JLabel("ISBN");
        txtISBN=new JTextField(10);
        lblTitulo=new JLabel("Titulo");
        txtTitulo=new JTextField(10);
        lblAutor=new JLabel("Autor");
        txtAutor=new JTextField(10);
        lblEjemplar=new JLabel("Ejemplar");
        txtEjemplar=new JTextField(5);
        cmbEditorial=new JComboBox(Editorial.values());
        
        panel.add(lblISBN);
        panel.add(txtISBN);
        panel.add(lblTitulo);
        panel.add(txtTitulo);
        panel.add(lblAutor);
        panel.add(txtAutor);
        panel.add(lblEjemplar);
        panel.add(txtEjemplar);
        panel.add(cmbEditorial);
        
        return panel;
    }

    public void setListener(AltaLibroListener listener) {
        this.listener = listener;
    }
}
