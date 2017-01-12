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
public interface PrestamoListener {
    public void aceptarClick(String matricula, String isbn, Integer ejemplar);
    public void cancelarClick();
}
