/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author Usuario
 */
public interface BajaLibroListener {
    public void aceptarClick(String isbn, Integer ejemplar);
    public void cancelarClick();
}
