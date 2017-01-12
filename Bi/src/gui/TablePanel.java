/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.Coleccion;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import model.Prestamo;

/**
 *
 * @author Usuario
 */
public class TablePanel extends JPanel{
    
    private JTable tblPrestamos;
    
    public TablePanel(Coleccion<Prestamo> coleccion){
        tblPrestamos=new JTable(new PrestamoModel(coleccion));
        super.setLayout(new BorderLayout());
        super.add(new JScrollPane(tblPrestamos));
        
    }
    
}
