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
public class RegimenIncompatibleExcepcion extends Exception {

    /**
     * Creates a new instance of <code>RegimenIncompatibleException</code>
     * without detail message.
     */
    public RegimenIncompatibleExcepcion() {
    }

    /**
     * Constructs an instance of <code>RegimenIncompatibleException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public RegimenIncompatibleExcepcion(String msg) {
        super(msg);
    }
}
