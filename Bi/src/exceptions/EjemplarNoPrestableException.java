/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author Usuario
 */
public class EjemplarNoPrestableException extends Exception {

    /**
     * Creates a new instance of <code>EjemplarNoPrestableException</code>
     * without detail message.
     */
    public EjemplarNoPrestableException() {
    }

    /**
     * Constructs an instance of <code>EjemplarNoPrestableException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public EjemplarNoPrestableException(String msg) {
        super(msg);
    }
}
