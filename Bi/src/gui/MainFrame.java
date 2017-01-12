/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.Controller;
import exceptions.EjemplarNoPrestableException;
import exceptions.ElementoNoEncontradoException;
import exceptions.ElementoRepetidoException;
import exceptions.FechaInvalidaException;
import exceptions.LibroNoEncontradoException;
import exceptions.LibroYaPrestadoException;
import exceptions.MaximoDePrestamosAlcanzadoException;
import exceptions.PersonaNoEncontradaException;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import model.Alumno;
import model.Carrera;
import model.Docente;
import model.Editorial;
import model.Libro;
import model.Persona;

/**
 *
 * @author Usuario
 */
public class MainFrame extends JFrame{
    private JMenu mnArchivo;
    private JMenu mnCatalogos;
    private JMenu mnAyuda;
    private TablePanel pnlTabla;
    private SearchPanel pnlBuscar;
    private JToolBar tlbToolBar;
    private JMenuBar mnbMenuBar;
    private Controller controller;
    private PrestamosDialog pDialog;
    private AltaUsuarioDialog aUDialog;
    private BajaUsuarioDialog bUDialog;
    private CatalogoUsuariosDialog cUDialog;
    private AltaLibroDialog aLDialog;
    private BajaLibroDialog bLDialog;
    private CatalogoLibrosDialog cLDialog;
    
