/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Modelo.Persona;
import controller.BaseDatos;
import gui.listeners.PersonaDialogListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;

/**
 *
 * @author princessdiana
 */
public class PrincipalFrame extends JFrame {
    
    private BusquedaPanel pnlBusqueda;
    private WorkPanel pnlWork;
    private JToolBar toolbar;
    
    private FisicaDialog dlgFisica;
    private MoralDialog dlgMoral;
    
    private JButton btnPrueba;
    private JButton btnPruebaMoral;
    
    private BaseDatos datos;
    
    public PrincipalFrame(){
        super("Impuestos Lasallinos");
        super.setSize(1100, 600);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLayout(new BorderLayout());
       
        super.setJMenuBar(createMenu());
        
        datos = new BaseDatos();
        
        pnlBusqueda = new BusquedaPanel();
        pnlWork = new WorkPanel();
        toolbar = new JToolBar();
        
        btnPrueba = new JButton("Prueba");
        btnPrueba.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inscribirPersonaFisicaClick();
            }
        });
        
        btnPruebaMoral = new JButton("Prueba");
        btnPruebaMoral.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inscribirPersonaMoralClick();
            }
        });        
        
        toolbar.add(btnPrueba);
        toolbar.add(btnPruebaMoral);
        
        
        dlgFisica = new FisicaDialog(this);
        dlgFisica.setListener(new PersonaDialogListener() {
            @Override
            public void aceptarButtonClick(Persona persona) {
                System.out.println(persona.getRfc());
                datos.agregar(persona);
            }
        });

        
        dlgMoral = new MoralDialog(this);

        super.add(toolbar, BorderLayout.NORTH);        
        super.add(pnlBusqueda, BorderLayout.SOUTH);
        super.add(pnlWork, BorderLayout.CENTER);
        super.setVisible(true);
    }
    
    private void inscribirPersonaFisicaClick(){
        dlgFisica.setVisible(true);
        System.out.println("añkjfkadjns");
    }
    
    private void inscribirPersonaMoralClick(){
        dlgMoral.setVisible(true);
        System.out.println("añkjfkadjns");
    }    
    
    private JMenuBar createMenu(){
        JMenuBar menu = new JMenuBar();
        
        JMenu mArchivo = new JMenu("Archivo");
        JMenuItem mmGuardar = new JMenuItem("Guardar");
        mmGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Esta guardando");
                datos.guardar();
            }
        });
        JMenuItem mmBuscar = new JMenuItem("Buscar");
        JMenuItem mmSalir = new JMenuItem("Salir");        
        mArchivo.add(mmGuardar);
        mArchivo.add(mmBuscar);
        mArchivo.addSeparator();
        mArchivo.add(mmSalir);
        
        JMenu mContribuyentes = new JMenu("Contribuyentes");
        JMenuItem mmFisica = new JMenuItem("Inscribir persona Fisica...");
        JMenuItem mmMoral = new JMenuItem("Inscribir persona Moral...");
        JMenuItem mmModificar = new JMenuItem("Modificar datos..");
        JMenuItem mmDeclarar = new JMenuItem("Declarar...");
        JMenuItem mmVer = new JMenuItem("Ver obligaciones...");
        mContribuyentes.add(mmFisica);
        mContribuyentes.add(mmMoral);
        mContribuyentes.add(mmModificar);
        mContribuyentes.addSeparator();
        mContribuyentes.add(mmVer);
        mContribuyentes.add(mmDeclarar);
        
        JMenu mAiuda = new JMenu("Ayuda");
        JMenuItem mmAcerca = new JMenuItem("Acerca de...");
        mAiuda.add(mmAcerca);
        
        menu.add(mArchivo);
        menu.add(mContribuyentes);
        menu.add(mAiuda);
        
        return menu;
    }
    
    
    
}