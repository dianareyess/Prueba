/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

/**
 *
 * @author princessdiana
 */
public enum TipoPeriodo {
    ENERO(Periodicidad.MENSUAL, 1, 1),
    FECBRERO(Periodicidad.MENSUAL, 2, 2),
    MARZO(Periodicidad.MENSUAL, 3, 3),
    ABRIL(Periodicidad.MENSUAL, 4, 4),
    MAYO(Periodicidad.MENSUAL, 5, 5),
    JUNIO(Periodicidad.MENSUAL, 6, 6),
    JULIO(Periodicidad.MENSUAL, 7, 7),
    AGOSTO(Periodicidad.MENSUAL, 8, 8),
    SEPTIEMBRE(Periodicidad.MENSUAL, 9, 9),
    OCTUBRE(Periodicidad.MENSUAL, 10, 10),
    NOVIEMBRE(Periodicidad.MENSUAL, 11, 11),
    DICIEMBRE(Periodicidad.MENSUAL, 12, 12),
    ENE_FEB(Periodicidad.BIMESTRAL, 1, 2),
    MAR_ABR(Periodicidad.BIMESTRAL, 3, 4),
    MAY_JUN(Periodicidad.BIMESTRAL, 5, 6),
    JUL_AGO(Periodicidad.BIMESTRAL, 7, 8),
    SEP_OCT(Periodicidad.BIMESTRAL, 9, 10),
    NOV_DIC(Periodicidad.BIMESTRAL, 11, 12),
    ENE_FEB_MAR(Periodicidad.TRIMESTRAL, 1, 3),
    ABR_MAY_JUN(Periodicidad.TRIMESTRAL, 4, 6),
    JUL_AGO_SEP(Periodicidad.TRIMESTRAL, 7, 9),
    OCT_NOV_DIC(Periodicidad.TRIMESTRAL, 10, 12);
    

    private Periodicidad periodicidad;
    private Integer mesInicial;
    private Integer mesFinal;
    
    private TipoPeriodo(Periodicidad periodicidad,
        Integer mesIni,
        Integer mesFin ) {
        this.periodicidad = periodicidad;
        this.mesInicial = mesIni;
        this.mesFinal = mesFin;
        
    }
    
    public static TipoPeriodo getPeriodo(Periodicidad p, Fecha f) {
        
       TipoPeriodo resultado = null;
       TipoPeriodo tp [] = TipoPeriodo.values();
       for (TipoPeriodo tipoPeriodo : tp) {
           if (tipoPeriodo.getPeriodicidad) {
               
           }
       }
    }

    void getMesFinal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}