    public MainFrame(){
        super("Biblioteca La Salle v1.0");
        super.setLayout(new BorderLayout());
        super.setSize(800,700);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        controller=new Controller();
        pDialog=new PrestamosDialog(this,"Nuevo prestamo");
        aUDialog=new AltaUsuarioDialog(this, "Agregar nuevo usuario");
        bUDialog=new BajaUsuarioDialog(this,"Eliminar un usuario");
        cUDialog=new CatalogoUsuariosDialog(this, "Catalogo de usuarios", controller.getUsuarios());
        aLDialog=new AltaLibroDialog(this,"Agregar nuevo libro");
        bLDialog=new BajaLibroDialog(this,"Eliminar un libro del catalogo");
        cLDialog=new CatalogoLibrosDialog(MainFrame.this, "Catalogo de libros", controller.getLibros());
        pnlTabla=new TablePanel(controller.getPrestamos());
        pnlBuscar=new SearchPanel();
        tlbToolBar=new JToolBar();
        mnbMenuBar=new JMenuBar();
        
        mnbMenuBar.add(mnArchivo());
        mnbMenuBar.add(mnCatalogos());
        mnbMenuBar.add(mnAyuda());
        
        super.add(mnbMenuBar,BorderLayout.NORTH);
        super.add(tlbToolBar);
        super.add(pnlBuscar,BorderLayout.SOUTH);
        super.add(pnlTabla,BorderLayout.CENTER);
        
        super.setVisible(true);
    }
    private JMenu mnArchivo(){
        mnArchivo=new JMenu("Archivo");
        JMenu mnUsuarios=new JMenu("Usuarios");
        JMenuItem mniAltaU=new JMenuItem("Agregar usuario");
        JMenuItem mniBajaU=new JMenuItem("Eliminar usuario");
        JMenu mnLibros=new JMenu("Libros");
        JMenuItem mniAltaL=new JMenuItem("Agregar libro");
        JMenuItem mniBajaL=new JMenuItem("Eliminar libro");
        JMenuItem mniPrestamos=new JMenuItem("Prestamos");
        JMenuItem mniSalir=new JMenuItem("Salir");
        
        mniAltaL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                aLDialog.setListener(new AltaLibroListener() {
                    @Override
                    public void agregarClick(String titulo, String autor, Editorial editorial, String isbn, Integer ejemplar) {
                        try {
                            controller.altaLibro(new Libro(titulo, autor,  editorial, isbn, ejemplar));
                            JOptionPane.showMessageDialog(MainFrame.this,"Libro agregado con exito");
                        } catch (ElementoRepetidoException ex) {
                            JOptionPane.showMessageDialog(MainFrame.this,"Este libro ya existe");
                        }
                        aLDialog.setVisible(false);
                    }

                    @Override
                    public void cancelarClick() {
                        aLDialog.setVisible(false);
                    }
                });
                aLDialog.setVisible(true);
            }
        });
        
        mniAltaU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                aUDialog.setListener(new AltaUsuarioListener() {
                    @Override
                    public void agregarClick(String nombre, String paterno, String materno, String id, Carrera carrera) {
                        try {
                            controller.altaPersona(new Alumno(nombre,paterno,materno,id,carrera));
                            JOptionPane.showMessageDialog(MainFrame.this,"Usuario agregado con exito");
                        } catch (ElementoRepetidoException ex) {
                            JOptionPane.showMessageDialog(MainFrame.this,"Este usuario ya existe");
                        }
                        aUDialog.setVisible(false);
                    }

                    @Override
                    public void cancelarClick() {
                        aUDialog.setVisible(false);
                    }

                    @Override
                    public void agregarDocenteClick(String nombre, String paterno, String materno, String id) {
                        try {
                            controller.altaPersona(new Docente(nombre, paterno, materno, id));
                            JOptionPane.showMessageDialog(MainFrame.this,"Usuario agregado con exito");
                        } catch (ElementoRepetidoException ex) {
                            JOptionPane.showMessageDialog(MainFrame.this,"Este docente ya existe");
                        }
                        aLDialog.setVisible(false);
                    }
                });
                aUDialog.setVisible(true);
            }
        });
        
        mniBajaL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                bLDialog.setListener(new BajaLibroListener() {
                    @Override
                    public void aceptarClick(String isbn, Integer ejemplar) {
                        try {
                            controller.bajaLibro(controller.buscarLibro(isbn, ejemplar));
                            JOptionPane.showMessageDialog(MainFrame.this,"Libro eliminado con exito");
                        } catch (ElementoNoEncontradoException ex) {
                            
                        } catch (LibroNoEncontradoException ex) {
                            JOptionPane.showMessageDialog(MainFrame.this.pDialog,"No se encuentra ese libro");
                        }
                        bLDialog.setVisible(false);
                    }

                    @Override
                    public void cancelarClick() {
                        bLDialog.setVisible(false);
                    }
                });
                bLDialog.setVisible(true);
            }
        });
        
        mniBajaU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                bUDialog.setListener(new BajaUsuarioListener() {
                    @Override
                    public void aceptarClick(String matricula) {
                        try {
                            controller.deletePersona(controller.buscarUsuario(matricula));
                            JOptionPane.showMessageDialog(MainFrame.this.pDialog,"Usuario eliminado con exito");
                        } catch (ElementoNoEncontradoException ex) {
                            
                        } catch (PersonaNoEncontradaException ex) {
                            JOptionPane.showMessageDialog(MainFrame.this.pDialog,"No se encuentra esa persona");
                        }
                        bUDialog.setVisible(false);
                    }

                    @Override
                    public void cancelarClick() {
                        bUDialog.setVisible(false);
                    }
                });
                bUDialog.setVisible(true);
            }
        });
        mniPrestamos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                    pDialog.setListener(new PrestamoListener() {
                    @Override
                    public void aceptarClick(String matricula, String isbn, Integer ejemplar) {
                        try {
                            Persona usuario=controller.buscarUsuario(matricula);
                            Libro libro=controller.buscarLibro(isbn, ejemplar);
                            controller.darPrestamo(usuario, libro);
                            JOptionPane.showMessageDialog(MainFrame.this,"Prestamo creado con exito");
                        } catch (PersonaNoEncontradaException ex) {
                            JOptionPane.showMessageDialog(MainFrame.this.pDialog,"No se encuentra esa persona");
                        } catch (LibroNoEncontradoException ex) {
                            JOptionPane.showMessageDialog(MainFrame.this.pDialog,"No se encuentra ese libro");
                        } catch (MaximoDePrestamosAlcanzadoException ex) {
                            JOptionPane.showMessageDialog(MainFrame.this.pDialog,"Este usuario ya ha alcanzado el limite de prestamos activos");
                        } catch (FechaInvalidaException ex) {
                            JOptionPane.showMessageDialog(MainFrame.this.pDialog,"La fecha no es valida");
                        } catch (EjemplarNoPrestableException ex) {
                            JOptionPane.showMessageDialog(MainFrame.this.pDialog,"Este ejemplar no puede prestarse");
                        } catch (ElementoRepetidoException ex) {
                            JOptionPane.showMessageDialog(MainFrame.this.pDialog,"Hay un error con el prestamo");
                        } catch (LibroYaPrestadoException ex) {
                            JOptionPane.showMessageDialog(MainFrame.this.pDialog,"Este ejemplar ya esta prestado");
                        }
                        pDialog.setVisible(false);
                    }

                    @Override
                    public void cancelarClick() {
                        pDialog.setVisible(false);
                    }
                });
                    pDialog.setVisible(true);
            }
        });
        
        mnUsuarios.add(mniAltaU);
        mnUsuarios.add(mniBajaU);
        mnLibros.add(mniAltaL);
        mnLibros.add(mniBajaL);
        mnArchivo.add(mnUsuarios);
        mnArchivo.add(mnLibros);
        mnArchivo.add(mniPrestamos);
        mnArchivo.addSeparator();
        mnArchivo.add(mniSalir);
        
        return mnArchivo;
    }
    
    private JMenu mnCatalogos(){
        mnCatalogos=new JMenu("Catalogos");
        JMenuItem mniUsuarios=new JMenuItem("Catalogo de usuarios");
        JMenuItem mniLibros=new JMenuItem("Catalogo de libros");
        
        mniUsuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cUDialog.setVisible(true);
            }
        });
        
        mniLibros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cLDialog.setVisible(true);
            }
        });
        mnCatalogos.add(mniUsuarios);
        mnCatalogos.add(mniLibros);
        
        return mnCatalogos;
    }
    
    private JMenu mnAyuda(){
        mnAyuda=new JMenu("Ayuda");
        JMenuItem mniAbout=new JMenuItem("Acerca de...");
        
        mniAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(MainFrame.this, "Biblioteca La Salle v1.0\nDeveloped by: Cesar Cruz Pomposo");
            }
        });
        
        mnAyuda.add(mniAbout);
        
        return mnAyuda;
    }
}
