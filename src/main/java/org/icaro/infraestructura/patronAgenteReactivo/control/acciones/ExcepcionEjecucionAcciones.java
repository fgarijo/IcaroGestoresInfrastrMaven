/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.icaro.infraestructura.patronAgenteReactivo.control.acciones;
import org.icaro.infraestructura.entidadesBasicas.excepciones.ExcepcionEnComponente;
/**
 *
 * @author Francisco J Garijo
 */

public class ExcepcionEjecucionAcciones extends ExcepcionEnComponente {

protected String identComponente = "Acciones Semanticas";
protected String identSuperComponente = "patronAgenteReactivo";
protected String identParteAfectada;
public  ExcepcionEjecucionAcciones (String parteAfectada, String causa, String contextoExcepcion){
super (parteAfectada,causa, contextoExcepcion);
}
}

