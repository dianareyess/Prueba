/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

/**
 *
 * @author princessdiana
 */
public class PersonaFisicaExcepcion extends Exception {

    /**
     * Creates a new instance of <code>PersonaFisicaException</code> without
     * detail message.
     */
    public PersonaFisicaExcepcion() {
    }

    /**
     * Constructs an instance of <code>PersonaFisicaException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public PersonaFisicaExcepcion(String msg) {
        super(msg);
    }
}
