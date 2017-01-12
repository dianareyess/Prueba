/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.Coleccion;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import model.Libro;

/**
 *
 * @author Usuario
 */
public class CatalogoLibrosDialog extends JDialog{
    public CatalogoLibrosDialog(JFrame owner, String titulo,Coleccion<Libro> coleccion){
        super(owner,titulo,false);
        super.setSize(700, 300);
        super.add(new JScrollPane(new JTable(new LibroModel(coleccion))));
        
        super.setVisible(false);
    }
}
