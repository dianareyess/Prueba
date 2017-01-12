/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import model.Carrera;

/**
 *
 * @author Usuario
 */
public interface AltaUsuarioListener {
    public void agregarClick(String nombre, String paterno, String materno, String id, Carrera carrera);
    public void agregarDocenteClick(String nombre, String paterno, String materno, String id);
    public void cancelarClick();
}
