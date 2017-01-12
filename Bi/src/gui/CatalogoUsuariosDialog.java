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
import model.Persona;

/**
 *
 * @author Usuario
 */
public class CatalogoUsuariosDialog extends JDialog{
    public CatalogoUsuariosDialog(JFrame owner, String titulo,Coleccion<Persona> coleccion){
        super(owner,titulo,false);
        super.setSize(700, 300);
        super.add(new JScrollPane(new JTable(new UsuarioModel(coleccion))));
        
        super.setVisible(false);
    }
}
