/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import model.Editorial;

/**
 *
 * @author Usuario
 */
public interface AltaLibroListener {
    public void agregarClick(String titulo, String autor, Editorial editorial, String isbn, Integer ejemplar);
    public void cancelarClick();
}
