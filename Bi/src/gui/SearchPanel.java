/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class SearchPanel extends JPanel{
    private JLabel lblMatricula;
    private JTextField txtMatricula;
    private JLabel lblISBN;
    private JTextField txtISBN;
    private JLabel lblEjemplar;
    private JTextField txtEjemplar;
    private JCheckBox chkActivo;
    private JButton btnBuscar;
    
    public SearchPanel(){
        super.setLayout(new FlowLayout(FlowLayout.LEFT));
        lblMatricula=new JLabel("Matricula");
        txtMatricula=new JTextField(10);
        lblISBN=new JLabel("ISBN");
        txtISBN=new JTextField(10);
        lblEjemplar=new JLabel("Ejemplar");
        txtEjemplar=new JTextField(5);
        chkActivo=new JCheckBox("Activo");
        btnBuscar=new JButton("Buscar");
        
        super.add(lblMatricula);
        super.add(txtMatricula);
        super.add(lblISBN);
        super.add(txtISBN);
        super.add(lblEjemplar);
        super.add(txtEjemplar);
        super.add(chkActivo);
        super.add(btnBuscar);
    }
}
